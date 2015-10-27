package de.hawhamburg.vs.rmi;

import de.hawhamburg.vs.rmi.server.DiceImpl;
import de.hawhamburg.vs.rmi.shared.DiceRMI;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/*

    HOW TO RUN:
        - run "rmiregistry -J-Djava.rmi.server.useCodebaseOnly=false"
        - run this main
        - run MainClient

 */

public class Main {
    public static void main(String[] args) {
        try {
            System.setProperty("java.rmi.server.codebase", DiceRMI.class.getProtectionDomain().getCodeSource().getLocation().toString());
            DiceRMI impl = new DiceImpl();
            DiceRMI service = (DiceRMI) UnicastRemoteObject.exportObject(impl, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("dice", service);
            System.out.println("Bound dice service");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
