package uk.co.revsys.help.repository.camel;

import java.util.HashMap;
import java.util.Map;
import org.apache.camel.Exchange;

public class UpdateLinkProcessor extends AbstractHelpRepositoryProcessor{

    private String title;
    private String url;
    private String tags;
    
    public UpdateLinkProcessor(String baseUrl) {
        super(baseUrl);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public String getHttpMethod() {
        return POST;
    }

    @Override
    public String getContentType() {
        return APPLICATION_FORM_URLENCODED;
    }

    @Override
    public String getUrlPath(Exchange exchange) {
        return "/update" + getPath();
    }
    
    @Override
    public Map<String, String> getPostParameters() {
        Map<String, String> postParameters = new HashMap<String, String>();
        postParameters.put("title", title);
        postParameters.put("url", url);
        postParameters.put("tags", tags);
        return postParameters;
    }

}
