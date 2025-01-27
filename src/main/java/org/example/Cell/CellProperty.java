package org.example.Cell;

import lombok.Getter;
import lombok.Setter;
import org.example.Player;

import java.util.Scanner;

@Setter
@Getter

public class CellProperty extends Cell {

    private int price;
    private int rent;
    private Player owner;
    private  final Scanner scanner = new Scanner(System.in);
    public  void purchase(Player player){
        if (player.getBalance()>=price && owner == null){
            this.owner = player;
            player.setBalance(player.getBalance()-price);
            System.out.println("игрок: " +player.getPlayerName() + " приобрел " + super.getName());
        } else if ((player.getBalance()< price && owner == null) && player.getChance() == 1)  {
            playerAssistance(player);
        }
    }


    public void payRent(Player player) {
        if ((owner != player && owner != null) && player.getBalance() >= rent) {
            if (player.getBalance()>rent) {
                player.setBalance(player.getBalance() - rent);
                owner.setBalance(owner.getBalance() + rent);
                System.out.println(player.getPlayerName()+ " оплатил " + rent +" игроку " + owner);
            }else if (player.getBalance()<rent){
                playerAssistance(player);
                System.out.println("вы выбываете");
                player.setBlocked(true);
            }
        }
    }

    public void playerAssistance(Player player) {
        System.out.println("У вас недостаточно средств для покупки");
        System.out.println("Хотите получить шанс со стороны казны в размере недостающей суммы для оплаты" +
                "(1- да/2 - нет");
        int answer = scanner.nextInt();
        if (answer == 1) {
            owner.setBalance(owner.getBalance() + rent);
            System.out.println("козна помогла вам с оплатой");
            player.setChance(player.getChance()-1);
            System.out.println(player.getPlayerName()+ " оплатил " + rent +" игроку " + owner);
        }else if (answer == 2) {
            System.out.println("Вы отказались от помощи козны");
        }
    }
    public CellProperty(int position, String name, int price, int rent) {
        super(position, name);

        this.price = price;
        this.rent = rent;
        this.owner = null;
    }

    @Override
    public String toString() {
        return "CellProperty{" +
                "name=" + super.getName() +
                ", position=" + super.getPosition() +
                ", price=" + price +
                ", rent=" + rent +
                ", owner=" + owner +
                '}';
    }
}

