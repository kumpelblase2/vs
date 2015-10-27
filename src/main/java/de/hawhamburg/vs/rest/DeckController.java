package de.hawhamburg.vs.rest;

import com.google.gson.Gson;
import de.hawhamburg.vs.rest.data.Deck;
import spark.Request;
import spark.Response;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static de.hawhamburg.vs.rest.JsonUtil.json;
import static spark.Spark.get;

public class DeckController {

    private Deck deck;

    public DeckController(Deck deck) {
        this.deck = deck;
        get("/deck/:gameId/community", this::handleCommunityDeck, json());
        get("/deck/:gameId/chance", this::handleChanceDeck, json());
    }

    public Object handleCommunityDeck(Request request, Response response) {
        return deck.drawCommunityCard();
    }

    public Object handleChanceDeck(Request request, Response response) {
        return deck.drawChangeCard();
    }
}
