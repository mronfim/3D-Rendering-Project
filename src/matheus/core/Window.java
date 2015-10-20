package matheus.core;

import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import matheus.graphics.Display;
import matheus.input.Keyboard;
import matheus.world.World;

public class Window extends JFrame
{
	public static final String TITLE = "3D to 2D Mapping";
	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;
	
	private Display display;
	private Looper loop;
	private World world;
	private Keyboard keyboard;
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	
	public Window()
	{
		super(TITLE);
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);		
		setVisible(true);
		
		display = new Display(WIDTH, HEIGHT, image);
		add(display);
		
		keyboard = new Keyboard();
		display.addKeyListener(keyboard);
		
		world = new World();
		
		loop = new Looper(this);
		loop.start();
	}
	
	public void update()
	{
		world.update();
		Keyboard.update();
	}
	
	public void render(double delta)
	{
		image.getGraphics().clearRect(0, 0, WIDTH, HEIGHT);
		world.render(image);
		display.draw(image);
	}
}
