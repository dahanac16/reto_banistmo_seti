package com.banistmo.developer.infrastructure.config;

import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.lambda.LambdaClient;

public class AWSLambdaConfig {

    private static final Region AWS_REGION = Region.US_EAST_1;

    public static LambdaClient configureLambdaClient() {
        return LambdaClient.builder()
                .region(AWS_REGION)
                .credentialsProvider(DefaultCredentialsProvider.create())
                .build();
    }
}
