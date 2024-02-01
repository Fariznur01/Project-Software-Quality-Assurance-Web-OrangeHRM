package OrangeWeb.cucumber.runner.admin;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/java/OrangeWeb/cucumber/features/admindetail/admindetail.feature",
        glue = "OrangeWeb.cucumber.stepDef.AdminDetail",
        plugin = {"html:target/report/admindetail/cucumber-reports"}
)
public class admindetail {

}
