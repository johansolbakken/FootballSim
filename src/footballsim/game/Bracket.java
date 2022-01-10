package footballsim.game;

/**
 * Struct containing results from this bracket
 */
class BracketResult {

}

/**
 * A bracket for simulating teams playing each other
 */
public class Bracket {
    private Match[] matches = new Match[8];
    private BracketResult results = new BracketResult();

    /**
     * Plays the next match
     */
    public void playNextMatches() {

    }

    /**
     * Gets the current result from the game
     * @return
     */
    public BracketResult getResult() {
        return results;
    }
}
