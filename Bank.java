
import java.util.ArrayList;
import java.util.List;

public class Bank {

    static List<Integer> bankList = new ArrayList<>();
    private int bankAll;
    private int bankMin = 10;
    private int bankMax = 29;
    private int bank;
    static int b;

    Bank() {
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
                b = 1;
            } else
                b = 0;
        }
        return b;
    }

    int putBank(int cost) {
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
        return cost;
    }

    private int getBankAll() {
        return bankAll;
    }

    private void setBankAll(int bankAll) {
        this.bankAll = bankAll;
    }

    int getBankMin() {
        return bankMin;
    }

    int getBankMax() {
        return bankMax;
    }

    static List<Integer> getBankList() {
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
