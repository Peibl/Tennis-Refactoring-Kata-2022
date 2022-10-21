
public class TennisGame1 implements TennisGame {

    private int player1Points = 0;
    private int player2Points = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            player1Points += 1;
        else
            player2Points += 1;
    }

    public String getScore() {
        if (isGameTied())
            return getScoreForTiedGame();

        if (isGameAfterDeuce())
            return getScoreAfterDeuce();

        return getScoreBeforeDeuce();
    }

    private boolean isGameTied() {
        return player1Points == player2Points;
    }

    private boolean isGameAfterDeuce() {
        return player1Points >= 4 || player2Points >= 4;
    }


    private String getScoreBeforeDeuce() {
        return getScoreLiteral(player1Points) + "-" + getScoreLiteral(player2Points);
    }

    private String getScoreLiteral(int points) {
        switch (points) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";

        }
        return "";
    }

    private String getScoreAfterDeuce() {
        String score;
        int minusResult = player1Points - player2Points;
        if (minusResult == 1) score = "Advantage player1";
        else if (minusResult == -1) score = "Advantage player2";
        else if (minusResult >= 2) score = "Win for player1";
        else score = "Win for player2";
        return score;
    }

    private String getScoreForTiedGame() {
        String score;
        switch (player1Points) {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            default:
                score = "Deuce";
                break;

        }
        return score;
    }
}
