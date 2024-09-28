package org.example;

import lombok.ToString;

import java.util.Scanner;


public enum
Gran {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6);

    private final int value;
    Gran(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }

    public static int roll() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("для броска нажмите на \"Enter\"");
        String input = scanner.nextLine();
        Gran[] faces = Gran.values();
        int a = faces[(int) (Math.random() * faces.length)].getValue();
        int b = faces[(int) (Math.random() * faces.length)].getValue();
        System.out.println("Первая кость: " + a);
        System.out.println("Вторая кость: " + b);
        return a + b;
    }


}
