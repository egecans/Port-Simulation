
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package containers;

/** BasicContainer is a child class which extends Container.
 * 
 * @author Egecan Serbester
 *
 */
public class BasicContainer extends Container {
	
	/** BasicContainer (int ID, int weight) is a constructor of BasicContainer class which has the same signature with extended class.
	 * 
	 * @param ID of Basic Container
	 * @param weight of Basic Container
	 */
	public BasicContainer (int ID, int weight) {
		super(ID,weight);
		type = "BasicContainer";
	}

	/** this method is initialized version of abstract consumption() method in Container class.
	 *  it sets the consumption properly with the features of Basic Container.
	 */
	protected void consumption() {
		super.setConsumption(2.50 * (double) super.getWeight());
	}
	
}


//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
