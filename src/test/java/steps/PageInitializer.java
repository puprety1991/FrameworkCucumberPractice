package steps;

import pages.AddEmployeePage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.SearchEmployeePage;

public class PageInitializer {
    public static LoginPage login;
    public static DashboardPage dashboard;

    public static AddEmployeePage addEmployee;
    public static SearchEmployeePage searchEmployee;
    public static void initializePageObjects(){
        login=new LoginPage();
        dashboard = new DashboardPage();
        addEmployee=new AddEmployeePage();
        searchEmployee = new SearchEmployeePage();

    }


}
