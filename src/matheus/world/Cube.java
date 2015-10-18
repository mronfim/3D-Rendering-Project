package matheus.world;

import matheus.math.*;

public class Cube
{
	private Vector3 world_pos;
	private Vector3[] vertices = {
		new Vector3(-1, 1,-1), 
		new Vector3( 1, 1,-1),
		new Vector3( 1,-1,-1),
		new Vector3(-1,-1,-1),
		new Vector3(-1, 1, 1), 
		new Vector3( 1, 1, 1),
		new Vector3( 1,-1, 1),
		new Vector3(-1,-1, 1),
	};
	private int[] faces = {
		0, 1, 2, 3,
		
	};
	
	public Cube(Vector3 pos)
	{
		world_pos = pos;
	}
}
