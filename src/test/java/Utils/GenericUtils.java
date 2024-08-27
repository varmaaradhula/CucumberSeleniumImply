package Utils;

import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class GenericUtils {
public WebDriver driver;

public GenericUtils(WebDriver driver){
    this.driver = driver;
}

    public void switchWindowsToChild(){

        Set<String> winHandles = driver.getWindowHandles();
        Iterator<String> handles = winHandles.iterator();
        String parentId = handles.next();
        String childId = handles.next();
        driver.switchTo().window(childId);
    }

    public String getPageUrl(){
    String presentUrl = driver.getCurrentUrl();
    return presentUrl;
    }
}
