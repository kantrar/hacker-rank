import java.util.Random;

public class GuessGame {
    private static int answer;
    private MyRandom myRandom;

    public int getNewRandom() {
        return myRandom.getRandom();
    }

    public GuessGame(MyRandom myRandom) {
        this.myRandom = myRandom;
        answer = getNewRandom();
    }

    public void nextGame() {
        answer = getNewRandom();
    }

    public int guess(int guessed) {
        if (guessed > answer) {
            return 1;
        } else if (guessed < answer) {
            return -1;
        }
        return 0;
    }
}
