package footballsim.events;

public class KeyReleasedEvent extends KeyEvent {

    public KeyReleasedEvent(int keycode) {
        super(keycode);
    }

    @Override
    public EventType getEventType() {
        return EventType.KeyReleased;
    }

    @Override
    public String getName() {
        return "KeyReleasedEvent";
    }

    @Override
    public String toString() {
        return super.toString() + ": " + m_KeyCode;
    }
    
}
