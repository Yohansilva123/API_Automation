import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.jayway.restassured.RestAssured.given;

public class SampleApiTest {
    SoftAssert softAssert;

    @Test
    public void makeSureThatGoogleIsUp() {
        softAssert =  new SoftAssert();
        Response response =  given().when().get("http://www.google.com");
        System.out.println(response.statusCode());
        softAssert.assertEquals(response.statusCode(), 200);
        softAssert.assertAll();
    }
    
    @Test
    public void postRequestTest(){
        softAssert =  new SoftAssert();
        RestAssured.baseURI ="http://restapi.demoqa.com/customer";
        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("FirstName", "Virender"); // Cast
        requestParams.put("LastName", "Singh");
        requestParams.put("UserName", "yohan_silv5625");
        requestParams.put("Password", "password1");

        requestParams.put("Email",  "yohansilvaa5556a@gmail.com");

        request.body(requestParams.toJSONString());
        Response response = request.post("/register");

        int statusCode = response.getStatusCode();
        System.out.println(statusCode);
        softAssert.assertEquals(statusCode, 201);

        System.out.println(response.body().asString());
//        softAssert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");

        JSONObject requestParams2 = new JSONObject();
        requestParams2.put("Email",  "yohansilvaa5556a@gmail.com"); // Cast
//        requestParams2.put("LastName", "Singh");

        request.body(requestParams2.toJSONString());
        response =  request.get("/register");

        System.out.println(response.body().asString());

        softAssert.assertAll();

    }
    @Test
    public void test(){
        String s1 = "1.00";
        String s2 = "-1.00";
        double v1= 1.02;
        double v2= -1.02;
        double v3 = Double.parseDouble(s1);
        double v4 = Double.parseDouble(s2);

        System.out.println(v1-v2);
        System.out.println(v3);
        System.out.println(v4);
    }

}
