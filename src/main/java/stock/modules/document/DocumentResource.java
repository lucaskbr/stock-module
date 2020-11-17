package stock.modules.document;


import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import stock.modules.document.dtos.UploadDocumentDto;
import stock.modules.document.services.SaveDocument;
import stock.modules.local.services.GetLocalById;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;
import java.nio.file.Paths;
import java.util.UUID;

@Path("/documents")
@Produces(MediaType.APPLICATION_JSON)
public class DocumentResource {


    @Inject
    SaveDocument saveDocument;

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response create(@MultipartForm UploadDocumentDto uploadDocumentDto) {
        try {
            Document document = saveDocument.execute(uploadDocumentDto);
            return Response.ok(document).status(Response.Status.CREATED).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }



}