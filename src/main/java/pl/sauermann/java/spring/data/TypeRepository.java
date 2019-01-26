package pl.sauermann.java.spring.data;

import pl.sauermann.java.spring.model.Type;

import java.util.HashMap;
import java.util.Map;

public class TypeRepository implements TypeDAO {

    private Map<String, Type> documentMap = new HashMap<>();

    @Override
    public Map<String, Type> getAll() {
        documentMap = storage();
        return documentMap;
    }

    private Map<String, Type> storage() {
        Map<String, Type> result = new HashMap<>();
        result.put("Type 1", Type.of("DOC", "Word documnet", ".doc"));
        result.put("Type 2", Type.of("PDF", "Pdf documnet", ".pdf"));
        result.put("Type 3", Type.of("NOTE", "Note documnet", ".txt"));
        return result;
    }
}
