package test.fluentlenium;

import org.fluentlenium.adapter.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import test.fluentlenium.pages.LoginPage;
import test.fluentlenium.pages.ProfilePage;
import test.fluentlenium.pages.SearchResultPage;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@SpringBootConfiguration
public class FluentIntegrationTest extends FluentTest{
    @Page
    private LoginPage loginPage;
    @Page
    private ProfilePage profilePage;
    @Page
    SearchResultPage searchResultPage;

//    @Value("${local.server.port}")
    private int serverPort = 8080;

    @Override
    public WebDriver getDefaultDriver() {
        return new SafariDriver();
    }

    public String getDefaultBaseUrl() {
        return "http://localhost:" + serverPort;
    }

    @Test
    public void hasPageTitle() {
        goTo("/");
        assertThat(findFirst("h2").getText()).isEqualTo("Log in");
    }

    @Test
    public void should_be_redirected_after_filling_form() {
        goTo("/");
        loginPage.isAt();
        loginPage.login();
        profilePage.isAt();
        profilePage.fillInfos("programmer","programmer@gmail.com","1994-09-09");
        profilePage.addTaste("spring");
        profilePage.saveProfile();
        takeScreenShot();
        searchResultPage.isAt();
        assertThat(searchResultPage.getNumberOfResults()).isEqualTo(2);
    }
}
