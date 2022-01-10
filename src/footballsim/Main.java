package footballsim;

import footballsim.core.Core;
import footballsim.logging.LogLevel;
import footballsim.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Core.initializeCore();

        Application app = new Application();
        app.run();
        app.destroy();
    }
}