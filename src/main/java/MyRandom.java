import java.util.Random;

public class MyRandom implements IRandom{
    public int getRandom() {
        return new Random().nextInt(101);
    }
}
