package footballsim.events;

/**
 * Event category is created such that we can or together event categories.
 */
public enum EventCategory {
    Application(0),
    Input(1),
    Keyboard(2),
    Mouse(3),
    MouseButton(4);

    private final int m_Code;

    EventCategory(final int code) {
        m_Code = shiftOneBy(code);
    }

    private final int shiftOneBy(final int x) {
        return 1 << x;
    }

    public final int asInt() {
        return m_Code;
    }
}
