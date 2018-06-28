package com.adobe.cq.model;

import com.codeborne.selenide.Selenide;

/*
Base Page Object for all AEM Pages
 */
public class BasePage {

    // each page has a unique path
    private String path;

    // default constructor
    public BasePage(String path) {
        this.path = path;
    }

    // open the page
    public void open() {
        Selenide.open(this.path);
    }

    // get the page
    public String getPath(){
        return path;
    }
}
