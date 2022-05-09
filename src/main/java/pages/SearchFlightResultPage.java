package pages;

import base.TestBase;


import java.io.IOException;

public class SearchFlightResultPage extends TestBase {

    public SearchFlightResultPage() throws IOException, IOException {

    }

    /**
     * Created by TTOLEY
     * This method return the title of the page
     * @return
     */
    public String getPageTitle(){
        return driver.getTitle();
    }
}
