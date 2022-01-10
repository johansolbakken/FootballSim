package footballsim.ui;

import footballsim.logging.Logger;

/**
 * Custom window class
 */
public class Window {
    
    private boolean m_ShouldClose = false;

    private int m_Width, m_Height;

    public Window(String title, int width, int height) {
        Logger.info("Created new window called '" + title + "', width: " + width + ", height: " + height);
    }

    public final boolean shouldWindowClose() {
        return m_ShouldClose;
    }
}
