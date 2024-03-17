public class ToolStore extends Normalloc{
    public ToolStore(Player player){
        super(player, "Store");
    }

    @Override
    public boolean onLocation(){
        System.out.println("------- Welcome to Store ! -------");
        boolean showMenu = true;
        while(showMenu){
        System.out.println("1- Guns");
        System.out.println("2- Zırhlar");
        System.out.println("3- Exit");
        System.out.print("Select :");
        int selectCase = input.nextInt();
        while(selectCase < 1 || selectCase > 3 ){
            System.out.print("Please select again!");
            selectCase = input.nextInt();
        }
        switch(selectCase){
            case 1:
                printWeapon();
                buyWeapon();
                break;
            case 2:
                printArmor();
                buyArmor();
                break;
            case 3:
                System.out.println("See you soon");
                showMenu = false;
                break;
        }

        }
        return true;


    }

  public void printWeapon(){
    System.out.println("------ Guns -----");
      for(Weapon w : Weapon.weapons()){
          System.out.println(w.getId() + "-" +  w.getName() +
                  "<Money : " + w.getPrice() + " , Damage : " + w.getDamage() + ">");

      }
      System.out.println("0 - Exit");

  }

     public void buyWeapon(){
         System.out.print("Please Select a Gun :");

         int selectWeaponID = input.nextInt();
         while(selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length ){
             System.out.print("Please select again!");
             selectWeaponID = input.nextInt();
         }

         if(selectWeaponID != 0){
         Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);

         if(selectedWeapon != null){
             if(selectedWeapon.getPrice() > this.getPlayer().getMoney()){
                 System.out.println("You don't have enough money");
             }else{
                 System.out.println(selectedWeapon.getName() + " bouth this gun !");
                 int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                 this.getPlayer().setMoney(balance);
                 System.out.println("Your money: " + this.getPlayer().getMoney());
                 this.getPlayer().getInventory().setWeapon(selectedWeapon);
             }
         }

         }
     }

   public void printArmor(){
    System.out.println("----- Armors -----");
       for(Armor a : Armor.armors()){
           System.out.println(a.getId() + " - " + a.getName() +
                   "<Price : " + a.getPrice() + ", Armor : " + a.getBlock() + "> ");
       }
       System.out.println("0 - Çıkış Yap");
}

public void buyArmor(){
    System.out.print("Please Select a Armor :");

    int selectArmorID = input.nextInt();
    while(selectArmorID < 0 || selectArmorID > Armor.armors().length ){
        System.out.print("Please select again!");
        selectArmorID = input.nextInt();
    }
    if(selectArmorID != 0){
        Armor selectedArmor = Armor.getArmorObjById(selectArmorID);

        if(selectedArmor != null){
            if(selectedArmor.getPrice() > this.getPlayer().getMoney()){
                System.out.println("You don't have enough money !");
            }else{
                System.out.println(selectedArmor.getName() + " you bought !");
                this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedArmor.getPrice());
                this.getPlayer().getInventory().setArmor(selectedArmor);
                System.out.println("Balance :" + this.getPlayer().getMoney());
            }

        }
    }

}
}




