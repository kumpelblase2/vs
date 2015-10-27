package de.hawhamburg.vs.rest;

import com.google.gson.Gson;
import de.hawhamburg.vs.rest.data.Deck;
import de.hawhamburg.vs.rmi.server.DiceImpl;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static spark.Spark.after;

public class RestMain {
    public static void main(String[] args) {
        Deck deck;
        try {
            deck = new Gson().fromJson(new FileReader(RestMain.class.getClassLoader().getResource("deck.json").getFile()), Deck.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        new DiceController(new DiceImpl());
        new DeckController(deck);

        after((req, res) -> res.type("application/json"));
    }
}
