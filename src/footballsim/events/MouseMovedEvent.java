package footballsim.events;

public class MouseMovedEvent extends Event {

    private float m_MouseX, m_MouseY;

    public MouseMovedEvent(float x, float y) {
        m_MouseX = x;
        m_MouseY = y;
    }

    public float getX() {
        return m_MouseX;
    }

    public float getY() {
        return m_MouseY;
    }

    @Override
    public EventType getEventType() {
        return EventType.MouseMoved;
    }

    @Override
    public int getCategoryFlags() {
        return EventCategory.Mouse.asInt() | EventCategory.Input.asInt();
    }

    @Override
    public String getName() {
        return "MouseMovedEvent";
    }
    
}
