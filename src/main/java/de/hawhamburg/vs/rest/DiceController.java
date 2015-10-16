package de.hawhamburg.vs.rest;

import de.hawhamburg.vs.rmi.shared.DiceRMI;
import de.hawhamburg.vs.rmi.shared.Roll;
import spark.Request;
import spark.Response;

import java.rmi.RemoteException;

import static de.hawhamburg.vs.rest.JsonUtil.json;
import static spark.Spark.*;

public final class DiceController {
    private final DiceRMI dice;

    public DiceController(DiceRMI dice) {
        this.dice = dice;
        get("/dice", this::handleDiceGet, json());
    }

    public Roll handleDiceGet(Request request, Response response) {
        try {
            return dice.roll();
        } catch (RemoteException e) {
            return null;
        }
    }
}
