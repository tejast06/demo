package pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HomePage extends TestBase {

    @FindBy(xpath = "//input[@id='BE_flight_origin_city']")
    WebElement originCity;

    @FindBy(xpath = "//input[@id='BE_flight_arrival_city']")
    WebElement arrivalCity;

    @FindBy(xpath="xpath_Delhi = //p[text()='New Delhi ']")
    WebElement delhi;

    @FindBy(xpath = "//input[@id='BE_flight_origin_date']")
    WebElement originDateField;

    @FindBy(xpath = "//td[@id='31/03/2022']")
    WebElement date;

    @FindBy(xpath = "//div[@class='booking-btn-flx']/div[1]")
    WebElement searchFlightBtn;

    @FindBy(xpath="//div[@id='booking_engine_modues']")
    WebElement getTextFromFields;


    public HomePage() throws IOException, IOException {
        super();
        PageFactory.initElements(driver, this);
    }

    /**
     * Created by TTOLEY
     * This method return the page title
     * @return
     */
    public String validatePageTitle(){
        return driver.getTitle();
    }

    /**
     * Created by TTOLEY
     * This method return the values from all fields
     * @return
     */
    public String getValuesFromFields(){
       return getTextFromFields.getText();
    }

    /**
     * Created by TTOLEY
     * This method click on Origin city field
     */
    public void clickOnDepartFromField() throws InterruptedException {
        originCity.click();
        Thread.sleep(2000);
    }

    /**
     * Created by TTOLEY
     * This method select the city
     * @param city
     */
    public void selectCity(String city) throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//p[text()='"+city+" ']"));
        element.click();
        Thread.sleep(2000);
    }

    /**
     * Created by TTOLEY
     * This method click on Arrival City
     */
    public void clickOnGoingToField() throws InterruptedException {
        arrivalCity.click();
        Thread.sleep(2000);
    }

    /**
     * Created by TTOLEY
     * This method click on Departure field
     */
    public void clickOnDepartureDateField() throws InterruptedException {
        originDateField.click();
        Thread.sleep(2000);

    }

    /**
     * Created by TTOLEY
     * This method select date from the calendar.
     * @param date
     */
    public void selectDate(String date) throws InterruptedException {
       driver.findElement(By.xpath("//td[@id='"+date+"']")).click();
       Thread.sleep(2000);
    }

    /**
     * Created by TTOLEY
     * This method click on search flight btn
     */
    public SearchFlightResultPage clickOnSearchFlightButton() throws IOException {
        searchFlightBtn.click();
        return new SearchFlightResultPage();
    }
}
