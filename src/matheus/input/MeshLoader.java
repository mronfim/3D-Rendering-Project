package matheus.input;

import java.io.File;
import java.util.Scanner;

import matheus.math.Vector3;

public class MeshLoader
{
	public static boolean loadMesh(String fileName, Vector3[] vertices, int[][] faces)
	{
		boolean loaded = false;
		File file = new File("res/" + fileName);
		Scanner scan;
		int i = 0, j = 0;
		
		try {
			scan = new Scanner(file);
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				if (line.startsWith("v")) {
					String[] tokens = line.split(" ");
					vertices[i++] = new Vector3(Float.parseFloat(tokens[1]), Float.parseFloat(tokens[2]), Float.parseFloat(tokens[3]));
				}
				else if (line.startsWith("f")) {
					String[] tokens = line.split(" ");
					faces[j++] = new int[]{Integer.parseInt(tokens[1])-1, Integer.parseInt(tokens[2])-1, Integer.parseInt(tokens[3])-1};
				}
			}
			loaded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return loaded;
	}
	
	public static int numberOfVertices(String fileName)
	{
		int vertices = 0;
		File file = new File("res/" + fileName);
		Scanner scan;
		
		try {
			scan = new Scanner(file);
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				if (line.startsWith("v"))
					vertices++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vertices;
	}
	
	public static int numberOfFaces(String fileName)
	{
		int faces = 0;
		File file = new File("res/" + fileName);
		Scanner scan;
		
		try {
			scan = new Scanner(file);
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				if (line.startsWith("f"))
					faces++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return faces;
	}
}
