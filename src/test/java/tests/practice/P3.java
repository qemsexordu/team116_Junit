package tests.practice;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.security.PublicKey;

public class P3 extends TestBase {
    @Test
    public void test01(){
        driver.get("http://webdriveruniversity.com/Actions");
        //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        Actions actions=new Actions(driver);
        //2. "Hover over Me First" kutusunun ustune gelin
        WebElement hoverElement=driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        actions.moveToElement(hoverElement).perform();
        bekle(5);

        //3. "Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[@class='list-alert'])[1]")).click();

        //4. Popup mesajini yazdirin
        Alert alert=driver.switchTo().alert();
        String message = alert.getText();

        //5. Popup'i tamam diyerek kapatin
        alert.accept();

        //6. "Click and hold" kutusuna basili tutun
        WebElement click=driver.findElement(By.xpath("(//div[@class='col-lg-12 text-center'])[3]"));
        actions.clickAndHold(click).perform();
        bekle(4);

        //7. "Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(click.getText());

        //8. "Double click me" butonunu cift tiklayin
        WebElement doubleClickButtton = driver.findElement(By.xpath("//div[@id='double-click']"));
        actions.doubleClick(doubleClickButtton);
        bekle(5);
    }
}
