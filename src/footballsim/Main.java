package footballsim;

import footballsim.logging.LogLevel;
import footballsim.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Logger.init();
        Logger.setLevel(LogLevel.ALL);
        Logger.info("Hello");
        Logger.config("What is going on here?");
        Logger.severe("Krise");
        Logger.finest("Diamant");
    }
}