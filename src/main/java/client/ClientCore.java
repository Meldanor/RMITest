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

package client;

import java.rmi.Naming;

import library.ServerInterface;

/*
 * Representing a client using methods offered by the server
 */
public class ClientCore {

    public ClientCore() {

    }

    public int test() {
        try {
            // Create an interactable object of the server interface
            ServerInterface server = (ServerInterface) Naming.lookup("//127.0.0.1/Server");
            // increase counter by one
            server.count();
            // return current state of the counter
            return server.getCounter();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

}
