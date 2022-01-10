package footballsim.core;

import footballsim.logging.LogLevel;
import footballsim.logging.Logger;

public class Core {
    
    public static void initializeCore() {
        Logger.init();
        Logger.setLevel(LogLevel.ALL);
    }

}
