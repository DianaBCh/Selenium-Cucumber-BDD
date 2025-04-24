package com.project.pages;

import com.project.utils.Driver;
import org.openqa.selenium.support.PageFactory;

public class CheckoutFunctionalityPage {

    public CheckoutFunctionalityPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
