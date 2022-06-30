import helpers.Helpers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class test {
    WebDriver driver;
    Helpers helper = new Helpers();

    @Test
    public void test(){
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
        File file = new File("/usr/local/bin/chromedriver");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());


        ChromeOptions opt = new ChromeOptions();
        opt.setBinary("/usr/local/bin/chromedriver");
//        opt.setBinary("/usr/bin/google-chrome");

        opt.addArguments("headless");
        opt.addArguments("window-size=1280x800");
//        opt.addArguments("no-sandbox");
        opt.addArguments("–disable-dev-shm-usage");
        opt.addArguments("start-maximized");
        opt.addArguments("--disable-gpu");
        opt.addArguments("--disable-setuid-sandbox");
        driver = new ChromeDriver(opt);

        String keyword = "Budowa";
        String url = "http://bip.piekary.pl/?c=179";
        driver.get(url);
        System.out.println("Title: " + driver.getTitle());

        reporter_7(url, keyword);

    }

    public int countSelects(String keyWord){
        String formatedXPATH = String.format("//a[contains(text(), '%s') or contains(text(), '%s') or contains(text(), '%s')]", keyWord, keyWord.toLowerCase(Locale.ROOT), keyWord.toUpperCase(Locale.ROOT));
        List<WebElement> elementList = driver.findElements(By.xpath(formatedXPATH));
        return elementList.size();
    }

    public void reporter_7(String URL, String keyWord){

        String outputFile = (helper.todayDateFromPattern("dd-MM-yyyy") + "_przetargi.html");
        String style = "style='border: 1px solid black; padding: 3px; text-align: center;'";
        try {
            FileWriter txtOutput = new FileWriter(outputFile, true);

            if(countSelects(keyWord) > 0)
            {
                txtOutput.write("<table " + style + ">");
                txtOutput.write("<tr " + style + "><th "+ style + ">Wynik z dnia i godziny</th><th " + style + ">Link</th><th " + style + ">Fraza</th><th " + style + ">Ilość</th></tr>");
                txtOutput.write("<tr " + style +"><td " + style + ">" + helper.todayDateFromPattern("HH:mm:ss dd-MM-yyyy")  + "</td><td "+ style + ">" + "<a target='_blank' href=" + URL + ">" + URL +"</a>" + "</td><td " + style+">" + keyWord +"</td><td " + style+ ">" + countSelects(keyWord) + " </td></tr>");
                txtOutput.write("</table>");
                txtOutput.write("</br>");

                txtOutput.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
