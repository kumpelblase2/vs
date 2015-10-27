package de.hawhamburg.vs.rmi.shared;

import java.io.Serializable;

public class Roll implements Serializable {
    private int number;

    public Roll(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Roll roll = (Roll) o;
        return number == roll.number;

    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public String toString() {
        return "Roll{" +
                "number=" + number +
                '}';
    }
}
