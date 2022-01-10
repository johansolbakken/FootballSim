package footballsim.events;

public class KeyPressedEvent extends KeyEvent {
    private int m_RepeatCount;

    public KeyPressedEvent(int keycode, int repeatCount) {
        super(keycode);
        m_RepeatCount = repeatCount;
    }

    public int getRepeatCount() {
        return m_RepeatCount;
    }

    @Override
    public EventType getEventType() {
        return EventType.KeyPressed;
    }

    @Override
    public String getName() {
        return "KeyPressedEvent";
    }

    @Override
    public String toString() {
        return super.toString() + ": " + m_KeyCode + " (" + m_RepeatCount + " repeats)";
    }
}
