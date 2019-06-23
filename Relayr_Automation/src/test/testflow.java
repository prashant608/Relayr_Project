package test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Search;

public class testflow {

    WebDriver driver;
    String text = "prashant";
    
    @BeforeTest

    public void setup(){

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://medium.com/");
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(priority=0)
    
    public void launch_search_text(){
    Search search = new Search(driver);

    // Verify Search icon text
      String searchIconText = String.valueOf(search.getSearchIcon());
      Assert.assertTrue(searchIconText.toLowerCase().contains("true"));

    // Verify placeholder exists
      search.clickOnSearch();
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      search.getPlaceholderText();
    
   // Verify instant search is working properly.
     // Enters a text, search and verifies the texts in search dropdown
     search.searchText(text);
     String peopleText = search.getPeopleText();
     Assert.assertTrue(peopleText.toLowerCase().contains("people"));
     
   // Verifies the search result contains the searched text
     String searchResult = search.getSearchResult();
     Assert.assertTrue(searchResult.toLowerCase().contains(text));
     
   // Click on more link and navigate to search page, check if follow button is present
     search.clickOnMore();
     String followButton = String.valueOf(search.getFollowButton());
     Assert.assertTrue(followButton.toLowerCase().contains("true"));
     
     driver.quit();

    }
}