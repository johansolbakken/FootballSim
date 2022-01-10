package footballsim;

import footballsim.game.Game;
import footballsim.ui.Window;

public class Application {
    /*
        Implementing singleton pattern
    */
    private static Application instance = new Application();

    public static Application getInstance() {
        return instance;
    }

    private Application() {}

    /*
        Application
    */

    private boolean running = false;
    private Window window = new Window("Football Simulator", 1080, 720);
    private Game game = new Game();

    /*
        Updates all components
    */
    private void onUpdate() {

    }

    /*
        Responds to events
    */
    private void onEvent() {

    }

    /*
        Main loop for application
    */
    public void run() {
        running = true;

        while (running) {
            onEvent();
            onUpdate();
        }
    }
    
}
