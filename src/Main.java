import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {


        final String fdj = "https://www.fdj.fr/jeux-de-tirage/loto/resultats";

        // Open a new browser window
        FirefoxDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.navigate().to(fdj);

        //------------------- française des jeux-----------------------
        Thread.sleep(5000);
        final String firstNumber = driver.findElement(By.cssSelector("div.result-content:nth-child(2) > div:nth-child(1) > div:nth-child(1) > span:nth-child(1)")).getText();
        final String secondNumber = driver.findElement(By.cssSelector("div.result-content:nth-child(2) > div:nth-child(1) > div:nth-child(2) > span:nth-child(1)")).getText();
        final String thirdNumber = driver.findElement(By.cssSelector("div.result-content:nth-child(2) > div:nth-child(1) > div:nth-child(3) > span:nth-child(1)")).getText();
        final String fourthNumber = driver.findElement(By.cssSelector("div.result-content:nth-child(2) > div:nth-child(1) > div:nth-child(4) > span:nth-child(1)")).getText();
        final String fifthNumber = driver.findElement(By.cssSelector("div.result-content:nth-child(2) > div:nth-child(1) > div:nth-child(5) > span:nth-child(1)")).getText();
        final String sixthNumber = driver.findElement(By.cssSelector("span.numbers-item_num:nth-child(2)")).getText();
        WebElement field = driver.findElement(By.cssSelector(".header-search-desktop > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)"));
        Actions builder = new Actions(driver);

        final String val = "la grotte aux dragons";
        for (char c : val.toCharArray()) {
            String s = new StringBuilder().append(c).toString();
            field.sendKeys(s);
            Thread.sleep(1000);

        }


        Actions seriesOfActions = builder.moveToElement(field).click().sendKeys(field, "la grotte aux dragons");
        Thread.sleep(200);
        seriesOfActions.perform();
        final String result = firstNumber + " " + secondNumber + " " + thirdNumber + " " + fourthNumber + " " + fifthNumber + " " + sixthNumber;
        System.out.println(result);

        // Close the browser window
        driver.close();

    }

}
