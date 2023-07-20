package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class TestBase {
    protected WebDriver driver;
   @Before
    public void setup(){
       WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

   }

   @After
    public void tearDown(){
       driver.close();

   }

   public void bekle(int saniye){
       try {
           Thread.sleep(saniye*1000);
       } catch (InterruptedException e) {
           System.out.println("bekleme isleminde hata olustu");
           throw new RuntimeException(e);

       }

   }

}
