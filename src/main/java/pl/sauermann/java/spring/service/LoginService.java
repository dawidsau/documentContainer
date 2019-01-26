package pl.sauermann.java.spring.service;

public class LoginService implements Login {

    private String email;
    private String password;

    public LoginService(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAuthorized(String email, String password) {
        return email.equals(getEmail()) && password.equals(getPassword());
    }
}
