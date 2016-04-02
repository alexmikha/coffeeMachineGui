import java.util.ArrayList;
import java.util.List;

public class CheckMoney {
    static List<Integer> checkMoneyList = new ArrayList<>();
    private Gui gui;
    private RecipeCoffee rc = new RecipeCoffee(this);
    static int moneycm = 0;
    int money;
    static int change;
    static int bad = 1;

    public CheckMoney(Gui checkMoney) {
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
            if (moneycm < rc.getPriseEspresso()) {
                bad = 1;
            }
        } else {
            bad = 0;
        }
        if (moneycm >= rc.getPriseEspresso()) {
            change = moneycm - rc.getPriseEspresso();
            bad = 2;
        }
        return bad;
    }

    void checkMoneyAmericano() {
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
                bad = 1;
            }
        } else {
            bad = 0;
        }
        if (moneycm >= rc.getPriseAmericano()) {
            change = moneycm - rc.getPriseAmericano();
            bad = 2;
        }
    }

    void checkMoneyCappucino() {
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
                bad = 1;
            }
        } else {
            bad = 0;
        }
        if (moneycm >= rc.getPriseCappuccino()) {
            change = moneycm - rc.getPriseCappuccino();
            bad = 2;
        }
    }

    void takeChange() {

        if (change != 0) {
            gui.getTextArea1().setText(" Preparing drink: " + rc.getName() + "\n" +
                    " coffee- " + Ingredients.getCoffee() + " water-" + Ingredients.getWater() +
                    " cost-" + rc.getPrise() + "$\n" +
                    " coffee ready with sugar-" + Ingredients.getSugar() + "\n You put: " + moneycm + "$\n" +
                    " Enough money for: " + rc.getName() + "-" + rc.getPrise() + "$\n" +
                    " Take the change: " + change + " $\n\n");
            gui.viewOutMoney();
        }
    }
}
