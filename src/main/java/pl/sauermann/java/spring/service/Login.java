package pl.sauermann.java.spring.service;

public interface Login {

    public boolean isAuthorized(String email, String password);
}
