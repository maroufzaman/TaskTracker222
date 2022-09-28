package com.rmrfroot.tasktracker222.cognitoClasses;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProvider;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProviderClientBuilder;
import com.amazonaws.services.cognitoidp.model.AdminGetUserRequest;
import com.amazonaws.services.cognitoidp.model.AdminGetUserResult;
import com.amazonaws.services.cognitoidp.model.UserNotFoundException;

public class CreateUserPool {

    public CreateUserPool(String user) {
        String app_client_id ="30pr4eskaka76d1r7ocbpvvn7k";
        String app_client_secret ="hkshvd2hhhv6o4ovhvqj9cub6eek4c66gk9lgukpfn65r087p0q";
        String user_pool_id ="us-west-1_NHU41muCf";
        String region = "us-west-1";
        String AWS_ACCESS_KEY = "AKIAQ6EX532Q666I4IW7";
        String AWS_SECRET_KEY = "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";
        AWSCredentials awsCreds = new BasicAWSCredentials(AWS_ACCESS_KEY, AWS_SECRET_KEY);
        AWSCognitoIdentityProvider client = AWSCognitoIdentityProviderClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .withRegion(region)
                .build();
        AdminGetUserRequest adminGetUserRequest = new AdminGetUserRequest()
                .withUserPoolId(user_pool_id)
                .withUsername(user);

        try {
            AdminGetUserResult adminGetUserResult = client.adminGetUser(adminGetUserRequest);
            System.out.println(adminGetUserResult.getUserMFASettingList());
        }catch (UserNotFoundException e) {
            System.out.println("User not found");
        }
    }
}
