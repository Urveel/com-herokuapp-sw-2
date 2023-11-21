package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class LoginTest extends BaseTest {

    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before

    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//button[@class='radius']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    public void verifyUsernameErrorMessage(){
        //storing expected text value in variable
        String expectedMessage = "Secure Area";

        //Finding element to locate text and store in variable
        WebElement actualTextElement = driver.findElement(By.xpath("//h4[@class='subheader']"));

        //Getting the actual text from webpage and storing into variable
        String actualMessage = actualTextElement.getText();

        //Comparing the expected and actual text and print message in console
        Assert.assertEquals("Invalid message", expectedMessage, actualMessage);
    }


    @Test
    public void verifyTheUsernameErrorMessage() {
        driver.findElement(By.name("username")).sendKeys("tomsmith1");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//button[@class='radius']")).click();
        String expectedMessage = "Your username is invalid!";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@id='flash']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Invalid Username", expectedMessage, actualMessage);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    public void verifyThePasswordErrorMessage() {
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        driver.findElement(By.xpath("//button[@class='radius']")).click();
        String expectedMessage = "Your username is invalid!";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@id='flash']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Invalid Password", expectedMessage, actualMessage);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

}
