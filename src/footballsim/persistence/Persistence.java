package footballsim.persistence;

import footballsim.game.Team;
import footballsim.util.image.Image;

public class Persistence {
    
    /**
     * Parses the team to Json and writes it to file.
     * @param url Filename
     * @param team The team to be saved
     */
    public static void writeTeam(String url, Team team) {
        // Lagrer team med navn "aa" ved ~/footballsim/teams/aa.json
    }

    /**
     * Reads a team from a file and returns it.
     * @param url The filename of the team.
     * @return the team.
     */
    public static Team readTeam(String url) {
        return null;
    }

    /**
     * Writes an image to file.
     * @param url the filename of the image.
     * @param image the image.
     */
    public static void writeImage(String url, Image image) {
        // should write to ~/footballsim/images/url.png for instance
    }

    /**
     * Reads an image.
     * @param url the filename of the image.
     * @return the image.
     */
    public static Image readImage(String url) {
        return null;
    }

}
