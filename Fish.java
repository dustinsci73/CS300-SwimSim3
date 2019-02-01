/**
 * Creates the fish objects to be placed in the tank
 * @author Dustin
 *
 */
public class Fish 
{
	private PApplet processing;
	private PImage fishImage;
	private int xPos;
	private int yPos;

	public Fish (PApplet process) 
	{
		this.processing = process;
		this.fishImage = processing.loadImage("images" + java.io.File.separator + "FISH.png");
		this.xPos = Utility.randomInt(processing.width);
		this.yPos = Utility.randomInt(processing.height);
	}
	
	public void update() 
	{
		processing.image(fishImage, xPos, yPos);
		if (xPos + 1 < processing.width) 
		{
			xPos += 1;
		}
		else 
		{
			xPos = 0;
		}
	}
	
	public void tryToEat(Food food) 
	{
		if (food.distanceTo(xPos, yPos) <= 40) 
		{
			food.getEaten();
		}
	}
	
	public float distanceTo(int x, int y) 
	{
		float dis = (float) Math.sqrt((x-xPos)*(x-xPos) + (y-yPos)*(y-yPos));
		return dis;
	} // returns the distance from this fish to position x, y
	
	public void getCaught() 
	{
		xPos = 0;
		yPos = Utility.randomInt(processing.height);
	} // moves this fish to a random position along the left edge of the screen
}

