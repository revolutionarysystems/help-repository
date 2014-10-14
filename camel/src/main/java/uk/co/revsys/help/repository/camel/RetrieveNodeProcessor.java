package uk.co.revsys.help.repository.camel;

import org.apache.camel.Exchange;

public class RetrieveNodeProcessor extends AbstractHelpRepositoryProcessor{

    public RetrieveNodeProcessor(String baseUrl) {
        super(baseUrl);
    }

    @Override
    public String getHttpMethod() {
        return "GET";
    }

    @Override
    public String getUrlPath(Exchange exchange) {
        return getPath();
    }

}
