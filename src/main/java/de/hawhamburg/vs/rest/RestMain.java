package de.hawhamburg.vs.rest;

import de.hawhamburg.vs.rmi.server.DiceImpl;

import static spark.Spark.after;

public class RestMain {
    public static void main(String[] args) {
        new DiceController(new DiceImpl());

        after((req, res) -> res.type("application/json"));
    }
}
