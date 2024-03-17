import java.util.Random;

public abstract class Battleloc extends Location{
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public Battleloc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation(){
        int obsNumber = this.randomObstacleNumber();

        System.out.println("You are now in : " + this.getName());
        System.out.println("Attention! Here " + obsNumber + " total " + this.getObstacle().getName() + " living !");
        System.out.print("Fight <F> OR <R> Run : ");
        String selectCase = input.nextLine().toUpperCase();

        if(selectCase.equals("F") && combat(obsNumber)){
            System.out.println(this.getName() + " you killed all the enemies !");
                return true;

        }
        if(this.getPlayer().getHealth() <= 0){
            System.out.println("You died !");
            return false;
        }

        return true;
    }

    public void awardArea(){
        Random random = new Random();

        int num1 = random.nextInt(100);
        int num2 = random.nextInt(56);
        int num3 = random.nextInt(101);
        if(getObstacle().getName().equalsIgnoreCase("Snake")){
            getObstacle().setMoney(10);
        }

        while(num1 < 55){
            if(num2 < 25){
                if(this.award.equalsIgnoreCase("Suprise") && num3 < 20){
                    getObstacle().setMoney(10);
                    getPlayer().setMoney(getObstacle().getMoney() + getPlayer().getMoney());
                    break;
                }else if(this.award.equalsIgnoreCase("Suprise") && num3 < 50){
                    getObstacle().setMoney(5);
                    getPlayer().setMoney(getObstacle().getMoney() + getPlayer().getMoney());
                    break;
                }else if(this.award.equalsIgnoreCase("Suprise") && num3 < 100){
                    getObstacle().setMoney(1);
                    getPlayer().setMoney(getObstacle().getMoney() + getPlayer().getMoney());
                    break;

                }
            }
            else if(num2 < 40){
                if(this.award.equalsIgnoreCase("Suprise") && num3 < 20){
                    getPlayer().getInventory().setArmor(Armor.getArmorObjById(1));
                    System.out.println(getPlayer().getInventory().getArmor().getName());
                    break;
                }
                else if(this.award.equalsIgnoreCase("Suprise") && num3 < 50){
                    getPlayer().getInventory().setArmor(Armor.getArmorObjById(2));
                    System.out.println(getPlayer().getInventory().getArmor().getName());
                    break;

                }
                else if(this.award.equalsIgnoreCase("Suprise") && num3 < 100){
                    getPlayer().getInventory().setArmor(Armor.getArmorObjById(3));
                    System.out.println(getPlayer().getInventory().getArmor().getName());
                    break;

                }
            }
            else if(num2 < 40){
                if(this.award.equalsIgnoreCase("Suprise") && num3 < 20){
                    getPlayer().getInventory().setArmor(Armor.getArmorObjById(1));
                    System.out.println(getPlayer().getInventory().getArmor().getName());
                    break;
                }
                else if(this.award.equalsIgnoreCase("Suprise") && num3 < 50){
                    getPlayer().getInventory().setArmor(Armor.getArmorObjById(2));
                    System.out.println(getPlayer().getInventory().getArmor().getName());
                    break;

                }
                else if(this.award.equalsIgnoreCase("Suprise") && num3 < 100){
                    getPlayer().getInventory().setArmor(Armor.getArmorObjById(3));
                    System.out.println(getPlayer().getInventory().getArmor().getName());
                    break;
                }
            }
            else if(num2 < 55){
                if(this.award.equalsIgnoreCase("Suprise") && num3 < 20){
                    getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(1));
                    System.out.println(getPlayer().getInventory().getWeapon().getName());
                    break;

                }
                else if(this.award.equalsIgnoreCase("Suprise") && num3 < 50){
                    getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(2));
                    System.out.println(getPlayer().getInventory().getWeapon().getName());
                    break;

                }
                else if(this.award.equalsIgnoreCase("Suprise") && num3 < 100){
                    getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(3));
                    System.out.println(getPlayer().getInventory().getWeapon().getName());
                    break;

                }

            }else{
                System.out.println("You didn't win anything");
            }
        }

    }

    public boolean combat(int obsNumber){

        for(int i= 1; i <= obsNumber; i++){
            this.getObstacle().setHealth(this.getObstacle().getOrgHealth());
            playerStats();
            obstacleStats(i);
            while(this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0){
                System.out.println("Hit H or R Run :");
                String selectCombat = input.nextLine();
                if(selectCombat.equals("H")){
                    System.out.println("You Hit !");
                    this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                    afterHit();
                    if(this.getObstacle().getHealth() > 0){
                        System.out.println();
                        System.out.println("Monster hit you !");
                        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if(obstacleDamage < 0){
                            obstacleDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                        afterHit();
                    }
                }else{
                    return false;
                }
            }
            if(this.getObstacle().getHealth() < this.getPlayer().getHealth()){
                System.out.println("You won !");
                System.out.println(this.getObstacle().getAward() + " won money !");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                System.out.println("Your money : " + this.getPlayer().getMoney());
            }else{
                return false;
            }
        }
        return true;
    }
    public void afterHit(){
        System.out.println("Canınız : " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + " Canı : " + this.getObstacle().getHealth());
        System.out.println("---------------");
    }
    public void playerStats(){
        System.out.println("Player Values");
        System.out.println("------------------------");
        System.out.println("Health : " + this.getPlayer().getHealth());
        System.out.println("Gun : " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Damage : " + this.getPlayer().getTotalDamage());
        System.out.println("Armor : " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Blocking : " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Money : " + this.getPlayer().getMoney());
        System.out.println();


    }
    public void obstacleStats(int i){
        System.out.println(i + "." + this.getObstacle().getName() + " Values");
        System.out.println("------------------");
        System.out.println("Health : " + this.getObstacle().getHealth());
        System.out.println("Damage : " + this.getObstacle().getDamage());
        System.out.println("Award : " + this.getObstacle().getAward());

    }

    public int randomObstacleNumber(){
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
