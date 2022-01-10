package footballsim.events;

public class MouseScrolledEvent extends Event {
    private float m_XOffset, m_YOffset;

    public MouseScrolledEvent(int xOffset, int yOffset) {
        m_XOffset = xOffset;
        m_YOffset = yOffset;
    }

    public float getXOffset() {
        return m_XOffset;
    }

    public float getYOffset() {
        return m_YOffset;
    }

    @Override
    public EventType getEventType() {
        return EventType.MouseScrolled;
    }

    @Override
    public int getCategoryFlags() {
        return EventCategory.Mouse.asInt() | EventCategory.Input.asInt();
    }

    @Override
    public String getName() {
        return "MouseScrolledEvent";
    }

    @Override
    public String toString() {
        return super.toString() + ": " + m_XOffset + ", " + m_YOffset;
    }
    
}
