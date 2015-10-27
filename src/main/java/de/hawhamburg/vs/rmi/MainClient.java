package de.hawhamburg.vs.rmi;

import de.hawhamburg.vs.rmi.shared.DiceRMI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MainClient {

    public static void main(String[] args) throws NotBoundException {
        try {
            Registry registry = LocateRegistry.getRegistry();
            DiceRMI dice = (DiceRMI)registry.lookup("dice");
            System.out.println(dice.roll());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
