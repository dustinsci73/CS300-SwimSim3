/**
 * Creates a hook object to be placed in the tank
 * @author Dustin
 *
 */
public class Hook 
{
	private PApplet processing;
	private PImage hookImage;
	private int xPos;
	private int yPos;

	public Hook (PApplet process) 
	{
		this.processing = process;
		this.hookImage = processing.loadImage("images" + java.io.File.separator + "HOOK.png");
		this.xPos = Utility.randomInt(processing.width);
		this.yPos = Utility.randomInt(processing.height);
	}
	public void update() 
	{
		processing.image(hookImage, xPos, yPos);
		processing.line(xPos + 5, yPos, xPos + 5, 0);
		if (yPos - 1 < 0) 
		{
			yPos = processing.height;
		}
		else 
		{
			yPos += -(processing.height + 50 - yPos)/50;
		}
	}
	public void handleClick(int mouseX, int mouseY) 
	{
		xPos = mouseX;
		yPos = processing.height;
	}
	public void tryToCatch(Fish fish) 
	{
		if (fish.distanceTo(xPos, yPos) <= 40) 
		{
			fish.getCaught();
		}
	}

}


