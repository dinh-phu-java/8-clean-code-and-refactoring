public class TennisGame {

    public static final java.lang.String LOVE_ALL = "Love-All";
    public static final java.lang.String FIFTEEN_ALL = "Fifteen-All";
    public static final java.lang.String THIRTY_ALL = "Thirty-All";
    public static final java.lang.String FORTY_ALL = "Forty-All";
    public static final java.lang.String DEUCE = "Deuce";

    public static String getResult(String player1Name, String player2Name, int myScore1, int myScore2) {
        String score = "";
        int tempScore=0;
        if (myScore1==myScore2)
        {
            switch (myScore1)
            {
                case 0:
                    score = LOVE_ALL;
                    break;
                case 1:
                    score = FIFTEEN_ALL;
                    break;
                case 2:
                    score = THIRTY_ALL;
                    break;
                case 3:
                    score = FORTY_ALL;
                    break;
                default:
                    score = DEUCE;
                    break;

            }
        }
        else if (myScore1>=4 || myScore2>=4)
        {
            score = getResult(myScore1, myScore2);
        }
        else
        {
            score = getScore(myScore1, myScore2, score);
        }
        return score;
    }

    private static String getScore(int myScore1, int myScore2, String score) {
        int tempScore;
        for (int i = 1; i<3; i++)
        {
            if (i==1) tempScore = myScore1;
            else { score=score.concat("-"); tempScore = myScore2;}
            switch(tempScore)
            {
                case 0:
                    score= score.concat("Love");
                    break;
                case 1:
                    score =score.concat("Fifteen");
                    break;
                case 2:
                    score =score.concat("Thirty");
                    break;
                case 3:
                    score =score.concat("Forty");
                    break;
            }
        }
        return score;
    }

    private static String getResult(int myScore1, int myScore2) {
        String score;
        int minusResult = myScore1-myScore2;
        if (minusResult==1) score ="Advantage player1";
        else if (minusResult ==-1) score ="Advantage player2";
        else if (minusResult>=2) score = "Win for player1";
        else score ="Win for player2";
        return score;
    }
}
