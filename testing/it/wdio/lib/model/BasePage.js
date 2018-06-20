/**
 * Base page class for inheritance.
 */
export default class BasePage {

    /**
     * Register the page's path.
     * @param {String} path URI without the first forward slash.
     */
    constructor(path) {
        this.path = path;
    }

    getPath() {
        return this.path;
    }

/*    getUrl() {
        return `${config.instance.getUrl()}/${this.path}`;
    }
*/
    /**
     * Open page with the provided path in the current window.
     * @param {String | undefined} path The path to open without trailing /
     * @returns {BasePage}
     */
    open(path) {
        if (path) {
            this.path = path;
        }

        // if (browser.getUrl() !== this.getUrl()) {
        browser.url(this.getPath());
        // }

        return this;
    }

    /**
     * Open page with the provided path in a new window.
     * @param {String} path The path to open without trailing /
     * @returns {BasePage}
     */
    openInNewWindow(path) {
        if (path) {
            this.path = path;
        }

        browser.newWindow(this.getPath());

        return this;
    }

    refresh() {
        browser.url(this.getPath());
    }

    /**
     * Check if the URL of the page is the same.
     * This is limited but we don't have a more programmatically
     * solution in place.
     * @returns {Boolean} true if sites is open.
     */
    isOpen() {
        return browser.getPath().indexOf(this.path) !== -1;
    }
}
