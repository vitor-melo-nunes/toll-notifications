package br.com.vitormelonunes.toll_notifications.adapters.inbound.message;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PayloadMessageQueue {
    private String type;
    private String messageId;
    private String topicArn;
    private String message;
    private String timestamp;
    private String unsubscribeURL;
    private MessageAttributes messageAttributes;
    private String signatureVersion;
    private String signature;
    private String signingCertURL;

    // Getters and Setters
    @JsonProperty("Type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("MessageId")
    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    @JsonProperty("TopicArn")
    public String getTopicArn() {
        return topicArn;
    }

    public void setTopicArn(String topicArn) {
        this.topicArn = topicArn;
    }

    @JsonProperty("Message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("Timestamp")
    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @JsonProperty("UnsubscribeURL")
    public String getUnsubscribeURL() {
        return unsubscribeURL;
    }

    public void setUnsubscribeURL(String unsubscribeURL) {
        this.unsubscribeURL = unsubscribeURL;
    }

    @JsonProperty("MessageAttributes")
    public MessageAttributes getMessageAttributes() {
        return messageAttributes;
    }

    public void setMessageAttributes(MessageAttributes messageAttributes) {
        this.messageAttributes = messageAttributes;
    }

    @JsonProperty("SignatureVersion")
    public String getSignatureVersion() {
        return signatureVersion;
    }

    public void setSignatureVersion(String signatureVersion) {
        this.signatureVersion = signatureVersion;
    }

    @JsonProperty("Signature")
    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @JsonProperty("SigningCertURL")
    public String getSigningCertURL() {
        return signingCertURL;
    }

    public void setSigningCertURL(String signingCertURL) {
        this.signingCertURL = signingCertURL;
    }

    public static class MessageAttributes {
        private Attribute id;
        private Attribute contentType;
        private Attribute timestamp;

        // Getters and Setters
        @JsonProperty("id")
        public Attribute getId() {
            return id;
        }

        public void setId(Attribute id) {
            this.id = id;
        }

        @JsonProperty("contentType")
        public Attribute getContentType() {
            return contentType;
        }

        public void setContentType(Attribute contentType) {
            this.contentType = contentType;
        }

        @JsonProperty("timestamp")
        public Attribute getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Attribute timestamp) {
            this.timestamp = timestamp;
        }
    }

    public static class Attribute {
        private String type;
        private String value;

        // Getters and Setters
        @JsonProperty("Type")
        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        @JsonProperty("Value")
        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
