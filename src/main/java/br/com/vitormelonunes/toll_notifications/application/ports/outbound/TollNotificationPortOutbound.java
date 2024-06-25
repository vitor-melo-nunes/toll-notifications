package br.com.vitormelonunes.toll_notifications.application.ports.outbound;

import br.com.vitormelonunes.toll_notifications.application.model.TollNotification;

public interface TollNotificationPortOutbound {
    void saveTollRecord(TollNotification tollNotification) throws Exception;
}
