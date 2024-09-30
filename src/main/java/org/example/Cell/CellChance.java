package org.example.Cell;

import lombok.*;
import org.example.Player;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class CellChance extends Cell {

private NameCard nameCard;

    public CellChance(int position, String name, NameCard nameCard) {
        super(position, name);
        this.nameCard = nameCard;

    }


    public void drawCard(Player player) {
        if (!player.isBlocked()) {
            NameCard card = NameCard.roll();
            System.out.println(card.getDescription());

            switch (card) {
                case ADVANCE_TO_GO:
                    setPosition(0);
                    player.setBalance(player.getBalance() + 200);
                    System.out.println(player);
                    break;

                case BANK_PAYS_DIVIDEND:
                    player.setBalance(player.getBalance() + 50);
                    System.out.println(player);
                    break;
                case GO_BACK_THREE_SPACES:
                    player.setPosition(player.getPosition() - 3);
                    System.out.println(player);
                    break;

                case GO_UP_TWO_SPACES:
                    player.setPosition(player.getPosition() +2);
                    System.out.println(player);
                    break;
                case PAY_POOR_TAX:
                    if (player.getBalance()>= 15){
                        player.setBalance(player.getBalance() - 15);
                        System.out.println(player);
                    }else player.setBlocked(true);
                    break;

                case DOCTORS_FEES:
                    if (player.getBalance()>= 50){
                        player.setBalance(player.getBalance() - 50);
                        System.out.println(player);
                    }else player.setBlocked(true);
                    break;

                case INHERITANCE:
                    player.setBalance(player.getBalance()+ 100);
                    System.out.println(player);
                    break;

                default:
                    System.out.println("Неизвестная карта");
                    break;
            }
        }
    }


    @Override
    public String toString() {
        return "CellChance{" +
                "nameCard=" + nameCard +
                "name" + super.getName() +
                ", position" + super.getPosition() +
                '}';
    }


}
