
public class TennisGame1 implements TennisGame {

    private Point player1Points = new Point();
    private Point player2Points = new Point();
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            player1Points.increase();
        else
            player2Points.increase();
    }

    public String getScore() {
        if (isGameTied())
            return getScoreForTiedGame();

        if (isGameAfterDeuce())
            return getScoreAfterDeuce();

        return getScoreBeforeDeuce();
    }

    private boolean isGameTied() {
        return player1Points.getValue() == player2Points.getValue();
    }

    private boolean isGameAfterDeuce() {
        return player1Points.getValue() >= 4 || player2Points.getValue() >= 4;
    }


    private String getScoreBeforeDeuce() {
        return player1Points.getLiteral() + "-" + player2Points.getLiteral();
    }

    private String getScoreAfterDeuce() {
        int pointsDifference = player1Points.getValue() - player2Points.getValue();

        if (pointsDifference == 1)
            return "Advantage player1";

        if (pointsDifference == -1)
            return "Advantage player2";

        if (pointsDifference >= 2)
            return "Win for player1";

        return "Win for player2";
    }

    private String getScoreForTiedGame() {
        if (player1Points.getValue() > 2) return "Deuce";
        return player1Points.getLiteral() + "-All";
    }
}
