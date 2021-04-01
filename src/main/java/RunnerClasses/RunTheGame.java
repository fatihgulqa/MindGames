package RunnerClasses;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        plugin = {
                "html:target/cucumber-report",
                "json:target/cucumber.json"
        },

        //   tags = {"@SmokeTest"},
        features = {"src/test/java/FeatureFiles"},
        glue = {"Stepdef"},
        dryRun = false
)
public class RunTheGame extends AbstractTestNGCucumberTests {

}
