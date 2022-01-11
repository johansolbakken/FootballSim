package footballsim.ui.window;

import footballsim.events.KeyPressedEvent;
import footballsim.events.KeyReleasedEvent;
import footballsim.events.KeyTypedEvent;
import footballsim.events.MouseScrolledEvent;
import footballsim.events.WindowCloseEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import footballsim.events.Event;
import footballsim.events.EventFunction;
import footballsim.events.MouseButtonPressedEvent;
import footballsim.events.MouseButtonReleasedEvent;
import footballsim.events.MouseMovedEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowInput implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener, WindowListener {

	private EventFunction<Event> m_EventCallback = (event) -> {return false;};

	public void setEventCallback(EventFunction<Event> fn) {
        m_EventCallback = fn;
    }

	public EventFunction<Event> getEventCallback() {
		return m_EventCallback;
	}

	// Skipepd
	@Override
	public void mouseDragged(MouseEvent e) {}

	@Override
	public void mouseMoved(MouseEvent e) {
		Event event = new MouseMovedEvent(e.getX(), e.getY());
		m_EventCallback.callback(event);
	}

	// Skipped
	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		Event event = new MouseButtonPressedEvent(e.getButton());
		m_EventCallback.callback(event);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Event event = new MouseButtonReleasedEvent(e.getButton());
		m_EventCallback.callback(event);
	}

	// Skipped
	@Override
	public void mouseEntered(MouseEvent e) {}

	// Skipped
	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {
		Event event = new KeyTypedEvent(e.getKeyCode());
		m_EventCallback.callback(event);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		Event event = new KeyPressedEvent(e.getKeyCode(), 1);
		m_EventCallback.callback(event);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		Event event = new KeyReleasedEvent(e.getKeyCode());
		m_EventCallback.callback(event);
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		Event event = new MouseScrolledEvent(e.getX(), e.getY());
		m_EventCallback.callback(event);
	}

	@Override
	public void windowClosing(WindowEvent e) {
		Event event = new WindowCloseEvent();
		m_EventCallback.callback(event);
	}

	// Skipped
	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}
}
