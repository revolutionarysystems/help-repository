package uk.co.revsys.help.repository.camel;

import uk.co.revsys.esb.component.HttpProxyComponent;
import java.util.Map;

import org.apache.camel.Processor;

public class HelpRepositoryComponent extends HttpProxyComponent{

    @Override
    protected void populateMappings(Map<String, Class<? extends Processor>> mappings) {
        mappings.put("retrieve", RetrieveNodeProcessor.class);
        mappings.put("createItem", CreateItemProcessor.class);
        mappings.put("createLink", CreateLinkProcessor.class);
        mappings.put("updateItem", UpdateItemProcessor.class);
        mappings.put("updateLink", UpdateLinkProcessor.class);
        mappings.put("upload", UploadProcessor.class);
        mappings.put("download", DownloadProcessor.class);
        mappings.put("delete", DeleteProcessor.class);
        mappings.put("search", SearchProcessor.class);
    }
    
}
