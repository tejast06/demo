package testcases;

import base.TestBase;
import pages.HomePage;
import pages.SearchFlightResultPage;
import testdata.TestDataFlightBooking;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import java.io.IOException;



public class TestFlightSearch extends TestBase implements TestDataFlightBooking {

    public HomePage homePage;
    public SearchFlightResultPage searchFlightResultPage;

    public TestFlightSearch() throws IOException, IOException {
        super();

    }

    @BeforeTest
    public void launchTheBrowser() throws IOException {

        initialization();
        homePage = new HomePage();
    }





    @Test(enabled = false)
    public void searchFlight() throws InterruptedException, IOException {

        //Validate that Page title is display on Home page
        SoftAssert softAssert = new SoftAssert();
        Assert.assertTrue(homePage.validatePageTitle().contains(homePageTitle),"Page title:"+homePageTitle+" is not" +
                "displayed on Home Page");

        //Click on 'Departure' field
        homePage.clickOnDepartFromField();

        //select 'Bangalore' from the dropdown
        homePage.selectCity(blr);

        //Validate that 'Bangalore' is display on Departure field.
        softAssert.assertTrue(homePage.getValuesFromFields().contains(BLR),"'Bangalore' is not displayed on Departure field.");

        //Click on 'Going To' field
        homePage.clickOnGoingToField();

        //Select 'New Delhi' from the dropdown
        homePage.selectCity(del);

        //Validate that 'New Delhi' is display on 'Going To' field
        softAssert.assertTrue(homePage.getValuesFromFields().contains(DEL),"'New Delhi' is not displayed on 'Going To' field");

        //Click on Departure date field
        homePage.clickOnDepartureDateField();

        //select '31/03/2022' from calendar
        homePage.selectDate(date);

        //Validate that '31/03/2022' is display on  departure date field
        softAssert.assertTrue(homePage.getValuesFromFields().contains(departureDate),"'31/03/2022' is not displayed" +
                " on  departure date field");
        softAssert.assertAll();


        //Click on Search flight button
       searchFlightResultPage =  homePage.clickOnSearchFlightButton();

       //Validate that page title: 'Yatra.com | Bengaluru to Delhi flights' is display
        softAssert.assertTrue(searchFlightResultPage.getPageTitle().contains(resultPageTitle),"page title: " +
                ""+resultPageTitle+" is not displayed");
        softAssert.assertAll();
    }

    @AfterTest
    public void closeTheBrowser(){
        driver.quit();
    }


}
