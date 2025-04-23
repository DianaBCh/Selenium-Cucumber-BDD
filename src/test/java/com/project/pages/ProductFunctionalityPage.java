package com.project.pages;

import com.project.utils.BrowserUtils;
import com.project.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductFunctionalityPage {

    public ProductFunctionalityPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(css = "div.inventory_item_name")
    public List<WebElement> itemNames;

    @FindBy(css = "div.inventory_item_price")
    public List<WebElement> itemPrices;

    @FindBy(css = "img.inventory_item_img")
    public List<WebElement> productImages;

    @FindBy(css = ".btn.btn_primary.btn_small.btn_inventory")
    public List<WebElement> addToCartButtons;

    @FindBy(className = "product_sort_container")
    public WebElement sortProductContainer;

    @FindBy(xpath = "//div[contains(@class, 'inventory_details_name')]")
    public WebElement productDetailsName;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    public WebElement flJacketItem;




    public void setProductElement(String productName) {

        Driver.getDriver().findElement(By.xpath("//div[@data-test='inventory-item-name' and normalize-space(text())='" + productName + "']")).click();

    }

    public void addItemToCart(String itemName) {
        /*
        WebElement addButton = Driver.getDriver().findElement(By.xpath("//div[@data-test='inventory-item-name' and normalize-space()='" + itemName + "']/ancestor::div[@class='inventory_item']//button"));
        addButton.click();
        BrowserUtils.sleep(5);

         */



        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        // Wait until the item is rendered in the DOM
        String itemXpath = "//div[@data-test='inventory-item-name' and normalize-space()='" + itemName + "']/ancestor::div[@class='inventory_item']//button";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(itemXpath)));

        // Now wait for the corresponding 'Add to cart' button
        String buttonXpath = itemXpath + "/ancestor::div[@class='inventory_item']//button[contains(text(), 'Add to cart')]";
        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(buttonXpath)));

        // Optional: log what's going on
        System.out.println("Clicking add button for: " + itemName);
        addButton.click();


    }

    public String getCartBadgeCount() {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        WebElement badge = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".shopping_cart_badge")));

        return badge.getText();

        /*

        List<WebElement> badges = Driver.getDriver().findElements(By.cssSelector(".shopping_cart_badge"));
            if (badges.isEmpty()) {
            return ""; // No badge present
            }
        return badges.get(0).getText();

         */

    }

    public String getButtonTextForItem(String itemName) {
        WebElement button = Driver.getDriver().findElement(By.xpath("//div[text()='" + itemName + "']/ancestor::div[@class='inventory_item']//button"));
        return button.getText();
    }

    public void removeItemFromCart(String itemName) {

        WebElement removeButton = Driver.getDriver().findElement(By.xpath(
                "//div[text()='" + itemName + "']/ancestor::div[@class='inventory_item']//button"));

        removeButton.click();
        BrowserUtils.sleep(3);


    }

    public boolean isLastRemovedItemDisplayed() {
        try {
            Driver.getDriver().findElement(By.xpath("//button[text()='Remove']"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void getAddOrRemoveButton(String itemName) {
        Driver.getDriver().findElement(By.xpath("//div[text()='" + itemName + "']/ancestor::div[@class='inventory_item']//button"));
    }
}
