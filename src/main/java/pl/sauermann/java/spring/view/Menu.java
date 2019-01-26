package pl.sauermann.java.spring.view;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Menu {

    private ResourceLoader menuFile;

    public Menu(ResourceLoader menuFile) {
        this.menuFile = menuFile;
    }

    public ResourceLoader getMenuFile() {
        return menuFile;
    }

    public void printMenu(String fileLocalization) {
        try {
            InputStream stream = menuFile.getResource(fileLocalization).getInputStream();
            Scanner scanner = new Scanner(stream);
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
            stream.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
