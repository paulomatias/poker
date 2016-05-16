package com.poker.model;

import org.junit.Test;

import static com.poker.model.Card.Rank.*;
import static com.poker.model.Card.Suit.*;
import static org.assertj.core.api.Assertions.assertThat;

public class FullHandTest {

    @Test
    public void testGetPair() {
        FullHand hand = new FullHand(
                new Card(CLUBS, AS),
                new Card(DIAMONDS, AS),
                new Card(SPADES, FIVE),
                new Card(HEARTS, NINE),
                new Card(CLUBS, TWO),
                new Card(DIAMONDS, JACK),
                new Card(SPADES, KING)
        );
        assertThat(hand.getPair()).containsExactlyInAnyOrder(new Card(CLUBS, AS), new Card(DIAMONDS, AS));
    }

    @Test
    public void testGetTwoPair() {
        FullHand hand = new FullHand(
                new Card(CLUBS, AS),
                new Card(DIAMONDS, AS),
                new Card(SPADES, FIVE),
                new Card(HEARTS, FIVE),
                new Card(CLUBS, TWO),
                new Card(DIAMONDS, JACK),
                new Card(SPADES, KING)
        );
        assertThat(hand.getTwoPair()).containsExactlyInAnyOrder(new Card(CLUBS, AS), new Card(DIAMONDS, AS), new Card(SPADES, FIVE), new Card(HEARTS, FIVE));
    }

    @Test
    public void testGetThreeOfAKind() {
        FullHand hand = new FullHand(
                new Card(CLUBS, AS),
                new Card(DIAMONDS, AS),
                new Card(SPADES, AS),
                new Card(HEARTS, NINE),
                new Card(CLUBS, TWO),
                new Card(DIAMONDS, JACK),
                new Card(SPADES, KING)
        );
        assertThat(hand.getThreeOfAKind()).containsExactlyInAnyOrder(new Card(CLUBS, AS), new Card(DIAMONDS, AS), new Card(SPADES, AS));
    }

    @Test
    public void testGetStraightWithAsAsOne() {
        FullHand hand = new FullHand(
                new Card(CLUBS, AS),
                new Card(DIAMONDS, TWO),
                new Card(SPADES, THREE),
                new Card(HEARTS, FOUR),
                new Card(CLUBS, FIVE),
                new Card(DIAMONDS, JACK),
                new Card(SPADES, KING)
        );
        assertThat(hand.getStraight()).containsExactlyInAnyOrder(new Card(CLUBS, AS), new Card(DIAMONDS, TWO), new Card(SPADES, THREE), new Card(HEARTS, FOUR), new Card(CLUBS, FIVE));
    }

    @Test
    public void testGetStraight() {
        FullHand hand = new FullHand(
                new Card(CLUBS, AS),
                new Card(DIAMONDS, FOUR),
                new Card(SPADES, FIVE),
                new Card(HEARTS, SIX),
                new Card(CLUBS, SEVEN),
                new Card(DIAMONDS, HEIGHT),
                new Card(SPADES, KING)
        );
        assertThat(hand.getStraight()).containsExactlyInAnyOrder(new Card(DIAMONDS, FOUR), new Card(SPADES, FIVE), new Card(HEARTS, SIX), new Card(CLUBS, SEVEN), new Card(DIAMONDS, HEIGHT));
    }

    @Test
    public void testGetFlush() {
        FullHand hand = new FullHand(
                new Card(CLUBS, AS),
                new Card(CLUBS, FOUR),
                new Card(CLUBS, FIVE),
                new Card(CLUBS, NINE),
                new Card(CLUBS, TWO),
                new Card(DIAMONDS, JACK),
                new Card(SPADES, KING)
        );
        assertThat(hand.getFlush()).containsExactlyInAnyOrder(new Card(CLUBS, AS), new Card(CLUBS, FOUR), new Card(CLUBS, FIVE), new Card(CLUBS, NINE), new Card(CLUBS, TWO));
    }

    @Test
    public void testGetFullHouse() {
        FullHand hand = new FullHand(
                new Card(CLUBS, AS),
                new Card(DIAMONDS, AS),
                new Card(SPADES, AS),
                new Card(HEARTS, NINE),
                new Card(CLUBS, NINE),
                new Card(DIAMONDS, JACK),
                new Card(SPADES, KING)
        );
        assertThat(hand.getFullHouse()).containsExactlyInAnyOrder(new Card(CLUBS, AS), new Card(DIAMONDS, AS), new Card(SPADES, AS), new Card(HEARTS, NINE), new Card(CLUBS, NINE));
    }

    @Test
    public void testGetFourOfAKind() {
        FullHand hand = new FullHand(
                new Card(CLUBS, AS),
                new Card(DIAMONDS, AS),
                new Card(SPADES, AS),
                new Card(HEARTS, AS),
                new Card(CLUBS, TWO),
                new Card(DIAMONDS, JACK),
                new Card(SPADES, KING)
        );
        assertThat(hand.getFourOfAKind()).containsExactlyInAnyOrder(new Card(CLUBS, AS), new Card(DIAMONDS, AS), new Card(SPADES, AS), new Card(HEARTS, AS));
    }

    @Test
    public void testGetStraightFlush() {
        FullHand hand = new FullHand(
                new Card(CLUBS, AS),
                new Card(DIAMONDS, FOUR),
                new Card(DIAMONDS, FIVE),
                new Card(DIAMONDS, SIX),
                new Card(DIAMONDS, SEVEN),
                new Card(DIAMONDS, HEIGHT),
                new Card(SPADES, KING)
        );
        assertThat(hand.getStraightFlush()).containsExactlyInAnyOrder(new Card(DIAMONDS, FOUR), new Card(DIAMONDS, FIVE), new Card(DIAMONDS, SIX), new Card(DIAMONDS, SEVEN), new Card(DIAMONDS, HEIGHT));
    }

    @Test
    public void testGetRoyalFlush() {
        FullHand hand = new FullHand(
                new Card(CLUBS, AS),
                new Card(DIAMONDS, AS),
                new Card(DIAMONDS, QUEEN),
                new Card(DIAMONDS, KING),
                new Card(DIAMONDS, JACK),
                new Card(DIAMONDS, TEN),
                new Card(SPADES, KING)
        );
        assertThat(hand.getRoyalFlush()).containsExactlyInAnyOrder(new Card(DIAMONDS, AS), new Card(DIAMONDS, QUEEN), new Card(DIAMONDS, KING), new Card(DIAMONDS, JACK), new Card(DIAMONDS, TEN));
    }
}