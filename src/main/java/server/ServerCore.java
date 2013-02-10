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

package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import library.ServerInterface;

/*
 * Representing the server offering methods to clients
 */
public class ServerCore extends UnicastRemoteObject implements ServerInterface {

    // how many clients have called "count"
    private int counter = 0;

    private static final long serialVersionUID = -9029920178150715285L;

    public ServerCore() throws RemoteException {
        super();
    }

    // increasing the counter
    public void count() throws RemoteException {
        ++counter;
    }

    // sending the current state of the counter to the client
    public int getCounter() throws RemoteException {
        return counter;
    }

}
