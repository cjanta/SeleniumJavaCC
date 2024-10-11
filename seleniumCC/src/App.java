import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {
        doLoginLogout(args);
 
    }

    private static void doLoginLogout(String[] args){
        WebDriver driver = getWebDriver(args);
        driver.get("https://portal.cc-student.com/index.php?cmd=login");
        boolean isUserLoggedIn = isUserAlreadyLoggedIn(driver);

        if(!isUserLoggedIn){
            String[] fakeArgs = {"Skan117", "x8t3tqzryz"};
            loginToWebsiteWithCredentials(fakeArgs, driver);
            isUserLoggedIn = true;
        }

        if(isUserLoggedIn){
            navigateToTimeRecordingMenu(driver);
            readParagraph(driver);
            //clickModalTimeRecordingButton(driver);
            //clickFinalTimeRecordingButton(driver);
        }
    }

    private static void readParagraph(WebDriver driver){
        WebElement iframeElement = driver.findElement(By.id("TheFrame"));
        driver.switchTo().frame(iframeElement);

        By byParagraphs = By.xpath("//body//p");
        WebElement paragraph = driver.findElement(byParagraphs);
        String readyText = "Sie befinden sich aktuell nicht an einem Comcave Standort.";
        if (readyText.equals(paragraph.getText())){
            System.out.println("Nachmittags ein-ausloggen möglich da nicht am Standort.");
        }
      
        driver.switchTo().defaultContent();
        
    }

    private static void clickFinalTimeRecordingButton(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        By finalButtonPath = By.name("kommengehenbutton");
        WebElement finalButton = wait.until(ExpectedConditions.elementToBeClickable((finalButtonPath)));
        finalButton.click();
    }

    private static void navigateToTimeRecordingMenu(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        By timeRecordingMenu = By.xpath("//a[contains(@href, 'cmd=kug')]");
        WebElement timeRecordingMenuButton = wait.until(ExpectedConditions.elementToBeClickable(timeRecordingMenu));
        timeRecordingMenuButton.click();     
    }

    private static void clickModalTimeRecordingButton(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        By zeiterfassung_oeffnen_button_path = By.xpath("//button[contains(@name, 'showDialogButton')]");
        WebElement zeiterfassung_oeffnen_button = wait.until(ExpectedConditions.elementToBeClickable((zeiterfassung_oeffnen_button_path)));
        zeiterfassung_oeffnen_button.click();
    }

    private static boolean isUserAlreadyLoggedIn(WebDriver driver){
        By logout = By.xpath("//a[contains(@href, 'cmd=logout')]");
        List<WebElement> results = driver.findElements(logout);
        return !results.isEmpty();
    }

    private static void loginToWebsiteWithCredentials(String[] args, WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        By loginUsername = By.name("login_username");
        WebElement usernameInput = wait.until(ExpectedConditions.presenceOfElementLocated(loginUsername));

        By loginPassword = By.name("login_passwort");
        WebElement passwordInput = wait.until(ExpectedConditions.presenceOfElementLocated(loginPassword));
        
        usernameInput.sendKeys(getUsernameFromArgs(args));
        passwordInput.sendKeys(getPasswordFromArgs(args));

        By loginButtonPath = By.xpath("//input[@type='submit']");
        WebElement login_button = driver.findElement(loginButtonPath);
        login_button.click();
    }

    private static String getUsernameFromArgs(String[] args){
        return args.length > 0 ? args[0] : "";
    }

    private static String getPasswordFromArgs(String[] args){
        return args.length > 1 ? args[1] : "";
    }

    private static WebDriver getWebDriver(String[] args){
        if(args.length > 2){
            String driverParam = args[2].toLowerCase();

            if (driverParam.equals("firefox")){
                return new FirefoxDriver();
            }
            else if (driverParam.equals("chrome")){
                return new ChromeDriver();
            }        
        }
        return new FirefoxDriver();
    }


}
