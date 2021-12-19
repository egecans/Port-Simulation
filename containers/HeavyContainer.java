
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package containers;

/** HeavyContainer is both child and parent class which extends Container and has 2 children (Refrigerated and Liquid Container)
 * 
 * @author Egecan Serbester
 *
 */
public class HeavyContainer extends Container {
	 
	/**  HeavyContainer (int ID, int weight) is a constructor of HeavyContainer class which has the same signature with extended class.
	 * 
	 * @param ID of Heavy Container
	 * @param weight of Heavy Container
	 */
	public HeavyContainer (int ID, int weight) {
		super(ID,weight);
		type = "HeavyContainer";
	}
	
	/** this method is initialized version of abstract consumption() method in Container class.
	 *  it sets the consumption properly with the features of Heavy Container.
	 */
	protected void consumption() {
		super.setConsumption(3.00 * (double) super.getWeight());
	}
	
	
	
}



//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

