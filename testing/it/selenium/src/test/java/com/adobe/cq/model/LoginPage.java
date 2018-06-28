package com.adobe.cq.model;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

// DOM Model of the login page
public class LoginPage extends BasePage {

    // Login path
    private static final String LOGIN_PATH = "/login.html";

    // default constructor
    public LoginPage() {
        super(LOGIN_PATH);
    }

    public void login(String username, String password) {
        $(By.id("username")).val(username);
        $(By.id("password")).val(password).pressEnter();
    }
}
