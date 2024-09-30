package org.example.Cell;

public enum NameCard {


    ADVANCE_TO_GO("Продвиньтесь на поле Старт и получите 200 денег."),
    GO_TO_JAIL("Отправляйтесь в тюрьму. Не проходите поле Старт, не получайте 200 денег."),
    BANK_PAYS_DIVIDEND("Банк выплачивает вам дивиденды в размере 50 денег."),
    GO_BACK_THREE_SPACES("Вернитесь на три клетки назад."),
    GO_UP_TWO_SPACES("передвиньтесь на две клетки назад"),
    PAY_POOR_TAX("Заплатите налог на бедных в размере 15 денег."),
    DOCTORS_FEES("Оплатите услуги врача в размере 50 денег."),
    INHERITANCE("Вы получили наследство в размере 100 денег.");

    private final String description;

    NameCard(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }

    public static NameCard roll() {
        NameCard[] cards = NameCard.values();
        return cards[(int) (Math.random() * cards.length)];
    }
}
