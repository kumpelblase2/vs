package de.hawhamburg.vs.rmi.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DiceRMI extends Remote {
    Roll roll() throws RemoteException;
}
