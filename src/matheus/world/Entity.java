package matheus.world;
import java.awt.Color;
import java.awt.Graphics;

import matheus.core.Time;
import matheus.math.Vector2;

public class Entity
{
	private Vector2 pos;
	private Vector2[] vertices;
	private int[] faces;
	
	public Entity(Vector2[] vertices, int[] faces, Vector2 world_pos)
	{
		this.vertices = vertices;
		this.faces = faces;
		pos = world_pos;
	}
	
	public Entity(String fileName)
	{
		// TODO: Create mesh from file
		// 		 Add transformations through matrices
	}
	
	float rot = 0.0f;
	public void update()
	{
		rot += Time.getDelta();
		float sinRot = (float)Math.sin(rot);
		rotate(20*sinRot);
//		move(new Vector2(2, 2));
	}
	
	public void render()
	{
		Vector2[] new_pos = vertices.clone();
		for (int i = 0; i < new_pos.length; i++)
			new_pos[i] = new_pos[i].add(pos);
		
		for (int i = 0; i < faces.length; i+=3)
		{
//			image.fillPolygon(
//					new int[]{(int)new_pos[faces[i]].getX(), (int)new_pos[faces[i+1]].getX(), (int)new_pos[faces[i+2]].getX()},
//					new int[]{(int)new_pos[faces[i]].getY(), (int)new_pos[faces[i+1]].getY(), (int)new_pos[faces[i+2]].getY()},
//					3
//			);
		}
	}
	
	public void rotate(float degrees)
	{		
		for (int i = 0; i < vertices.length; i++)
			vertices[i] = vertices[i].rotate(degrees);
	}
	
	public void move(Vector2 other)
	{
		pos = pos.add(other);
	}
}
