package org.example.Cell;

import lombok.Getter;
import lombok.Setter;
import org.example.NameCard;


@Getter
@Setter
public class Board {
    private Cell[] properties = new Cell[36];


    public Board() {
        properties[0] = new CellStarAndRest(0, "Старт");
        properties[1] = new CellProperty(1, "Улица Ленина", 180, 45);
        properties[2] = new CellChance(2, "Шанс", NameCard.roll());
        properties[3] = new CellProperty(3, "Улица Гагарина", 220, 55);
        properties[4] = new CellProperty(4, "Проспект Мира", 240, 60);
        properties[5] = new CellChance(5, "Шанс",NameCard.roll());
        properties[6] = new CellProperty(6, "Улица Ломоносова", 260, 65);
        properties[7] = new CellProperty(7, "Улица Свердлова",280, 70);
        properties[8] = new CellTax(8, "Налог, заплатите в казну 45 денег");
        properties[9] = new CellJail(9, "Тюрьма");
        properties[10] = new CellProperty(10, "Проспект Октября", 320, 80);
        properties[11] = new CellProperty(11, "Улица Крылова", 340, 85);
        properties[12] = new CellChance(12, "Шанс",NameCard.roll());
        properties[13] = new CellTax(13, "Налог заплатите в казну 70 денег");
        properties[14] = new CellProperty(14, "Проспект Победы", 360, 90);
        properties[15] = new CellChance(15, "Шанс",NameCard.roll());
        properties[16] = new CellProperty(16, "Улица Суворова", 400, 100);
        properties[17] = new CellProperty(17, "Улица Мартова",410, 90);
        properties[18] = new CellStarAndRest(18, "Отдых");
        properties[19] = new CellProperty(19, "Проспект Ленина", 420, 105);
        properties[20] = new CellChance(20, "Шанс",NameCard.roll());
        properties[21] = new CellTax(21, "Налог заплатите в казну 45 денег");
        properties[22] = new CellProperty(22, "Улица Бабушкина", 480, 120);
        properties[23] = new CellProperty(23, "Проспект Энгельса", 500, 125);
        properties[24] = new CellChance(24, "Шанс",NameCard.roll());
        properties[25] = new CellProperty(25, "Улица Чехова",560, 140);
        properties[26] = new CellProperty(26, "Проспект Вернадского",540, 135);
        properties[27] = new CellJail(27, "Отправляйтесь в тюрьму");
        properties[28] = new CellChance(28, "Шанс",NameCard.roll());
        properties[29] = new CellProperty(29, "Проспект Варсова",540, 135);
        properties[30] = new CellProperty(30, "Проспект Кутузова", 580, 145);
        properties[31] = new CellProperty(31, "Улица Горького",600, 150);
        properties[32] = new CellChance(31, "Шанс",NameCard.roll());
        properties[33] = new CellTax(33, "Налог заплатите в казну 70 денег");
        properties[34] = new CellProperty(34, "Проспект Кирова",620, 155);
        properties[35] = new CellProperty(35, "Проспект Маркса",640,160);
    }

    public Cell info(int a ) {
        return properties[a];

    }


}
