package matheus.core;

import matheus.core.*;

public class Looper implements Runnable
{
	public static final double UPS = 60.0; // updates per second
	public static final double MS_PER_UPDATE = Time.MILLIS / UPS; // milliseconds per update
	
	private Window window;
	private Thread thread;
	private boolean running;
	
	/**
	 * Creates a new Looper which loops its run() method over and over.
	 * Used for updating and rendering. Updates are done 60 times a second.
	 * @param w - Window in which to update and render.
	 */
	public Looper(Window w)
	{
		window = w;
		running = false;
	}
	
	/**
	 * Starts the Looper's thread.
	 */
	public void start()
	{
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	/**
	 * Stops the Looper's thread.
	 */
	public void stop()
	{
		if (!running)
			return;
		running = false;
		try {
			thread.join(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * The method that contains the loop.
	 */
	public void run()
	{
		double previous = Time.getTime();
		double lag = 0.0;
		double counter = 0.0;
		int fps = 0, ups = 0;
		while (running)
		{
			double current = Time.getTime();
			double elapsed = current - previous;
			previous = current;
			lag += elapsed;
			counter += elapsed;
			
			while (lag >= MS_PER_UPDATE)
			{
				window.update();
				ups++;
				lag -= MS_PER_UPDATE;
			}
			
			Time.setDelta((float)(lag/MS_PER_UPDATE));
			
			window.render(lag / MS_PER_UPDATE);
			fps++;
			
			if (counter >= 1000)
			{
				System.out.println("FPS: " + fps + ", UPS: " + ups);
				counter = fps = ups = 0;
			}
		}
	}
}
