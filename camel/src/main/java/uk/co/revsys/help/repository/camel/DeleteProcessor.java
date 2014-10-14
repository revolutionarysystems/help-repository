package uk.co.revsys.help.repository.camel;

import org.apache.camel.Exchange;

public class DeleteProcessor extends AbstractHelpRepositoryProcessor{

    public DeleteProcessor(String baseUrl) {
        super(baseUrl);
    }

    @Override
    public String getHttpMethod() {
        return "DELETE";
    }

    @Override
    public String getUrlPath(Exchange exchange) {
        return getPath();
    }

}
