import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {


        String fdj = "https://www.fdj.fr/jeux-de-tirage/loto/resultats";

        // Open a new browser window
        FirefoxDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.navigate().to("https://www.fdj.fr/jeux-de-tirage/loto/resultats");

        //------------------- française des jeux-----------------------
        Thread.sleep(5000);
        final String text = driver.findElement(By.cssSelector("div.result-content:nth-child(2) > div:nth-child(1) > div:nth-child(1) > span:nth-child(1)")).getText();
        final String text1 = driver.findElement(By.cssSelector("div.result-content:nth-child(2) > div:nth-child(1) > div:nth-child(2) > span:nth-child(1)")).getText();
        final String text2 = driver.findElement(By.cssSelector("div.result-content:nth-child(2) > div:nth-child(1) > div:nth-child(3) > span:nth-child(1)")).getText();
        final String text3 = driver.findElement(By.cssSelector("div.result-content:nth-child(2) > div:nth-child(1) > div:nth-child(4) > span:nth-child(1)")).getText();
        final String text4 = driver.findElement(By.cssSelector("div.result-content:nth-child(2) > div:nth-child(1) > div:nth-child(5) > span:nth-child(1)")).getText();
        final String text5 = driver.findElement(By.cssSelector("span.numbers-item_num:nth-child(2)")).getText();
        WebElement field = driver.findElement(By.cssSelector(".header-search-desktop > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)"));
        Actions builder = new Actions(driver);

        String val = "la grotte aux dragons";
        for (int i = 0; i < val.length(); i++){
            char c = val.charAt(i);
            String s = new StringBuilder().append(c).toString();
            field.sendKeys(s);
            Thread.sleep(1000);
        }

        //--------------------------Tv time ------------------------




        Actions seriesOfActions = builder.moveToElement(field).click().sendKeys(field,"la grotte aux dragons");
        Thread.sleep(5000);
        seriesOfActions.perform();
       String result = text + " " + text1 + " " + text2 +" " + text3 + " " + text4 + " " + text5;
        System.out.println(result);

        // Close the browser window
        //driver.close();

    }

}
