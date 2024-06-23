package br.com.vitormelonunes.toll_notifications.adapters.outbound.integration.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notification-provider-cliente", url = "http://localhost:9999")
public interface NotificationProviderClient {
    @PostMapping("/notificate/")
    NotificationResponseBody generateNotification(@RequestBody NotificationRequestBody requestData);
}