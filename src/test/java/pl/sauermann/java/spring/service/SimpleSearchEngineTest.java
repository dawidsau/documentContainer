package pl.sauermann.java.spring.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.sauermann.java.spring.config.Config;
import pl.sauermann.java.spring.model.Document;
import pl.sauermann.java.spring.model.Type;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SimpleSearchEngineTest {

    private ApplicationContext context;
    private SearchEngine engine;

    @Before
    public void setUp() {
        context = new AnnotationConfigApplicationContext(Config.class);
        engine = context.getBean("engine", SearchEngine.class);
    }

    @Test
    public void shouldReturnNumberOfAllDocuments() {
        engine = context.getBean(SearchEngine.class);

        int result = engine.listOfAll().size();
        assertEquals(4, result);
        engine = context.getBean(SearchEngine.class);

    }

    @Test
    public void shouldFindDocumentsByType() {
        List<Document> listOfDocumentsFoundByType = engine.findByType(Type.of("DOC", "Word document", ".doc"));

        assertEquals(2,listOfDocumentsFoundByType.size());

    }
}