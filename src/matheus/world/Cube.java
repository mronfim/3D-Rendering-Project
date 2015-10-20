package matheus.world;

import java.awt.image.BufferedImage;

import matheus.core.Window;
import matheus.input.Keyboard;
import matheus.input.MeshLoader;
import matheus.math.Vector2;
import matheus.math.Vector3;

public class Cube
{
	private Vector3 world_pos;
	private Vector3[] obj_vertices;
	private Vector3[] world_vertices;
	private int[][] faces;
	private int[] color;
	private float[][] zbuffer;
	private float z_over_d;
	float rotate_y = 0;
	float rotate_x = 0;
	
	public Cube(Vector3 pos, String fileName)
	{
		world_pos = pos;
		obj_vertices = new Vector3[MeshLoader.numberOfVertices(fileName)];
		world_vertices = new Vector3[obj_vertices.length];
		faces = new int[MeshLoader.numberOfFaces(fileName)][];
		color = new int[faces.length];
		if (!MeshLoader.loadMesh(fileName, obj_vertices, faces))
		{
			throw new RuntimeException("ERROR: Could not load object");
		}
		for (int i = 0; i < obj_vertices.length; i++)
			world_vertices[i] =  obj_vertices[i].mult(100).add(world_pos);
		
		color[0] = 0xFF0000;
		color[1] = 0x00FF00;
		color[2] = 0x0000FF;
		color[3] = 0xFFFF00;
		color[4] = 0xFF00FF;
		color[5] = 0x00FFFF;
		
		color[6] = 0xFF0000;
		color[7] = 0x00FF00;
		color[8] = 0x0000FF;
		color[9] = 0xFFFF00;
		color[10] = 0xFF00FF;
		color[11] = 0x00FFFF;
	}
	
	public void update()
	{
		for (int i = 0; i < obj_vertices.length; i++)
		{
			z_over_d = world_pos.getZ() / 5.0f;
			world_vertices[i] = obj_vertices[i].mult(100);
			world_vertices[i] = world_vertices[i].rotateX(rotate_x).rotateY(rotate_y).div(z_over_d).add(world_pos);
		}
		
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
	
	public void render(BufferedImage image)
	{
		zbuffer = new float[Window.HEIGHT][Window.WIDTH];
		for (int f = 0; f < faces.length; f++)
		{
			// Find the maximum x,y and minimum x,y
			float x_min = Window.WIDTH, x_max = 0, y_min = Window.HEIGHT, y_max = 0;
			for (int i = 0; i < faces[f].length; i++)
			{
				float x = world_vertices[faces[f][i]].getX();
				float y = world_vertices[faces[f][i]].getY();
				if (x < x_min) {
					x_min = x <= 0 ? 0 : x; 
				}
				if (x > x_max) {
					x_max = x > Window.WIDTH ? Window.WIDTH : x;
				}
				if (y < y_min) {
					y_min = y <= 0 ? 0 : y;
				}
				if (y > y_max) {
					y_max = y > Window.HEIGHT ? Window.HEIGHT : y;
				}
			}
			
			// Area of face
			Vector2 v1 = new Vector2((int)world_vertices[faces[f][0]].getX(), (int)world_vertices[faces[f][0]].getY());
			Vector2 v2 = new Vector2((int)world_vertices[faces[f][1]].getX(), (int)world_vertices[faces[f][1]].getY());
			Vector2 v3 = new Vector2((int)world_vertices[faces[f][2]].getX(), (int)world_vertices[faces[f][2]].getY());
			
			float base = v1.sub(v2).length();
			float height = Math.abs(v1.sub(v2).rotate(90).normalize().dot(v1.sub(v3)));
			float face_area = 0.5f * base * height;
			
			for (int j = (int)y_min; j <= (int)y_max; j++)
			{
				for (int i = (int)x_min; i <= (int)x_max; i++)
				{
					Vector2 pixel = new Vector2(i, j);
					float base1 = v1.sub(v2).length();
					float height1 = Math.abs(v1.sub(v2).rotate(90).normalize().dot(v1.sub(pixel)));
					float area1 = 0.5f * base1 * height1;
					
					float base2 = v2.sub(v3).length();
					float height2 = Math.abs(v2.sub(v3).rotate(90).normalize().dot(v2.sub(pixel)));
					float area2 = 0.5f * base2 * height2;
					
					float base3 = v3.sub(v1).length();
					float height3 = Math.abs(v3.sub(v1).rotate(90).normalize().dot(v3.sub(pixel)));
					float area3 = 0.5f * base3 * height3;
					
					if ((int)(area1 + area2 + area3) == (int)face_area)
					{
						image.setRGB(i, j, color[f]);
					}
				}
			}
		}
	}
}
