package uk.co.revsys.help.repository.camel;

import uk.co.revsys.esb.component.HttpProxyProcessor;

public abstract class AbstractHelpRepositoryProcessor extends HttpProxyProcessor {

    private String path;

    public AbstractHelpRepositoryProcessor(String baseUrl) {
        super(baseUrl);
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
