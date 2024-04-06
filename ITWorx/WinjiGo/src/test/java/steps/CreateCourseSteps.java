package steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import services.login.CoursesPageServices;
import services.login.CreateCoursePageServices;
import services.login.LoginPageServices;

public class CreateCourseSteps {
    LoginPageServices loginPageServices = new LoginPageServices();
    CoursesPageServices coursesPageServices = new CoursesPageServices();
    CreateCoursePageServices createCoursePageServices = new CreateCoursePageServices();
    @Given("User navigates to the website")
    public void userNavigatesToTheWebsite() {
        loginPageServices.navigateToWebsite();
    }

    @Given("that the user logs in")
    public void thatTheUserLogsIn() {
        loginPageServices.enterUsername();
        loginPageServices.enterPassword();
        loginPageServices.login();
    }

    @And("the user navigates to the courses page")
    public void theUserNavigatesToTheCoursesPage() {
        coursesPageServices.navigateToCoursesPage();
    }

    @Then("the user clicks on add course button")
    public void theUserClicksOnAddCourseButton() {
        coursesPageServices.createNewCourse();
    }

    @When("the user click on the create button")
    public void theUserClickOnTheCreateButton() {
        createCoursePageServices.createCourse();
    }

    @Then("the course should reflect on the courses list page")
    public void theCourseShouldReflectOnTheCoursesListPage() {
        coursesPageServices.filterCourse();
        Assert.assertEquals(coursesPageServices.getCourseName(), coursesPageServices.getUserCourseNameInput());
    }

    @Then("the user fills all the form data")
    public void theUserFillsAllTheFormData() {
        createCoursePageServices.addCourseName();
        createCoursePageServices.addCourseGrade();
        createCoursePageServices.addCourseSubject();
        createCoursePageServices.addCourseTeacher();
    }
    @After
    public void closeDriver(){
        loginPageServices.closeDriver();
    }
}
