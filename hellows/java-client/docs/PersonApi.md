# PersonApi

All URIs are relative to *https://localhost/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**helloWorldHello**](PersonApi.md#helloWorldHello) | **POST** /helloworld/hello | Say hello to the given user


<a name="helloWorldHello"></a>
# **helloWorldHello**
> StatusDTO helloWorldHello(who)

Say hello to the given user

This is an example of how the JSON should be structured             {                 \&quot;firstName\&quot; : \&quot;Nicolai\&quot;,                 \&quot;lastName\&quot; : \&quot;Oksen\&quot;             }

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PersonApi;


PersonApi apiInstance = new PersonApi();
Person who = new Person(); // Person | Who to say hello to
try {
    StatusDTO result = apiInstance.helloWorldHello(who);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PersonApi#helloWorldHello");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **who** | [**Person**](Person.md)| Who to say hello to | [optional]

### Return type

[**StatusDTO**](StatusDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/json, application/json-patch+json
 - **Accept**: text/plain, application/json, text/json

