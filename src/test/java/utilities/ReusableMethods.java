package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Set;

public class ReusableMethods {
    public static String ikinciSayfaWHD(String ilkSayfaWindowHandleDegeri, WebDriver driver){
        String ikinciSayfaWHD="";
        Set<String> windowHandlesSeti  = driver.getWindowHandles();
        for (String each: windowHandlesSeti
        ) {
            if (!each.equals(ilkSayfaWindowHandleDegeri)){
                ikinciSayfaWHD = each;
            }
        }
        return ikinciSayfaWHD;
    }
    public static String hucredekiYaziyiGetir(int satirNo , int sutunNo, WebDriver driver){
        //               //tbody/tr[7]/td[1]
        String dinamikXPath = "//tbody/tr["+satirNo+"]/td["+sutunNo+"]";
        WebElement istenenHucredekiElement = driver.findElement(By.xpath(dinamikXPath));
        return istenenHucredekiElement.getText();
    }
    public void tumSayfaFotoCek(WebDriver driver){
        TakesScreenshot tss = (TakesScreenshot) driver;
        // Dosya adini dinamik hale getirmek icin time stamp kullanalim
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

    }
}
