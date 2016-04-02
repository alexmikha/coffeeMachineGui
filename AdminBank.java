
import java.util.Arrays;

public class AdminBank {

    private Gui gui;
    Bank bnk = new Bank();
    private int takeBankAll;
    int bank = 0;
    String passBank = "b";
    String loginBank = "2";
    String[] passwordBankItem = {" Welcome to menuAdminBank\n" + " Enter password\n"};
    String[] accessAdminIngrItem = {" \nAccess Granted!\n\n" + " Take money- press button Yes\n" +
            " See how much money in the Bank- press button No\n"};
    String[] bankHasItem = {" Bank has: " + bnk.getBankMin() + "$\n"};

    final ThreadLocal<String[]> lookAllBankItem = new ThreadLocal<String[]>() {
        @Override
        protected String[] initialValue() {
            return new String[]{" Bank has: " + getBank() + "\n" +
                    " Bank has max: " + bnk.getBankMax() + "\n" +
                    " Bank: " + bnk.getBankList() + "\n"};
        }
    };

    final ThreadLocal<String[]> takeBankItem = new ThreadLocal<String[]>() {
        @Override
        protected String[] initialValue() {
            return new String[]{"Bank has: " + getBank() + "$\n" + " Took: " + getTakeBankAll() + "$\n" +
                    " It left in the bank: " + bnk.getBankMin() + "\n"};
        }
    };

    AdminBank(Gui gui) {
        this.gui = gui;
    }

    void controlLoginBank() {
        if (gui.getTextField1().getText().equals(loginBank)) {
            gui.getTextArea1().append(Arrays.toString(passwordBankItem));
            gui.getTextField1().setText("password");
        }
    }

    void controlPaswordBank() {
        if (gui.getTextField1().getText().equals(passBank)) {
            gui.getTextArea1().append(Arrays.toString(accessAdminIngrItem));
            gui.button10.setEnabled(true);
            gui.button11.setEnabled(true);
        }
    }

    int takeMoney() {
        Bank.getBankList();
        int sum = 0;
        for (Integer b : Bank.bankList) {
            sum = sum + b;
        }
        bank = sum;
        setBank(sum);
        takeBankAll = bank - bnk.getBankMin();
        setTakeBankAll(takeBankAll);
        gui.getTextArea1().append(Arrays.toString(takeBankItem.get()));
        Bank.bankList.clear();
        Bank.bankList.add(bnk.getBankMin());
        gui.getTextArea1().append(Arrays.toString(bankHasItem));
        return sum;
    }

    void lookMoney() {
        Bank.getBankList();
        int sum = 0;
        for (Integer b : Bank.bankList) {
            sum = sum + b;
        }
        bank = sum;
        setBank(sum);
        gui.getTextArea1().append(Arrays.toString(lookAllBankItem.get()));
    }

    int getTakeBankAll() {
        return takeBankAll;
    }

    void setTakeBankAll(int takeBankAll) {
        this.takeBankAll = takeBankAll;
    }

    int getBank() {
        return bank;
    }

    void setBank(int bank) {
        this.bank = bank;
    }

}
