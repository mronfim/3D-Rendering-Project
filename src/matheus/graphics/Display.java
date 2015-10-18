package matheus.graphics;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Display extends Canvas
{
	private int width;
	private int height;
	
	public Display(int w, int h, BufferedImage img)
	{
		width = w;
		height = h;
		
		Dimension size = new Dimension(width, height);
		setPreferredSize(size);
		setMaximumSize(size);
		setMinimumSize(size);
		setBackground(Color.BLACK);
		setVisible(true);
	}
	
	public void draw(BufferedImage image)
	{
		BufferStrategy bs = getBufferStrategy();
		if (bs == null)
		{
			createBufferStrategy(2);
			return ;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		
		g.drawImage(image, 0, 0, this);
		
		g.dispose();
		bs.show();
	}
}
