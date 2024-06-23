package br.com.vitormelonunes.toll_notifications.adapters.inbound.message;

import br.com.vitormelonunes.toll_notifications.application.model.TollRecord;
import br.com.vitormelonunes.toll_notifications.application.ports.inbound.TollNotificationPortInbound;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TollNotificationMessageAdapterInbound {

    private final ObjectMapper objectMapper;

    @Autowired
    private final TollNotificationPortInbound tollNotificationPortInbound;

    public TollNotificationMessageAdapterInbound(ObjectMapper objectMapper, TollNotificationPortInbound tollNotificationPortInbound) {
        this.objectMapper = objectMapper;
        this.tollNotificationPortInbound = tollNotificationPortInbound;
    }

    @SqsListener("toll-records-created-notifications-pending-queue")
    public void listenTollRecordCreatedQueue(String message) throws Exception {
        try {

            PayloadMessageQueue payloadMessageQueue = objectMapper.readValue(message, PayloadMessageQueue.class);

            TollRecord tollRecordReceived = objectMapper.readValue(payloadMessageQueue.getMessage(), TollRecord.class);

            tollNotificationPortInbound.createTollNotificationTollRecordCreated(tollRecordReceived);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
