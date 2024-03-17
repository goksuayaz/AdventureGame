public class SafeHouse extends Normalloc{
    public SafeHouse(Player player){
        super(player,"Safe House");
    }

    @Override
    public boolean onLocation(){
        System.out.println("You are in Safe House !");
        System.out.println("Lives Full !");
        this.getPlayer().setHealth(this.getPlayer().getOrjHealth());
        return true;
    }

}
