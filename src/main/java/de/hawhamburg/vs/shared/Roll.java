package de.hawhamburg.vs.shared;

import java.io.Serializable;

public class Roll implements Serializable {
    private int number;

    public Roll(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
