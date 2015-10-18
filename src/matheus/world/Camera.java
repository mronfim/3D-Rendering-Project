package matheus.world;

import java.awt.Graphics;

import matheus.math.Vector3;

public class Camera
{
	private Vector3 pos;
	private Vector3 direction;
	private Vector3 absolute_up = new Vector3(0, 1, 0);
	
	/**
	 * Creates a new Camera object at position p facing direction d.
	 * @param p - A Vector3 object for the position of the camera in the world.
	 * @param direction - A Vector3 object for the direction the camera is facing.
	 */
	public Camera(Vector3 p, Vector3 d){
		pos = p;
		direction = d;
	}
	
	public void update()
	{
		
	}
	
	public void render(Graphics g)
	{
		
	}
}
