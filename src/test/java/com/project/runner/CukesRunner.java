package com.project.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-reports.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"
        },
        features = "src/test/resources/features",
        glue = "com/project/stepDefs",
        dryRun = false, // true -> only runs feature file to get unimplemented snippets
                        // false -> it runs both feature file and step def.
        tags = "@e2eFlow",
        publish = true //generating a report with public link

)


public class CukesRunner {
}
