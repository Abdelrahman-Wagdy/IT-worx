package services;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.*;

public class APIServices {
    public static Response getRandomActivity(){
        return RestAssured.get("https://www.boredapi.com/api/activity");
    }
}
