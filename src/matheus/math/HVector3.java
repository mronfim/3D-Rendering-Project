package matheus.math;

public class HVector3
{
	private float x;
	private float y;
	private float w;
	
	public HVector3(float x, float y, float w)
	{
		this.x = x;
		this.y = y;
		this.w = w;
	}
	
	public HVector3(Vector2 vec, float w)
	{
		this(vec.getX(), vec.getY(), w);
	}
}
