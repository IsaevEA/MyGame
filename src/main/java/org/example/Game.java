package org.example;

import org.example.Cell.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Game {
    private Map<String, Player> players = new HashMap<>();
    private Board board = new Board();
    private Scanner scanner = new Scanner(System.in);

    public void startGame() throws IOException, InterruptedException {
        new GameHistory().play();

        initializePlayers();

        while (players.size() > 1) {
            playTurns();
        }
        if (players.size() == 1) {
            System.out.println(players);
            System.out.println("Поздравляем, вы прошли игру");
        }
    }

    private void initializePlayers() {
        System.out.println("Сколько будет игроков?");
        int playerCount = scanner.nextInt();

        if (playerCount > 1) {
            for (int i = 0; i < playerCount; i++) {
                System.out.println("Введите имя игрока под №" + (i + 1));
                String playerName = scanner.next();
                players.put(playerName, new Player(playerName));
            }
        } else {
            System.out.println("недопустимое значение");
        }
    }

    private void playTurns() throws InterruptedException {
        Iterator<Player> iterator = players.values().iterator();
        while (iterator.hasNext()) {
            Player player = iterator.next();
            System.out.println(player);

            if (player.isBlocked()) {
                iterator.remove();
                continue;
            }

            if (player.getPrisonKey() == 0) {
                takeTurn(player);
            } else {
                skipTurn(player);
            }

            Thread.sleep(1000);
        }
    }

    private void takeTurn(Player player) {
        System.out.println(player.getPlayerName() + " делает ход");
        int newPosition = player.getPosition() + Gran.roll();
        updatePlayerPosition(player, newPosition);

        Cell currentCell = board.info(player.getPosition());

        if (currentCell instanceof CellProperty) {
            handlePropertyCell((CellProperty) currentCell, player);
        } else if (currentCell instanceof CellChance) {
            ((CellChance) currentCell).drawCard(player);
        } else if (currentCell instanceof CellJail) {
            ((CellJail) currentCell).jail(player);
        } else if (currentCell instanceof CellTax) {
            ((CellTax) currentCell).tax(player);
        }
    }

    private void updatePlayerPosition(Player player, int newPosition) {
        if (newPosition < board.getProperties().length) {
            player.setPosition(newPosition);
        } else if (newPosition < 0) {
            int adjustedPosition = newPosition + board.getProperties().length;
            player.setPosition(adjustedPosition);
        } else {
            int adjustedPosition = newPosition - board.getProperties().length;
            player.setPosition(adjustedPosition);
        }
        System.out.println(board.info(player.getPosition()));
    }

    private void handlePropertyCell(CellProperty property, Player player) {
        if (property.getOwner() == null) {
            offerPurchase(property, player);
        } else {
            chargeRent(property, player);
        }
    }

    private void offerPurchase(CellProperty property, Player player) {
        System.out.println("Данная ячейка продается в аукционе, хотите приобрести? (1 - да / 2 - нет)");
        int response = scanner.nextInt();

        if (response == 1) {
            property.purchase(player);
        } else {
            System.out.println("Продолжайте игру.");
        }
    }

    private void chargeRent(CellProperty property, Player player) {
        System.out.println("Данная ячейка принадлежит игроку: " + property.getOwner());
        System.out.println("Вам необходимо внести оплату за аренду " + property.getRent());
        property.payRent(player);
    }

    private void skipTurn(Player player) {
        System.out.println("Игрок " + player.getPlayerName() + " пропускает ход");
        player.setPrisonKey(player.getPrisonKey() - 1);
    }
}
