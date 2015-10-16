package de.hawhamburg.vs.rmi;

import de.hawhamburg.vs.rmi.server.DiceImpl;
import de.hawhamburg.vs.rmi.shared.DiceRMI;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Main {
    public static void main(String[] args) {
        try {
            DiceImpl impl = new DiceImpl();
            DiceRMI service = (DiceRMI) UnicastRemoteObject.exportObject(impl, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("dice", service);
            System.out.println("Bound dice service");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
