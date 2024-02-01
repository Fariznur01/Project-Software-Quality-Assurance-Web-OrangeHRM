package OrangeWeb.cucumber.runner.fitur;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/java/OrangeWeb/cucumber/features/fitur/fitur.feature",
        glue = "OrangeWeb.cucumber.stepDef.Feature",
        plugin = {"html:target/report/fiture/cucumber-reports"}
)
public class fitur {

}
