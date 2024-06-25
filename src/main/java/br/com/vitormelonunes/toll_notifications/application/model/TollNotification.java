package br.com.vitormelonunes.toll_notifications.application.model;

import java.time.Instant;
import java.util.UUID;

public class TollNotification {

    private UUID tollNotificationId;
    private String name;
    private String phone;
    private String licensePlateNumber;
    private Long tollRecordId;
    private String message;
    private Instant createdAt;

    public TollNotification(UUID tollNotificationId,
                            TollRecord tollRecord,
                            Customer customer,
                            String message) {
        this.tollNotificationId = tollNotificationId;
        this.name = customer.getName();
        this.phone = customer.getPhone();
        this.licensePlateNumber = tollRecord.getLicensePlateNumber();
        this.tollRecordId = tollRecord.getTollRecordId();
        this.message = message;
    }

    public TollNotification(UUID tollNotificationId,
                            String name,
                            String phone,
                            String licensePlateNumber,
                            Long tollRecordId,
                            String message,
                            Instant createdAt) {
        this.tollNotificationId = tollNotificationId;
        this.name = name;
        this.phone = phone;
        this.licensePlateNumber = licensePlateNumber;
        this.tollRecordId = tollRecordId;
        this.message = message;
        this.createdAt = createdAt;
    }

    public UUID getTollNotificationId() {
        return tollNotificationId;
    }

    public void setTollNotificationId(UUID tollNotificationId) {
        this.tollNotificationId = tollNotificationId;
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

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    public Long getTollRecordId() {
        return tollRecordId;
    }

    public void setTollRecordId(Long tollRecordId) {
        this.tollRecordId = tollRecordId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}

