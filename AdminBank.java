/**
 * Created by mi on 14.03.2016.
 */
import java.util.Scanner;

//import static Bank.bankList;
//
//import static Bank.getBankList;

public class AdminBank {

    MenuCoffee mc = new MenuCoffee();
    Bank bnk = new Bank(null);
    private int takeBankAll;
    int bank = 0;

    public AdminBank() {
    }

    public int takeMoney() {
        Gui gui = new Gui();
        System.out.println("Password:");
        String pass = "mon";
        Scanner sc = new Scanner(System.in);
        String adminmoney = sc.nextLine();
        if (adminmoney.equals(pass)) {
            System.out.println("Access Granted");
        } else {
            System.out.println("Insert password yet");
            return takeMoney();
        }
        bnk.getBankList();
        int sum = 0;
        for (Integer b : bnk.bankList) {
            sum = sum + b;
        }
        bank = sum;
        setBank(sum);
        takeBankAll = bank - bnk.getBankMin();
        setTakeBankAll(takeBankAll);

        System.out.println(1 + " - take money");
        System.out.println(2 + " - look all Bank");
        //     System.out.println(3 + " -вернутся в меню");
        sc = new Scanner(System.in);
        int get = sc.nextInt();
        if (get == 1) {
            System.out.println("Bank has: " + getBank() + "$");
            System.out.println("Took: " + getTakeBankAll() + "$");

            bnk.bankList.clear();
            bnk.bankList.add(bnk.getBankMin());
            System.out.println("Bank has: " + bnk.getBankMin() + "$");
        }
        if (get == 2) {
            System.out.println("Bank has:      {" + getBank() + "}");
            System.out.println("Bank has max:  {" + bnk.getBankMax() + "}");
            System.out.println("All Bank: " + bnk.getBankList());
        }
//        return gui.menu();
        return sum;
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
