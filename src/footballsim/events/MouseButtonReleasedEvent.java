package footballsim.events;

public class MouseButtonReleasedEvent extends MouseButtonEvent {

    public MouseButtonReleasedEvent(int button) {
        super(button);
    }

    @Override
    public EventType getEventType() {
        return EventType.MouseButtonReleased;
    }

    @Override
    public String getName() {
        return "MouseButtonReleasedEvent";
    }

    @Override
    public String toString() {
        return super.toString() + ": " + m_Button;
    }
    
}
