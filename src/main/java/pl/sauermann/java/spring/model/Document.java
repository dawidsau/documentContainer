package pl.sauermann.java.spring.model;

import java.time.LocalDate;
import java.util.Objects;

public class Document {

    private String name;
    private Type type;
    private String location;
    private LocalDate created;
    private LocalDate modified;

    private Document(String name, Type type, String location) {
        this.name = name;
        this.type = type;
        this.location = location;
    }

    public static Document of(String name, Type type, String location) {
        return new Document(name, type, location);
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public String getLocation() {
        return location;
    }

    public LocalDate getCreated() {
        return created;
    }

    public LocalDate getModified() {
        return modified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return Objects.equals(getName(), document.getName()) &&
                Objects.equals(getType(), document.getType()) &&
                Objects.equals(getLocation(), document.getLocation()) &&
                Objects.equals(getCreated(), document.getCreated()) &&
                Objects.equals(getModified(), document.getModified());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getType(), getLocation(), getCreated(), getModified());
    }

    @Override
    public String toString() {
        return "Document{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", location='" + location + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }
}
