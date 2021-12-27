package com.esi;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/esi/",
        glue = "com.esi.stepdefs",
        tags = "@exo1",
        plugin = {"pretty", "html:target/cucumber-reports/exo1"}
)
public class RunTests {


}