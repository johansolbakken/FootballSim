package footballsim.events;

public class KeyTypedEvent extends KeyEvent {

    public KeyTypedEvent(int keycode) {
        super(keycode);
    }

    @Override
    public EventType getEventType() {
        return EventType.KeyTyped;
    }

    @Override
    public String getName() {
        return "KeyTypedEvent";
    }

    @Override
    public String toString() {
        return super.toString() + ": " + m_KeyCode;
    }
    
}
