# Toll Notifications
[This repository is part of the Toll Free Flow project](https://github.com/vitor-melo-nunes/toll-freeflow)

The Toll Notifications Service is responsible for managing notifications related to toll events and payments. It receives toll events and payment confirmations and sends notifications to customers.

## Features
- Receive toll event notifications
- Process payment notifications
- Send notifications to customers

## Getting Started
### Prerequisites
- Docker
- Brownser

### Build and Run
1. Run ```docker-compose up```

2. Run ```docker exec -it localstack awslocal sqs create-queue --region sa-east-1 --queue-name toll-records-created-notifications-pending-queue```

3. Run ```docker exec -it localstack aws --endpoint="http://localhost:4566" dynamodb create-table --region "sa-east-1" --table-name "toll_notifications" --attribute-definitions "AttributeName=tollNotificationId,AttributeType=S" "AttributeName=tollRecordId,AttributeType=N" --key-schema "AttributeName=tollNotificationId,KeyType=HASH" "AttributeName=tollRecordId,KeyType=RANGE" --provisioned-throughput "ReadCapacityUnits=5,WriteCapacityUnits=5"```

4. Run ```docker exec -it localstack awslocal sqs send-message --region sa-east-1 --queue-url https://localhost.localstack.cloud:4566/000000000000/toll-records-created-notifications-pending-queue --message-body "{'tollRecordId':'be4d330b-366a-46c3-8c77-528469ca4658','licensePlateNumber':'BRA2E19','tagNumber':'5276632812116115','tagValidationCode':'237','amount':15.00,'status':'CREATED','creationDate':'2024-06-23T15:28:45.123456Z','updateDate':'2024-06-23T15:28:45.123456Z'}"```
