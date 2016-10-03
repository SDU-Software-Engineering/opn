# BankApi

All URIs are relative to *https://localhost/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**apiBankAccrueInterestPost**](BankApi.md#apiBankAccrueInterestPost) | **POST** /api/Bank/accrue-interest | Placeholder for the action that is invoked when you ask to accrue interest             Functionality: for every account, add positive or negative interest to             the balance of the account.
[**apiBankCreateAccountPost**](BankApi.md#apiBankCreateAccountPost) | **POST** /api/Bank/create-account | Create an account for the given user
[**apiBankCreatePost**](BankApi.md#apiBankCreatePost) | **POST** /api/Bank/create | Create a new user
[**apiBankDepositPost**](BankApi.md#apiBankDepositPost) | **POST** /api/Bank/deposit | Deposit money on the given account of the given customer
[**apiBankLoginPost**](BankApi.md#apiBankLoginPost) | **POST** /api/Bank/login | Login to the system with the given user
[**apiBankWithdrawPost**](BankApi.md#apiBankWithdrawPost) | **POST** /api/Bank/withdraw | Withdraw money from the given account of the given customer


<a name="apiBankAccrueInterestPost"></a>
# **apiBankAccrueInterestPost**
> String apiBankAccrueInterestPost()

Placeholder for the action that is invoked when you ask to accrue interest             Functionality: for every account, add positive or negative interest to             the balance of the account.

### Example
```java
// Import classes:
//import dk.sdu.mmmi.opn.swaggerbank.ApiException;
//import io.swagger.client.api.BankApi;


BankApi apiInstance = new BankApi();
try {
    String result = apiInstance.apiBankAccrueInterestPost();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BankApi#apiBankAccrueInterestPost");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

<a name="apiBankCreateAccountPost"></a>
# **apiBankCreateAccountPost**
> CustomerDTO apiBankCreateAccountPost(credentialAndAccount)

Create an account for the given user

This is an example of how the JSON should be structured             {                 \&quot;credential\&quot; : {                  \&quot;name\&quot; : \&quot;Nicolai\&quot;,                  \&quot;id\&quot; : 1                  },                 \&quot;account\&quot; : {                  \&quot;name\&quot; : \&quot;Budget Account\&quot;,                  \&quot;positiveInterest\&quot; : 2.0,                  \&quot;negativeInterest\&quot; : 5.0                 }             }

### Example
```java
// Import classes:
//import dk.sdu.mmmi.opn.swaggerbank.ApiException;
//import io.swagger.client.api.BankApi;


BankApi apiInstance = new BankApi();
CredentialAndAccount credentialAndAccount = new CredentialAndAccount(); // CredentialAndAccount | CredentialAndAccount object containing credential and account information
try {
    CustomerDTO result = apiInstance.apiBankCreateAccountPost(credentialAndAccount);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BankApi#apiBankCreateAccountPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **credentialAndAccount** | [**CredentialAndAccount**](CredentialAndAccount.md)| CredentialAndAccount object containing credential and account information | [optional]

### Return type

[**CustomerDTO**](CustomerDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/json, application/json-patch+json
 - **Accept**: text/plain, application/json, text/json

<a name="apiBankCreatePost"></a>
# **apiBankCreatePost**
> CustomerDTO apiBankCreatePost(name)

Create a new user

This is an example of how the BODY should be structured              \&quot;Nicolai Oksen\&quot;

### Example
```java
// Import classes:
//import dk.sdu.mmmi.opn.swaggerbank.ApiException;
//import io.swagger.client.api.BankApi;


BankApi apiInstance = new BankApi();
String name = "name_example"; // String | Name of customer
try {
    CustomerDTO result = apiInstance.apiBankCreatePost(name);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BankApi#apiBankCreatePost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**| Name of customer | [optional]

### Return type

[**CustomerDTO**](CustomerDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/json, application/json-patch+json
 - **Accept**: text/plain, application/json, text/json

<a name="apiBankDepositPost"></a>
# **apiBankDepositPost**
> CustomerDTO apiBankDepositPost(deposit)

Deposit money on the given account of the given customer

This is an example of how the JSON should be structured             {             \&quot;credential\&quot; : {              \&quot;name\&quot; : \&quot;Nicolai\&quot;,              \&quot;id\&quot; : 1              },             \&quot;accountId\&quot; : 2,             \&quot;amount\&quot; : 100.0             }

### Example
```java
// Import classes:
//import dk.sdu.mmmi.opn.swaggerbank.ApiException;
//import io.swagger.client.api.BankApi;


BankApi apiInstance = new BankApi();
Object deposit = null; // Object | JSON object containing credentials, account id and withdraw amount
try {
    CustomerDTO result = apiInstance.apiBankDepositPost(deposit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BankApi#apiBankDepositPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **deposit** | **Object**| JSON object containing credentials, account id and withdraw amount | [optional]

### Return type

[**CustomerDTO**](CustomerDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/json, application/json-patch+json
 - **Accept**: text/plain, application/json, text/json

<a name="apiBankLoginPost"></a>
# **apiBankLoginPost**
> CustomerDTO apiBankLoginPost(credential)

Login to the system with the given user

This is an example of how the JSON should be structured             {                 \&quot;name\&quot; : \&quot;Nicolai\&quot;,                 \&quot;id\&quot; : 1             }

### Example
```java
// Import classes:
//import dk.sdu.mmmi.opn.swaggerbank.ApiException;
//import io.swagger.client.api.BankApi;


BankApi apiInstance = new BankApi();
Credential credential = new Credential(); // Credential | Login credentials for customer
try {
    CustomerDTO result = apiInstance.apiBankLoginPost(credential);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BankApi#apiBankLoginPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **credential** | [**Credential**](Credential.md)| Login credentials for customer | [optional]

### Return type

[**CustomerDTO**](CustomerDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/json, application/json-patch+json
 - **Accept**: text/plain, application/json, text/json

<a name="apiBankWithdrawPost"></a>
# **apiBankWithdrawPost**
> CustomerDTO apiBankWithdrawPost(withdraw)

Withdraw money from the given account of the given customer

This is an example of how the JSON should be structured             {             \&quot;credential\&quot; : {              \&quot;name\&quot; : \&quot;Nicolai\&quot;,              \&quot;id\&quot; : 1              },             \&quot;accountId\&quot; : 2,             \&quot;amount\&quot; : 100.0             }

### Example
```java
// Import classes:
//import dk.sdu.mmmi.opn.swaggerbank.ApiException;
//import io.swagger.client.api.BankApi;


BankApi apiInstance = new BankApi();
Object withdraw = null; // Object | JSON object containing credentials, account id and withdraw amount
try {
    CustomerDTO result = apiInstance.apiBankWithdrawPost(withdraw);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BankApi#apiBankWithdrawPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **withdraw** | **Object**| JSON object containing credentials, account id and withdraw amount | [optional]

### Return type

[**CustomerDTO**](CustomerDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/json, application/json-patch+json
 - **Accept**: text/plain, application/json, text/json

