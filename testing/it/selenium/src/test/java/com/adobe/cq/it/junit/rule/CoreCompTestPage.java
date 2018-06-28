package com.adobe.cq.it.junit.rule;

import com.adobe.cq.testing.client.CQClient;
import com.adobe.cq.testing.junit.rules.Page;
import org.apache.commons.io.IOUtils;
import org.apache.sling.testing.clients.ClientException;
import org.apache.sling.testing.clients.util.ResourceUtil;
import org.apache.sling.testing.junit.rules.instance.Instance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

import static org.apache.http.HttpStatus.SC_CREATED;


public class CoreCompTestPage extends Page {

    private Logger logger = LoggerFactory.getLogger(Page.class);

    private static final String SITE_ROOT_PATH = "/content/core-components";
    private static final String TEMPLATE_ROOT_PATH = "/conf/core-components";
    private static final String TEMPLATE_PATH = "/conf/core-components/settings/wcm/templates/core-components";

    public CoreCompTestPage(Instance quickstartRule) {
        super(quickstartRule);
    }

    @Override
    protected String initialParentPath() {
        return SITE_ROOT_PATH + "/core-components-page";
    }

    @Override
    protected String initialName() {
        return "corecomptestpage-" + UUID.randomUUID();
    }

    @Override
    protected String initialTemplatePath() {
        return TEMPLATE_PATH;
    }
    // Calls prepare() then creates the random test page
    @Override
    protected void before() throws ClientException {
        super.before();
    }

    // deletes the test page
    @Override
    protected void after() {
        super.after();
    }

    // returns the title of the page
    @Override
    public String getTitle() {
        return "Core Component Test Page";
    }

    // returns initial name
    @Override
    public String getName() {
        return super.getName();
    }

    // return initial parent path
    @Override
    public String getParentPath() {
        return super.getParentPath();
    }

    // returns initial template path
    @Override
    public String getTemplatePath() {
        return super.getTemplatePath();
    }


    @Override
    protected CQClient getClient() throws ClientException {
        return super.getClient();
    }

    @Override
    protected void prepare() throws ClientException {

        if (getClient().exists(SITE_ROOT_PATH)) {
            logger.debug("Site already present, skipping installation");
            return;
        }

        // install the template
        try {
            InputStream templateStream =
                ResourceUtil.getResourceAsStream("/com/adobe/cq/testing/junit/rules/template.json");
            String template = IOUtils.toString(templateStream, StandardCharsets.UTF_8);
            getClient().importContent(TEMPLATE_ROOT_PATH, "json", template, SC_CREATED);
            logger.info("Created test template in {}", TEMPLATE_ROOT_PATH);
        } catch (IOException e) {
            throw new ClientException("Failed to create test template.", e);
        }

        // install the site
        try {
            InputStream siteStream =
                ResourceUtil.getResourceAsStream("/com/adobe/cq/testing/junit/rules/site.json");
            String site = IOUtils.toString(siteStream, StandardCharsets.UTF_8);
            getClient().importContent(SITE_ROOT_PATH, "json", site, SC_CREATED);
            logger.info("Created test site {}", SITE_ROOT_PATH);
        } catch (IOException e) {
            throw new ClientException("Failed to create test site.", e);
        }
    }
}
