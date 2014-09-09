package uk.co.revsys.help.repository.camel;

public class DownloadProcessor extends AbstractHelpRepositoryProcessor{

    public DownloadProcessor(String baseUrl) {
        super(baseUrl);
    }

    @Override
    public String getHttpMethod() {
        return "GET";
    }

    @Override
    public String getUrlPath() {
        return "/binary" + getPath();
    }

}
