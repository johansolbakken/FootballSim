package footballsim.logging;

/**
 * Object for holding a color.
 */
public class LogColorRefrence {
    private LogColor s_CurrentColor = LogColor.ANSI_WHITE;
    
    public void setColor(final LogColor color) {
        if (color == null) throw new IllegalArgumentException("LogColor can not be null");
        s_CurrentColor = color;
    }

    public final LogColor getColor() {
        return s_CurrentColor;
    }
}
