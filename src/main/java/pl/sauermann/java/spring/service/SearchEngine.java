package pl.sauermann.java.spring.service;

import pl.sauermann.java.spring.data.DocumentDAO;
import pl.sauermann.java.spring.model.Document;
import pl.sauermann.java.spring.model.Type;

import java.util.List;

public interface SearchEngine {

    List<Document>  listOfAll();

    List<Document>  findByType(Type type);

    void setRepository(DocumentDAO documentDAO);
}
