# SignupControllerApi

All URIs are relative to *https://localhost:8082/farmservice*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addNewFormSignupUsingPOST**](SignupControllerApi.md#addNewFormSignupUsingPOST) | **POST** /signup/user/add/form | Add new user.
[**addNewSignupUsingPOST**](SignupControllerApi.md#addNewSignupUsingPOST) | **POST** /signup/user/add | Add new user.
[**deleteSignupUsingDELETE**](SignupControllerApi.md#deleteSignupUsingDELETE) | **DELETE** /signup/user/delete/{username} | Delete user account.
[**getApprovedUsersUsingGET**](SignupControllerApi.md#getApprovedUsersUsingGET) | **GET** /signup/users/approved | Returns all approved users only.
[**getSignedupUserUsingGET**](SignupControllerApi.md#getSignedupUserUsingGET) | **GET** /signup/users/{username} | Returns users with matched username.
[**getSignedupUsersUsingGET**](SignupControllerApi.md#getSignedupUsersUsingGET) | **GET** /signup/users | Returns all users.
[**getTotalUsersUsingGET**](SignupControllerApi.md#getTotalUsersUsingGET) | **GET** /signup/users/count | Returns total number of users.
[**partialupdateSignupUsingPATCH**](SignupControllerApi.md#partialupdateSignupUsingPATCH) | **PATCH** /signup/user/update/partial/{username} | Update some profile detail.
[**updateSignupUsingPUT**](SignupControllerApi.md#updateSignupUsingPUT) | **PUT** /signup/user/update/full/{username} | Update a user account.


<a name="addNewFormSignupUsingPOST"></a>
# **addNewFormSignupUsingPOST**
> String addNewFormSignupUsingPOST(reqParams)

Add new user.

### Example
```java
// Import classes:
//import org.packt.springboot22.vid02.config.ApiException;
//import org.packt.springboot22.vid02.client.SignupControllerApi;


SignupControllerApi apiInstance = new SignupControllerApi();
Object reqParams = null; // Object | reqParams
try {
    String result = apiInstance.addNewFormSignupUsingPOST(reqParams);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SignupControllerApi#addNewFormSignupUsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reqParams** | [**Object**](.md)| reqParams |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: */*

<a name="addNewSignupUsingPOST"></a>
# **addNewSignupUsingPOST**
> String addNewSignupUsingPOST(profile)

Add new user.

### Example
```java
// Import classes:
//import org.packt.springboot22.vid02.config.ApiException;
//import org.packt.springboot22.vid02.client.SignupControllerApi;


SignupControllerApi apiInstance = new SignupControllerApi();
ProfileInformation profile = new ProfileInformation(); // ProfileInformation | profile
try {
    String result = apiInstance.addNewSignupUsingPOST(profile);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SignupControllerApi#addNewSignupUsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **profile** | [**ProfileInformation**](ProfileInformation.md)| profile |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, Profile data
 - **Accept**: */*

<a name="deleteSignupUsingDELETE"></a>
# **deleteSignupUsingDELETE**
> String deleteSignupUsingDELETE(username)

Delete user account.

### Example
```java
// Import classes:
//import org.packt.springboot22.vid02.config.ApiException;
//import org.packt.springboot22.vid02.client.SignupControllerApi;


SignupControllerApi apiInstance = new SignupControllerApi();
String username = "username_example"; // String | username
try {
    String result = apiInstance.deleteSignupUsingDELETE(username);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SignupControllerApi#deleteSignupUsingDELETE");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **String**| username |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getApprovedUsersUsingGET"></a>
# **getApprovedUsersUsingGET**
> java.util.List&lt;Object&gt; getApprovedUsersUsingGET()

Returns all approved users only.

### Example
```java
// Import classes:
//import org.packt.springboot22.vid02.config.ApiException;
//import org.packt.springboot22.vid02.client.SignupControllerApi;


SignupControllerApi apiInstance = new SignupControllerApi();
try {
    java.util.List<Object> result = apiInstance.getApprovedUsersUsingGET();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SignupControllerApi#getApprovedUsersUsingGET");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**java.util.List&lt;Object&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getSignedupUserUsingGET"></a>
# **getSignedupUserUsingGET**
> java.util.List&lt;Object&gt; getSignedupUserUsingGET(username)

Returns users with matched username.

### Example
```java
// Import classes:
//import org.packt.springboot22.vid02.config.ApiException;
//import org.packt.springboot22.vid02.client.SignupControllerApi;


SignupControllerApi apiInstance = new SignupControllerApi();
String username = "username_example"; // String | Login username
try {
    java.util.List<Object> result = apiInstance.getSignedupUserUsingGET(username);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SignupControllerApi#getSignedupUserUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **String**| Login username |

### Return type

**java.util.List&lt;Object&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getSignedupUsersUsingGET"></a>
# **getSignedupUsersUsingGET**
> java.util.List&lt;Object&gt; getSignedupUsersUsingGET()

Returns all users.

### Example
```java
// Import classes:
//import org.packt.springboot22.vid02.config.ApiException;
//import org.packt.springboot22.vid02.client.SignupControllerApi;


SignupControllerApi apiInstance = new SignupControllerApi();
try {
    java.util.List<Object> result = apiInstance.getSignedupUsersUsingGET();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SignupControllerApi#getSignedupUsersUsingGET");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**java.util.List&lt;Object&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getTotalUsersUsingGET"></a>
# **getTotalUsersUsingGET**
> String getTotalUsersUsingGET()

Returns total number of users.

### Example
```java
// Import classes:
//import org.packt.springboot22.vid02.config.ApiException;
//import org.packt.springboot22.vid02.client.SignupControllerApi;


SignupControllerApi apiInstance = new SignupControllerApi();
try {
    String result = apiInstance.getTotalUsersUsingGET();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SignupControllerApi#getTotalUsersUsingGET");
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
 - **Accept**: application/json

<a name="partialupdateSignupUsingPATCH"></a>
# **partialupdateSignupUsingPATCH**
> String partialupdateSignupUsingPATCH(updates, username)

Update some profile detail.

### Example
```java
// Import classes:
//import org.packt.springboot22.vid02.config.ApiException;
//import org.packt.springboot22.vid02.client.SignupControllerApi;


SignupControllerApi apiInstance = new SignupControllerApi();
Object updates = null; // Object | updates
String username = "username_example"; // String | username
try {
    String result = apiInstance.partialupdateSignupUsingPATCH(updates, username);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SignupControllerApi#partialupdateSignupUsingPATCH");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **updates** | **Object**| updates |
 **username** | **String**| username |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="updateSignupUsingPUT"></a>
# **updateSignupUsingPUT**
> String updateSignupUsingPUT(profile, username)

Update a user account.

### Example
```java
// Import classes:
//import org.packt.springboot22.vid02.config.ApiException;
//import org.packt.springboot22.vid02.client.SignupControllerApi;


SignupControllerApi apiInstance = new SignupControllerApi();
ProfileInformation profile = new ProfileInformation(); // ProfileInformation | profile
String username = "username_example"; // String | username
try {
    String result = apiInstance.updateSignupUsingPUT(profile, username);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SignupControllerApi#updateSignupUsingPUT");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **profile** | [**ProfileInformation**](ProfileInformation.md)| profile |
 **username** | **String**| username |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

