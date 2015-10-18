package matheus.world;

import java.awt.Graphics;

import matheus.core.Window;
import matheus.math.Vector3;

public class World
{
	private Triangle tri;
	
	public World()
	{
		tri = new Triangle(new Vector3((float)(Window.WIDTH / 2.0), (float) (Window.HEIGHT / 2.0), 15.0f));
	}
	
	public void update()
	{
		tri.update();
	}
	
	public void render(Graphics g)
	{
		tri.render(g);
	}
}
