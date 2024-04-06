package services.login;

import browseractions.BrowserActions;

public class LoginPageServices {
    private final BrowserActions browserActions = new BrowserActions();
    private final String USERNAME_FIELD;
    private final String PASSWORD_FIELD;
    private final String LOGIN_BUTTON_FIELD;
    private final String USERNAME;
    private final String PASSWORD;
    public LoginPageServices(){
        USERNAME_FIELD = System.getProperty("username.field");
        PASSWORD_FIELD = System.getProperty("password.field");
        LOGIN_BUTTON_FIELD = System.getProperty("login.button");
        USERNAME = System.getProperty("login.username");
        PASSWORD = System.getProperty("login.password");
    }

    public void navigateToWebsite(){
        browserActions.navigateToURL();
    }
    public void enterUsername(){
        browserActions.fillData(USERNAME_FIELD, BrowserActions.TypeOfElement.ID, USERNAME);
    }
    public void enterPassword(){
        browserActions.fillData(PASSWORD_FIELD, BrowserActions.TypeOfElement.ID, PASSWORD);
    }
    public void login(){
        browserActions.click(LOGIN_BUTTON_FIELD, BrowserActions.TypeOfElement.ID);
    }

    public void closeDriver(){
        browserActions.closeBrowser();
    }
}
