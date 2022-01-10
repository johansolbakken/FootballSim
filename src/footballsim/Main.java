package footballsim;

import footballsim.core.Core;

public class Main {
    public static void main(String[] args) {
        Core.initializeCore();

        Application app = new Application();
        app.run();
        app.destroy();
    }
}