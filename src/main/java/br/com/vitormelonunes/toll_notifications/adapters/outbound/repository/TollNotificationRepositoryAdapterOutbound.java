package br.com.vitormelonunes.toll_notifications.adapters.outbound.repository;

import br.com.vitormelonunes.toll_notifications.application.model.TollNotification;
import br.com.vitormelonunes.toll_notifications.application.ports.outbound.TollNotificationPortOutbound;
import io.awspring.cloud.dynamodb.DynamoDbTemplate;
import org.springframework.stereotype.Component;

@Component
public class TollNotificationRepositoryAdapterOutbound implements TollNotificationPortOutbound {
    private final DynamoDbTemplate dynamoDbTemplate;

    public TollNotificationRepositoryAdapterOutbound(DynamoDbTemplate dynamoDbTemplate) {
        this.dynamoDbTemplate = dynamoDbTemplate;
    }

    @Override
    public void saveTollRecord(TollNotification tollNotification) throws Exception {
        try {
            TollNotifications tollNotificationEntity = TollNotifications.generateRegister(tollNotification);
            dynamoDbTemplate.save(tollNotificationEntity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
