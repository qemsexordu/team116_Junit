package tests.day06_JUnit_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Before_AfterClassNotasyonlari {

    // Amazon ana sayfayua gidin
    // 3 farkli test methodu olusturup verilen testleri yapin
    //1-URL'in amazon icerdigini test edin
    //2-Nutella arattirin ve sonuclarin Nutella icerdigini test edin
    //3-Ilk urune click yapip, urun isminin Nutella icerdigini test edin
    static WebDriver driver;

    @BeforeClass
    public static void setup (){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass
    public static void tearDown (){
        driver.close();
    }

    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        //1-URL'in amazon icerdigini test edin

        String expectedUrlIcerigi="amazon";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerigi)){
            System.out.println("test Passed");
        }else {
            System.out.println("test Failed");
            throw new RuntimeException();
        }
    }

    @Test
    public void test02(){
        //2-Nutella arattirin ve sonuclarin Nutella icerdigini test edin

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        WebElement sonucYaziElementi = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String expectedIcerik = "Nutella";
        String actualYazi = sonucYaziElementi.getText();

        if (actualYazi.contains(expectedIcerik)){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
            throw new RuntimeException();
        }

    }
    @Test
    public void test03(){
        //3-Ilk urune click yapip, urun isminin Nutella icerdigini test edin
        driver.findElement(By.xpath("(//*[@class='s-image'])[1]")).click();

        WebElement urunIsimElementi = driver.findElement(By.xpath("//span[@id='productTitle']"));

        String actualResult = urunIsimElementi.getText();
        String expectedResult = "Nutella";

        if (actualResult.contains(expectedResult)){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
            throw new RuntimeException();
        }

    }
}
