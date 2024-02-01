package OrangeWeb.cucumber.runner.login;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/java/OrangeWeb/cucumber/features/login/login.feature",
        glue = "OrangeWeb.cucumber.stepDef.Login",
        plugin = {"html:target/report/login/cucumber-reports"}
)

public class login {
}


