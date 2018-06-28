package com.adobe.cq.model;

/*
The editor page represents any content page which is opened in the /editor.html
it should provide all the functionalites a editor page offers
 */
public class EditorPage extends BasePage {

    public EditorPage(String contentPage) {
        super("/editor.html" + contentPage);
    }
}
