package footballsim.events;

public class WindowCloseEvent extends Event {

    @Override
    public EventType getEventType() {
        return EventType.WindowClose;
    }

    @Override
    public int getCategoryFlags() {
        return EventCategory.Application.asInt();
    }

    @Override
    public String getName() {
        return "WindowCloseEvent";
    }
    
}
