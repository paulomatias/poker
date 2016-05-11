package com.poker.model;

import com.poker.model.Card.Rank;
import com.poker.model.Card.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    public static final int NUMBER_OF_CARDS = 52;
    private List<Card> cards = new ArrayList<>(NUMBER_OF_CARDS);

    public List<Card> getCards() {
        return cards;
    }

    private Deck() {
    }

    public static Deck retrieve() {
        Deck deck = new Deck();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.cards.add(new Card(suit, rank));
            }
        }
        return deck;
    }

    public void shuffle() {
        Collections.shuffle(this.cards);
    }
}
