import BasePage from "./BasePage";

/**
 * Login page object.
 */
export default class LoginPage extends BasePage {

    constructor() {
        super(`libs/granite/core/content/login.html`);
    }

    /**
     * Find out if the user is logged in so we can
     * avoid performing logging in again.
     *
     * @returns {Boolean}
     */
    static isLoggedIn() {
        return browser.getCookie("login-token") !== null;
    }

    /**
     * Get the username element.
     *
     * @type {browser.element}
     */
    get usernameField() {
        return browser.element("#username");
    }

    /**
     * Get the password element.
     *
     * @type {browser.element}
     */
    get passwordField() {
        return browser.element("#password");
    }

    /**
     * Get the submit element.
     *
     * @type {browser.element}
     */
    get submitButton() {
        return browser.element("#submit-button");
    }

    /**
     * Login with a browser dependend username (eg. 'admin_chrome')
     *
     * @returns {LoginPage}
     */
    login() {
        return this.loginAs("admin", "admin");
    }

    open(){
        super.open(this.path);
    }

    /**
     * Login as admin/admin
     *
     * @returns {LoginPage}
     */
    loginDefault() {
        return this.loginAs(
            process.env.CQ_USERNAME || "admin",
            process.env.CQ_PASSWORD || "admin"
        );
    }

    /**
     * Login with a custom username and password.
     *
     * @param {String} username Custom valid AEM username.
     * @param {String} password Custom valid AEM password.
     * @returns {LoginPage}
     */
    loginAs(username, password) {
        if (!LoginPage.isLoggedIn()) {
            this.open();
            this.usernameField.setValue(username);
            this.passwordField.setValue(password);
            this.submitButton.click();

            browser.waitForVisible("coral-panelstack");
        }
        return this;
    }
}
