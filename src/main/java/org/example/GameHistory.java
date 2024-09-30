package org.example;

import org.example.Cell.Board;

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
            list();
        }
    }
    public void list(){
        System.out.println("Желаете предварительно просмотреть улицы в данном городе?(1-да/2-нет)");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if(input == 1){
            Board board = new Board();
            board.printInfo();
        } else if (input == 2) {
            System.out.println("продолжайте игру");
        }else System.out.println("нет такой команды");
    }
}
