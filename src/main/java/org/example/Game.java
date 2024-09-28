package org.example;

import org.example.Cell.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {
    public void startGame() throws IOException, InterruptedException {
        new GameHistory().play();
        Cell cell = new Cell();
        Board board = new Board();
        Map<String, Player> players = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сколько будет игроков?");
        int a = scanner.nextInt();
        for (int i = 0; i < a; i++) {
            System.out.println("Введите имя игрока под №" + (i + 1));
            String playerName = scanner.next();
            players.put(playerName, new Player(playerName));
        }



        //TODO  разделить на методы
        while (players.size()>1){
            for (Player player : players.values()) {
                System.out.println(player);
                if (player.isBlocked()) {
                    players.remove(player.getPlayerName());
                }
                if (!player.isBlocked()&& player.getPrisonKey() == 0) {
                    System.out.println(player.getPlayerName() + " делает ход");
                    int newPosition = player.getPosition() + Gran.roll();
                    if (newPosition < board.getProperties().length){
                        player.setPosition(newPosition);

                        System.out.println(board.info(player.getPosition()));
                    }else {
                        player.setPosition(player.getPosition() + Gran.roll() - board.getProperties().length);
                        System.out.println(board.info(player.getPosition()));
                    }
                    if (board.info(player.getPosition()) instanceof CellProperty){
                        if (((CellProperty) board.info(player.getPosition())).getOwner() == null){
                            System.out.println("Данная ячейка продается в аукционе, хотите приобрести?(1-да/2-нет)");
                            int question = scanner.nextInt();
                            if (question == 1){
                                ((CellProperty) board.info(player.getPosition())).purchase(player);
                            } else if (question == 2) {
                                System.out.println("продолжайте игру");
                            }
                        }else {
                            System.out.println("Данная ячейка принадлежит игроку: " + ((CellProperty) board.info(player.getPosition())).getOwner());
                            System.out.println("Вам необходимо внести оплату за аренду " + ((CellProperty) board.info(player.getPosition())).getRent());
                            ((CellProperty) board.info(player.getPosition())).payRent(player);
                        }
                    } else if (board.info(player.getPosition()) instanceof CellChance) {
                        ((CellChance) board.info(player.getPosition())).drawCard(player);
                    } else if (board.info(player.getPosition()) instanceof CellJail){
                        ((CellJail) board.info(player.getPosition())).jail(player);


                    }
                } else if (player.getPrisonKey()>0){
                    System.out.println("Игрок" + player.getPlayerName() + " пропускает ход");
                    player.setPrisonKey(player.getPrisonKey()-1);
                }

                Thread.sleep(1000);
            }
        }
    }
}
