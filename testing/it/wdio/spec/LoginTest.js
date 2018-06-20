import { expect } from "chai";
import LoginPage from "../lib/model/LoginPage"

describe("Login Page", () => {
   it("should open", () => {
       var loginPage = new LoginPage();
       loginPage.open();
       expect(browser.getUrl()).to.equal(loginPage.getPath())
   })
});
