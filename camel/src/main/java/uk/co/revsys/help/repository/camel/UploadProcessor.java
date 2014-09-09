package uk.co.revsys.help.repository.camel;

public class UploadProcessor extends AbstractHelpRepositoryProcessor{

    public UploadProcessor(String baseUrl) {
        super(baseUrl);
    }

    @Override
    public String getHttpMethod() {
        return "POST";
    }

    @Override
    public String getUrlPath() {
        return "/binary" + getPath();
    }

}
