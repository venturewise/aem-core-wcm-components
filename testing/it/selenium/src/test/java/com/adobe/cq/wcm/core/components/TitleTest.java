package com.adobe.cq.wcm.core.components;

import com.adobe.cq.it.junit.rule.CoreCompTestPage;
import com.adobe.cq.it.CoreCompTitle;
import com.adobe.cq.model.EditorPage;
import com.adobe.cq.model.LoginPage;
import com.adobe.cq.testing.client.CQClient;
import com.adobe.cq.testing.client.ComponentClient;
import com.adobe.cq.testing.junit.rules.CQAuthorClassRule;
import com.adobe.cq.testing.junit.rules.CQRule;

import com.codeborne.selenide.Selenide;
import org.junit.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.Selenide.$;

public class TitleTest {

    private static String cqUsername = System.getProperty("cq.username", "admin");
    private static String cqPassword = System.getProperty("cq.password", "admin");

    protected static CQClient adminAuthor;
    protected static ComponentClient componentClient;

    // Create author instance config for this class
    @ClassRule
    public static CQAuthorClassRule cqBaseClassRule = new CQAuthorClassRule();

    // some basic stuff done before each test (filtering, test descr)
    @Rule
    public CQRule cqBaseRule = new CQRule(cqBaseClassRule.authorRule);

    // sets up site and template if not existing yet, and creates a random page
    @Rule
    public CoreCompTestPage testPage = new CoreCompTestPage(cqBaseClassRule.authorRule);

    @BeforeClass
    public static void setUp() throws Exception {
        // for selenium we have to go through the login page
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.login(cqUsername, cqPassword);
        // get an admin client
        adminAuthor = cqBaseClassRule.authorRule.getAdminClient(CQClient.class);
        // get component client to create components
        componentClient = adminAuthor.adaptTo(ComponentClient.class);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        // we must explicitly close the driver :S
        getWebDriver().quit();
    }

    @Test
    public void testDefaultTitleText() throws Exception {
        //create component as preparation step
        CoreCompTitle comp = componentClient.addComponent(CoreCompTitle.class,testPage.getPath(),
            "/jcr:content/root/responsivegrid",null,"last",200,201);

        // open the randomly created page in editor
        EditorPage emptyPage = new EditorPage(testPage.getPath()+".html");
        emptyPage.open();

        // switch to the contentFrame
        Selenide.switchTo().frame("ContentFrame");
        // check if title is set
        $(By.className("cmp-title__text")).shouldHave(text("Core Component Test Page"));
    }

}
