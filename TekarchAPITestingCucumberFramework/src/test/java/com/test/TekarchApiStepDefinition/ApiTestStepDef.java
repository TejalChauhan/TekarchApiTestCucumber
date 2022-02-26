package com.test.TekarchApiStepDefinition;

import java.io.File;

import org.hamcrest.Matchers;

import com.test.Constants.Endpoints;
import com.test.Constants.SourcePath;
import com.test.Utils.Utils;
import com.test.helpers.UserServiceHelper;
import com.test.modules.LoginPojo;
import com.test.modules.UserPojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class ApiTestStepDef extends UserServiceHelper {
	 public static String token;
	
	@Given("User sets the baseURL for API request")
	public void user_sets_the_base_url_for_api_request() {
		RestAssured.baseURI = getBaseUri();
	}
	

	@When("User send Login API request to LoginTekarchAPI")
	public void user_send_login_api_request_to_logintekarchapi() {
		loginToApp();																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																							
	}

	@Then("Save the response token")
	public void save_the_response_token() {
		token = response.jsonPath().getString("[0].token");
		System.out.println("The generated token: "+token); 
	}
	@When("User send post request to add new user data")
	public void user_send_post_request_to_add_new_user_data() {
		addUserData(token);
		System.out.println("Status after Add new user data :  ");
	}

	@Then("validate the response status")
	public void validate_the_response_status() {
		int status = response.getStatusCode();
		System.out.println("Status Code :"+status);
		response.then().statusCode(201);
	}

	@Then("validate the successful response")
	public void validate_the_successful_response() {
		String res_status = response.jsonPath().getString("status");
		System.out.print(res_status);
		response.then().assertThat().body("status", Matchers.equalTo("success"));
	}
	@When("User send update request to update user data")
	public void user_send_update_request_to_update_user_data() {
	   updateUserData(token);
	   System.out.println("Status after update the user data :  ");
	}
	@When("User send delete request to delete the user data")
	public void user_send_delete_request_to_delete_the_user_data() {
	   deleteUserData(token);
	   System.out.println("Status after delete the user data :  ");
	}
	@When("User send get request to get all the user data")
	public void user_send_get_request_to_get_all_the_user_data() {
	   UserPojo[] list =  getUserData(token);
	}

	@Then("validate the json schema in response")
	public void validate_the_json_schema_in_response() {
	//	response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File(SourcePath.USERDATA_JASONPATH)));
	}

}
