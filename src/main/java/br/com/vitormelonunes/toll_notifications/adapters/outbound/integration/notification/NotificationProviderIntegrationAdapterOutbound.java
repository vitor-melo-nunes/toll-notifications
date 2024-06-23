package br.com.vitormelonunes.toll_notifications.adapters.outbound.integration.notification;

import br.com.vitormelonunes.toll_notifications.application.model.NotificationProviderResponse;
import br.com.vitormelonunes.toll_notifications.application.model.TollNotification;
import br.com.vitormelonunes.toll_notifications.application.ports.outbound.NotificationProviderPortOutbound;
import org.springframework.stereotype.Component;

@Component
public class NotificationProviderIntegrationAdapterOutbound implements NotificationProviderPortOutbound {

    private final NotificationProviderClient notificationProviderClient;

    public NotificationProviderIntegrationAdapterOutbound(NotificationProviderClient notificationProviderClient) {
        this.notificationProviderClient = notificationProviderClient;
    }

    public NotificationProviderResponse sendNotification(TollNotification tollNotification) throws Exception {
        NotificationRequestBody notificationRequestBody = NotificationRequestBody.generateFromModel(tollNotification);
        NotificationResponseBody notificationResponseBody = this.notificationProviderClient.generateNotification(notificationRequestBody);

        return notificationResponseBody.convertToDomain();
    }



}