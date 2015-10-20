package matheus.world;

import java.awt.image.BufferedImage;

import matheus.core.Window;
import matheus.math.Vector3;

public class World
{
	private Triangle tri;
	private Cube cube;
	
	public World()
	{
		tri = new Triangle(new Vector3((float)(Window.WIDTH / 2.0), (float) (Window.HEIGHT / 2.0), 15.0f));
		cube = new Cube(new Vector3((float)(Window.WIDTH / 2.0), (float) (Window.HEIGHT / 2.0), 15.0f), "cube.obj");
	}
	
	public void update()
	{
//		tri.update();
		cube.update();
	}
	
	public void render(BufferedImage image)
	{
//		tri.render(image.getGraphics());
		cube.render(image);
	}
}
