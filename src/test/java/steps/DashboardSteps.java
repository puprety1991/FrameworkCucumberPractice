package steps;

import io.cucumber.java.en.Then;
import utils.CommonMethods;

public class DashboardSteps extends CommonMethods {
    @Then("user verify dashboard page")
    public void user_verify_dashboard_page() {
        softAssertionDisplay(dashboard.dashboardText);
    }
}
