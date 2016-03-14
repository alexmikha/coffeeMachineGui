/**
 * Created by mi on 14.03.2016.
 */
public class CheckMoney {

    private Gui gui;
    RecipeCoffee rc = new RecipeCoffee();
    MenuCoffee mc = new MenuCoffee();
    Ingredients ingr = new Ingredients();
    Bank bank = new Bank(gui);
    int moneycm;
    int money;
    int cost = 0;
    static int change;

    public CheckMoney(Gui checkMoney) {
        this.gui = checkMoney;

    }


    public int checkMoneyEspresso() {
        Gui gui = new Gui();
        gui.money = Integer.parseInt(gui.textField3.getText());
        if (money == 1 || money == 2 || money == 5 || money == 10) {
            moneycm = money;
            gui.checkMoneyList.add(moneycm);
            int sum = 0;
            for (Integer m : gui.checkMoneyList) {
                sum = sum + m;
            }
            moneycm = sum;
            if (moneycm < gui.recipeCoffee.getEspresso()) {
                gui.checkAddMoney();
            }
        } else {
            gui.checkBadMoney();
        }
        if (moneycm >= gui.recipeCoffee.getEspresso()) {
            change = moneycm - gui.recipeCoffee.getEspresso();
            gui.getTextArea1().setText("You put: " + moneycm + "$\n" + "Enough money for: " +
                    gui.recipeCoffee.getName1() + "-" + gui.recipeCoffee.getPriseEspresso() + "$\n\n");
//               takeChange(change);
            gui.chooseOrder();
        }
        return 0;
    }

    public int checkMoneyAmericano() {
        Gui gui = new Gui();
        System.out.println("Insert money: ");
//        Scanner sc = new Scanner(System.in);
//        money = sc.nextInt();
//        Scanner or = new Scanner(System.in);
        if (money == 1 || money == 2 || money == 5 || money == 10) {
            while (money < rc.getAmericano()) {
                System.out.println("Not enough money for a drink");
                System.out.println("Add money");
//                money += sc.nextInt();
            }

        } else {
            System.out.println("Introduced not correct money");
            System.out.println("Take this money " + money + "$");
            return checkMoneyAmericano();
        }
        if (money >= rc.getAmericano()) {
            System.out.println("You put: " + money + "$");
            int change = money - rc.getAmericano();
            System.out.println("Enough money for: : " + rc.getName2() + "-" + rc.getAmericano() + "$");

            System.out.println("Do you want to cancel your order?");
            System.out.println(1 + " -yes");
            System.out.println(2 + " -not");
//            int order = or.nextInt();
//            if (order == 1)
//                cancelOrder();
//            else if (order == 2) {
//            rc.recipeAmericano(7, 120, sugar, 7);
            if (change != 0)
                System.out.println("Take the change: " + change + "$");
            bank.putBank(rc.getCost());
//                mc.menu();
            //           gui.menu();
        }
        return 0;
    }
//        return 0;
//    }

    public int checkMoneyCappucino() {
        Gui gui = new Gui();
        System.out.println("Insert money: ");
//        Scanner sc = new Scanner(System.in);
//        money = sc.nextInt();
//        Scanner or = new Scanner(System.in);
        if (money == 1 || money == 2 || money == 5 || money == 10) {
            while (money < rc.getCappuccino()) {
                System.out.println("Not enough money for a drink");
                System.out.println("Add money");
//                money += sc.nextInt();
            }

        } else {
            System.out.println("Introduced not correct money");
            System.out.println("Take this money " + money + "$");
            return checkMoneyCappucino();
        }
        if (money >= rc.getCappuccino()) {
            System.out.println("You put: " + money + "$");
            int change = money - rc.getCappuccino();
            System.out.println("Enough money for: " + rc.getName3() + "-" + rc.getCappuccino() + "$");

            System.out.println("Do You want to cancel your order?");
            System.out.println(1 + " -yes");
            System.out.println(2 + " -not");
//            int order = or.nextInt();
//            if (order == 1)
//                cancelOrder();
//            else if (order == 2) {
//            rc.recipeCappucino(7, 30, 70, sugar, 9);
            if (change != 0)
                System.out.println("Take the change: " + change + "$");
            bank.putBank(rc.getCost());
//                mc.menu();
            //           gui.menu();
        }
        return checkMoneyCappucino();
    }
//        return 0;
//    }


    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getChange() {
        return change;
    }


}
