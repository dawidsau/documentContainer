package pl.sauermann.java.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ResourceLoader;
import pl.sauermann.java.spring.data.DocumentDAO;
import pl.sauermann.java.spring.data.DocumentRepository;
import pl.sauermann.java.spring.service.Login;
import pl.sauermann.java.spring.service.LoginService;
import pl.sauermann.java.spring.service.SearchEngine;
import pl.sauermann.java.spring.service.SimpleSearchEngine;
import pl.sauermann.java.spring.view.Menu;

@Configuration
@ComponentScan("META-INF/data/")
@PropertySource("classpath:META-INF/data/properties/env_dev.properties")
public class Config {

    @Value("${user.email}")
    private String email;

    @Value("${user.password}")
    private String password;

    @Bean
    public Login login() {
        return new LoginService(email, password);
    }

    @Bean
    public SearchEngine engine(DocumentDAO documentDAO) {
        SearchEngine result = new SimpleSearchEngine();
        result.setRepository(documentDAO);
        return result;
    }

    @Bean
    public DocumentDAO documentDAO() {
        return new DocumentRepository();
    }

    @Bean
    public Menu menu(ResourceLoader resource) {
        return new Menu(resource);
    }
}
