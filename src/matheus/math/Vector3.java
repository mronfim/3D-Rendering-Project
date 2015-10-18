package matheus.math;

public class Vector3
{
	public static final int SIZE = 3;
	private float x;
	private float y;
	private float z;
	
	/**
	 * Creates a new Vector3 object with x and y and z as its displacements in the respective axes.
	 * @param x - A float value. The displacement on the x-axis.
	 * @param y - A float value. The displacement on the y-axis.
	 * @param z - A float value. The displacement on the z-axis.
	 */
	public Vector3(float x, float y, float z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/**
	 * Calculates the length (magnitude) of the vector. Does not modify the current object.
	 * @return A float value.
	 */
	public float length()
	{
		return (float)Math.sqrt(x*x + y*y + z*z);
	}	
	
	/**
	 * Returns the normalized vector. Does not modify the current object.
	 * @return - A vector3 object.
	 */
	public Vector3 normalize()
	{
		float length = length();
		float x2 = x / length;
		float y2 = y / length;
		float z2 = z / length;
		return new Vector3(x2, y2, z2);
	}
	
	/**
	 * Takes the dot product of the vector and the vector other. Does not modify the current object.
	 * @param other - A Vector3 object
	 * @return A float value.
	 */
	public float dot(Vector3 other)
	{
		float x2 = x * other.getX();
		float y2 = y * other.getY();
		float z2 = z * other.getZ();
		return x2 + y2 + z2;
	}
	
	/**
	 * Takes the cross product of the vector and the vector other. Does not modify the current object.
	 * @param other - A Vector3 object
	 * @return A Vector3 object
	 */
	public Vector3 cross(Vector3 other)
	{
		float x2 = y * other.getZ() - z * other.getY();
		float y2 = z * other.getX() - x * other.getZ();
		float z2 = x * other.getY() - y * other.getX();
		return new Vector3(x2, y2, z2);
	}
	
	/**	
	 * Add two vectors. Does not modify the current object.
	 * @param other - A Vector3 object.
	 * @return	A new Vector3 object
	 */
	public Vector3 add(Vector3 other)
	{
		float x2 = x + other.getX();
		float y2 = y + other.getY();
		float z2 = z + other.getZ();
		return new Vector3(x2, y2, z2);
	}
	
	/**
	 * Subtract two vectors. Does not modify the current object.
	 * @param other - A vector3 object.
	 * @return A new Vector3 object
	 */
	public Vector3 sub(Vector3 other)
	{
		float x2 = x - other.getX();
		float y2 = y - other.getY();
		float z2 = z - other.getZ();
		return new Vector3(x2, y2, z2);
	}
	
	/**
	 * Multiplies the vector by a scalar value. Does not modify the current object.
	 * @param c - A float scalar value.
	 * @return A new Vector3 object.
	 */
	public Vector3 mult(float c)
	{
		return new Vector3(x*c, y*c, z*c);
	}
	
	/**
	 * Divides the vector by a scalar value. Does not modify the current object.
	 * @param c - A float scalar value.
	 * @return A new Vector3 object
	 */
	public Vector3 div(float c)
	{
		float rep_c = 1.0f / c;
		return new Vector3(x*rep_c, y*rep_c, z*rep_c);
	}
	
	/**
	 * Returns the X displacement of the vector. Does not modify the current object.
	 * @return A float value.
	 */
	public float getX() { return x; }
	
	/**
	 * Returns the Y displacement of the vector. Does not modify the current object.
	 * @return A float value.
	 */
	public float getY() { return y; }
	
	/**
	 * Returns the Z displacement of the vector. Does not modify the current object.
	 * @return A float value.
	 */
	public float getZ() { return z; }
	
	/**
	 * Sets the X displacement of the current vector object to the argument x.
	 * @param x - A float value.
	 */
	public void setX(float x) { this.x = x; }
	
	/**
	 * Sets the Y displacement of the current vector object to the argument y.
	 * @param y - A float value.
	 */
	public void setY(float y) { this.y = y; }
	
	/**
	 * Sets the Z displacement of the current vector object to the argument z.
	 * @param y - A float value.
	 */
	public void setZ(float z) { this.z = z; }
}
