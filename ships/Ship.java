
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package ships;

import java.util.ArrayList;
import java.util.Collections;

import containers.Container;
import interfaces.IShip;
import ports.Port;

/** Ship is a class that has some methods and implements IShip.
 * 
 * @author Egecan Serbester
 *
 */
public class Ship implements IShip{
	private int ID, totalWeightCapacity, maxNumberOfAllContainers,maxNumberOfHeavyContainers,maxNumberOfRefrigeratedContainers,maxNumberOfLiquidContainers;
	private double fuel, fuelConsumptionPerKM;
	private Port currentPort;
	private static int IDofship = 0; 
	private int NumberofAllContainers, NumberOfHeavyContainers, NumberOfRefrigeratedContainers, NumberOfLiquidContainers, totalWeight = 0;
	public ArrayList<Container> currentContainers = new ArrayList<Container>() ;
	
	/** Ship is a constructor of Ship class with signature which has 8 parameters.
	 * 
	 * @param ID of ship
	 * @param p port of ship
	 * @param totalWeightCapacity of ship
	 * @param maxNumberOfAllContainers  of ship
	 * @param maxNumberOfHeavyContainers  of ship
	 * @param maxNumberOfRefrigeratedContainers  of ship
	 * @param maxNumberOfLiquidContainers  of ship
	 * @param fuelConsumptionPerKM  of ship
	 */
	public Ship(int ID, Port p, int totalWeightCapacity, int maxNumberOfAllContainers, int maxNumberOfHeavyContainers, int
			maxNumberOfRefrigeratedContainers, int maxNumberOfLiquidContainers, double fuelConsumptionPerKM) {
		this.ID=ID;
		IDofship++;
		this.currentPort=p;
		this.totalWeightCapacity=totalWeightCapacity;
		this.maxNumberOfAllContainers=maxNumberOfAllContainers;
		this.maxNumberOfHeavyContainers=maxNumberOfHeavyContainers;
		this.maxNumberOfRefrigeratedContainers=maxNumberOfRefrigeratedContainers;
		this.maxNumberOfLiquidContainers=maxNumberOfLiquidContainers;
		this.fuelConsumptionPerKM=fuelConsumptionPerKM;
		fuel=0;
		p.incomingShip(this);
	}
	
	/** This method is for refueling the ship add the fuel the given amount.
	 * 
	 */
	public void reFuel(double newFuel) {
		fuel += newFuel;
	}
	/** This method calculates the totalConsumptionPerKm
	 * 
	 * @return totalConsumptionPerKm
	 */
	public double totalConsumptionPerKm() {
		double totalConsumptionPerKm = fuelConsumptionPerKM;
		for (int i = 0; i< currentContainers.size(); i++) {
			totalConsumptionPerKm += currentContainers.get(i).getConsumption();
		}
		return totalConsumptionPerKm;
	}
	/** This method decided whether the ship can sail to another port or not by comparing distance with the fuel.
	 * 
	 */
	public boolean sailTo(Port p) {
		if (fuel >= p.getDistance(currentPort) * totalConsumptionPerKm() ) {
			reFuel ( - (p.getDistance(currentPort) * totalConsumptionPerKm() ) );
			currentPort.outgoingShip(this);
			p.incomingShip(this);
			currentPort = p;
			return true;
		}
		return false;
	}
	
	
	/** This method decides whether a given container can load to the ship or not by comparing with ship's limitations 
	 * if it succeed method can do some operations about the loading process.
	 */
	public boolean load(Container cont) {
		
		if ( ( currentPort.containers.contains(cont) ) && (cont.getWeight() <= (totalWeightCapacity - totalWeight)) 
				&& ( (maxNumberOfAllContainers- NumberofAllContainers) >= 1) ){
			if (cont.getType().equals("BasicContainer") ) {
				currentContainers.add(cont);
				currentPort.containers.remove(cont);
				NumberofAllContainers += 1;
				totalWeight += cont.getWeight();
				return true;	
			}
			else if ( (cont.getType().equals("HeavyContainer") )  && ( (maxNumberOfHeavyContainers - NumberOfHeavyContainers) >= 1) ) {
				currentContainers.add(cont);
				currentPort.containers.remove(cont);
				NumberofAllContainers += 1;
				totalWeight += cont.getWeight();
				NumberOfHeavyContainers += 1; 
				return true;
			}
			else if ( (cont.getType().equals("LiquidContainer") ) && ( (maxNumberOfHeavyContainers - NumberOfHeavyContainers) >= 1)
							&& ( (maxNumberOfLiquidContainers - NumberOfLiquidContainers) >= 1 ) ) {
				currentContainers.add(cont);
				currentPort.containers.remove(cont);
				NumberofAllContainers += 1;
				totalWeight += cont.getWeight();
				NumberOfLiquidContainers += 1; 
				NumberOfHeavyContainers += 1; 
				return true;	
			}
			else if ( cont.getType().equals("RefrigeratedContainer") && ( (maxNumberOfHeavyContainers - NumberOfHeavyContainers) >= 1)
							&& ( (maxNumberOfRefrigeratedContainers - NumberOfRefrigeratedContainers) >= 1 ) )	 {
				currentContainers.add(cont);
				currentPort.containers.remove(cont);
				NumberofAllContainers += 1;
				totalWeight += cont.getWeight();
				NumberOfRefrigeratedContainers += 1; 
				NumberOfHeavyContainers += 1; 
				return true; 
			}
			else {
				return false;
			}
		}
			else { 
				return false;
			}
	}
			

			
			
