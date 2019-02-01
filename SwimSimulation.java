/**
 * Creates and runs the simulation in the tank
 * @author Dustin
 *
 */
public class SwimSimulation 
{
	private PApplet processing;
	private Fish [] fishPositions;
	private Food [] foodPositions;
	private Hook [] hookPositions;
	Fish fish1;
	Fish fish2;
	Fish fish3;
	Fish fish4;
	Food food1;
	Food food2;
	Food food3;
	Food food4;
	Food food5;
	Food food6;
	Hook hook1;
	public SwimSimulation(PApplet process) 
	{
		this.processing = process;
		fish1 = new Fish(processing);
		fish2 = new Fish(processing);
		fish3 = new Fish(processing);
		fish4 = new Fish(processing);
		food1 = new Food(processing);
		food2 = new Food(processing);
		food3 = new Food(processing);
		food4 = new Food(processing);
		food5 = new Food(processing);
		food6 = new Food(processing);
		hook1 = new Hook(processing);
		this.fishPositions = new Fish[] {fish1, fish2, fish3, fish4};
		this.foodPositions = new Food[] {food1, food2, food3, food4, food5, food6};
		this.hookPositions = new Hook[] {hook1};	
	}
	
	public void update()
	{
		processing.background(0,255,255);
		for (int i = 0; i < fishPositions.length; i++) 
		{
			for (int j = 0; j < foodPositions.length; j++)
			{
				((Fish) fishPositions[i]).tryToEat(foodPositions[j]);
			}
		}
		for (int i = 0; i < hookPositions.length; i++) 
		{
			for (int j = 0; j < fishPositions.length; j++)
			{
				((Hook) hookPositions[i]).tryToCatch(fishPositions[j]);
			}
		}
		for (int i = 0; i < fishPositions.length; i++) 
		{
			((Fish) fishPositions[i]).update();
		}
		for (int i = 0; i < foodPositions.length; i++) 
		{
			((Food) foodPositions[i]).update();
		}
		for (int i = 0; i < hookPositions.length; i++) 
		{
			((Hook) hookPositions[i]).update();
		}
	}
	public void handleClick(int mouseX, int mouseY) 
	{
		hook1.handleClick(mouseX, mouseY);
	}
}