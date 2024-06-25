package br.com.vitormelonunes.toll_notifications.application.service;

import br.com.vitormelonunes.toll_notifications.application.model.Customer;
import br.com.vitormelonunes.toll_notifications.application.model.NotificationProviderResponse;
import br.com.vitormelonunes.toll_notifications.application.model.TollNotification;
import br.com.vitormelonunes.toll_notifications.application.model.TollRecord;
import br.com.vitormelonunes.toll_notifications.application.ports.inbound.TollNotificationPortInbound;
import br.com.vitormelonunes.toll_notifications.application.ports.outbound.CustomerPortOutbound;
import br.com.vitormelonunes.toll_notifications.application.ports.outbound.NotificationProviderPortOutbound;
import br.com.vitormelonunes.toll_notifications.application.ports.outbound.TollNotificationPortOutbound;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class TollNotificationService implements TollNotificationPortInbound {

    private final TollNotificationPortOutbound tollNotificationPortOutbound;
    private final CustomerPortOutbound customerPortOutbound;
    private final NotificationProviderPortOutbound notificationProviderPortOutbound;

    public TollNotificationService(TollNotificationPortOutbound tollNotificationPortOutbound, CustomerPortOutbound customerPortOutbound, NotificationProviderPortOutbound notificationProviderPortOutbound) {
        this.tollNotificationPortOutbound = tollNotificationPortOutbound;
        this.customerPortOutbound = customerPortOutbound;
        this.notificationProviderPortOutbound = notificationProviderPortOutbound;
    }

    @Override
    public void createTollNotificationTollRecordCreated(TollRecord tollRecord) throws Exception {

        Customer customerFound = this.customerPortOutbound.getCustomer(tollRecord.getLicensePlateNumber());
        var notificationMessage = "Registro de pedágio criado para a placa " + tollRecord.getLicensePlateNumber();
        var tollNotificationId = UUID.randomUUID();

        TollNotification tollNotification = new TollNotification(tollNotificationId,
                tollRecord,
                customerFound,
                notificationMessage);

        NotificationProviderResponse notificationProviderResponse =
                this.notificationProviderPortOutbound.sendNotification(tollNotification);

        if(!"Success".equalsIgnoreCase(notificationProviderResponse.getStatus())) {
            throw new Exception("Failed to send customer notification");
        }

        tollNotification.setCreatedAt(Instant.now());
        this.tollNotificationPortOutbound.saveTollRecord(tollNotification);
    }
}
