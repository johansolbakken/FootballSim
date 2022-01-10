package footballsim.events;


public class WindowResizeEvent extends Event {
    private int m_Width, m_Height;

    public WindowResizeEvent(int width, int height) {
        m_Width = width;
        m_Height = height;
    }

    public int getWidth() {
        return m_Width;
    }

    public int getHeight() {
        return m_Height;
    }

    @Override
    public EventType getEventType() {
        return EventType.WindowResize;
    }

    @Override
    public int getCategoryFlags() {
        return EventCategory.Application.asInt();
    }

    @Override
    public String getName() {
        return "WindowResizeEvent";
    }

    @Override
    public String toString() {
        return super.toString() + ": " + m_Width + ", " + m_Height;
    }
    
}
