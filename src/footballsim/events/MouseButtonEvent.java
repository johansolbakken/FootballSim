package footballsim.events;

public abstract class MouseButtonEvent extends Event {

    protected int m_Button;

    protected MouseButtonEvent(int button) {
        m_Button = button;
    }

    public int getButton() {
        return m_Button;
    }

    @Override
    public int getCategoryFlags() {
        return EventCategory.Mouse.asInt() | EventCategory.Input.asInt();
    }
    
}
