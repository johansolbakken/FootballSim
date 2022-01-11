package footballsim.ui.window;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

import footballsim.events.Event;
import footballsim.events.EventFunction;
import footballsim.logging.Logger;

/**
 * Custom window class
 */

class WindowProperties {
    public String Title;
    public int Width, Height;
    public boolean IsVSync = false;

    public WindowInput InputHandler;
}

class Frame extends JFrame {
    public Frame(String title) {
        super(title);
    }

    protected void paintComponent(Graphics g)
    {
        BufferedImage bufferedImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bufferedImage.createGraphics();

        // Renderer

        Graphics2D g2dComponent = (Graphics2D) g;
        g2dComponent.drawImage(bufferedImage, null, 0, 0);
    }
}

public class Window {
    private Frame m_Frame;

    private WindowProperties m_Properties;
    private boolean m_ShouldClose = false;

    public Window(String title, int width, int height) {
        init(title, width, height);
    }

    private void init(String title, int width, int height) {
        Logger.info("Created new window called '" + title + "', width: " + width + ", height: " + height);

        m_Properties = new WindowProperties();
        m_Properties.Title = title;
        m_Properties.Width = width;
        m_Properties.Height = height;
        m_Properties.InputHandler = new WindowInput();

        m_Frame = new Frame(m_Properties.Title);
        m_Frame.setSize(m_Properties.Width, m_Properties.Height);
        m_Frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        m_Frame.setLocationRelativeTo(null);
        m_Frame.setVisible(true);

        m_Properties.InputHandler = new WindowInput();
        m_Frame.addKeyListener(m_Properties.InputHandler);
        m_Frame.addMouseListener(m_Properties.InputHandler);
        m_Frame.addMouseMotionListener(m_Properties.InputHandler);
        m_Frame.addMouseWheelListener(m_Properties.InputHandler);
        m_Frame.addWindowListener(m_Properties.InputHandler);
    }

    public void onUpdate() {
        m_Frame.repaint();
    }

    public void setEventCallback(EventFunction<Event> fn) {
        m_Properties.InputHandler.setEventCallback(fn);
    }

    public int getWidth() {
        return m_Properties.Width;
    }

    public int getHeight() {
        return m_Properties.Height;
    }

    public void setVSync(boolean enabled) {
        // set enabled
        m_Properties.IsVSync = enabled;
    }

    public boolean isVSync() {
        return m_Properties.IsVSync;
    }

    public final boolean shouldWindowClose() {
        return m_ShouldClose;
    }

    public void close() {
        m_ShouldClose = true;
        m_Frame.dispose();
    }
}
