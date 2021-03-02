public class RealTennisGame implements TennisGame {

    private int player1Score;
    private int player2Score;
    private String player1Name;
    private String player2Name;

    private static  final String[] SCORE_NAMES = new String[]{"Love", "Fifteen", "Thirty", "Forty"};

    public RealTennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1"){
            this.player1Score += 1;
        } else {
            this.player2Score += 1;
        }
    }

    public String getScore() {
        if (isGameEnded()) {
            return getFinalScore();
        } else {
            return getActualScore();
        }
    }

    private String getActualScore() {
        if (player1Score == player2Score){
            return SCORE_NAMES[player1Score] + "-All";
        }
        return SCORE_NAMES[player1Score] + "-" + SCORE_NAMES[player2Score];
    }

    private String getFinalScore() {
        if (player1Score == player2Score){
            return "Deuce";
        }
        String playerWitMaxValue = getPlayerNameWithMaxScore();
        return isWinning() ? "Win for " + playerWitMaxValue : "Advantage " + playerWitMaxValue ;
    }

    private String getPlayerNameWithMaxScore() {
        return player1Score > player2Score ? player1Name : player2Name;
    }

    private boolean isWinning() {
        return (player1Score - player2Score) * (player1Score - player2Score) != 1;
    }

    private boolean isGameEnded() {
        return player1Score >= 4 || player2Score >= 4 || (player2Score + player1Score) >= 6;
    }

}
