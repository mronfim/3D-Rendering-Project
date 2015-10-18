package matheus.world;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import matheus.input.Keyboard;
import matheus.math.Vector3;

public class Triangle
{
	private Color color = new Color(0.6f, 0.6f, 0.8f, 1.0f);
	private Vector3 world_pos;
	private Vector3[] vertices = {
		new Vector3( 0, -100, 0), 
		new Vector3( 100,100, 0),
		new Vector3(-100,100, 0)};
	private int[] faces = { 0, 1, 2 };
	
	private Vector3 velocity;
	private float z_over_d;
	int nPoints = faces.length;
	int[] xPoints = new int[nPoints];
	int[] yPoints = new int[nPoints];
	int[] zPoints = new int[nPoints];
	
	public Triangle(Vector3 pos)
	{
		world_pos = pos;
		velocity = new Vector3(1.0f, 0.0f, 0.0f);
		
		for (int i = 0; i < nPoints; i++)
		{
			xPoints[i] = (int)(vertices[faces[i]].add(world_pos)).getX();
			yPoints[i] = (int)(vertices[faces[i]].add(world_pos)).getY();
			zPoints[i] = (int)(vertices[faces[i]].add(world_pos)).getZ();
		}
	}
	
	public void update()
	{
		for (int i = 0; i < vertices.length; i++)
		{
			Vector3 temp = vertices[i];
			z_over_d = world_pos.getZ() / 5.0f;
			temp = temp.div(z_over_d).add(world_pos);
			xPoints[i] = (int)temp.getX();
			yPoints[i] = (int)temp.getY();
			zPoints[i] = (int)temp.getZ();
		}
		
		if (Keyboard.isKeyDown(Keyboard.KEY_D))
			world_pos = world_pos.sub(velocity.mult(5));
		if (Keyboard.isKeyDown(Keyboard.KEY_A))
			world_pos = world_pos.add(velocity.mult(5));
		if (Keyboard.isKeyDown(Keyboard.KEY_W))
			world_pos = world_pos.add(velocity.cross(new Vector3(0, 1, 0)).mult(-0.25f));
		if (Keyboard.isKeyDown(Keyboard.KEY_S))
			world_pos = world_pos.add(velocity.cross(new Vector3(0, 1, 0)).mult(0.25f));
	}
	
	public void render(Graphics g)
	{
		g.setColor(color);
		if (!behind())
			g.fillPolygon(xPoints, yPoints, nPoints);
	}
	
	private boolean behind()
	{
		boolean behind = false;
		
		for (int i = 0; i < nPoints; i++)
			if (zPoints[i] <= 0)
				behind = true;
		
		return behind;
	}
}
