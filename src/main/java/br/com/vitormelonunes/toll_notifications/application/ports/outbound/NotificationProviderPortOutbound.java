package br.com.vitormelonunes.toll_notifications.application.ports.outbound;

import br.com.vitormelonunes.toll_notifications.application.model.Customer;
import br.com.vitormelonunes.toll_notifications.application.model.NotificationProviderResponse;
import br.com.vitormelonunes.toll_notifications.application.model.TollNotification;

public interface NotificationProviderPortOutbound {
    NotificationProviderResponse sendNotification(TollNotification tollNotification) throws Exception;
}
