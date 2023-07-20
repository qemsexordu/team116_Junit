package tests.practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase1;

public class P2 extends TestBase1 {
    // Yeni TestBase olusturun
    // WebDriver ayarlarını yapın

    @Test
    public void test01 (){
        // https://www.n11.com adresine gidin
        driver.get("https://www.n11.com");
        System.out.println("n11 e gittik");

        // URL'nin "n11.com" içerdiğini test edin
        String expectedUrl = "n11.com";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrl));
        System.out.println("url kontrol yapildi");

        // Sayfa başlığının "n111" içermediğini test edin

        String expectedTitle = "n111";
        String actulTitle = driver.getTitle();

        Assert.assertFalse(actulTitle.contains(expectedTitle));
        System.out.println("title test yapildi");

        // Arama çubuğuna "telefon" yazın ve aratın

        WebElement searchBox = driver.findElement(By.id("searchData"));
        searchBox.sendKeys("telefon"+ Keys.ENTER);
        System.out.println("telefon aratildi");

        bekle(3);


        // Sol yan menüde bulunan filtrelerden "Marka" olarak "Samsung" seçeneğini clickleyin

        WebElement checkBox = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div[2]/div[1]/section[5]/div/div[2]/div[1]/a"));
        checkBox.click();
        System.out.println("checkbox checked");

        // Sol yan menüde bulunan filtrelerden "Fiyat Aralığı" olarak "10000-20000 TL" seçeneğini clickleyin

        driver.findElement(By.id("minPrice")).sendKeys("10000");
        driver.findElement(By.id("maxPrice")).sendKeys("20000");

        driver.findElement(By.id("priceSearchButton")).click();
        System.out.println("pricesearchButton");

        // Çıkan sonuç sayısının 2'den fazla olduğunu test edin

        WebElement result = driver.findElement(By.xpath("(//strong)[3]"));
        String resultString=result.getText();

        int resultCount = Integer.parseInt(resultString);
        System.out.println(resultCount);

        Assert.assertTrue(resultCount>2);
        System.out.println("All test Checked and done");

    }







}
