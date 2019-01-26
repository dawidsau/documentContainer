package pl.sauermann.java.spring.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.sauermann.java.spring.model.Document;
import pl.sauermann.java.spring.model.Type;

import java.util.HashMap;
import java.util.Map;

public class DocumentRepository implements DocumentDAO {

    private static final Logger log = LoggerFactory.getLogger(DocumentRepository.class);
    private Map<String, Document> documentMap = new HashMap<>();

    @Override
    public Map<String, Document> getAll() {
        log.info("Adding documents via getAll method");
        documentMap = storage();
        return documentMap;
    }

    private Map<String, Document> storage() {
        Map<String, Document> result = new HashMap<>();
        result.put("Document 1",
                Document.of("Document 1", Type.of("DOC", "Word documnet", ".doc"), "Local repository"));
        result.put("Document 2",
                Document.of("Document 2", Type.of("DOC", "Word documnet", ".docx"), "Local repository"));
        result.put("Document 3",
                Document.of("Document 3", Type.of("PDF", "Pdf document", ".pdf"), "Local repository"));
        result.put("Document 4",
                Document.of("Document 4", Type.of("NOTE", "Note documnet", ".txt"), "Local repository"));
        return result;
    }


}
