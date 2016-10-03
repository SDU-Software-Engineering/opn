# swagger-java-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>io.swagger</groupId>
    <artifactId>swagger-java-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-java-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/swagger-java-client-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import dk.sdu.mmmi.opn.swaggerbank.*;
import dk.sdu.mmmi.opn.swaggerbank.auth.*;
import dk.sdu.mmmi.opn.swaggerbank.model.*;
import io.swagger.client.api.BankApi;

import java.io.File;
import java.util.*;

public class BankApiExample {

    public static void main(String[] args) {
        
        BankApi apiInstance = new BankApi();
        try {
            String result = apiInstance.apiBankAccrueInterestPost();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling BankApi#apiBankAccrueInterestPost");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://localhost/*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*BankApi* | [**apiBankAccrueInterestPost**](docs/BankApi.md#apiBankAccrueInterestPost) | **POST** /api/Bank/accrue-interest | Placeholder for the action that is invoked when you ask to accrue interest             Functionality: for every account, add positive or negative interest to             the balance of the account.
*BankApi* | [**apiBankCreateAccountPost**](docs/BankApi.md#apiBankCreateAccountPost) | **POST** /api/Bank/create-account | Create an account for the given user
*BankApi* | [**apiBankCreatePost**](docs/BankApi.md#apiBankCreatePost) | **POST** /api/Bank/create | Create a new user
*BankApi* | [**apiBankDepositPost**](docs/BankApi.md#apiBankDepositPost) | **POST** /api/Bank/deposit | Deposit money on the given account of the given customer
*BankApi* | [**apiBankLoginPost**](docs/BankApi.md#apiBankLoginPost) | **POST** /api/Bank/login | Login to the system with the given user
*BankApi* | [**apiBankWithdrawPost**](docs/BankApi.md#apiBankWithdrawPost) | **POST** /api/Bank/withdraw | Withdraw money from the given account of the given customer


## Documentation for Models

 - [Account](docs/Account.md)
 - [AccountDTO](docs/AccountDTO.md)
 - [Credential](docs/Credential.md)
 - [CredentialAndAccount](docs/CredentialAndAccount.md)
 - [CustomerDTO](docs/CustomerDTO.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issue.

## Author



