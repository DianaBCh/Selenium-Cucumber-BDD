package com.project.pages;

import com.project.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    @FindBy(className = ".inventory_details_name.large_size")
    public WebElement productDetailsName;

    public WebElement setProductElement(String productName) {
        //String xpath = "//div[contains(@class, 'inventory_details_name') and contains(@class, 'large_size') and text()='" + productName + "']";
        //return Driver.getDriver().findElement(By.xpath(xpath));
        return Driver.getDriver().findElement(By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']"));
    }



}
