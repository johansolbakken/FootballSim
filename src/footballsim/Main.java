package footballsim;

import footballsim.app.Application;
import footballsim.core.Core;

public class Main {
    public static void main(String[] args) {
        Core.initializeCore();

        Application.create(new FootballGame());
        Application.getInstance().run();
        Application.getInstance().destroy();
    }
}