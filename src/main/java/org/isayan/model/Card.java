package org.isayan.model;

public class Card {
    private final Rank rank;
    private final Suit suit;
    private boolean faceUp = false;

    public Card(Rank rank, Suit suit) {
        this.suit = suit;
        this.rank = rank;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public boolean isFaceUp() {
        return faceUp;
    }

    public void setFaceUp(boolean faceUp) {
        this.faceUp = faceUp;
    }

    @Override
    public String toString() {
        return "%s of %s".formatted(getRank(), getSuit());
    }
}
