package footballsim.ui;

/**
 * Custom window class
 */
public class Window {
    
    private boolean n_WindowShouldClose = false;

    private int width, height;

    public Window(String title, int width, int height) {
        
    }

    public boolean shouldWindowClose() {
        return n_WindowShouldClose;
    }

}
