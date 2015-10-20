package matheus.math;

public class Vector2
{
	public static final int SIZE = 2;
	private float x;
	private float y;
	
	/**
	 * Creates a new Vector2 object with x and y as its displacements in the respective axes.
	 * @param x - A float value. The displacement on the x-axis.
	 * @param y - A float value. The displacement on the y-axis.
	 */
	public Vector2(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	public Vector2(Vector3 other)
	{
		this.x = other.getX();
		this.y = other.getY();
	}
	
	/**
	 * Calculates the length (magnitude) of the vector. Does not modify the current object.
	 * @return A float value.
	 */
	public float length()
	{
		return (float)Math.sqrt(x*x + y*y);
	}	
	
	/**
	 * Returns the normalized vector. Does not modify the current object.
	 * @return - A vector2 object.
	 */
	public Vector2 normalize()
	{
		float length = length();
		float x2 = x / length;
		float y2 = y / length;
		return new Vector2(x2, y2);
	}
	
	/**
	 * Takes the dot product of the vector and the vector other. Does not modify the current object.
	 * @param other - A Vector2 object
	 * @return A float value.
	 */
	public float dot(Vector2 other)
	{
		float x2 = x * other.getX();
		float y2 = y * other.getY();
		return x2 + y2;
	}
	
	/**
	 * Rotates the vector by the specified degree about its object space origin. Does not modify the current object.
	 * @param degrees - The amount to rotate by, in degrees.
	 * @return A new Vector2 object.
	 */
	public Vector2 rotate(float degrees)
	{
		float angle = (float) Math.toRadians(degrees);
		float x2 = (float) (x * Math.cos(angle) - y * Math.sin(angle));
		float y2 = (float) (x * Math.sin(angle) + y * Math.cos(angle));
		return new Vector2(x2, y2);
	}
	
	/**	
	 * Add two vectors. Does not modify the current object.
	 * @param other - A Vector2 object.
	 * @return	A new Vector2 object
	 */
	public Vector2 add(Vector2 other)
	{
		float x2 = x + other.getX();
		float y2 = y + other.getY();
		return new Vector2(x2, y2);
	}
	
	/**
	 * Subtract two vectors. Does not modify the current object.
	 * @param other - A vector2 object.
	 * @return A new Vector2 object
	 */
	public Vector2 sub(Vector2 other)
	{
		float x2 = x - other.getX();
		float y2 = y - other.getY();
		return new Vector2(x2, y2);
	}
	
	/**
	 * Multiplies the vector by a scalar value. Does not modify the current object.
	 * @param c - A float scalar value.
	 * @return A new Vector2 object.
	 */
	public Vector2 mult(float c)
	{
		return new Vector2(x*c, y*c);
	}
	
	/**
	 * Divides the vector by a scalar value. Does not modify the current object.
	 * @param c - A float scalar value.
	 * @return A new Vector2 object
	 */
	public Vector2 div(float c)
	{
		float rep_c = 1.0f / c;
		return new Vector2(x*rep_c, y*rep_c);
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
	 * Sets the X displacement of the current vector object to the argument x.
	 * @param x - A float value.
	 */
	public void setX(float x) { this.x = x; }
	
	/**
	 * Sets the Y displacement of the current vector object to the argument y.
	 * @param y - A float value.
	 */
	public void setY(float y) { this.y = y; }
}
