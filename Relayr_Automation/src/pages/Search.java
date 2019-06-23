package pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

public class Search {

    WebDriver driver;

    @FindBy(xpath="//*[@id=\"container\"]/div[2]/div/div[1]/div[2]/div[2]/div/label/span")
    WebElement searchIcon;
    
    @FindBy(xpath="//*[@id=\"container\"]/div[1]/div/div/div[1]/a")
    WebElement privacyPolicyLink;
    
    @FindBy(xpath="//*[@id=\"container\"]/div[1]/div/div/div[2]/button/span")
    WebElement privacyPolicyClose;
    
    @FindBy(xpath="//*[@id=\"container\"]/div[2]/div/div[1]/div[2]/div[2]/div/label/input")
    WebElement searchTextBox;
    
    @FindBy(xpath="//*[@id=\"container\"]/div[2]/div/div[4]/div[1]/div/header[1]/div/div[1]/span")
    WebElement searchPeopleText;
    
    @FindBy(xpath="//*[@id=\"container\"]/div[2]/div/div[4]/div[1]/div/header[1]/div/div[2]/a")
    WebElement searchMoreText;
    
    @FindBy(xpath="//*[@id=\"container\"]/div[2]/div/div[4]/div[1]/div/header[2]/div/div[1]/span")
    WebElement searchPublicationText;
    
    @FindBy(xpath="//*[@id=\"container\"]/div[2]/div/div[4]/div[1]/div/a/span[2]")
    WebElement searchForText;
    
    @FindBy(xpath="//*[@id=\"container\"]/div[2]/div/div[4]/div[1]/div/ul[1]/li[1]/a/div/div/span")
    WebElement searchResult;
    
    @FindBy(xpath="//*[@id=\"container\"]/div[2]/div/div[3]/div[2]/div[2]/div/ul/li[1]/div[1]/span/button[2]")
    WebElement followButton;
    
    public Search(WebDriver driver){
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    //Check if the search icon exists
    public boolean getSearchIcon(){
     try {
    	 // Closes the privacy policy link if displayed
    	 if (privacyPolicyLink.isDisplayed()) {
        	 privacyPolicyClose.click();
        	 return searchIcon.isDisplayed();
         }
     }
     catch(Exception e)     
     {       
    	 return searchIcon.isDisplayed();  
     }
	return true;   
    }
    
    public void clickOnSearch() {
    	searchIcon.click();
    }
    
    public void searchText(String searchText) {
    	searchTextBox.sendKeys(searchText);
    }
    
    public void getPlaceholderText() {
    	searchTextBox.getAttribute("Search Medium");
    }
    
    public String getPeopleText() {
    	return searchPeopleText.getText();
    }
    
    public String getSearchResult() {
    	return searchResult.getText();
    }
    
    public void clickOnMore() {
    	searchMoreText.click();
    }
    
    public boolean getFollowButton() {
    	return followButton.isDisplayed();
    }
}