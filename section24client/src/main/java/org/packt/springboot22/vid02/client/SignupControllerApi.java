package org.packt.springboot22.vid02.client;

import org.packt.springboot22.vid02.config.ApiException;
import org.packt.springboot22.vid02.config.ApiClient;
import org.packt.springboot22.vid02.config.ApiResponse;
import org.packt.springboot22.vid02.config.Configuration;
import org.packt.springboot22.vid02.config.Pair;

import javax.ws.rs.core.GenericType;

import org.packt.springboot22.vid02.model.ProfileInformation;


@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-09-01T10:47:23.730+08:00")
public class SignupControllerApi {
  private ApiClient apiClient;

  public SignupControllerApi() {
    this(Configuration.getDefaultApiClient());
  }

  public SignupControllerApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Add new user.
   * 
   * @param reqParams reqParams (required)
   * @return String
   * @throws ApiException if fails to make API call
   */
  public String addNewFormSignupUsingPOST(Object reqParams) throws ApiException {
    return addNewFormSignupUsingPOSTWithHttpInfo(reqParams).getData();
      }

  /**
   * Add new user.
   * 
   * @param reqParams reqParams (required)
   * @return ApiResponse&lt;String&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<String> addNewFormSignupUsingPOSTWithHttpInfo(Object reqParams) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'reqParams' is set
    if (reqParams == null) {
      throw new ApiException(400, "Missing the required parameter 'reqParams' when calling addNewFormSignupUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/signup/user/add/form";

    // query params
    java.util.List<Pair> localVarQueryParams = new java.util.ArrayList<Pair>();
    java.util.Map<String, String> localVarHeaderParams = new java.util.HashMap<String, String>();
    java.util.Map<String, Object> localVarFormParams = new java.util.HashMap<String, Object>();


    
    if (reqParams != null)
      localVarFormParams.put("reqParams", reqParams);

    final String[] localVarAccepts = {
      "*/*"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/x-www-form-urlencoded"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<String> localVarReturnType = new GenericType<String>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Add new user.
   * 
   * @param profile profile (required)
   * @return String
   * @throws ApiException if fails to make API call
   */
  public String addNewSignupUsingPOST(ProfileInformation profile) throws ApiException {
    return addNewSignupUsingPOSTWithHttpInfo(profile).getData();
      }

  /**
   * Add new user.
   * 
   * @param profile profile (required)
   * @return ApiResponse&lt;String&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<String> addNewSignupUsingPOSTWithHttpInfo(ProfileInformation profile) throws ApiException {
    Object localVarPostBody = profile;
    
    // verify the required parameter 'profile' is set
    if (profile == null) {
      throw new ApiException(400, "Missing the required parameter 'profile' when calling addNewSignupUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/signup/user/add";

    // query params
    java.util.List<Pair> localVarQueryParams = new java.util.ArrayList<Pair>();
    java.util.Map<String, String> localVarHeaderParams = new java.util.HashMap<String, String>();
    java.util.Map<String, Object> localVarFormParams = new java.util.HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "*/*"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json", "Profile data"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<String> localVarReturnType = new GenericType<String>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Delete user account.
   * 
   * @param username username (required)
   * @return String
   * @throws ApiException if fails to make API call
   */
  public String deleteSignupUsingDELETE(String username) throws ApiException {
    return deleteSignupUsingDELETEWithHttpInfo(username).getData();
      }

