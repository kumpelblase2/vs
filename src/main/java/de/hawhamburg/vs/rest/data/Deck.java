package de.hawhamburg.vs.rest.data;

import java.util.List;
import java.util.Random;


public class Deck {
    private List<Card> community;
    private List<Card> chance;

    public Deck() {}

    public Deck(List<Card> communityDeck, List<Card> changeDeck) {
        this.community = communityDeck;
        this.chance = changeDeck;
    }

    public List<Card> getCommunity() {
        return community;
    }

    public List<Card> getChance() {
        return chance;
    }

    public Card drawCommunityCard() {
        return community.get(new Random().nextInt(community.size() - 1));
    }

    public Card drawChangeCard() {
        return chance.get(new Random().nextInt(chance.size() - 1));
    }
}
