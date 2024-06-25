package br.com.vitormelonunes.toll_notifications.adapters.outbound.integration.notification;

import br.com.vitormelonunes.toll_notifications.application.model.NotificationProviderResponse;

public class NotificationResponseBody {
    private String processId;
    private String status;
    private String phone;

    public NotificationResponseBody() {}

    public NotificationResponseBody(String processId, String status, String phone) {
        this.processId = processId;
        this.status = status;
        this.phone = phone;
    }

    public NotificationProviderResponse convertToDomain() {
        NotificationProviderResponse notificationProviderResponse = new NotificationProviderResponse();
        notificationProviderResponse.setProcessId(this.processId);
        notificationProviderResponse.setPhone(this.phone);
        notificationProviderResponse.setStatus(this.status);

        return notificationProviderResponse;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
