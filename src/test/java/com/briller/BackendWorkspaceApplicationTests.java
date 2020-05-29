package com.briller;


import com.briller.Mapper.generalMapper;
import com.briller.Model.general;
import com.briller.Model.generalDTO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import com.briller.Controller.generalController;
import org.junit.runner.RunWith;

import com.briller.Model.*;
import static org.junit.Assert.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BackendWorkspaceApplicationTests {


    @Autowired
    private generalController GeneralController;


    @Test
    public void contextLoads()
    {

    }

    /* u can write test cases like this for every api*/

    @Before
    public void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8002;
    }

    @Test
    public void whenMeasureResponseTime_thenCorrect() {
        Response data = RestAssured.get("/test/getdata");
        long timeInMillis = data.time();
        long timeInSec = data.timeIn(TimeUnit.SECONDS);
        assertEquals(timeInSec, timeInMillis/1000);
    }


    @Test
    public void getData(){
        get("/test/getdata").then().statusCode(200);
    }

    @Test
    public void postdata(){
        with().body(new general(2,"worker"))
                .contentType(ContentType.JSON)
                .when().request("POST", "/test/adddata")
                .then().statusCode(200);
    }

}
