#!/bin/bash


## SQS
docker exec -it localstack awslocal sqs create-queue --region sa-east-1 --queue-name toll-records-created-notifications-pending-queue

docker exec -it localstack awslocal sqs send-message --region sa-east-1 --queue-url https://localhost.localstack.cloud:4566/000000000000/toll-records-created-notifications-pending-queue --message-body "{'tollRecordId':'be4d330b-366a-46c3-8c77-528469ca4658','licensePlateNumber':'BRA2E19','tagNumber':'5276632812116115','tagValidationCode':'237','amount':15.00,'status':'CREATED','creationDate':'2024-06-23T15:28:45.123456Z','updateDate':'2024-06-23T15:28:45.123456Z'}"

docker exec -it localstack awslocal sqs purge-queue --region sa-east-1 --queue-url https://localhost.localstack.cloud:4566/000000000000/toll-records-created-notifications-pending-queue


## Dynamo

# Create Table
docker exec -it localstack aws --endpoint="http://localhost:4566" dynamodb create-table --region "sa-east-1" --table-name "toll_notifications" --attribute-definitions "AttributeName=tollNotificationId,AttributeType=S" "AttributeName=tollRecordId,AttributeType=N" --key-schema "AttributeName=tollNotificationId,KeyType=HASH" "AttributeName=tollRecordId,KeyType=RANGE" --provisioned-throughput "ReadCapacityUnits=5,WriteCapacityUnits=5"

# Delete Table
docker exec -it localstack aws --endpoint="http://localhost:4566" dynamodb delete-table --region "sa-east-1" --table-name "toll_notifications"
