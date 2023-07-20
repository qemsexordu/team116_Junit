package tests.practice;

import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P4 extends TestBase {
    @Test
    public void test01(){
        //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //2. "Hover over Me First" kutusunun ustune gelin
        WebElement hover = driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hover).perform();

        WebElement hover1 = driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        hover1.click();
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
        System.out.println("bu calisiyor");
        bekle(6);

        //3. "Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[@class='list-alert'])[1]")).click();


        //4. Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        bekle(3);

        WebElement hover2 = driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        hover1.click();
        actions.sendKeys(Keys.TAB).click().perform();
        bekle(3);



        //5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        bekle(3);

        //6. "Click and hold" kutusuna basili tutun
        WebElement clickButton =driver.findElement(By.xpath("(//div[@class='col-lg-12 text-center'])[3]"));
        actions.clickAndHold(clickButton).perform();

        // hover over me second butonuna klavye ile geciniz
        bekle(5);



        //7. "Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickButton.getText());



        //8. "Double click me" butonunu cift tiklayin
        WebElement clickButton2 = driver.findElement(By.xpath("(//div[@id='double-click'])"));
        actions.doubleClick(clickButton2).perform();
        bekle(3);
    }

}
