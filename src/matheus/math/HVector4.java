package matheus.math;

public class HVector4
{
	private float x;
	private float y;
	private float z;
	private float w;
	
	public HVector4(float x, float y, float z, float w)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	
	public HVector4(Vector3 vec, float w)
	{
		this(vec.getX(), vec.getY(), vec.getZ(), w);
	}
}
