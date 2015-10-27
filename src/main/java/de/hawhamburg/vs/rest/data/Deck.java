package de.hawhamburg.vs.rest.data;

import java.util.List;
import java.util.Random;


public class Deck {
    private List<Card> communityDeck;
    private List<Card> changeDeck;

    public Deck() {}

    public Deck(List<Card> communityDeck, List<Card> changeDeck) {
        this.communityDeck = communityDeck;
        this.changeDeck = changeDeck;
    }

    public List<Card> getCommunityDeck() {
        return communityDeck;
    }

    public List<Card> getChangeDeck() {
        return changeDeck;
    }

    public Card drawCommunityCard() {
        return communityDeck.get(new Random().nextInt(communityDeck.size()));
    }

    public Card drawChangeCard() {
        return changeDeck.get(new Random().nextInt(changeDeck.size()));
    }
}
