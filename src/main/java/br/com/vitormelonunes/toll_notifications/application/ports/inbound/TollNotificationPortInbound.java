package br.com.vitormelonunes.toll_notifications.application.ports.inbound;

import br.com.vitormelonunes.toll_notifications.application.model.TollNotification;
import br.com.vitormelonunes.toll_notifications.application.model.TollRecord;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public interface TollNotificationPortInbound {
    void createTollNotificationTollRecordCreated(TollRecord tollRecord) throws Exception;
}
