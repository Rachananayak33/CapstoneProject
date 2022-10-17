package com.log4j.test;
import static org.junit.Assert.*;
import org.json.simple.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import io.restassured.specification.RequestSpecification;
public class TestRestAssured {
	RequestSpecification given;
	InitLogger logger;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	@Before
	public void setUp() throws Exception {
		logger = new InitLogger(TestRestAssured.class.getName());
		RestAssured.baseURI="http://localhost:8080/FlyAway";
		given = RestAssured.given();
	}
	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void testLogin() {
		RestAssured.baseURI= "http://localhost:8080/FlyAway/loginaction";
		RequestSpecification given = RestAssured.given();
		Response response = given.request(Method.POST, "?email_id=user@user.com&pwd=user");
		if (response.statusCode()==200) {
			System.out.println("Invalid Username or Password");
		} else {
			logger.LogDebug("Login");
			System.out.println("Success for login with response code "+response.getStatusCode());
			System.out.println(response.getHeader("Content-Type"));
		}
	}
	@Test
	public void testRegister() {
		RestAssured.baseURI="http://localhost:8080/FlyAway/signupaction";
		RequestSpecification given = RestAssured.given();
		Response response = given.request(Method.POST,"?email_id=user81@user.com&pwd=user&pwd2=user&name=user2&address=user&city=user");
		if (response.statusCode()==200) {
			System.out.println("User already exist");
		} else {
			logger.LogDebug("Register");
			System.out.println("Success for register with response code "+response.getStatusCode());
			System.out.println(response.getHeader("Content-Type"));
		}
	}
	@Test
	public void testSelectFlight() {
		RestAssured.baseURI="http://localhost:8080/FlyAway/home";
		RequestSpecification given = RestAssured.given();
		Response response = given.request(Method.GET,"?source=1&destination=4");
		logger.LogDebug("Select Flight");
		System.out.println("Success for Select Flight with response code "+response.getStatusCode());
		System.out.println(response.getHeader("Content-Type"));
	}
	@Test
	public void testSeeBookings() {
		RestAssured.baseURI="http://localhost:8080/FlyAway/bookflight";
		RequestSpecification given = RestAssured.given();
		Response response = given.request(Method.GET,"?id=1");
		logger.LogDebug("See Bookings");
		System.out.println("Success for See Booking with response code "+response.getStatusCode());
		System.out.println(response.getHeader("Content-Type"));
	}
	@Test
	public void testCompletePurchase() {
		RestAssured.baseURI="http://localhost:8080/FlyAway/completepurchase";
		RequestSpecification given = RestAssured.given();
		Response response = given.request(Method.GET);
		logger.LogDebug("Complete purchase");
		System.out.println("Success for Complete Purchase with response code "+response.getStatusCode());
		System.out.println(response.getHeader("Content-Type"));	
	}
}

