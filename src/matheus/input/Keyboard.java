package matheus.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener
{
	public static final int KEY_UP 		= 0x0;
	public static final int KEY_DOWN 	= 0x1;
	public static final int KEY_LEFT 	= 0x2;
	public static final int KEY_RIGHT	= 0x3;
	public static final int KEY_W		= 0x4;
	public static final int KEY_S		= 0x5;
	public static final int KEY_A		= 0x6;
	public static final int KEY_D		= 0x7;
	
	private static final int MAX_KEYS 			= 0x100;
	private static boolean[] keys_current 		= new boolean[MAX_KEYS];
	private static boolean[] keys		= new boolean[MAX_KEYS];
	
	private static final int MAX_MOUSE_BUTTONS 	= 0x5;
	private static boolean[] mouse_current		= new boolean[MAX_MOUSE_BUTTONS];
	private static boolean[] mouse_previous		= new boolean[MAX_MOUSE_BUTTONS];
	
	@Override
	public void keyPressed(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_UP:
			Keyboard.setKeyDown(Keyboard.KEY_UP);
			break;
		case KeyEvent.VK_DOWN:
			Keyboard.setKeyDown(Keyboard.KEY_DOWN);
			break;
		case KeyEvent.VK_LEFT:
			Keyboard.setKeyDown(Keyboard.KEY_LEFT);
			break;
		case KeyEvent.VK_RIGHT:
			Keyboard.setKeyDown(Keyboard.KEY_RIGHT);
			break;
		case KeyEvent.VK_W:
			Keyboard.setKeyDown(Keyboard.KEY_W);
			break;
		case KeyEvent.VK_S:
			Keyboard.setKeyDown(Keyboard.KEY_S);
			break;
		case KeyEvent.VK_A:
			Keyboard.setKeyDown(Keyboard.KEY_A);
			break;
		case KeyEvent.VK_D:
			Keyboard.setKeyDown(Keyboard.KEY_D);
			break;
		default:
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_UP:
			Keyboard.setKeyUp(Keyboard.KEY_UP);
			break;
		case KeyEvent.VK_DOWN:
			Keyboard.setKeyUp(Keyboard.KEY_DOWN);
			break;
		case KeyEvent.VK_LEFT:
			Keyboard.setKeyUp(Keyboard.KEY_LEFT);
			break;
		case KeyEvent.VK_RIGHT:
			Keyboard.setKeyUp(Keyboard.KEY_RIGHT);
			break;
		case KeyEvent.VK_W:
			Keyboard.setKeyUp(Keyboard.KEY_W);
			break;
		case KeyEvent.VK_S:
			Keyboard.setKeyUp(Keyboard.KEY_S);
			break;
		case KeyEvent.VK_A:
			Keyboard.setKeyUp(Keyboard.KEY_A);
			break;
		case KeyEvent.VK_D:
			Keyboard.setKeyUp(Keyboard.KEY_D);
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {}
	
	public static void update()
	{
		for (int i = 0; i < MAX_KEYS; i++)
			keys[i] = keys_current[i];
		for (int i = 0; i < MAX_MOUSE_BUTTONS; i++)
			mouse_previous[i] = mouse_current[i];
	}
	
	public static void setKeyDown(int keyCode)
	{
		if (keyCode > -1 && keyCode < MAX_KEYS)
			keys_current[keyCode] = true;
	}
	
	public static void setKeyUp(int keyCode)
	{
		if (keyCode > -1 && keyCode < MAX_KEYS)
			keys_current[keyCode] = false;
	}
	
	public static boolean isKeyDown(int keyCode)
	{
		return keys_current[keyCode];
	}
	
	public static boolean isKeyUp(int keyCode)
	{
		return !keys_current[keyCode];
	}
	
	public static boolean isKeyPressed(int keyCode)
	{
		return !keys[keyCode] && keys_current[keyCode];
	}
}
