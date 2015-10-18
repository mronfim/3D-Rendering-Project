package matheus.world;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Arrays;

import matheus.input.Keyboard;
import matheus.math.Vector3;

public class Triangle
{
	private Vector3 world_pos;
	private Vector3[] vertices = {
		new Vector3( 0,-1, 0), 
		new Vector3( 1, 1,-1),
		new Vector3(-1, 1,-1),
		new Vector3( 0, 1, 1)};
	private int[][] faces = {
			{0, 1, 2},
			{0, 3, 1},
			{0, 3, 2},
			{1, 2, 3}};
	private Vector3[] final_vert;
	private Color[] colors = {
			new Color(1.0f, 0.0f, 0.0f, 1.0f),
			new Color(0.0f, 1.0f, 0.0f, 1.0f),
			new Color(0.0f, 0.0f, 1.0f, 1.0f),
			new Color(0.0f, 1.0f, 1.0f, 1.0f)
	};
	
	private Vector3 towardCamera;	
	private Vector3 velocity;
	private float z_over_d;
	float rotate_y = 0;
	float rotate_x = 0;
	
	public Triangle(Vector3 pos)
	{
		world_pos = pos;
		velocity = new Vector3(1.0f, 0.0f, 0.0f);
		towardCamera = new Vector3(0, 0, -1);
		final_vert = new Vector3[vertices.length];
		
		for (int i = 0; i < vertices.length; i++)
		{
			final_vert[i] = vertices[i].mult(200).add(world_pos);
		}
	}
	
	public void update()
	{
		orderFaces();
		for (int i = 0; i < vertices.length; i++)
		{
			z_over_d = world_pos.getZ() / 5.0f;
			final_vert[i] = vertices[i].mult(200);
			final_vert[i] = final_vert[i].rotateX(rotate_x).rotateY(rotate_y).div(z_over_d).add(world_pos);
			
		}
		
		if (Keyboard.isKeyDown(Keyboard.KEY_D))
			world_pos = world_pos.sub(velocity.mult(5));
		if (Keyboard.isKeyDown(Keyboard.KEY_A))
			world_pos = world_pos.add(velocity.mult(5));
		if (Keyboard.isKeyDown(Keyboard.KEY_W))
			world_pos = world_pos.add(velocity.cross(new Vector3(0, 1, 0)).mult(-0.25f));
		if (Keyboard.isKeyDown(Keyboard.KEY_S))
			world_pos = world_pos.add(velocity.cross(new Vector3(0, 1, 0)).mult(0.25f));
		
		if (Keyboard.isKeyDown(Keyboard.KEY_UP))
		{
			rotate_x += 2;
			if (rotate_x >= 360)
				rotate_x -= 360;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_DOWN))
		{
			rotate_x -= 2;
			if (rotate_x <= -360)
				rotate_x += 360;
		}
		
		if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT))
		{
			rotate_y += 2;
			if (rotate_y >= 360)
				rotate_y -= 360;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_LEFT))
		{
			rotate_y -= 2;
			if (rotate_y <= -360)
				rotate_y += 360;
		}
	}
	
	public void render(Graphics g)
	{
		int[] x;
		int[] y;
		
		for (int i = 0; i < final_vert.length; i++)
		{
			x = new int[]{(int)final_vert[faces[i][0]].getX(), (int)final_vert[faces[i][1]].getX(), (int)final_vert[faces[i][2]].getX()};
			y = new int[]{(int)final_vert[faces[i][0]].getY(), (int)final_vert[faces[i][1]].getY(), (int)final_vert[faces[i][2]].getY()};
			
//			g.setColor(colors[i]);
			g.drawPolygon(x, y, x.length);
		}
	}
	
	private void orderFaces()
	{
		Vector3[] norms = calculateSurfaceNorms();
		float[] dot_prod = new float[norms.length];
		
		for (int i = 0; i < norms.length; i++)
		{
			float dot = norms[i].dot(towardCamera);
			dot_prod[i] = dot;
		}
		
		for (int i = (dot_prod.length - 1); i >= 0; i--)
		{
			for (int j = 1; j <= i; j++)
			{
				if (dot_prod[j-1] > dot_prod[j])
				{
					Vector3 temp = final_vert[j-1];
					final_vert[j-1] = final_vert[i];
					final_vert[i] = temp;
					
					Color color = colors[j-1];
					colors[j-1] = colors[i];
					colors[i] = color;
				}
			}
		}	
	}
	
	private Vector3[] calculateSurfaceNorms()
	{
		Vector3[] norms = new Vector3[faces.length];
		Vector3 u;
		Vector3 v;
		
		for (int i = 0; i < faces.length; i++)
		{
				u = final_vert[faces[i][1]].sub(final_vert[faces[i][2]]).normalize();
				v = final_vert[faces[i][1]].sub(final_vert[faces[i][0]]).normalize();
				norms[i] = v.cross(u).normalize();
		}
		
		return norms;
	}
}