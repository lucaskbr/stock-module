package stock.modules.document;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import stock.modules.document.Document;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class DocumentRepository implements PanacheRepository<Document> {

    public List<Document> list() {
        return listAll();
    }

    public Document getById(Long id) {
        return findById(id);
    }

    @Transactional
    public Document save(Document document) {
        persist(document);
        return document;
    }

    @Transactional
    public void remove(Long id) {
        Document documentEntity = findById(id);

        delete(documentEntity);
    }

}