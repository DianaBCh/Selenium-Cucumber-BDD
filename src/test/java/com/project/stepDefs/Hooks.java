package com.project.stepDefs;

import com.project.utils.ConfigurationReader;
import com.project.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;

public class Hooks {

    @Before
    public void setUpMethod(){
            Driver.getDriver().manage().window().maximize();
            Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            Driver.getDriver().get(ConfigurationReader.getProperty("swagLabs"));
            System.out.println("---> @Before: RUNNING BEFORE EACH SCENARIO");

        }




    @After
    public void tearDownMethod(Scenario scenario){

        if(scenario.isFailed()){

            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png", scenario.getName());
        }

        System.out.println("---> @After: RUNNING AFTER EACH SCENARIO");

        //BrowserUtils.sleep(2);
        Driver.closeDriver();


    }

    public void setupStep(){

        System.out.println("-----> @BeforeSTEP : Running before each step!");
    }

    //@AfterStep
    public void teardownStep() {

        System.out.println("-----> @AfterSTEP : Running after each step!");
    }

}
