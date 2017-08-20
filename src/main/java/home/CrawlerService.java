package home;

import home.models.Url;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Created by roshanalwis on 8/21/17.
 */

@RestController
public class CrawlerService {

    @RequestMapping(value = "/crawl", method = RequestMethod.POST)
    public ResponseEntity<String> crawl(@RequestBody Url url){
        WebDriver driver = new HtmlUnitDriver();
        driver.get(url.toString());
        String content = driver.getPageSource();
        driver.quit();
        return new ResponseEntity<String>(content, HttpStatus.OK);
    }
}
