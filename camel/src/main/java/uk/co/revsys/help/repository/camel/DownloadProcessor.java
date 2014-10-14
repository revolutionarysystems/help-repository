package uk.co.revsys.help.repository.camel;

import org.apache.camel.Exchange;

public class DownloadProcessor extends AbstractHelpRepositoryProcessor{

    public DownloadProcessor(String baseUrl) {
        super(baseUrl);
    }

    @Override
    public String getHttpMethod() {
        return "GET";
    }

    @Override
    public String getUrlPath(Exchange exchange) {
        return "/binary" + getPath();
    }

}
