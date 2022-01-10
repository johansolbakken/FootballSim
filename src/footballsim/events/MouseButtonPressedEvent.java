package footballsim.events;

public class MouseButtonPressedEvent extends MouseButtonEvent {

    public MouseButtonPressedEvent(int button) {
        super(button);
    }

    @Override
    public EventType getEventType() {
        return EventType.MouseButtonPressed;
    }

    @Override
    public String getName() {
        return "MouseButtonPressedEvent";
    }

    @Override
    public String toString() {
        return super.toString() + ": " + m_Button;
    }
    
}
