
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package containers;

/** LiquidContainer is a child class which extends HeavyContainer.
 * 
 * @author Egecan Serbester
 *
 */
public class LiquidContainer extends HeavyContainer {
	
	/**  LiquidContainer (int ID, int weight) is a constructor of LiquidContainer class which has the same signature with extended class.
	 *  
	 * @param ID of Liquid Container
	 * @param weight of Liquid Container
	 */
	public LiquidContainer (int ID, int weight) {
		super(ID,weight);
		type = "LiquidContainer";
	}
	
	/** this method is overloading version of consumption() method in HeavyContainer class.
	 *  it sets the consumption properly with the features of Liquid Container.
	 */
	protected void consumption() {
		setConsumption(4.00 * (double) super.getWeight());
	}
}



//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

