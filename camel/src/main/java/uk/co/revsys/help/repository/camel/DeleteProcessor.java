package uk.co.revsys.help.repository.camel;

import java.util.UUID;

public class DeleteProcessor extends AbstractHelpRepositoryProcessor{

    public DeleteProcessor(String baseUrl) {
        super(baseUrl);
    }

    @Override
    public String getHttpMethod() {
        return "DELETE";
    }

    @Override
    public String getUrlPath() {
        return getPath();
    }

}
