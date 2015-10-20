package matheus.math;

public class Matrix3
{
	private float matrix[][] = {{1, 0, 0},
								{0, 1, 0},
								{0, 1, 0}};
	public Matrix3(){}
	
	public Matrix3(float[][] m)
	{
		matrix = m;
	}
	
	public Vector3 transform(Vector3 other)
	{
		float x = matrix[0][0]*other.getX() + matrix[0][1]*other.getY() + matrix[0][2]*other.getZ();
		float y = matrix[1][0]*other.getX() + matrix[1][1]*other.getY() + matrix[1][2]*other.getZ();
		float z = matrix[2][0]*other.getX() + matrix[2][1]*other.getY() + matrix[2][2]*other.getZ();
		return new Vector3(x, y, x);
	}
}
