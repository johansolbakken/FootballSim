package footballsim;

import footballsim.events.Event;
import footballsim.events.EventDispatcher;
import footballsim.events.EventType;
import footballsim.game.Game;
import footballsim.logging.Logger;
import footballsim.ui.window.Window;

public class Application {
    private boolean m_Running = false;
    private Window m_Window;
    private Game m_Game;

    public Application() {
        Logger.info("Application is created");

        m_Window = new Window("Football Simulator", 1080, 720);
        m_Window.setEventCallback(this::onEvent);

        m_Game = new Game();
    }

    /*
        Updates all components
    */
    private void onUpdate() {

    }

    /*
        Responds to events
    */
    private boolean onEvent(Event event) {
        EventDispatcher dispatcher = new EventDispatcher(event);
        dispatcher.dispatch(EventType.WindowClose, (e) -> { m_Running = false;
            System.out.println("Exiting");
            return true; });
        Logger.info(event.toString());
        return false;
    }

    /*
        Main loop for application
    */
    public void run() {
        m_Running = true;

        while (m_Running) {
            onUpdate();

            m_Window.onUpdate();
        }

        destroy();
    }

    /*
        Destroys resources
    */
    public void destroy() {
        m_Window.close();
    }

    // Events

}
