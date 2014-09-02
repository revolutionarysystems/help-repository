package uk.co.revsys.help.repository.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import uk.co.revsys.content.repository.ContentRepositoryServiceFactory;
import uk.co.revsys.content.repository.rest.AbstractContentRepositoryRestService;
import uk.co.revsys.content.repository.security.AuthorisationHandler;
import uk.co.revsys.help.repository.model.HelpItem;

public class HelpRepositoryRestService extends AbstractContentRepositoryRestService{

    public HelpRepositoryRestService(ContentRepositoryServiceFactory repositoryFactory, ObjectMapper objectMapper, AuthorisationHandler authorisationHandler) {
        super(repositoryFactory, objectMapper, authorisationHandler, HelpItem.class);
    }

}
