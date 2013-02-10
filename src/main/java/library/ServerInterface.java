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

package library;

import java.rmi.Remote;
import java.rmi.RemoteException;

/*
 * Interface shared by server and client
 */
public interface ServerInterface extends Remote {

    public void count() throws RemoteException;

    public int getCounter() throws RemoteException;
}
