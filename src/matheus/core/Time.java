package matheus.core;

public class Time
{
	public static final double MILLIS = 1000.0; // milliseconds per second
	
	private static float delta = 0; // time since last frame
	
	/**
	 * Sets the Time class delta variable. Represents an amount of time in seconds.
	 * @param dt - A float value.
	 */
	public static void setDelta(float dt)
	{
		delta = dt;
	}
	
	/**
	 * Return the Time class delta variable. Represents an amount of time in seconds.
	 * @return A float value.
	 */
	public static float getDelta()
	{
		return delta;
	}
	
	/**
	 * Return the current time in milliseconds.
	 * @return A long value.
	 */
	public static long getTime()
	{
		return System.currentTimeMillis();
	}
}
