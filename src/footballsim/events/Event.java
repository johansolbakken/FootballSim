package footballsim.events;

import java.util.Objects;

public abstract class Event {
    private boolean m_Handled = false;

    public abstract EventType getEventType();
    public abstract int getCategoryFlags();
    public abstract String getName();

    public boolean isInCategory(EventCategory category) {
        return (getCategoryFlags() & category.asInt()) != 0;
    }

    public boolean isHandled() {
        return m_Handled;
    }

    public void setHandled(boolean handled, Object sender) {
        Objects.requireNonNull(sender);
        if (!(sender instanceof EventDispatcher)) {
            throw new IllegalAccessError("Cannot access this class");
        }
        m_Handled = handled;
    }

    @Override
    public String toString() {
        return getName();
    }
}
