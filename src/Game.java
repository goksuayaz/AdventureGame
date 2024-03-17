import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);

    public void start(){
        System.out.println("Welcome to Adventure Game !");
        System.out.print("Please enter your name : ");
        //String playerName = input.nextLine();

        Player player = new Player(" ");
        System.out.println("Dear " + player.getName() + " Welcome To This Island !");
        System.out.println("Everything is real!");
        System.out.println("Please select a character before you start! ");
        System.out.println("------------------------------------------");
        player.selectChar();

        Location location = null;
        while(true){
            player.printInfo();
            System.out.println();
            System.out.println("###### Locations #######");
            System.out.println();
            System.out.println("1- Safe House  -----> You are safe !");
            System.out.println("2- Tool Store -----> You can buy gun or armor !");
            System.out.println("3- Cave -----> Award: Food, Be careful! a zombie might appear !");
            System.out.println("4- Forest -----> Award: Wood, Be careful! a vampire might appear !");
            System.out.println("5- River -----> Award: Water, Be careful, a bear might appear !");
            System.out.println("6- Mine -----> Be careful! a snake might appear !");
            System.out.println("0- Exit -----> Close the game");

            System.out.print("Please select a location : ");
            int selectLoc = input.nextInt();
            switch(selectLoc){
                case 0:
                    location = null;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                case 6:
                    location = new Mine(player);
                    break;
                default:
                    System.out.println("Please select a valid location");
            }

            if(location == null){
                System.out.println("You gave up quickly !");
                break;
            }

            if(!location.onLocation()){
                System.out.println("GAME OVER !");
                break;
            }


        }


    }
}
