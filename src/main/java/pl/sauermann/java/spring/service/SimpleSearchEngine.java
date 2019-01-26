package pl.sauermann.java.spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.sauermann.java.spring.data.DocumentDAO;
import pl.sauermann.java.spring.model.Document;
import pl.sauermann.java.spring.model.Type;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleSearchEngine implements SearchEngine {

    private static final Logger log = LoggerFactory.getLogger(SearchEngine.class);

    private DocumentDAO documentDAO;

    public SimpleSearchEngine() {
        log.info("Simple engine initialized with id {}", this);
    }

    @Override
    public List<Document> listOfAll() {
        if (documentDAO != null) {
            log.info("Repository assigned");
            return new ArrayList<>(documentDAO.getAll().values());
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public List<Document> findByType(Type type) {
        return listOfAll().stream()
                .filter(document ->
                        document.getType()
                                .getName()
                                .equals(type.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public void setRepository(DocumentDAO documentDAO) {
        this.documentDAO = documentDAO;
    }
}
