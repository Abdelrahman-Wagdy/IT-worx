package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import models.Activity;
import org.testng.Assert;

import static services.APIServices.getRandomActivity;

public class ActivityApiSteps {
    private Activity activity = new Activity();
    private Response response;
    @Given("that the user fires a get request")
    public void thatTheUserFiresAGetRequest() {
        response = getRandomActivity();
    }

    @Then("the response code shall be 200")
    public void theResponseCodeShallBe() {
        Assert.assertEquals(response.statusCode(), 200);
    }

    @And("the response body shall be correct")
    public void theResponseBodyShallBeCorrect() {
        activity = response.as(Activity.class);
        System.out.println(activity.toString());
        Assert.assertTrue(activity.getActivity() != null, "activity isn't sent");
        Assert.assertTrue(activity.getAccessibility() != null);
        Assert.assertTrue(activity.getKey() != null);
        Assert.assertTrue(activity.getLink() != null);
        Assert.assertTrue(activity.getPrice() != null);
        Assert.assertTrue(activity.getType() != null);
        Assert.assertTrue(activity.getParticipants() != 0);
    }
}
