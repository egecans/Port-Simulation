
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package containers;

/** Container is an abstract class which has some defined and undefined methods.
 *  It is the parent of BasicContainer and HeavyContainer.
 * @author Egecan Serbester
 *
 */
public abstract class Container {
	
	
	protected  String type;
	protected int ID, weight;
	protected double consumption;
	private static int IDofcont = 0;
	
	/**
	 * Container is a constructor with signature which has 2 parameters.
	 * @param ID  ID of container
	 * @param weight  weight of container
	 */
	public Container (int ID, int weight) {
		this.ID=ID;
		this.weight=weight;
		IDofcont++;
		type = null;
		consumption();
	}
	
	/** consumption() method is an abstract method, it is defined here but it will be initialized in child classes.
	 * 
	 */
	protected abstract void consumption();
	
	/** equals(Container other) method tells us whether 2 containers are equal or not
	 * 
	 * @param other Container
	 * @return boolean
	 */
	public boolean equals(Container other) {
		 if (other.getID()==ID & other.getWeight()==weight & other.getType()==type)
			 return true;
		 return false;
	 }
	
	/** setConsumption(double consumption) sets the consumption
	 * 
	 * @param consumption
	 */
	protected void setConsumption(double consumption) {
		this.consumption = consumption;
	}
	
	/** getConsumption() gets the consumption
	 * 
	 * @return consumption
	 */
	public double getConsumption() {
		return consumption;
	}
	
	/**getID() gets ID.
	 * 
	 * @return ID
	 */
	public int getID() {
		return ID;
	}
	
	/** getIDofcont() gets ID of container.
	 * 
	 * @return ID of container
	 */
	public static int getIDofcont() {
		return IDofcont;
	}
	
	/** getWeight() gets weight of container
	 * 
	 * @return weight
	 */
	public int getWeight() {
		return weight;
	}
	
	/** getType() gets type of container
	 * 
	 * @return type
	 */
	public String getType() {
		return type;
	}
	

	
	
	

	
	
	
	
}



//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

