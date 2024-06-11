package contact.list.project.configurations.browserstack;

import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BStackSampleTest extends BrowserStackConfiguration {

    @Test
    public void test() {
        driverBrowserStack.get("https://thinking-tester-contact-list.herokuapp.com/");
        final WebDriverWait wait = new WebDriverWait(driverBrowserStack, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs("Contact List App"));
//        String product_name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='1']/p"))).getText();
//        WebElement cart_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='1']/div[4]")));
//        cart_btn.click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("float-cart__content")));
//        final String product_in_cart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='__next']/div/div/div[2]/div[2]/div[2]/div/div[3]/p[1]"))).getText();
//        assertTrue("Product add to the cart - Failed!", product_name.matches(product_in_cart));
    }
}