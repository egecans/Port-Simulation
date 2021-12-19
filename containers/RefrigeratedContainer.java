
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package containers;

/**  RefrigeratedContainer is a child class which extends HeavyContainer.
 * 
 * @author Egecan Serbester
 *
 */
public class RefrigeratedContainer extends HeavyContainer {
	
	/**  RefrigeratedContainer (int ID, int weight) is a constructor of LiquidContainer class which has the same signature with extended class.
	 * 
	 * @param ID of Refrigerated Container
	 * @param weight of Refrigerated Container
	 */
	public RefrigeratedContainer (int ID, int weight) {
		super(ID,weight);	
		type = "RefrigeratedContainer";
	}
	
	/** this method is overloading version of consumption() method in HeavyContainer class.
	 *  it sets the consumption properly with the features of Refrigerated Container.
	 */
	protected void consumption() {
		super.setConsumption(5.00 * (double) super.getWeight());
	}

}



//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

