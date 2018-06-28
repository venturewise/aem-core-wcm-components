package com.adobe.cq.it;

import com.adobe.cq.testing.client.ComponentClient;
import com.adobe.cq.testing.client.components.AbstractComponent;

/*
We use the ComponentClient to add a new component
 */
public class CoreCompTitle extends AbstractComponent {

    public static final String RESOURCE_TYPE = "core/wcm/components/title/v2/title";
    public static final String PROP_TYPE = "type";
    public static final String PROP_TITLE = "jcr:title";


    public CoreCompTitle(ComponentClient client, String pagePath, String location, String nameHint) {
        super(client, pagePath, location, nameHint);
    }
    @Override
    public String getResourceType() {
        return RESOURCE_TYPE;
    }
}
