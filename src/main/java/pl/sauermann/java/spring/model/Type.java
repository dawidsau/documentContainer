package pl.sauermann.java.spring.model;

import java.util.Objects;

public class Type {

    private String name;
    private String desc;
    private String extension;

    private Type(String name, String desc, String extension) {
        this.name = name;
        this.desc = desc;
        this.extension = extension;
    }

    public static Type of(String name, String desc, String extension) {
        return new Type(name, desc, extension);
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getExtension() {
        return extension;
    }

    @Override
    public String toString() {
        return "Type{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", extension='" + extension + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type type = (Type) o;
        return Objects.equals(getName(), type.getName()) &&
                Objects.equals(getDesc(), type.getDesc()) &&
                Objects.equals(getExtension(), type.getExtension());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDesc(), getExtension());
    }
}
