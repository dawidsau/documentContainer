package pl.sauermann.java.spring;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.sauermann.java.spring.config.Config;
import pl.sauermann.java.spring.service.Login;
import pl.sauermann.java.spring.view.Menu;

import static org.junit.Assert.assertNotNull;

public class MyDocumentsTest {

    private static final Logger log = LoggerFactory.getLogger(MyDocumentsTest.class);
    private static final String EMAIL = "test@mydocuments.com";
    private static final String PASSWORD = "test123";
    private static final String POSSITIVE = "User is authorized correctly";
    private static final String NEGATIVE = "User insert wrong credentials";

    private ApplicationContext context;
    private Menu menu;

    @Before
    public void setUp() {
        context = new AnnotationConfigApplicationContext(Config.class);
    }

    @Test
    public void shouldCreateMenuObject() {
        menu = context.getBean("menu", Menu.class);

        assertNotNull(menu);
        menu.printMenu(("META-INF/data/menu.txt"));
    }

    @Test
    public void shouldAuthorizedUser() {
        Login login = context.getBean(Login.class);

        assertNotNull(login);

        boolean result = login.isAuthorized(EMAIL, PASSWORD);
        if (result) {
            System.out.println(POSSITIVE);
        } else {
            System.out.println(NEGATIVE);
        }
    }

}
