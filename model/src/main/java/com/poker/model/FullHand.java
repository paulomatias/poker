package com.poker.model;

import com.poker.model.Card.Rank;
import com.poker.model.Card.Suit;

import java.util.*;
import java.util.stream.Collectors;

import static com.poker.model.Card.Rank.AS;
import static com.poker.model.Card.Rank.KING;
import static java.util.Collections.emptyList;

public class FullHand {
    public static final int FULL_HAND_NUMBER_OF_CARDS = 7;
    private List<Card> fullHand = new ArrayList<>(FULL_HAND_NUMBER_OF_CARDS);

    public FullHand(Card... cards) {
        Collections.addAll(fullHand, cards);
    }

    public List<Card> getPair() {
        List<Card> pair = new ArrayList<>();
        Map<Rank, List<Card>> fullHandByRank = fullHand.stream().collect(Collectors.groupingBy(Card::getRank));
        fullHandByRank.keySet().stream()
                .filter(rank -> fullHandByRank.get(rank).size() == 2)
                .forEach(rank -> pair.addAll(fullHandByRank.get(rank)));
        if (pair.size() == 2) {
            return pair;
        } else {
            return emptyList();
        }
    }

    public List<Card> getTwoPair() {
        List<Card> twoPair = new ArrayList<>();
        Map<Rank, List<Card>> fullHandByRank = fullHand.stream().collect(Collectors.groupingBy(Card::getRank));
        fullHandByRank.keySet().stream()
                .filter(rank -> fullHandByRank.get(rank).size() == 2)
                .forEach(rank -> twoPair.addAll(fullHandByRank.get(rank)));
        if (twoPair.size() == 4) {
            return twoPair;
        } else {
            return emptyList();
        }
    }

    public List<Card> getThreeOfAKind() {
        List<Card> threeOfAKind = new ArrayList<>();
        Map<Rank, List<Card>> fullHandByRank = fullHand.stream().collect(Collectors.groupingBy(Card::getRank));
        fullHandByRank.keySet().stream().
                filter(rank -> fullHandByRank.get(rank).size() == 3)
                .forEach(rank -> threeOfAKind.addAll(fullHandByRank.get(rank)));
        if (threeOfAKind.size() == 3) {
            return threeOfAKind;
        } else {
            return emptyList();
        }
    }

    public List<Card> getStraight() {
        List<Card> straight = new ArrayList<>();
        Map<Rank, List<Card>> fullHandByRank = fullHand.stream().collect(Collectors.groupingBy(Card::getRank));

        List<Rank> allRanksWithAsInTheFrontToo = new ArrayList<>();
        allRanksWithAsInTheFrontToo.add(AS);
        allRanksWithAsInTheFrontToo.addAll(Arrays.asList(Rank.values()));

        int maxStraight = 0;
        for (Rank rank : allRanksWithAsInTheFrontToo) {
            List<Card> cards = fullHandByRank.get(rank);
            if (cards == null) {
                straight = new ArrayList<>();
                maxStraight = 0;
            } else {
                straight.addAll(cards);
                maxStraight++;
            }
            if (maxStraight >= 5) {
                return straight;
            }
        }
        return emptyList();
    }

    public List<Card> getFlush() {
        List<Card> flush = new ArrayList<>();
        Map<Suit, List<Card>> fullHandBySuit = fullHand.stream().collect(Collectors.groupingBy(Card::getSuit));
        fullHandBySuit.keySet().stream()
                .filter(suit -> fullHandBySuit.get(suit).size() == 5)
                .forEach(suit -> flush.addAll(fullHandBySuit.get(suit)));
        if (flush.size() == 5) {
            return flush;
        } else {
            return emptyList();
        }
    }

    public List<Card> getFullHouse() {
        List<Card> fullHouse = new ArrayList<>();

        Map<Rank, List<Card>> fullHandByRank = fullHand.stream().collect(Collectors.groupingBy(Card::getRank));
        Rank rankOfThePair = null;
        Rank rankOfTheThreeOfAKind = null;
        for (Rank rank : fullHandByRank.keySet()) {
            if (fullHandByRank.get(rank).size() == 2) {
                fullHouse.addAll(fullHandByRank.get(rank));
                rankOfThePair = rank;
            } else if (fullHandByRank.get(rank).size() == 3) {
                fullHouse.addAll(fullHandByRank.get(rank));
                rankOfTheThreeOfAKind = rank;
            }
        }
        if (rankOfThePair != null && rankOfTheThreeOfAKind != null) {
            return fullHouse;
        } else {
            return emptyList();
        }
    }

    public List<Card> getFourOfAKind() {
        List<Card> fourOfaKind = new ArrayList<>();

        Map<Rank, List<Card>> fullHandByRank = fullHand.stream().collect(Collectors.groupingBy(Card::getRank));
        fullHandByRank.keySet().stream()
                .filter(rank -> fullHandByRank.get(rank).size() == 4)
                .forEach(rank -> fourOfaKind.addAll(fullHandByRank.get(rank)));

        if (fourOfaKind.size() == 4) {
            return fourOfaKind;
        } else {
            return emptyList();
        }
    }

    public List<Card> getStraightFlush() {
        List<Card> straightFlush = getStraight();
        Map<Suit, List<Card>> straightFlushBySuit = straightFlush.stream().collect(Collectors.groupingBy(Card::getSuit));
        for (Suit suit : straightFlushBySuit.keySet()) {
            if (straightFlushBySuit.get(suit).size() == 5) {
                return straightFlushBySuit.get(suit);
            }
        }
        return emptyList();
    }

    public List<Card> getRoyalFlush() {
        List<Card> straightFlush = getStraightFlush();
        Suit suit = straightFlush.get(0).getSuit();
        if (straightFlush.containsAll(Arrays.asList(new Card(suit, AS), new Card(suit, KING)))) {
            return straightFlush;
        } else {
            return emptyList();
        }
    }

}
