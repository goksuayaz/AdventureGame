import java.util.Random;

public class Mine extends Battleloc{
    public Mine(Player player){
        super(player,"Mine",new Snake(),"Material",getRandomValue());
    }

    private static int getRandomValue(){
        Random random = new Random();
        return random.nextInt(5) + 1;
    }
}
