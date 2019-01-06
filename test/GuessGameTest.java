import org.junit.Test;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.Assert.*;

public class GuessGameTest {
    @Test
    public void testSimpleGame() {
        GuessGame underTest = new GuessGame(new MyRandom() {
            @Override
            public int getRandom() {
                return 50;
            }
        });
        int result;

        result = underTest.guess(40);
        assertTrue(result < 0 );

        result = underTest.guess(60);
        assertTrue(result > 0 );

        result = underTest.guess(50);
        assertTrue(result == 0 );

    }


    @Test
    public void testNextGame() {
        Queue<Integer> queue = new LinkedBlockingQueue<Integer>();
        queue.add(0);
        queue.add(50);

        GuessGame underTest = new GuessGame(new MyRandom() {
            @Override
            public int getRandom() {
                return 0;
                //return queue.remove();
            }
        });
        int result;

        result = underTest.guess(60);
        assertTrue(result > 0 );

        result = underTest.guess(0);
        assertTrue(result == 0 );

        underTest.nextGame();

        result = underTest.guess(40);
        assertTrue(result < 0 );

        result = underTest.guess(60);
        assertTrue(result > 0 );

        result = underTest.guess(50);
        assertTrue(result == 0 );

    }
}