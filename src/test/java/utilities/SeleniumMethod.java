package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class SeleniumMethod {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    private JavascriptExecutor jsExecutor;

    // Constructor
    public SeleniumMethod(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
        this.jsExecutor = (JavascriptExecutor) driver;
    }

    // 1. Delete a task by name from a table
  /*  public void deleteTask(String taskName, By tableLocator) {
        try {
            // Locate the task table
            WebElement taskTable = driver.findElement(tableLocator);

            // Get all table rows from tbody
            List<WebElement> rows = taskTable.findElements(By.cssSelector("tbody tr"));
            boolean taskFound = false;

            for (WebElement row : rows) {
                WebElement nameCell = row.findElement(By.cssSelector("td:nth-child(1) span"));
                String currentTaskName = nameCell.getText().trim();

                if (currentTaskName.equalsIgnoreCase(taskName)) {
                    WebElement deleteButton = row.findElement(By.cssSelector("button.ant-btn-dangerous"));
                    deleteButton.click();
                    System.out.println("Delete button clicked for task: " + taskName);
                    taskFound = true;
                    break;
                }
            }

            if (!taskFound) {
                System.err.println("Task not found in table: " + taskName);
            }

        } catch (NoSuchElementException e) {
            System.err.println("Element not found while trying to delete task: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error while deleting task: " + e.getMessage());
        }
    }*/



    // 2. Wait for element visibility
    public WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // 3. Wait for element to be clickable
    public WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // 4. Click with wait
    public void click(By locator) {
        waitForClickable(locator).click();
    }

    // 5. Enter text
    public void enterText(By locator, String text) {
        WebElement element = waitForVisibility(locator);
        element.clear();
        element.sendKeys(text);
    }

    // 6. Get text
    public String getText(By locator) {
        return waitForVisibility(locator).getText().trim();
    }

    // 7. Element present?
    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // 8. Element visible?
    public boolean isElementVisible(By locator) {
        try {
            return waitForVisibility(locator).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    // 9. Select from dropdown
    public void selectDropdownByText(By locator, String visibleText) {
        WebElement dropdown = waitForVisibility(locator);
        new Select(dropdown).selectByVisibleText(visibleText);
    }

    // 10. Accept alert
    public void acceptAlert() {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
        } catch (NoAlertPresentException | TimeoutException e) {
            System.err.println("No alert present to accept.");
        }
    }

    // ---------------------------
    // Mouse Actions & Scrolling
    // ---------------------------

    // 11. Hover over element
    public void hoverOverElement(By locator) {
        WebElement element = waitForVisibility(locator);
        actions.moveToElement(element).perform();
    }

    // 12. Double-click
    public void doubleClick(By locator) {
        WebElement element = waitForClickable(locator);
        actions.doubleClick(element).perform();
    }

    // 13. Right-click
    public void rightClick(By locator) {
        WebElement element = waitForClickable(locator);
        actions.contextClick(element).perform();
    }

    // 14. Drag and drop
    public void dragAndDrop(By sourceLocator, By targetLocator) {
        WebElement source = waitForVisibility(sourceLocator);
        WebElement target = waitForVisibility(targetLocator);
        actions.dragAndDrop(source, target).perform();
    }

    // 15. Scroll to element using JavaScript
    public void scrollToElement(By locator) {
        WebElement element = waitForVisibility(locator);
        jsExecutor.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", element);
    }

    // 16. Scroll by pixel
    public void scrollByPixel(int x, int y) {
        jsExecutor.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
    }

    // 17. Scroll to bottom
    public void scrollToBottom() {
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    // 18. Scroll to top
    public void scrollToTop() {
        jsExecutor.executeScript("window.scrollTo(0, 0);");
    }

    // -------------------------
    // Keyboard Actions
    // -------------------------

    // 19. Press ENTER key
    public void pressEnter(By locator) {
        WebElement element = waitForVisibility(locator);
        element.sendKeys(Keys.ENTER);
    }

    // 20. Press TAB key
    public void pressTab(By locator) {
        WebElement element = waitForVisibility(locator);
        element.sendKeys(Keys.TAB);
    }

    // 21. Press ESC key
    public void pressEscape(By locator) {
        WebElement element = waitForVisibility(locator);
        element.sendKeys(Keys.ESCAPE);
    }

    // 22. Simulate key combination (e.g., Ctrl+A)
    public void pressCtrlA(By locator) {
        WebElement element = waitForVisibility(locator);
        element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
    }
    
   
}
