package de.hawhamburg.vs.rest;

import spark.Request;
import spark.Response;

import static de.hawhamburg.vs.rest.JsonUtil.json;
import static spark.Spark.get;

public class DeckController {
    public DeckController() {
        get("/deck/:gameId/community", this::handleCommunityDeck, json());
        get("/deck/:gameId/chance", this::handleChanceDeck, json());
    }

    public Object handleCommunityDeck(Request request, Response response) {
        return null;
    }

    public Object handleChanceDeck(Request request, Response response) {
        return null;
    }
}