	/** This method decides whether a given container can unload from the ship or not by comparing with ship's limitations 
	 * if it succeed method can do some operations about the unloading process.
	 */
	public boolean unLoad(Container cont) {
		if ( currentContainers.contains(cont) ) {
			currentPort.containers.add(cont);
			currentContainers.remove(cont);
			NumberofAllContainers -= 1;
			totalWeight -= cont.getWeight();
			if (cont.getType().equals("BasicContainer") ) { return true; }
			else if (cont.getType().equals("HeavyContainer") ) { NumberOfHeavyContainers -= 1; return true; }
			else if (cont.getType().equals("LiquidContainer")) { NumberOfLiquidContainers -= 1; NumberOfHeavyContainers -= 1; return true; }
			else if (cont.getType().equals("RefrigeratedContainer") ) { NumberOfRefrigeratedContainers -= 1; NumberOfHeavyContainers -= 1; return true; }
			else {return false; } 
			}
		else {
			return false;
			}
		}
	
	/** This method gets index of container in currentContainers arrayList with given container id
	 * 
	 * @param contID container ID
	 * @return container index
	 */
	public int getIndexofContainer(int contID) {
		for (int i=0 ; i < currentContainers.size(); i++) {
			if (currentContainers.get(i).getID() == contID) {
				return i;
			}
		}
		return -1;
	}
	
	/** This method sorts the container arrayList with respect to containers' IDs.
	 * 
	 * @param contList container ArrayList
	 * @return sorted container ArrayList
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
	
	
	/** gets current containers arrayList
	 * 
	 * @return current containers arrayList
	 */
	public ArrayList<Container> getCurrentContainers() {
		return sortedContainer(currentContainers);
	}

	/** gets ship ID
	 * 
	 * @return ship ID
	 */
	public int getID() {
		return ID;
	}
	
	/** gets the value that how many times the ship was called with static field IDofship
	 * 
	 * @return ID of ship
	 */
	public static int getIDofship() {
		return IDofship;
	}
	
	/** gets the current port which ship is on
	 * 
	 * @return current port
	 */
	public Port getCurrentPort() {
		return currentPort;
	}
	
	
	/** gets fuel of ship
	 * 
	 * @return fuel
	 */
	public double getFuel() {
		return fuel;
	}


	/** This method finds the BasicContainers in containers ArrayList.
	 *  it is required for main method to print in output file.
	 * @return line of Basic Containers
	 */
	public String BasicContainers() {
		String IDs ="BasicContainer:";
		for (int i = 0; i<sortedContainer(currentContainers).size(); i++ ) {
			if (sortedContainer(currentContainers).get(i).getType().equals("BasicContainer")) {
				IDs += " "+ sortedContainer(currentContainers).get(i).getID();
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
		for (int i = 0; i<sortedContainer(currentContainers).size(); i++ ) {
			if (sortedContainer(currentContainers).get(i).getType().equals("HeavyContainer")) {
				IDs += " "+ sortedContainer(currentContainers).get(i).getID();
			}
		}
		return IDs;
	}
	
	/** This method finds the RefrigeratedContainers in containers ArrayList.
	 *  it is required for main method to print in output file.
	 * @return line of Refrigerated Containers
	 */
	public String RefrigeratedContainers() {
		String IDs ="RefrigeratedContainer:";
		for (int i = 0; i<sortedContainer(currentContainers).size(); i++ ) {
			if (sortedContainer(currentContainers).get(i).getType().equals("RefrigeratedContainer")) {
				IDs += " "+ sortedContainer(currentContainers).get(i).getID();
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
		for (int i = 0; i<sortedContainer(currentContainers).size(); i++ ) {
			if (sortedContainer(currentContainers).get(i).getType().equals("LiquidContainer")) {
				IDs += " "+ sortedContainer(currentContainers).get(i).getID();
			}
		}
		return IDs;
	}
	
	
	
}



//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

