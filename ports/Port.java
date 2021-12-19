
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package ports;

import java.util.*;

import containers.Container;
import interfaces.IPort;
import ships.Ship;

/** Port is a class that has some methods and implements IPort.
 * 
 * @author Egecan Serbester
 *
 */
public class Port implements IPort {
	private static int IDofport = 0;
	private int ID;
	private double X, Y;
	public ArrayList<Container> containers = new ArrayList<Container>() ;
	public ArrayList<Ship> history = new ArrayList<Ship>() ;
	public ArrayList<Ship> current = new ArrayList<Ship>() ;
	
	/** Port is a constructor of Port class with signature which has 3 parameters.
	 * 
	 * @param ID of port
	 * @param X coordinate of port
	 * @param Y coordinate of port
	 */
	public Port(int ID, double X, double Y) {
		this.X=X;
		this.Y=Y;
		this.ID=ID;
		IDofport++;
	}
	
	/** getDistance(Port other) method calculates the distance and return it.
	 * 
	 * @param other port
	 * @return the result of calculating distance process
	 */
	public double getDistance(Port other) {
		return Math.sqrt((Y-other.getY())*(Y-other.getY())+(X-other.getX())*(X-other.getX()));
	}
	
	
	/** This method adds the incoming ship to current Array list
	 * 
	 */
	
	public void incomingShip(Ship s) {
		current.add(s);
		}

	
	/** This method adds the outgoing ship to history Array list even if the ship hasn't visited the port before 
	 * and removes that ship from current ArrayList.
	 */
	
	public void outgoingShip(Ship s) {
		if ( ! ( history.contains(s))) {
		history.add(s);
		}
		current.remove(s);
	}
	
	/**  getIndexofContainer(int contID) method is finding the index of container whose id was given.
	 *  This process is required for taking and processing input in main class.
	 * @param contID id of container
	 * @return index of container whose id was given in container ArrayList.
	 */
	public int getIndexofContainer(int contID) {
		for (int i=0 ; i < containers.size(); i++) {
			if (containers.get(i).getID() == contID) {
				return i;
			}
		}
		return -1;
	}
	
	/** gets portID 
	 * 
	 * @return portID
	 */

	public int getID() {
		return ID;
	}
	
	/** gets the value that how many times the port was called with static field IDofport
 	 * 
	 * @return IDofport
	 */

	public static int getIDofport() {
		return IDofport;
	}
	
	/** gets x coordinate of port
	 * 
	 * @return  x coordinate
	 */
	public double getX() {
		return X;
	}
	
	/** gets y coordinate of port
	 * 
	 * @return y coordinate 
	 */
	public double getY() {
		return Y;
	}


	/** This method is my own method for any given ArrayList of containers to sort it with respect to their IDs.
	 *  in this method, I firstly creating new ArrayList of integer for IDs and then sorting this.
	 *  And then I create a new ArrayList of integers to find indexes of sorted IDs in given ArrayList of containers.
	 *  Finally, I match indexes with sorted ID list and return Sorted ArrayList of container
	 * @param contList  ArrayList of containers
	 * @return sorted by ID ArrayList of containers
	 */
	public ArrayList<Container> sortedContainer(ArrayList<Container> contList) {
		
		ArrayList<Integer> IDs = new ArrayList<Integer>();
		for (int i=0; i<contList.size(); i++) {
			IDs.add(contList.get(i).getID());   
			}
		IDs.sort(null);
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		for (int i=0 ; i< contList.size(); i++) {
			for (int j=0 ; j< contList.size(); j++) {
				if (IDs.get(i).equals(contList.get(j).getID())) {
					indexes.add(j);
					break;
				}
			}
		}
		ArrayList<Container> contListSort = new ArrayList<Container>();
		for (int i=0; i<indexes.size(); i++) {
			contListSort.add(contList.get(indexes.get(i)));
			}
		return contListSort;
	}
	
	/** This method is my own method for any given ArrayList of ship to sort it with respect to their IDs.
	 *  its procedure is similar to sortedContainer(contList) method.
	 * @param ShipList ArrayList of ships
	 * @return sorted by ID ArrayList of ships
	 */
public ArrayList<Ship> sortedShips(ArrayList<Ship> ShipList) {
		
		ArrayList<Integer> IDs = new ArrayList<Integer>();
		for (int i=0; i<ShipList.size(); i++) {
			IDs.add(ShipList.get(i).getID());   
			}
		IDs.sort(null);
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		for (int i=0 ; i< ShipList.size(); i++) {
			for (int j=0 ; j< ShipList.size(); j++) {
				if (IDs.get(i).equals(ShipList.get(j).getID())) {
					indexes.add(j);
					break;
				}
			}
		}
		ArrayList<Ship> ShipListSort = new ArrayList<Ship>();
		for (int i=0; i<indexes.size(); i++) {
			ShipListSort.add(ShipList.get(indexes.get(i)));
			}
		return ShipListSort;
	}
	
	/** This method finds the BasicContainers in containers ArrayList.
	 *  it is required for main method to print in output file.
	 * @return line of Basic Containers
	 */
	
	public String BasicContainers() {
		String IDs ="BasicContainer:";
		for (int i = 0; i<sortedContainer(containers).size(); i++ ) {
			if (sortedContainer(containers).get(i).getType().equals("BasicContainer")) {
				IDs += " "+ sortedContainer(containers).get(i).getID();
			}
		}
		return IDs;
	}
	
	/** This method finds the HeavyContainers in containers ArrayList.
	 *  it is required for main method to print in output file.
	 * @return line of Heavy Containers
	 */
	public String HeavyContainers() {
		String IDs ="HeavyContainer:";
		for (int i = 0; i<sortedContainer(containers).size(); i++ ) {
			if (sortedContainer(containers).get(i).getType().equals("HeavyContainer")) {
				IDs += " "+ sortedContainer(containers).get(i).getID();
			}
		}
		return IDs;
	}
	
	/** This method finds the RefrigeratedContainers in containers ArrayList.
	 *  it is required for main method to print in output file.
	 * @return line of Refrigerated Containers.
	 */
	
	public String RefrigeratedContainers() {
		String IDs ="RefrigeratedContainer:";
		for (int i = 0; i<sortedContainer(containers).size(); i++ ) {
			if (sortedContainer(containers).get(i).getType().equals("RefrigeratedContainer")) {
				IDs += " "+ sortedContainer(containers).get(i).getID();
			}
		}
		return IDs;
	}
	
	/** This method finds the LiquidContainers in containers ArrayList.
	 *  it is required for main method to print in output file.
	 * @return line of Liquid Containers
	 */
	public String LiquidContainers() {
		String IDs ="LiquidContainer:";
		for (int i = 0; i<sortedContainer(containers).size(); i++ ) {
			if (sortedContainer(containers).get(i).getType().equals("LiquidContainer")) {
				IDs += " "+ sortedContainer(containers).get(i).getID();
			}
		}
		return IDs;
	}
	
	
	
	
	
}



//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

