package stock.modules.document.dtos;

import org.jboss.resteasy.annotations.providers.multipart.PartType;

import javax.validation.constraints.NotNull;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;
import java.io.InputStream;

public class UploadDocumentDto {

    @FormParam("sourceFile")
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    InputStream sourceFile;

    @NotNull
    @FormParam("type")
    @PartType(MediaType.TEXT_PLAIN)
    String type;

    public InputStream getSourceFile() {
        return sourceFile;
    }

    public void setSourceFile(InputStream sourceFile) {
        this.sourceFile = sourceFile;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}