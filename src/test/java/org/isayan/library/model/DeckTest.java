package org.isayan.library.model;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class DeckTest {
    private final SoftAssertions softly = new SoftAssertions();
    @Test
    void deckIsInitializedCorrectly() {
        Deck deck = new Deck();
        softly.assertThat(deck.getCards())
                .describedAs("The deck should have 52 cards.")
                .doesNotHaveDuplicates()
                .hasSize(52);

        softly.assertThat(deck.getCards())
                .describedAs("The deck contains the 4 suits.")
                .extracting(Card::getSuit)
                .containsExactlyInAnyOrderElementsOf(
                        Arrays.stream(Suit.values()).toList()
                );

        softly.assertThat(deck.getCards())
                .describedAs("The deck contains the 13 ranks.")
                .extracting(Card::getRank)
                .containsExactlyInAnyOrderElementsOf(
                        Arrays.stream(Rank.values()).toList()
                );
    }

    @Test
    void deckIsCorrectlyComposed() {
        Deck deck = new Deck();

        Map<Suit, Long> suitCounts = deck.getCards().stream()
                        .collect(Collectors.groupingBy(Card::getSuit, Collectors.counting()));

        softly.assertThat(suitCounts)
                .describedAs("Each suit should appear 13 times")
                .containsOnly(
                        entry(Suit.CLUBS, 13L),
                        entry(Suit.HEARTS, 13L),
                        entry(Suit.SPADES, 13L),
                        entry(Suit.DIAMONDS, 13L)
                );

        Map<Rank, Long> rankCounts = deck.getCards().stream()
                .collect(Collectors.groupingBy(Card::getRank, Collectors.counting()));

        softly.assertThat(rankCounts)
                .describedAs("Each rank should appear 4 times")
                .containsOnly(
                        entry(Rank.ACE, 4L),
                        entry(Rank.TWO, 4L),
                        entry(Rank.THREE, 4L),
                        entry(Rank.FOUR, 4L),
                        entry(Rank.FIVE, 4L),
                        entry(Rank.SIX, 4L),
                        entry(Rank.SEVEN, 4L),
                        entry(Rank.EIGHT, 4L),
                        entry(Rank.NINE, 4L),
                        entry(Rank.TEN, 4L),
                        entry(Rank.JACK, 4L),
                        entry(Rank.QUEEN, 4L),
                        entry(Rank.KING, 4L)
                );
    }
}