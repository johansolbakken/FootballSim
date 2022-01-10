package footballsim.events;

@FunctionalInterface
public interface EventFunction<T extends Event> {
    boolean callback(T event);
}
