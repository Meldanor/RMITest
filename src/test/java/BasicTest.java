/*
 * Copyright (C) 2013 Kilian Gaertner
 * 
 * This file is part of RMITest.
 * 
 * RMITest is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 3 of the License.
 * 
 * RMITest is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with RMITest.  If not, see <http://www.gnu.org/licenses/>.
 */

import static org.junit.Assert.*;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import org.junit.Test;

import server.ServerCore;
import client.ClientCore;

public class BasicTest {

    // Create registry - admin can also be done by console
    @Test
    public void init() {
        try {
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        } catch (Exception e) {
            fail("Can't create registry");
            e.printStackTrace();
        }
        System.out.println("Registry started!");
        System.out.println();

    }

    // Create a new server and one client call the method once
    @Test
    public void oneClientTest() {
        System.out.println("Start oneClientTest");
        // Tell RMI that there is a new service in the registry
        try {
            Naming.rebind("Server", new ServerCore());
        } catch (Exception e) {
            e.printStackTrace();
            fail("Can't start server");
        }

        // Start client and call RMI method
        ClientCore client = new ClientCore();
        int count = client.test();
        assertEquals("Counter must be 1!", count, 1);
        System.out.println("Counter = " + count);
        System.out.println("Finished oneClientTest");
        System.out.println();
    }

    @Test
    public void multipleClientTest() {
        System.out.println("Start oneClientTest");
        // Tell RMI that there is a new service in the registry
        try {
            Naming.rebind("Server", new ServerCore());
        } catch (Exception e) {
            e.printStackTrace();
            fail("Can't start server");
        }

        // Start clients and call RMI methodes
        ClientCore client1 = new ClientCore();
        int count = client1.test();
        assertEquals("Counter must be 1!", count, 1);
        System.out.println("Client1 counted. Counter = " + count);

        ClientCore client2 = new ClientCore();
        count = client2.test();
        assertEquals("Counter must be 2!", count, 2);
        System.out.println("Client2 counted. Counter = " + count);

        count = client1.test();
        assertEquals("Counter must be 1!", count, 3);
        System.out.println("Client1 counted. Counter = " + count);

        System.out.println("Finished oneClientTest");
        System.out.println();
    }

}
