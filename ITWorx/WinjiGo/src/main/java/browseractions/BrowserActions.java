package browseractions;

import driversingleton.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyFileHandler;

import java.time.Duration;
import java.util.List;

public class BrowserActions {
    private String URL;

    public BrowserActions(){
        PropertyFileHandler propertyFileHander = new PropertyFileHandler("src/test/resources/config.properties");
        propertyFileHander.loadPropertiesFile();
        URL = System.getProperty("url");

    }
    public enum TypeOfElement {
        ID("id"),
        CSS_SELECTOR("css selector"),
        XPATH("xpath"),
        NAME("name"),
        CLASSNAME("classname");
        protected String typeValue;
        TypeOfElement(String typeValue){
            this.typeValue=typeValue;
        }
    }
    public WebElement getElement(String element,TypeOfElement typeOfElement){
        try{
            switch (typeOfElement){
                case ID:
                    return DriverSingleton.getDriver().findElement(By.id(element));
                case CSS_SELECTOR:
                    return DriverSingleton.getDriver().findElement(By.cssSelector("*[title=\""+element+"\"]"));
                case XPATH:
                    return DriverSingleton.getDriver().findElement(By.xpath(element));
                case CLASSNAME:
                    return DriverSingleton.getDriver().findElement(By.className(element));
                case NAME:
                default:
                    return DriverSingleton.getDriver().findElement(By.name(element));
            }
        }catch (NoSuchElementException error){
            waitTillVisible(element, typeOfElement);
            return  getElement(element, typeOfElement);
        }
    }

    public void click(String element,TypeOfElement typeOfElement){
        try{
            getElement(element, typeOfElement).click();
        }catch (ElementNotInteractableException error){
            waitTillClickable(element, typeOfElement);
            click(element, typeOfElement);
        }

    }
    public void fillData(String element,TypeOfElement typeOfElement, String data){
        getElement(element, typeOfElement).sendKeys(data);
    }
    public void closeBrowser(){
        DriverSingleton.getDriver().quit();
    }
    public void navigateToURL(){
        DriverSingleton.getDriver().navigate().to(URL);
    }
    public String getURL(){
        return DriverSingleton.getDriver().getCurrentUrl();
    }
    public List<WebElement> getElements(String element, TypeOfElement typeOfElement){
        switch (typeOfElement) {
            case ID:
                return DriverSingleton.getDriver().findElements(By.id(element));
            case CSS_SELECTOR:
                return DriverSingleton.getDriver().findElements(By.cssSelector("*[title=\"" + element + "\"]"));
            case XPATH:
                return DriverSingleton.getDriver().findElements(By.xpath(element));
            case CLASSNAME:
                return DriverSingleton.getDriver().findElements(By.className(element));
            case NAME:
            default:
                return DriverSingleton.getDriver().findElements(By.name(element));
        }
    }
    public void selectOption(String element, TypeOfElement typeOfElement,String value){
        Select dropdown = new Select(getElement(element, typeOfElement));
        dropdown.selectByVisibleText(value);
    }
    private void waitTillVisible(String element, TypeOfElement typeOfElement){
        WebDriverWait wait = new WebDriverWait(DriverSingleton.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(getElement(element, typeOfElement)));
    }
    private void waitTillClickable(String element, TypeOfElement typeOfElement){
        WebDriverWait wait = new WebDriverWait(DriverSingleton.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(getElement(element, typeOfElement)));
    }
}
