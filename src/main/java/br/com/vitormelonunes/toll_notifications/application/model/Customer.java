package br.com.vitormelonunes.toll_notifications.application.model;

import java.time.Instant;

public class Customer {
    private String licensePlateNumber;
    private String identificationDocument;
    private String name;
    private String phone;
    private Instant createdAt;

    public  Customer() {}

    public Customer(String licensePlateNumber, String identificationDocument, String name, String phone, Instant createdAt) {
        this.licensePlateNumber = licensePlateNumber;
        this.identificationDocument = identificationDocument;
        this.name = name;
        this.phone = phone;
        this.createdAt = createdAt;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    public String getIdentificationDocument() {
        return identificationDocument;
    }

    public void setIdentificationDocument(String identificationDocument) {
        this.identificationDocument = identificationDocument;
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

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
