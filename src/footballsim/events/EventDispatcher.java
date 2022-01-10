package footballsim.events;


public class EventDispatcher {
    private Event m_Event;

    public EventDispatcher(Event event) {
        m_Event = event;
    }

    public boolean dispatch(EventType type, EventFunction<Event> eventFn) {
        if (m_Event.getEventType() == type) {
            m_Event.setHandled(eventFn.callback(m_Event), this);
            return true;
        }

        return false;
    }
}
