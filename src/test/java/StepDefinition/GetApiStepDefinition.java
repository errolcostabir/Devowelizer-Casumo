package StepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.*;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import utils.InitExtentReport;
import utils.TestContextSetup;
import utils.ToolsFactory;

import java.io.IOException;

public class GetApiStepDefinition {

    public int Statuscode;
    Response response;
    TestContextSetup testContextSetup;
    InitExtentReport extentReport;
    ResponseBody body;
    ToolsFactory tool;
    RequestSpecification httpRequest;

    public GetApiStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        extentReport = new InitExtentReport(testContextSetup);
        tool=new ToolsFactory();
    }

    //method that runs before each scenario
    @Before
    public void beforeScenario(Scenario scenario) throws IOException {
        extentReport.initializeExtentReport();
        testContextSetup.test = testContextSetup.report.createTest(scenario.getName());
        testContextSetup.test.info("Initialized report");
    }

    //method runs after each scenario
    @After
    public void afterScenario() {
        testContextSetup.test.info("Flushing reports");
        testContextSetup.report.flush();
    }

    //the step definition logic for the given statement
    @Given("get request is made to the respective URI")
    public void api_request_is_made() {
        testContextSetup.test.info("Set the Base URI");
        try {
            //setting the base URI
            RestAssured.baseURI = "http://localhost:8080/";
            httpRequest = RestAssured.given();
        } catch (Exception e) {
            testContextSetup.test.fail("Entered Catch");
        }
    }

    //the step definition logic for And statement
    @And("the words checked are {string}")
    public void the_words_checked_are(String str) {
        try{
            //making a get request for each parameter
            testContextSetup.test.info("http request is made");
            response = httpRequest.get(str);
        }catch(Exception e){
            testContextSetup.test.fail("Entered Catch");
        }
    }

    //the step definition logic for then statement
    @Then("the response body should not have a vowel")
    public void the_response_should_not_have_a_vowel() {
        try{
            testContextSetup.test.info("Getting response body");
            body = response.getBody(); //getting the response body
            String responseBody = body.asString(); //converting response body to string
            testContextSetup.test.info("Response is: "+responseBody);
            Assert.assertTrue(tool.containsvowel(responseBody)); //Asserting if the ressponse is having a vowel or no
            testContextSetup.test.pass("No vowels were present in the response");
        }catch(Exception e){
            testContextSetup.test.fail("Entered Catch");
        }
    }

}
