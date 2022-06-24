import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.io.File;

public class test {

    @Test
    public void mainTest(){
        String x = "..............STRING............";
        System.out.println(x);
//        WebDriverManager.chromedriver().setup();
////        WebDriver driver = new ChromeDriver();
//        File file = new File("/usr/local/bin/chromedriver");
//        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
//
//
//        ChromeOptions opt = new ChromeOptions();
//        opt.setBinary("/usr/bin/google-chrome");
//
//        opt.addArguments("--headless");
//        opt.addArguments("--window-size=1280x800");
//        opt.addArguments("--no-sandbox");
//        opt.addArguments("–-disable-dev-shm-usage");
//        opt.addArguments("--start-maximized");
//        opt.addArguments("--disable-gpu");
//        opt.addArguments("--disable-setuid-sandbox");
//        WebDriver driver = new ChromeDriver(opt);


//
//        driver.get("https://www.google.com");
//        System.out.println("Title: " + driver.getTitle());
    }
}
