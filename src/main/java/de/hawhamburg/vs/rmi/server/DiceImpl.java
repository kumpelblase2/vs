package de.hawhamburg.vs.rmi.server;

import de.hawhamburg.vs.rmi.shared.DiceRMI;
import de.hawhamburg.vs.rmi.shared.Roll;

import java.rmi.RemoteException;
import java.util.Random;

public class DiceImpl implements DiceRMI {
    @Override
    public Roll roll() throws RemoteException {
        return new Roll(new Random().nextInt(5) + 1);
    }
}
