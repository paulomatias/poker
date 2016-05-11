package com.poker.model;

import org.junit.Test;

import java.util.Arrays;

import static com.poker.model.Card.Rank.*;
import static com.poker.model.Card.Suit.*;
import static com.poker.model.Deck.NUMBER_OF_CARDS;
import static org.assertj.core.api.Assertions.assertThat;

public class DeckTest {

    @Test
    public void testRetrieveContainsAllPokerCardsInOrder() {
        Deck deck = Deck.retrieve();
        assertThat(deck.getCards()).hasSize(NUMBER_OF_CARDS);
        assertThat(deck.getCards()).containsExactly(getCardsInOrder());
    }

    private Card[] getCardsInOrder() {
        return new Card[]{
                new Card(HEARTS, TWO), new Card(HEARTS, THREE), new Card(HEARTS, FOUR), new Card(HEARTS, FIVE), new Card(HEARTS, SIX), new Card(HEARTS, SEVEN), new Card(HEARTS, HEIGHT), new Card(HEARTS, NINE), new Card(HEARTS, TEN), new Card(HEARTS, JACK), new Card(HEARTS, QUEEN), new Card(HEARTS, KING), new Card(HEARTS, AS),
                new Card(DIAMONDS, TWO), new Card(DIAMONDS, THREE), new Card(DIAMONDS, FOUR), new Card(DIAMONDS, FIVE), new Card(DIAMONDS, SIX), new Card(DIAMONDS, SEVEN), new Card(DIAMONDS, HEIGHT), new Card(DIAMONDS, NINE), new Card(DIAMONDS, TEN), new Card(DIAMONDS, JACK), new Card(DIAMONDS, QUEEN), new Card(DIAMONDS, KING), new Card(DIAMONDS, AS),
                new Card(CLUBS, TWO), new Card(CLUBS, THREE), new Card(CLUBS, FOUR), new Card(CLUBS, FIVE), new Card(CLUBS, SIX), new Card(CLUBS, SEVEN), new Card(CLUBS, HEIGHT), new Card(CLUBS, NINE), new Card(CLUBS, TEN), new Card(CLUBS, JACK), new Card(CLUBS, QUEEN), new Card(CLUBS, KING), new Card(CLUBS, AS),
                new Card(SPADES, TWO), new Card(SPADES, THREE), new Card(SPADES, FOUR), new Card(SPADES, FIVE), new Card(SPADES, SIX), new Card(SPADES, SEVEN), new Card(SPADES, HEIGHT), new Card(SPADES, NINE), new Card(SPADES, TEN), new Card(SPADES, JACK), new Card(SPADES, QUEEN), new Card(SPADES, KING), new Card(SPADES, AS)};
    }

    @Test
    public void testShuffle() {
        Deck deck = Deck.retrieve();
        deck.shuffle();
        assertThat(deck.getCards()).hasSize(NUMBER_OF_CARDS);
        assertThat(deck.getCards()).containsExactlyInAnyOrder(getCardsInOrder());
        assertThat(deck.getCards()).isNotEqualTo(Arrays.asList(getCardsInOrder()));
    }
}