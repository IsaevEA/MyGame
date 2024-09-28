package org.example;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class GameHistory {
    public void play() throws IOException {
        try (FileReader fileReader = new FileReader("TextStart.txt");
             Scanner scanner = new Scanner(fileReader)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        }
    }
}
