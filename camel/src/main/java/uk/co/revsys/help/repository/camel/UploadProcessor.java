package uk.co.revsys.help.repository.camel;

import java.io.ByteArrayOutputStream;
import javax.activation.DataHandler;
import org.apache.camel.Exchange;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;

public class UploadProcessor extends AbstractHelpRepositoryProcessor {

    public UploadProcessor(String baseUrl) {
        super(baseUrl);
    }

    @Override
    public void preProcess(Exchange exchange) throws Exception {
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        DataHandler attachment = exchange.getIn().getAttachment(exchange.getIn().getAttachmentNames().iterator().next());
        builder.addBinaryBody("file", attachment.getInputStream(), ContentType.create(attachment.getContentType()), attachment.getName());
        HttpEntity entity = builder.build();
        exchange.getIn().setHeader(Exchange.CONTENT_TYPE, entity.getContentType().getValue());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        entity.writeTo(outputStream);
        exchange.getIn().setBody(outputStream.toByteArray());
    }

    @Override
    public void postProcess(Exchange exchange) throws Exception {
        exchange.getOut().setHeader(Exchange.CONTENT_TYPE, APPLICATION_JSON);
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
