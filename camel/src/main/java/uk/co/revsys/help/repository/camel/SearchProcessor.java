package uk.co.revsys.help.repository.camel;

import org.apache.camel.Exchange;
import uk.co.revsys.esb.component.HttpProxyProcessor;

public class SearchProcessor extends HttpProxyProcessor{

    private String query;
    
    public SearchProcessor(String baseUrl) {
        super(baseUrl);
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public String getHttpMethod() {
        return GET;
    }

    @Override
    public String getUrlPath(Exchange exchange) {
        return "/query?query=" + getQuery();
    }

}
