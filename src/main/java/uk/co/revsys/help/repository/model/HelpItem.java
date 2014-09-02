package uk.co.revsys.help.repository.model;

import uk.co.revsys.content.repository.annotation.ContentName;
import uk.co.revsys.content.repository.annotation.ContentType;
import uk.co.revsys.content.repository.annotation.Versioned;

@Versioned
@ContentName("title")
@ContentType("help/item")
public class HelpItem {

    private String title;
    private String text;

    public HelpItem() {
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
    
}