  /**
   * Delete user account.
   * 
   * @param username username (required)
   * @return ApiResponse&lt;String&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<String> deleteSignupUsingDELETEWithHttpInfo(String username) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'username' is set
    if (username == null) {
      throw new ApiException(400, "Missing the required parameter 'username' when calling deleteSignupUsingDELETE");
    }
    
    // create path and map variables
    String localVarPath = "/signup/user/delete/{username}"
      .replaceAll("\\{" + "username" + "\\}", apiClient.escapeString(username.toString()));

    // query params
    java.util.List<Pair> localVarQueryParams = new java.util.ArrayList<Pair>();
    java.util.Map<String, String> localVarHeaderParams = new java.util.HashMap<String, String>();
    java.util.Map<String, Object> localVarFormParams = new java.util.HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "*/*"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<String> localVarReturnType = new GenericType<String>() {};
    return apiClient.invokeAPI(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns all approved users only.
   * 
   * @return java.util.List&lt;Object&gt;
   * @throws ApiException if fails to make API call
   */
  public java.util.List<Object> getApprovedUsersUsingGET() throws ApiException {
    return getApprovedUsersUsingGETWithHttpInfo().getData();
      }

  /**
   * Returns all approved users only.
   * 
   * @return ApiResponse&lt;java.util.List&lt;Object&gt;&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<java.util.List<Object>> getApprovedUsersUsingGETWithHttpInfo() throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/signup/users/approved";

    // query params
    java.util.List<Pair> localVarQueryParams = new java.util.ArrayList<Pair>();
    java.util.Map<String, String> localVarHeaderParams = new java.util.HashMap<String, String>();
    java.util.Map<String, Object> localVarFormParams = new java.util.HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<java.util.List<Object>> localVarReturnType = new GenericType<java.util.List<Object>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns users with matched username.
   * 
   * @param username Login username (required)
   * @return java.util.List&lt;Object&gt;
   * @throws ApiException if fails to make API call
   */
  public java.util.List<Object> getSignedupUserUsingGET(String username) throws ApiException {
    return getSignedupUserUsingGETWithHttpInfo(username).getData();
      }

  /**
   * Returns users with matched username.
   * 
   * @param username Login username (required)
   * @return ApiResponse&lt;java.util.List&lt;Object&gt;&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<java.util.List<Object>> getSignedupUserUsingGETWithHttpInfo(String username) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'username' is set
    if (username == null) {
      throw new ApiException(400, "Missing the required parameter 'username' when calling getSignedupUserUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/signup/users/{username}"
      .replaceAll("\\{" + "username" + "\\}", apiClient.escapeString(username.toString()));

    // query params
    java.util.List<Pair> localVarQueryParams = new java.util.ArrayList<Pair>();
    java.util.Map<String, String> localVarHeaderParams = new java.util.HashMap<String, String>();
    java.util.Map<String, Object> localVarFormParams = new java.util.HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<java.util.List<Object>> localVarReturnType = new GenericType<java.util.List<Object>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns all users.
   * 
   * @return java.util.List&lt;Object&gt;
   * @throws ApiException if fails to make API call
   */
  public java.util.List<Object> getSignedupUsersUsingGET() throws ApiException {
    return getSignedupUsersUsingGETWithHttpInfo().getData();
      }

  /**
   * Returns all users.
   * 
   * @return ApiResponse&lt;java.util.List&lt;Object&gt;&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<java.util.List<Object>> getSignedupUsersUsingGETWithHttpInfo() throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/signup/users";

    // query params
    java.util.List<Pair> localVarQueryParams = new java.util.ArrayList<Pair>();
    java.util.Map<String, String> localVarHeaderParams = new java.util.HashMap<String, String>();
    java.util.Map<String, Object> localVarFormParams = new java.util.HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<java.util.List<Object>> localVarReturnType = new GenericType<java.util.List<Object>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns total number of users.
   * 
   * @return String
   * @throws ApiException if fails to make API call
   */
  public String getTotalUsersUsingGET() throws ApiException {
    return getTotalUsersUsingGETWithHttpInfo().getData();
      }

  /**
   * Returns total number of users.
   * 
   * @return ApiResponse&lt;String&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<String> getTotalUsersUsingGETWithHttpInfo() throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/signup/users/count";

    // query params
    java.util.List<Pair> localVarQueryParams = new java.util.ArrayList<Pair>();
    java.util.Map<String, String> localVarHeaderParams = new java.util.HashMap<String, String>();
    java.util.Map<String, Object> localVarFormParams = new java.util.HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<String> localVarReturnType = new GenericType<String>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Update some profile detail.
   * 
   * @param updates updates (required)
   * @param username username (required)
   * @return String
   * @throws ApiException if fails to make API call
   */
  public String partialupdateSignupUsingPATCH(Object updates, String username) throws ApiException {
    return partialupdateSignupUsingPATCHWithHttpInfo(updates, username).getData();
      }

  /**
   * Update some profile detail.
   * 
   * @param updates updates (required)
   * @param username username (required)
   * @return ApiResponse&lt;String&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<String> partialupdateSignupUsingPATCHWithHttpInfo(Object updates, String username) throws ApiException {
    Object localVarPostBody = updates;
    
    // verify the required parameter 'updates' is set
    if (updates == null) {
      throw new ApiException(400, "Missing the required parameter 'updates' when calling partialupdateSignupUsingPATCH");
    }
    
    // verify the required parameter 'username' is set
    if (username == null) {
      throw new ApiException(400, "Missing the required parameter 'username' when calling partialupdateSignupUsingPATCH");
    }
    
    // create path and map variables
    String localVarPath = "/signup/user/update/partial/{username}"
      .replaceAll("\\{" + "username" + "\\}", apiClient.escapeString(username.toString()));

    // query params
    java.util.List<Pair> localVarQueryParams = new java.util.ArrayList<Pair>();
    java.util.Map<String, String> localVarHeaderParams = new java.util.HashMap<String, String>();
    java.util.Map<String, Object> localVarFormParams = new java.util.HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "*/*"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<String> localVarReturnType = new GenericType<String>() {};
    return apiClient.invokeAPI(localVarPath, "PATCH", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Update a user account.
   * 
   * @param profile profile (required)
   * @param username username (required)
   * @return String
   * @throws ApiException if fails to make API call
   */
  public String updateSignupUsingPUT(ProfileInformation profile, String username) throws ApiException {
    return updateSignupUsingPUTWithHttpInfo(profile, username).getData();
      }

  /**
   * Update a user account.
   * 
   * @param profile profile (required)
   * @param username username (required)
   * @return ApiResponse&lt;String&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<String> updateSignupUsingPUTWithHttpInfo(ProfileInformation profile, String username) throws ApiException {
    Object localVarPostBody = profile;
    
    // verify the required parameter 'profile' is set
    if (profile == null) {
      throw new ApiException(400, "Missing the required parameter 'profile' when calling updateSignupUsingPUT");
    }
    
    // verify the required parameter 'username' is set
    if (username == null) {
      throw new ApiException(400, "Missing the required parameter 'username' when calling updateSignupUsingPUT");
    }
    
    // create path and map variables
    String localVarPath = "/signup/user/update/full/{username}"
      .replaceAll("\\{" + "username" + "\\}", apiClient.escapeString(username.toString()));

    // query params
    java.util.List<Pair> localVarQueryParams = new java.util.ArrayList<Pair>();
    java.util.Map<String, String> localVarHeaderParams = new java.util.HashMap<String, String>();
    java.util.Map<String, Object> localVarFormParams = new java.util.HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "*/*"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<String> localVarReturnType = new GenericType<String>() {};
    return apiClient.invokeAPI(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
