package de.hawhamburg.vs.rest;

import de.hawhamburg.vs.rmi.shared.DiceRMI;
import de.hawhamburg.vs.rmi.shared.Roll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;

import java.rmi.RemoteException;

import static de.hawhamburg.vs.rest.JsonUtil.json;
import static spark.Spark.*;

public final class DiceController {
    private final DiceRMI dice;
    private static final Logger log = LoggerFactory.getLogger(DiceController.class);

    public DiceController(DiceRMI dice) {
        this.dice = dice;
        get("/dice", this::handleDiceGet, json());
        get("/deck/:gameId/community", this::handleCommunityDeck, json());
        get("/deck/:gameId/chance", this::handleChanceDeck, json());
    }

    public Roll handleDiceGet(Request request, Response response) {
        try {
            Roll roll = dice.roll();
            log.info(roll.toString());
            return roll;
        } catch (RemoteException e) {
            return null;
        }
    }

    public Object handleCommunityDeck(Request request, Response response) {
        return null;
    }

    public Object handleChanceDeck(Request request, Response response) {
        return null;
    }
}
