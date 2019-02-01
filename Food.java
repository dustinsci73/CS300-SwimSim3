/**
 * Creates food objects to be placed in the tank
 * @author Dustin
 *
 */
public class Food 
{
	private PApplet processing;
	private PImage foodImage;
	private int xPos;
	private int yPos;

	public Food (PApplet process) 
	{
		this.processing = process;
		this.foodImage = processing.loadImage("images" + java.io.File.separator + "FOOD.png");
		this.xPos = Utility.randomInt(processing.width);
		this.yPos = Utility.randomInt(processing.height);
	}
	public void update() 
	{
		processing.image(foodImage, xPos, yPos);
		if (yPos + 1 > processing.height) 
		{
			yPos = 0;
		}
		else 
		{
			yPos += 1;
		}
		if (xPos - 1 < 0) 
		{
			xPos = processing.width;
		}
		else 
		{
			xPos -= 1;
		} 
	}
	public float distanceTo(int x, int y) 
	{
		float dis = (float) Math.sqrt((x-xPos)*(x-xPos) + (y-yPos)*(y-yPos));
		return dis;
	} // returns the distance from this food to position x, y
	public void getEaten() 
	{
		yPos = 0;
		xPos = Utility.randomInt(processing.width);
	} // moves this food to a random position at the top of the screen

}
