package stock.modules.document.services;


import stock.modules.document.Document;
import stock.modules.document.DocumentRepository;
import stock.modules.document.dtos.UploadDocumentDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.*;
import java.nio.file.Paths;
import java.util.UUID;

@ApplicationScoped
public class SaveDocument {

    @Inject
    DocumentRepository documentRepository;

    public Document execute(UploadDocumentDto uploadDocumentDto) throws Exception {
        String projectPath = Paths.get("").toAbsolutePath().getParent().toString();
        String uploadsPath = "/src/main/java/stock/uploads/documents/";
        String fileName = UUID.randomUUID() + ".pdf";

        String uploadedFileLocation = projectPath + uploadsPath + fileName;

        writeToFile(uploadDocumentDto.getSourceFile(), uploadedFileLocation);

        Document document = new Document();
        document.setPath(fileName);
        document.setType(uploadDocumentDto.getType());

        return documentRepository.save(document);

    }


    // save uploaded file to new location
    private void writeToFile(InputStream uploadedInputStream, String uploadedFileLocation) throws IOException {

        int read = 0;
        byte[] bytes = new byte[1024];

        OutputStream out = new FileOutputStream(new File(uploadedFileLocation));
        while ((read = uploadedInputStream.read(bytes)) != -1) {
            out.write(bytes, 0, read);
        }
        out.flush();
        out.close();

    }

}