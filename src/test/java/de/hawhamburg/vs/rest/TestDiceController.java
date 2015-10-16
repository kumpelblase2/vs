package de.hawhamburg.vs.rest;

import de.hawhamburg.vs.rmi.shared.DiceRMI;
import de.hawhamburg.vs.rmi.shared.Roll;
import org.junit.Before;
import org.junit.Test;

import java.rmi.RemoteException;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestDiceController {
    DiceController controller;

    @Before
    public void setup() throws RemoteException {
        DiceRMI diceMock = mock(DiceRMI.class);
        when(diceMock.roll()).thenReturn(new Roll(3));
        controller = new DiceController(diceMock);
    }

    @Test
    public void testDiceRoll() {
        assertThat(controller.handleDiceGet(null, null), equalTo(new Roll(3)));
    }
}
