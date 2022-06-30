package com.cydeo.library.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "json:target/cucumber.json",
                "rerun:target/rerun.txt",
                "html:target/cucumber-report.html"
        },
        features ="src/test/resources/features",
        glue = "com/cydeo/library/step_definitions",
        dryRun = false,
        tags = ""


)

public class CukesRunner {

}
