package es.sescam.ykonos.test.pages;

public class LoginIncorrectPage extends BasePage {

    public boolean findErrorMessage(){
        return find(getProperty("config-data.error-message")).isDisplayed();
    }

    public boolean compareTextErrorMessage1(){
        return getProperty("config-data.error-message-1") != null &&
        		getProperty("config-data.error-message-1").equals("Error en la autenticación del usuario");
    }    

    public boolean compareTextErrorMessage2(){
        return getProperty("config-data.error-message-2") != null &&
        		getProperty("config-data.error-message-2").equals("Usuario o contraseña incorrectos");
    }

    public boolean confirmInputColor(){
        return getProperty("config-data.password-value") != null && getProperty("config-data.password-value").equals("#dc3545");
    }
}