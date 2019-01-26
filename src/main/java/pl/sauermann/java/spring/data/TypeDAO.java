package pl.sauermann.java.spring.data;

import pl.sauermann.java.spring.model.Type;

import java.util.Map;

public interface TypeDAO {

    Map<String, Type> getAll();

}
