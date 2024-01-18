import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
public class FindBugs {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }



    @Test(priority = 1)
    public void testWebsiteLoad() {
        driver.get("https://academybugs.com/find-bugs/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement sqPageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("sq-page")));
        Assert.assertNotNull(sqPageElement, "Website failed to load.");
        driver.manage().window().maximize();
    }

            @Test(priority = 2)
            public void testDefaultSortingFunctionality() {
                Select productType = new Select(driver.findElement(By.id("sortfield")));
                productType.selectByValue("1");
                productType = new Select(driver.findElement(By.id("sortfield")));

                driver.findElement(By.xpath("//*[@id=\"cc-window\"]/div/a[2]")).click(); // click cookies

                productType.selectByValue("2");
                productType = new Select(driver.findElement(By.id("sortfield")));

                productType.selectByValue("3");
                productType = new Select(driver.findElement(By.id("sortfield")));

                productType.selectByValue("4");
                productType = new Select(driver.findElement(By.id("sortfield")));

                productType.selectByValue("5");
                productType = new Select(driver.findElement(By.id("sortfield")));

                productType.selectByValue("6");
                productType = new Select(driver.findElement(By.id("sortfield")));

                productType.selectByValue("7");
                productType = new Select(driver.findElement(By.id("sortfield")));

                Assert.assertEquals(productType.getFirstSelectedOption().getAttribute("value"), "7", "Default sorting option not selected.");
            }

            @Test(priority = 3)
            public void testAddToCartButton() {
                WebElement button = driver.findElement(By.id("ec_add_to_cart_5"));
                button.click();
                WebDriverWait waitElement1 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement viewCartElement = waitElement1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ec_product_page\"]/div[2]/a"))); // Replace with the actual identifier of the "View Cart" link or button
                Assert.assertTrue(viewCartElement.isDisplayed(), "View Cart element is not displayed");

            }

            @Test(priority = 4)
            public void testCheckoutAndMyCartPage() {
                WebElement checkoutButton = driver.findElement(By.id("ec_added_to_cart_5"));
                checkoutButton.click();
                String expectedUrl = "https://academybugs.com/my-cart/";
                String actualUrl = driver.getCurrentUrl();
                Assert.assertEquals(actualUrl, expectedUrl, "URLs don't match");
            }

            @Test(priority = 5)
            public void testProductSearch() {
                WebElement searchInput = driver.findElement(By.xpath("//*[@id=\"ec_searchwidget-3\"]/div/form/input[1]"));
                searchInput.sendKeys("bracelet");
                WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"ec_searchwidget-3\"]/div/form/input[2]"));
                searchButton.click();
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement productElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("ec_image_link_cover")));
                // Verify if the product is loaded
                Assert.assertTrue(productElement.isDisplayed(), "Product is not displayed");
            }

            @Test(priority = 6)
            public void testProductSearchResult() {
                WebElement productLoad = driver.findElement(By.className("ec_image_link_cover"));
                productLoad.click();
                String expectedUrl2 = "https://academybugs.com/store/buddha-bracelet/";
                String actualUrl2 = driver.getCurrentUrl();
                Assert.assertEquals(actualUrl2, expectedUrl2, "URLs don't match");
            }

            @Test(priority = 7)
            public void testCheckoutDetailsPage() {
                WebElement BraceletAdding = driver.findElement(By.xpath("//*[@id=\"post-1683\"]/div/section/div[1]/div[3]/form/div[8]/div[2]/input"));
                BraceletAdding.click();
                WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set up an explicit wait with a maximum wait time of 10 seconds
                WebElement CheckOut2 = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"post-1374\"]/div/section/div[4]/div[7]/a")));
                CheckOut2.click();
                String expectedUrl3 = "https://academybugs.com/my-cart/?ec_page=checkout_info";
                String actualUrl3 = driver.getCurrentUrl();
                Assert.assertEquals(actualUrl3, expectedUrl3, "URLs don't match");
            }

            @Test(priority = 8)
            public void testExamplesOfBugsLink() {
                WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set up an explicit wait with a maximum wait time of 10 seconds
                WebElement element3 = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"menu-item-5906\"]/a"))); // Wait for the element to be visible
                WebElement ExampleOfBugs = driver.findElement(By.xpath("//*[@id=\"menu-item-5906\"]/a"));
                ExampleOfBugs.click();
                String expectedUrl4 = "https://academybugs.com/";
                String actualUrl4 = driver.getCurrentUrl();
                Assert.assertEquals(actualUrl4, expectedUrl4, "URLs don't match");
            }

            @Test(priority = 9)
            public void testManufactureWording() {
                driver.get("https://academybugs.com/find-bugs/");
                WebElement ImageClick = driver.findElement(By.xpath("//*[@id=\"ec_product_image_effect_4481370\"]/a"));
                ImageClick.click();
                WebElement ManufactureWording = driver.findElement(By.xpath("//*[@id=\"manufacturer-bug\"]/a"));
                ManufactureWording.click();
                String currentURL = driver.getCurrentUrl();
                String expectedURL = "https://DNK.com";
                if (!currentURL.equals(expectedURL)) {
                    Assert.fail("Test Case 9 : Failed \nManufacture wording Test");
                }
            }
            }





