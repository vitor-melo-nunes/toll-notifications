package br.com.vitormelonunes.toll_notifications.adapters.outbound.integration.notification;

import br.com.vitormelonunes.toll_notifications.application.model.TollNotification;

public class NotificationRequestBody {

    private String name;
    private String phone;
    private String message;

    public NotificationRequestBody(String name, String phone, String message) {
        this.name = name;
        this.phone = phone;
        this.message = message;
    }

    public NotificationRequestBody() {}

    public static NotificationRequestBody generateFromModel(TollNotification tollNotification) {

        NotificationRequestBody notificationRequestBody = new NotificationRequestBody();
        notificationRequestBody.name = tollNotification.getName();
        notificationRequestBody.phone = tollNotification.getPhone();
        notificationRequestBody.message = tollNotification.getMessage();

        return  notificationRequestBody;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
