package footballsim.events;

public abstract class KeyEvent extends Event {
    protected int m_KeyCode;

    public int getKeyCode() {
        return m_KeyCode;
    }

    protected KeyEvent(int keycode) {
        m_KeyCode = keycode;
    }

    @Override
    public int getCategoryFlags() {
        return EventCategory.Keyboard.asInt() | EventCategory.Input.asInt();
    }    
}
