/**
 * Created by mi on 14.03.2016.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bank {

    static List<Integer> bankList = new ArrayList<Integer>();
    private Gui gui;
    MenuCoffee menuCoffee = new MenuCoffee(this);
    private int bankAll;
    private int bankMin = 10;
    private int bankMax = 20;
    int bank;
    static int b;

    public Bank(Gui bank) {
        this.gui = bank;
    }

    public Bank() {
    }

    int checkBank() {

        if (!bankList.isEmpty()) {
            int sum = 0;
            for (Integer bn : bankList) {
                sum = sum + bn;
            }
            bankAll = sum;
            setBankAll(sum);

            if (getBankAll() >= getBankMax()) {
                System.out.println("The Bank is full!!!");
                //     gui.getTextArea1().setText("The Bank is full!!!");gui.getTextArea1().append(Arrays.toString(gui.crowdedBankItem));
                gui.getTextArea1().append(Arrays.toString(gui.crowdedBankItem));
            }
            b = 1;
        } else
            b = 0;
        return b;
    }


    public int putBank(int cost) {
        if (bankList.isEmpty()) {
            bankList.add(getBankMin());
        }
        bankList.add(cost);
        int sum = 0;
        for (Integer bn : bankList) {
            sum = sum + bn;
        }
        bank = sum;
        setBankAll(bank);
        System.out.println("bank " + bank);
        return cost;
    }

    public int getBankAll() {
        return bankAll;
    }

    public void setBankAll(int bankAll) {
        this.bankAll = bankAll;
    }

    public int getBankMin() {
        return bankMin;
    }

    public int getBankMax() {
        return bankMax;
    }

    public static List<Integer> getBankList() {
        return bankList;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "allbank=" + bankAll +
                ", bankmin=" + bankMin +
                ", bankmax=" + bankMax +
                ", bank=" + bank +
                '}';
    }
}
