package footballsim.game;

import footballsim.logging.Logger;

class GameResult {

}

public class Game {
    private Bracket bracket = new Bracket();

    public Game() {
        Logger.info("Created new game");
    }

    /**
     * Plays the next round
     */
    public void playRound() {
        bracket.playNextMatches();
    }

    /**
     * Gets how many rounds there are left
     * @return
     */
    public int getRoundsLeft() {
        return 10;
    }

    /**
     * Gets result from the game
     * @return
     */
    public GameResult getResult() {
        return new GameResult();
    }
}
