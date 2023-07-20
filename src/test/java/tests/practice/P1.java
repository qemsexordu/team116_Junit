package tests.practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.time.Duration;

public class P1 extends TestBase {

    // WebDriver ayarlarını yapın
    // https://www.n11.com adresine gidin
    @Test
    public void test01(){
        driver.get("https://www.n11.com");
        // URL'nin "n11.com" içerdiğini test edin
        String expectedUrl = "n11.com";
        String actualUrlElement = driver.getCurrentUrl();
        System.out.println("Git");

        Assert.assertTrue(actualUrlElement.contains(expectedUrl));
        System.out.println("url assert sonrasi");

        // Sayfa başlığının "n111" içermediğini test edin
        String expectedTitle = "n111";
        String actualTitle= driver.getTitle();
        System.out.println("title alma sonrasi");

        Assert.assertFalse(actualTitle.contains(expectedTitle));
        System.out.println("title assert sonrasi");

        // Arama çubuğuna "telefon" yazın ve aratın
        bekle(5);
        System.out.println("Bekleme sonrasi");
        WebElement searchBox = driver.findElement(By.id("searchData"));

        searchBox.sendKeys("telefon"+Keys.ENTER);
        bekle(5);

        // Sol yan menüde bulunan filtrelerden "Marka" olarak "Samsung" seçeneğini clickleyin
        WebElement samsunBox=driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div[2]/div[1]/section[5]/div/div[2]/div[1]/a"));
        samsunBox.click();

        bekle(3);

        // Sol yan menüde bulunan filtrelerden "Fiyat Aralığı" olarak "1000-2000 TL" seçeneğini clickleyin
        driver.findElement(By.id("minPrice")).sendKeys("15000");
        driver.findElement(By.id("maxPrice")).sendKeys("25000");

        driver.findElement(By.id("priceSearchButton")).click();
        bekle(5);

        // Çıkan sonuç sayısının 2'den fazla olduğunu test edin

        WebElement resultCount = driver.findElement(By.className("resultText"));
        System.out.println("resultext sonrasi");
        int count = Integer.parseInt(resultCount.getText().replaceAll("[^0-9]",""));







    }





    // Çıkan sonuç sayısının 2'den fazla olduğunu test edin
    // 2. ürüne tıklayın ve ürün detaylarının doğru şekilde yüklenip yüklenmediğini test edin
}
