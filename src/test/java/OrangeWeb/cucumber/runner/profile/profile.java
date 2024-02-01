package OrangeWeb.cucumber.runner.profile;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/java/OrangeWeb/cucumber/features/tabprofile/profile.feature",
        glue = "OrangeWeb.cucumber.stepDef.Tabprofile",
        plugin = {"html:target/report/tabprofile/cucumber-reports"}
)
public class profile {

}
