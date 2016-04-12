import java.util.ArrayList;
import java.util.List;

class CheckMoney {
    static List<Integer> checkMoneyList = new ArrayList<>();
    private Gui gui;
    private RecipeCoffee rc = new RecipeCoffee();
    static int moneycm = 0;
    private int money;
    private static int change;
    static int verifyMoney = 1;

    CheckMoney(Gui checkMoney) {
        this.gui = checkMoney;
    }

    int checkMoneyEspresso() {
        money = Integer.parseInt(gui.getTextField3().getText());
        if (money == 1 || money == 2 || money == 5 || money == 10) {
            moneycm = money;
            checkMoneyList.add(moneycm);
            int sum = 0;
            for (Integer m : checkMoneyList) {
                sum = sum + m;
            }
            moneycm = sum;
            if (moneycm < rc.getPriceEspresso()) {
                verifyMoney = 1;
            }
        } else {
            verifyMoney = 0;
        }
        if (moneycm >= rc.getPriceEspresso()) {
            change = moneycm - rc.getPriceEspresso();
            verifyMoney = 2;
        }
        return verifyMoney;
    }

    int checkMoneyAmericano() {
        money = Integer.parseInt(gui.getTextField3().getText());
        if (money == 1 || money == 2 || money == 5 || money == 10) {
            moneycm = money;
            checkMoneyList.add(moneycm);
            int sum = 0;
            for (Integer m : checkMoneyList) {
                sum = sum + m;
            }
            moneycm = sum;
            if (moneycm < rc.getPriseAmericano()) {
                verifyMoney = 1;
            }
        } else {
            verifyMoney = 0;
        }
        if (moneycm >= rc.getPriseAmericano()) {
            change = moneycm - rc.getPriseAmericano();
            verifyMoney = 2;
        }
        return verifyMoney;
    }

    int checkMoneyCappucino() {
        money = Integer.parseInt(gui.getTextField3().getText());
        if (money == 1 || money == 2 || money == 5 || money == 10) {
            moneycm = money;
            checkMoneyList.add(moneycm);
            int sum = 0;
            for (Integer m : checkMoneyList) {
                sum = sum + m;
            }
            moneycm = sum;
            if (moneycm < rc.getPriseCappuccino()) {
                verifyMoney = 1;
            }
        } else {
            verifyMoney = 0;
        }
        if (moneycm >= rc.getPriseCappuccino()) {
            change = moneycm - rc.getPriseCappuccino();
            verifyMoney = 2;
        }
        return verifyMoney;
    }

    void takeChange() {
        if (change != 0) {
            gui.getTextArea1().setText(" Preparing drink: " + rc.getName() + "\n" +
                    " coffee- " + Ingredients.getCoffee() + ", water-" + Ingredients.getWater() +
                    ", milk-" + Ingredients.getMilk() +
                    ", cost-" + rc.getPrice() + "$\n" +
                    " coffee ready with sugar-" + Ingredients.getSugar() + "\n You put: " + moneycm + "$\n" +
                    " Take the change: " + change + " $\n\n");
            gui.viewOutMoney();
        }
    }
}
