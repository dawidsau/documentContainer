package pl.sauermann.java.spring.data;

import pl.sauermann.java.spring.model.Document;

import java.util.Map;

public interface DocumentDAO {

    Map<String,Document> getAll();


}
