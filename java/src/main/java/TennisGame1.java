
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
        return getPointLiteral(player1Points) + "-" + getPointLiteral(player2Points);
    }

    private String getPointLiteral(int points) {
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
        int pointsDifference = player1Points - player2Points;

        if (pointsDifference == 1)
            return "Advantage player1";

        if (pointsDifference == -1)
            return "Advantage player2";

        if (pointsDifference >= 2)
            return "Win for player1";

        return "Win for player2";
    }

    private String getScoreForTiedGame() {
        if (player1Points > 2) return "Deuce";
        return getPointLiteral(player1Points) + "-All";
    }
}
