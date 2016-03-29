
import java.util.Arrays;

public class AdminBank {

    private Gui gui;
    Bank bnk = new Bank();
    private int takeBankAll;
    int bank = 0;
    String passBank = "b";
    String loginBank = "2";
    String[] passwordBankItem = {" Welcome to menuAdminBank\n" + " Enter password\n"};
//    String[] passwordYetItem = {" Insert password yet\n"};
//    String[] loginYetItem = {" Insert login yet\n"};
    String[] accessAdminIngrItem = {" \nAccess Granted!\n\n" + " Take money- press button Yes\n" +
            " Look all Bank- press button No\n"};
    String[] bankHasItem = {" Bank has: " + bnk.getBankMin() + "$\n"};

    final ThreadLocal<String[]> lookAllBankItem = new ThreadLocal<String[]>() {
        @Override
        protected String[] initialValue() {
            return new String[]{"Bank has: " + getBank() + "\n" +
                    "Bank has max: " + bnk.getBankMax() + "\n" +
                    "All Bank: " + bnk.getBankList() + "\n"};
        }
    };

    final ThreadLocal<String[]> takeBankItem = new ThreadLocal<String[]>() {
        @Override
        protected String[] initialValue() {
            return new String[]{"Bank has: " + getBank() + "$\n" + " Took: " + getTakeBankAll() + "$\n" +
                    " It left in the bank: " + bnk.getBankMin() + "\n"};
        }
    };

    public AdminBank(Gui gui) {
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

    public int takeMoney() {
        Bank.getBankList();
        int sum = 0;
        for (Integer b : Bank.bankList) {
            sum = sum + b;
        }
        bank = sum;
        setBank(sum);
        takeBankAll = bank - bnk.getBankMin();
        setTakeBankAll(takeBankAll);

        System.out.println("Bank has: " + getBank() + "$");
        System.out.println("Took: " + getTakeBankAll() + "$");
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

    public int getTakeBankAll() {
        return takeBankAll;
    }

    public void setTakeBankAll(int takeBankAll) {
        this.takeBankAll = takeBankAll;
    }

    public int getBank() {
        return bank;
    }

    public void setBank(int bank) {
        this.bank = bank;
    }

}
