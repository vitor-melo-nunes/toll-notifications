package br.com.vitormelonunes.toll_notifications.adapters.outbound.repository;

import br.com.vitormelonunes.toll_notifications.application.model.TollNotification;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

import java.time.Instant;
import java.util.UUID;

@DynamoDbBean
public class TollNotifications {

    private UUID tollNotificationId;
    private String name;
    private String phone;
    private String licensePlateNumber;
    private Long tollRecordId;
    private String message;
    private Instant createdAt;

    public TollNotifications(UUID tollNotificationId,
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

    public TollNotifications() {}

    public static TollNotifications generateRegister(TollNotification tollNotification) {

        var  entity = new TollNotifications();

        entity.tollNotificationId = tollNotification.getTollNotificationId();
        entity.name = tollNotification.getName();
        entity.phone = tollNotification.getPhone();
        entity.licensePlateNumber = tollNotification.getLicensePlateNumber();
        entity.tollRecordId = tollNotification.getTollRecordId();
        entity.message = tollNotification.getMessage();
        entity.createdAt = tollNotification.getCreatedAt();

        return entity;
    }


    @DynamoDbPartitionKey
    @DynamoDbAttribute("tollNotificationId")
    public UUID getTollNotificationId() {
        return tollNotificationId;
    }

    public void setTollNotificationId(UUID tollNotificationId) {
        this.tollNotificationId = tollNotificationId;
    }

    @DynamoDbAttribute("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @DynamoDbAttribute("phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @DynamoDbAttribute("licensePlateNumber")
    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    @DynamoDbSortKey
    @DynamoDbAttribute("tollRecordId")
    public Long getTollRecordId() {
        return tollRecordId;
    }

    public void setTollRecordId(Long tollRecordId) {
        this.tollRecordId = tollRecordId;
    }

    @DynamoDbAttribute("message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    @DynamoDbAttribute("createdAt")
    public Instant getCreatedAt() {
        return createdAt;
    }

}
