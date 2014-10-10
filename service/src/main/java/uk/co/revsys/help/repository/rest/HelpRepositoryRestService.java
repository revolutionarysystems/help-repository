package uk.co.revsys.help.repository.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;
import javax.jcr.RepositoryException;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.co.revsys.content.repository.ContentRepositoryServiceFactory;
import uk.co.revsys.content.repository.model.ContentNode;
import uk.co.revsys.content.repository.model.Status;
import uk.co.revsys.content.repository.rest.AbstractContentRepositoryRestService;
import uk.co.revsys.content.repository.security.AuthorisationHandler;

public class HelpRepositoryRestService extends AbstractContentRepositoryRestService {

    private final Logger LOGGER = LoggerFactory.getLogger(HelpRepositoryRestService.class);
    
    private static final String HELP_ARTICLE_CONTENT_TYPE = "help/article";
    private static final String HELP_LINK_CONTENT_TYPE = "help/link";

    public HelpRepositoryRestService(ContentRepositoryServiceFactory repositoryFactory, ObjectMapper objectMapper, AuthorisationHandler authorisationHandler) {
        super(repositoryFactory, objectMapper, authorisationHandler);
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response createItemInRoot(@FormParam("title") String title, @FormParam("text") String text, @FormParam("url") String url, @FormParam("status") String status) {
        return createItem(null, title, text, url, status);
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("{path:.*}")
    public Response createItem(@PathParam("path") String path, @FormParam("title") String title, @FormParam("text") String text, @FormParam("url") String url, @FormParam("status") String statusString) {
        try {
            if (title == null || (text == null && url == null)) {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
            String contentType = HELP_ARTICLE_CONTENT_TYPE;
            Map<String, String> properties = new HashMap<String, String>();
            properties.put("title", title);
            if (url != null && !url.isEmpty()) {
                contentType = HELP_LINK_CONTENT_TYPE;
                properties.put("url", url);
            } else {
                properties.put("text", text);
            }
            String name = title;
            Status status = Status.published;
            if(statusString != null){
                status = Status.valueOf(statusString);
            }
            ContentNode contentNode = getRepository().create(path, name, status, contentType, properties);
            return Response.ok(getObjectMapper().writeValueAsString(contentNode)).build();
        } catch (RepositoryException ex) {
            LOGGER.error("Unable to create item", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        } catch (JsonProcessingException ex) {
            LOGGER.error("Unable to create item", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/update/{path:.*}")
    public Response updateItem(@PathParam("path") String path, @FormParam("title") String title, @FormParam("text") String text, @FormParam("url") String url, @FormParam("status") String statusString) {
        try {
            Map<String, String> properties = new HashMap<String, String>();
            if (title != null && !title.isEmpty()) {
                properties.put("title", title);
            }
            if (url != null && !url.isEmpty()) {
                properties.put("url", url);
            } else if(text != null && !text.isEmpty()){
                properties.put("text", text);
            }
            Status status = Status.published;
            if(statusString != null){
                status = Status.valueOf(statusString);
            }
            ContentNode contentNode = getRepository().update(path, status, properties);
            return Response.ok(getObjectMapper().writeValueAsString(contentNode)).build();
        } catch (RepositoryException ex) {
            LOGGER.error("Unable to update item " + path, ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        } catch (JsonProcessingException ex) {
            LOGGER.error("Unable to update item " + path, ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

}
