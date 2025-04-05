package com.project.pages;

import com.project.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductFunctionalityPage {

    public ProductFunctionalityPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "item_4_title_link")
    public WebElement product1;

    @FindBy(id = "item_0_title_link")
    public WebElement product2;

    @FindBy(id = "item_1_title_link")
    public WebElement product3;

    @FindBy(id = "item_5_title_link")
    public WebElement product4;

    @FindBy(id = "item_2_title_link")
    public WebElement product5;

    @FindBy(id = "item_3_title_link")
    public WebElement product6;

    @FindBy(css = "div.inventory_item_name")
    public List<WebElement> productNames;

    @FindBy(css = "div.inventory_item_price")
    public List<WebElement> productPrices;

    @FindBy(css = "img.inventory_item_img")
    public List<WebElement> productImages;

    @FindBy(css = ".btn.btn_primary.btn_small.btn_inventory")
    public List<WebElement> addToCartButtons;

}
