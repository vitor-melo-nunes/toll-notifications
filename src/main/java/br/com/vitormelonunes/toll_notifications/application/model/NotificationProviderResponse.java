package br.com.vitormelonunes.toll_notifications.application.model;

public class NotificationProviderResponse {

    private String processId;
    private String status;
    private String phone;

    public NotificationProviderResponse(String processId, String status, String phone) {
        this.processId = processId;
        this.status = status;
        this.phone = phone;
    }

    public NotificationProviderResponse() {}

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
