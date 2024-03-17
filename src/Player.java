import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int orjHealth;
    private int money;
    private String name;
    private String charName;
    private Scanner input = new Scanner(System.in);
    private Inventory inventory;

    public Player(String name){
        this.name = name;
        this.inventory = new Inventory();
    }
    public void selectChar(){

        GameChar[] charList = {new Samuray(), new Archer(), new Knight()};
        System.out.println("Characters");
        System.out.println("----------------------------------------");
        for(GameChar gameChar : charList){
            System.out.println("ID:" + gameChar.getId() + " Character:" + gameChar.getName() +
                    " Damage:" + gameChar.getDamage() +
                    " Health:" + gameChar.getHealth() +
                    " Money:" + gameChar.getMoney());
        }
        System.out.println("----------------------------------------");
        System.out.println("Please enter a character id: ");
        int selectChar = input.nextInt();
        switch(selectChar){
            case 1:
                initPlayer(new Samuray());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
            initPlayer(new Knight());
            break;
            default:
                initPlayer(new Samuray());

        }
    }




    public void initPlayer(GameChar gameChar){
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setOrjHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());

    }
    public void printInfo(){
        System.out.println("Your Gun" + this.getInventory().getWeapon().getName() +
                ", Rag : " + this.getInventory().getArmor().getName() +
                ", Block : " + this.getInventory().getArmor().getBlock() +
                ", Damage : " + this.getTotalDamage() +
                ", Health : " + this.getHealth() +
                ", Money : " + this.getMoney());

    }
    public int getTotalDamage(){
        return damage + this.getInventory().getWeapon().getDamage() ;

    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Weapon getWeapon(){
        return this.getInventory().getWeapon();
    }

    public int getOrjHealth() {
        return orjHealth;
    }

    public void setOrjHealth(int orjHealth) {
        this.orjHealth = orjHealth;
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }
}
