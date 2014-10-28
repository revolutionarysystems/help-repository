package uk.co.revsys.help.repository.camel;

import java.util.HashMap;
import java.util.Map;
import org.apache.camel.Exchange;

public class UpdateItemProcessor extends AbstractHelpRepositoryProcessor{

    private String title;
    private String text;
    private String status;
    private String tags;
    
    public UpdateItemProcessor(String baseUrl) {
        super(baseUrl);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public String getContentType() {
        return APPLICATION_FORM_URLENCODED;
    }

    @Override
    public String getHttpMethod() {
        return POST;
    }

    @Override
    public String getUrlPath(Exchange exchange) {
        return "/update" + getPath();
    }
    
    @Override
    public Map<String, String> getPostParameters() {
        Map<String, String> postParameters = new HashMap<String, String>();
        postParameters.put("title", title);
        postParameters.put("text", text);
        postParameters.put("status", status);
        postParameters.put("tags", tags);
        return postParameters;
    }

}
