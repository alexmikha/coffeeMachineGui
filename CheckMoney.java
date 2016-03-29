import java.util.ArrayList;
import java.util.List;

public class CheckMoney {
    static List<Integer> checkMoneyList = new ArrayList<>();
    private Gui gui;
    private RecipeCoffee rc = new RecipeCoffee(this);
    int moneycm;
    int money;
    int cost = 0;

    static int change;

    public CheckMoney(Gui checkMoney) {
        this.gui = checkMoney;
    }

    void checkMoneyEspresso() {
//
        gui.viewInsertMoney();
        money = Integer.parseInt(gui.getTextField3().getText());
        if (money == 1 || money == 2 || money == 5 || money == 10) {
            moneycm = money;
            checkMoneyList.add(moneycm);
            int sum = 0;
            for (Integer m : checkMoneyList) {
                sum = sum + m;
            }
            moneycm = sum;
            if (moneycm < rc.getPriseEspresso()) {
                gui.checkAddMoney();
            }
        } else {
            gui.checkBadMoney();
        }
        if (moneycm >= rc.getPriseEspresso()) {
            change = moneycm - rc.getPriseEspresso();
            gui.getTextArea1().setText(" You put: " + moneycm + "$\n" + " Enough money for: " +
                    rc.getName1() + "-" + rc.getPriseEspresso() + "$\n\n");
            gui.chooseOrder();
        }
    }

    void checkMoneyAmericano() {
        gui.viewInsertMoney();
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
                gui.checkAddMoney();
            }
        } else {
            gui.checkBadMoney();
        }
        if (moneycm >= gui.recipeCoffee.getPriseAmericano()) {
            change = moneycm - rc.getPriseAmericano();
            gui.getTextArea1().setText("You put: " + moneycm + "$\n" + "Enough money for: " +
                    rc.getName2() + "-" + rc.getPriseAmericano() + "$\n\n");
            gui.chooseOrder();
        }
    }

    void checkMoneyCappucino() {
        gui.viewInsertMoney();
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
                gui.checkAddMoney();
            }
        } else {
            gui.checkBadMoney();
        }
        if (moneycm >= rc.getPriseCappuccino()) {
            change = moneycm - rc.getPriseCappuccino();
            gui.getTextArea1().setText("You put: " + moneycm + "$\n" + "Enough money for: " +
                    rc.getName3() + "-" + rc.getPriseCappuccino() + "$\n\n");
            gui.chooseOrder();
        }
    }

    void takeChange() {

        if (change!= 0) {
            //           System.out.println("change- " + getChange());
            gui.getTextArea1().setText(" Preparing drink: " + rc.getName() + "\n" +
                    " coffee- " + Ingredients.getCoffee() + " water-" + Ingredients.getWater() +
                    " cost-" + rc.getPrise() + "$\n" +
                    " coffee ready with sugar-" + Ingredients.getSugar() + "\n You put: " + moneycm + "$\n" +
                    " Enough money for: " + rc.getName() + "-" + rc.getPrise() + "$\n" +
                    " Take the change: " +change + " $\n\n");
            gui.viewOutMoney();
        }
    }

}
