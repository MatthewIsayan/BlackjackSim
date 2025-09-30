package org.isayan.library.event;

import org.isayan.library.person.Person;
import org.isayan.library.model.Card;

public class CardDealtEvent implements Event {
    private final Person person;
    private final Card card;
    private final int cardNumber;

    public CardDealtEvent(Person person, Card card, int cardNumber) {
        this.person = person;
        this.card = card;
        this.cardNumber = cardNumber;
    }

    public Person getPerson() {
        return person;
    }

    public Card getCard() {
        return card;
    }

    public int getCardNumber() {
        return cardNumber;
    }
}
