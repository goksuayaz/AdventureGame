import java.util.Random;

public class Snake extends Obstacle{

    public Snake(){
        super(4,getRandomValue(),12,"Snake",0);

    }
    private static int getRandomValue(){
        Random random = new Random();
        return random.nextInt(4) + 3;
    }


}
