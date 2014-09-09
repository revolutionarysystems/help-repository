package uk.co.revsys.help.repository.camel;

import java.util.HashMap;
import java.util.Map;

public class CreateLinkProcessor extends AbstractHelpRepositoryProcessor{

    private String title;
    private String url;
    
    public CreateLinkProcessor(String baseUrl) {
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

    @Override
    public String getHttpMethod() {
        return POST;
    }

    @Override
    public String getContentType() {
        return APPLICATION_FORM_URLENCODED;
    }

    @Override
    public String getUrlPath() {
        return getPath();
    }
    
    @Override
    public Map<String, String> getPostParameters() {
        Map<String, String> postParameters = new HashMap<String, String>();
        postParameters.put("title", title);
        postParameters.put("url", url);
        return postParameters;
    }

}
