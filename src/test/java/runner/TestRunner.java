package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","html:target/cucumber",
                "json:target/cucumber.json"},
        features="src/test/java/uiFeatures",
        glue="automation.step_definitions",
        tags="@run",
        dryRun = false,
        monochrome = true
)

public class TestRunner {

}
