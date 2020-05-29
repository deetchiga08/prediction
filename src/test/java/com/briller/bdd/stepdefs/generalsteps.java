package com.briller.bdd.stepdefs;
import com.briller.Model.general;
import cucumber.api.java8.En;
import io.cucumber.datatable.DataTable;
import io.restassured.response.Response;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
public class generalsteps extends AbstractSteps implements En {

    public generalsteps() {
        Given("user wants to create an general with the following attributes", (DataTable dataTable) -> {
            testContext().reset();
            List<general> generalList = dataTable.asList(general.class);

            // First row of DataTable has the general attributes hence calling get(0) method.
            super.testContext()
                    .setPayload(generalList.get(0));
        });

        When("user saves the new general {string}", (String testContext) -> {
            String createSampleUrl = "/test/adddata";

            // AbstractSteps class makes the POST call and stores response in TestContext
            executePost(createSampleUrl);
        });

        Then("the save {string}", (String expectedResult) -> {
            Response response = testContext().getResponse();

            switch (expectedResult) {
                case "IS SUCCESSFUL":
                    assertThat(response.statusCode()).isIn(200, 201);
                    break;
                case "FAILS":
                    assertThat(response.statusCode()).isBetween(400, 504);
                    break;
                default:
                    fail("Unexpected error");
            }
        });


    }
}