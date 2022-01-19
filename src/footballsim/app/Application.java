package footballsim.app;

import footballsim.events.Event;
import footballsim.events.EventDispatcher;
import footballsim.events.EventType;
import footballsim.game.Game;
import footballsim.layers.Layer;
import footballsim.layers.LayerStack;
import footballsim.logging.Logger;
import footballsim.ui.window.Window;

public class Application {
    private static Application s_Instance;

    private boolean m_Running = false;
    private Window m_Window;
    private Game m_Game;
    private LayerStack m_LayerStack;

    public static void create(Application app) {
        if (s_Instance != null) {
            Logger.severe("Application is already running!");
            throw new IllegalStateException("App already running!");
        }

        s_Instance = app;
    }

    public static Application getInstance() {
        return s_Instance;
    }

    protected Application() {
        Logger.info("Application is created");

        m_Window = new Window("Football Simulator", 1080, 720);
        m_Window.setEventCallback(this::onEvent);

        m_Game = new Game();

        m_LayerStack = new LayerStack();
    }

    public void pushLayer(Layer layer) {
        m_LayerStack.pushLayer(layer);
    }

    public void pushOverlay(Layer overlay) {
        m_LayerStack.pushOverlay(overlay);
    }

    /*
        Responds to events
    */
    private boolean onEvent(Event event) {
        //Logger.info(event.toString());

        EventDispatcher dispatcher = new EventDispatcher(event);
        dispatcher.dispatch(EventType.WindowClose, this::event_window_close);

        for (int i = m_LayerStack.getFirst(); i <= m_LayerStack.getLast(); i++) {
            m_LayerStack.get(i).onEvent(event);
        }

        return false;
    }

    /*
        Main loop for application
    */
    public void run() {
        m_Running = true;

        while (m_Running) {
            // TODO: timestep

            for (int i = m_LayerStack.getLast(); i >= m_LayerStack.getFirst(); i--) {
                m_LayerStack.get(i).onUpdate();
            }

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
    private boolean event_window_close(Event e) {
        m_Running = true;
        return true;
    }
}
