package uk.co.revsys.help.repository.camel;

import java.util.HashMap;
import java.util.Map;
import org.apache.camel.Exchange;

public class UpdateItemProcessor extends AbstractHelpRepositoryProcessor{

    private String title;
    private String text;
    
    public UpdateItemProcessor(String baseUrl) {
        super(baseUrl);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
        return postParameters;
    }

}
