
import java.util.Arrays;

class AdminBank {

    private Gui gui;
    private Bank bnk = new Bank();
    private int takeBankAll;
    private int bank = 0;
     String passBank = "b";
    String loginBank = "2";
    private String[] passwordBankItem = {" Welcome to menuAdminBank\n" + " Enter password\n"};
    private String[] accessAdminIngrItem = {" \nAccess Granted!\n\n" + " Take money- press button Yes\n" +
            " See how much money in the Bank- press button No\n"};
    private String[] bankHasItem = {" Bank has: " + bnk.getBankMin() + "$\n"};

    private final ThreadLocal<String[]> lookAllBankItem = new ThreadLocal<String[]>() {
        @Override
        protected String[] initialValue() {
            return new String[]{" Bank has: " + getBank() + "\n" +
                    " Bank has max: " + bnk.getBankMax() + "\n" +
                    " Bank: " + Bank.getBankList() + "\n"};
        }
    };

    private final ThreadLocal<String[]> takeBankItem = new ThreadLocal<String[]>() {
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

    private int getTakeBankAll() {
        return takeBankAll;
    }

    private void setTakeBankAll(int takeBankAll) {
        this.takeBankAll = takeBankAll;
    }

    private int getBank() {
        return bank;
    }

    private void setBank(int bank) {
        this.bank = bank;
    }

}
