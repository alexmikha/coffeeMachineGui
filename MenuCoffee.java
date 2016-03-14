/**
 * Created by mi on 14.03.2016.
 */
public class MenuCoffee {
    private Gui gui;
    private Bank bank;
    Ingredients ingredients = new Ingredients(this);

    private String name = " ";
    private int espresso;
    private int americano;
    private int cappucino;

//    public MenuCoffee(Ingredients menuCoffee) {
//        this.ingredients = menuCoffee;
//    }

    public MenuCoffee(Gui menuCoffee) {
        this.gui = menuCoffee;
    }

    public MenuCoffee(Bank bank) {
        this.bank = bank;
    }

    public MenuCoffee() {
        americano = 7;
        espresso = 5;
        cappucino = 9;
    }

    //   public int menu() {
    //       System.out.println();
    //       Gui gui = new Gui();
//        Ingredients ing = new Ingredients();
//               ing.checkIngradients();
    //       System.out.println("You choose a drink");
    //              Gui gui = new Gui();
//        gui.textArea1.append("1" + "-" + getName1() + " cost-" + getEspresso() + "$\n" +
//                "2" + "-" + getName2() + " cost-" + getAmericano() + "$\n" +
//                "3" + "-" + getName3() + " cost-" + getCappucino() + "$\n" +
//                "4" + "-" + "other\n");
//        System.out.println(1 + "-" + getName1() + " cost-" + espresso + "$");
//        System.out.println(2 + "-" + getName2() + " cost-" + americano + "$");
//        System.out.println(3 + "-" + getName3() + " cost-" + cappucino + "$");
    //      Gui gui = new Gui();
    //   gui.textArea.append("1");
    //      System.out.println(4 + "-" + "other");
    //      Scanner menu = new Scanner(System.in);
    //      int recipe = menu.nextInt();
    //     if (recipe == 1) {
//            rc.menuSugar();
//            setName("Espresso");
//            System.out.println("You chose " + getName());
//            CheckMoney cm = new CheckMoney();
//            cm.checkMoneyEspresso();
//        }
//        if (recipe == 2) {
//            rc.menuSugar();
//            setName("Americano");
//            System.out.println("You chose " + getName());
//            CheckMoney cm = new CheckMoney();
//            cm.checkMoneyAmericano();
//        }
//        if (recipe == 3) {
//            rc.menuSugar();
//            setName("Cappucino");
//            System.out.println("You chose " + getName());
//            CheckMoney cm = new CheckMoney();
//            cm.checkMoneyCappucino();
//        }
//        if (recipe == 4) {
//            menuAdmin();
//        } else {
//        return menu();
//   }
//        return 0;
//    }

    public int menuAdmin() {

        String admin1 = "ad1";
        String admin2 = "ad2";
//        Scanner sc = new Scanner(System.in);
//        String admin = sc.nextLine();
        System.out.println("Login:");
//        AdminBank adminBank = new AdminBank();
//        AdminIngradient adminIngr = new AdminIngradient();
        //    final ActionListener[] actionListeners = gui.getTextField1().getActionListeners();
        gui.getTextField1().setText(admin1);
        //  gui.button3.addActionListener(e -> gui.button3ActionPerformed(e));
        cotrolPassword();
        return 0;
    }

    int cotrolPassword() {
        AdminBank adminBank = new AdminBank();
        AdminIngradient adminIngr = new AdminIngradient();
        String admin1 = "ad1";
        String admin2 = "ad2";
        if (gui.getTextField1().equals(admin1)) {
            System.out.println("Welcome to menuAdminMoney");
            adminBank.takeMoney();
        }
        if (gui.getTextField1().equals(admin2)) {
            System.out.println("Welcome to menuAdminIngradient");
            adminIngr.adminIngradient();
        }
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName1() {
        return "Espresso";
    }

    public String getName2() {
        return "Americano";
    }

    public String getName3() {
        return "Cappucino";
    }

    public int getEspresso() {
        return espresso;
    }

    public void setEspresso(int espresso) {
        this.espresso = espresso;
    }

    public int getAmericano() {
        return americano;
    }

    public void setAmericano(int americano) {
        this.americano = americano;
    }

    public int getCappucino() {
        return cappucino;
    }

    public void setCappucino(int cappucino) {
        this.cappucino = cappucino;
    }
}
