

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Thread.sleep;


public class Gui extends JFrame {

    private List<String> moneyList = new ArrayList<>();
    private List<String> sugarList = new ArrayList<>();
    private List<String> menuList = new ArrayList<>();
    private RecipeCoffee recipeCoffee = new RecipeCoffee(this);
    private CheckMoney checkMoney = new CheckMoney(this);
    private Ingredients ingr = new Ingredients();
    private AdminBank adminBank = new AdminBank(this);
    private AdminIngradient adminIngr = new AdminIngradient(this);

    private Bank bank = new Bank();
    private SWorker sw = new SWorker(this);
    private final ThreadLocal<SWorker1> sw1 = new ThreadLocal<>();
    private int sugarGui;
    private int moneyBad;
    private int moneyCancel = 0;
    private ImageIcon imageIcon6;
    private ImageIcon imageIcon7;
    private ImageIcon imageIcon8;
    private ImageIcon imageIcon9;
    private ImageIcon imageIcon10;


    private int getSugarGui() {
        return sugarGui;
    }

    private void setSugarGui(int sugarGui) {
        this.sugarGui = sugarGui;
    }

    private String[] menuItem = {" Please select the drink:\n" + " Espresso     price 5$\n" +
            " Americano    price 7$\n" + " Cappuccino  price 9&\n\n"};
    private String[] checkAddMoneyItem = {" Not enough money for a drink\n", " Add money\n"};
    private String[] chooseOrderItem = {" Do You want to cancel your order?\n" + " Press the button - Yes\n" +
            " Press the button -  No\n"};
    private String[] menuSugarItem = {" Do You want with sugar ?\n" + " 0", "1", "2", "3", "4\n\n"};
    private String[] menuMoneyItem = {" Insert money: ", "1", "2", "5", "10\n\n"};
    private String[] crowdedBankItem = {" The Bank is full !!!\n"};
    private String[] cleanedIngrItem = {" Ingradients were cleared !!!\n"};

    private ThreadLocal<String[]> cancelOrderItem;

    public Gui() {
        super();
        initComponents();
        startCoffeeMachine();
        selectDrink();
        ingr.fillStock();
        imageIcon6 = new ImageIcon(getClass().getResource("/images/CUP_FALL.gif"));
        imageIcon7 = new ImageIcon(getClass().getResource("/images/MONEY_IN.gif"));
        imageIcon8 = new ImageIcon(getClass().getResource("/images/Money_out_new.gif"));
        imageIcon9 = new ImageIcon(getClass().getResource("/images/FALL.jpg"));
        imageIcon10 = new ImageIcon(getClass().getResource("/images/MONEY.jpg"));
        moneyBad = 0;
        cancelOrderItem = new ThreadLocal<String[]>() {
            @Override
            protected String[] initialValue() {
                return new String[]{" Take Your the money: " + CheckMoney.checkMoneyList + " $\n" + "All money: " +
                        moneyCancel + " $\n" + " Come again\n\n"};
            }
        };
    }

    void removeAnimInsertOutMoney() {
        panel5.remove(label7);
        label7.setIcon(imageIcon10);
        panel5.add(label7);
        panel5.revalidate();
        panel5.repaint();
    }

    void removeAnimInsertMoney() {
        panel5.remove(label7);
        label7.setIcon(imageIcon10);
        panel5.add(label7);
        panel5.revalidate();
        panel5.repaint();
    }

    boolean viewInsertMoney() {
        label7.setIcon(imageIcon7);
        panel5.add(label7);
        panel5.revalidate();
        panel5.repaint();
        return true;
    }

    boolean viewOutMoney() {
        label7.setIcon(imageIcon8);
        panel5.add(label7);
        panel5.revalidate();
        panel5.repaint();
        return true;
    }

    void removeAnimDrink() {
        panel4.remove(label6);
        panel4.revalidate();
        panel4.repaint();
        label6.setIcon(imageIcon9);
        panel4.add(label6);
    }

    private void viewCoffeeDrink() {
        removeAnimDrink();
        label6.setIcon(imageIcon6);
        panel4.add(label6);
        panel4.revalidate();
        panel4.repaint();
    }

    void cleanedIngr() {
        ingr.checkIngradients();
        bank.checkBank();
        int a = Ingredients.a;
        //       int b = Bank.b;
        if (a == 0) {
            unlockControl();
        }
        if (a == 1) {
            textArea1.append(Arrays.toString(cleanedIngrItem));
            blockControl();
        }
    }

    void crowdedBank() {
        bank.checkBank();
        ingr.checkIngradients();
        //       int a = Ingredients.a;
        int b = Bank.b;
        if (b == 0) {
            unlockControl();
        }
        if (b == 1) {
            textArea1.append(Arrays.toString(crowdedBankItem));
            blockControl();
        }
    }

    private void unlockControl() {
        bank.checkBank();
        ingr.checkIngradients();
        int a = Ingredients.a;
        int b = Bank.b;
        if ((a == 0) && (b == 0)) {
            button1.setEnabled(true);
            button2.setEnabled(true);
            button3.setEnabled(true);
            button4.setEnabled(true);
            button5.setEnabled(true);
            button6.setEnabled(true);
            button7.setEnabled(true);
            button7.setEnabled(true);
            button8.setEnabled(true);
            button9.setEnabled(true);
            button10.setEnabled(true);
            button11.setEnabled(true);
            textField1.setText(menuList.get(0));
            textField2.setText(sugarList.get(0));
            textField3.setText(moneyList.get(0));
        }
    }

    private void blockControl() {
        bank.checkBank();
        ingr.checkIngradients();
        int a = Ingredients.a;
        int b = Bank.b;
        if (a == 1 || b == 1) {
            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(true);
            button4.setEnabled(false);
            button5.setEnabled(false);
            button6.setEnabled(false);
            button7.setEnabled(false);
            button7.setEnabled(false);
            button8.setEnabled(false);
            button9.setEnabled(false);
            button10.setEnabled(false);
            button11.setEnabled(false);
            if (a == 1) {
                textField1.setText("login Ingr");
                textField3.setText("ingr");
            }
            if (b == 1) {
                textField1.setText("login Bank");
                textField3.setText("bank");
            }
            textField2.setText(" ");
        }
    }

    private void checkIngBank() {
        cleanedIngr();
        crowdedBank();
    }

    private void makeDrink() {
        if (textField1.getText().equals(menuList.get(0)))
            recipeCoffee.recipeEspresso();
        else if (textField1.getText().equals(menuList.get(1)))
            recipeCoffee.recipeAmericano();
        else if (textField1.getText().equals(menuList.get(2)))
            recipeCoffee.recipeCappuccino();
        bank.putBank(recipeCoffee.getCost());
        checkMoney.takeChange();
        checkIngBank();
        CheckMoney.checkMoneyList.clear();
    }

    void selectDrink() {
        CheckMoney.checkMoneyList.clear();
        CheckMoney.moneycm = 0;
        bank.checkBank();
        ingr.checkIngradients();
        int a = Ingredients.a;
        int b = Bank.b;
        if (a == 0 && b == 0) {
            try {
                textArea1.append(Arrays.toString(menuItem));
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void startCoffeeMachine() {
        menuList.add("Espresso");
        menuList.add("Americano");
        menuList.add("Cappuccino");

        sugarList.add("0");
        sugarList.add("1");
        sugarList.add("2");
        sugarList.add("3");
        sugarList.add("4");

        moneyList.add("1");
        moneyList.add("2");
        moneyList.add("3");
        moneyList.add("4");
        moneyList.add("5");
        moneyList.add("6");
        moneyList.add("7");
        moneyList.add("8");
        moneyList.add("9");
        moneyList.add("10");
    }

    private void menuSugar() {
        textArea1.append(Arrays.toString(menuSugarItem));
    }

    private void addSugar() {
        for (int i = 0; i < sugarList.size(); i++) {
            i++;
        }
        if (sugarList.get(0).equals(textField2.getText()))
            textField2.setText("1");
        else if (sugarList.get(1).equals(textField2.getText()))
            textField2.setText("2");
        else if (sugarList.get(2).equals(textField2.getText()))
            textField2.setText("3");
        else if (sugarList.get(3).equals(textField2.getText()))
            textField2.setText("4");
        setSugarGui(Integer.parseInt(textField2.getText()));
        Ingredients.setSugar(getSugarGui());
    }

    private void minusSugar() {
        int i = 0;
        for (sugarList.size(); i >= 0; i--) {
            i--;
        }
        if (sugarList.get(4).equals(textField2.getText()))
            textField2.setText("3");
        else if (sugarList.get(3).equals(textField2.getText()))
            textField2.setText("2");
        else if (sugarList.get(2).equals(textField2.getText()))
            textField2.setText("1");
        else if (sugarList.get(1).equals(textField2.getText()))
            textField2.setText("0");
        setSugarGui(Integer.parseInt(textField2.getText()));
        Ingredients.setSugar(getSugarGui());
    }

    private void menuMoney() {
        textArea1.append(Arrays.toString(menuMoneyItem));
    }

    private void insertAddMoney() {
        for (int i = 0; i < moneyList.size(); i++) {
            i++;
        }
        if (moneyList.get(0).equals(textField3.getText()))
            textField3.setText("2");
        else if (moneyList.get(1).equals(textField3.getText()))
            textField3.setText("3");
        else if (moneyList.get(2).equals(textField3.getText()))
            textField3.setText("4");
        else if (moneyList.get(3).equals(textField3.getText()))
            textField3.setText("5");
        else if (moneyList.get(4).equals(textField3.getText()))
            textField3.setText("6");
        else if (moneyList.get(5).equals(textField3.getText()))
            textField3.setText("7");
        else if (moneyList.get(6).equals(textField3.getText()))
            textField3.setText("8");
        else if (moneyList.get(7).equals(textField3.getText()))
            textField3.setText("9");
        else if (moneyList.get(8).equals(textField3.getText()))
            textField3.setText("10");
    }

    private void iinsertSubtractMoney() {
        int i = 0;
        for (moneyList.size(); i >= 0; i--) {
            i--;
        }
        if (moneyList.get(9).equals(textField3.getText()))
            textField3.setText("9");
        else if (moneyList.get(8).equals(textField3.getText()))
            textField3.setText("8");
        else if (moneyList.get(7).equals(textField3.getText()))
            textField3.setText("7");
        else if (moneyList.get(6).equals(textField3.getText()))
            textField3.setText("6");
        else if (moneyList.get(5).equals(textField3.getText()))
            textField3.setText("5");
        else if (moneyList.get(4).equals(textField3.getText()))
            textField3.setText("4");
        else if (moneyList.get(3).equals(textField3.getText()))
            textField3.setText("3");
        else if (moneyList.get(2).equals(textField3.getText()))
            textField3.setText("2");
        else if (moneyList.get(1).equals(textField3.getText()))
            textField3.setText("1");
    }

    private void chooseOrder() {
        textArea1.append(Arrays.toString(chooseOrderItem));
    }

    private void cancelOrder() {
        int sum = 0;
        for (Integer i : CheckMoney.checkMoneyList) {
            sum = sum + i;
        }
        moneyCancel = sum;
        textArea1.append(Arrays.toString(cancelOrderItem.get()));
        try {
            cancelOrderItem.remove();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    void addMoney() {
        textArea1.append(Arrays.toString(checkAddMoneyItem));
    }

    boolean takeBadMoney() {
        sw = new SWorker(this);
        int money = Integer.parseInt(textField3.getText());
        int sum = 0;
        for (Integer mon : CheckMoney.checkMoneyList) {
            sum = sum + mon;
        }
        moneyBad = sum;
        textArea1.setText(" Introduced not correct money\n" + " Take this money " + money + "$\n" +
                " Take this money " + moneyBad + "$\n\n");
        sw.execute();
        return true;
    }

    private void selectAddRecipe() {
        for (int i = 0; i < menuList.size(); i++) {
            i++;
        }
        if (menuList.get(0).equals(textField1.getText()))
            textField1.setText(recipeCoffee.getName2());
        else if (menuList.get(1).equals(textField1.getText()))
            textField1.setText(recipeCoffee.getName3());
    }

    private void selesctMinusRecipe() {
        int i = 0;
        for (menuList.size(); i >= 0; i--) {
            i--;
        }
        if (menuList.get(2).equals(textField1.getText()))
            textField1.setText(recipeCoffee.getName2());
        else if (menuList.get(1).equals(textField1.getText()))
            textField1.setText(recipeCoffee.getName1());
    }

    void putMoneyEspresso() {
        if (CheckMoney.moneycm >= recipeCoffee.getPriceEspresso()) {
            textArea1.setText(" You put: " + CheckMoney.moneycm + "$\n" + " Enough money for: " +
                    recipeCoffee.getName1() + "-" + recipeCoffee.getPriceEspresso() + "$\n\n");
            chooseOrder();
        }
    }

    void putMoneyAmericano() {
        if (CheckMoney.moneycm >= recipeCoffee.getPriseAmericano()) {
            textArea1.setText(" You put: " + CheckMoney.moneycm + "$\n" + " Enough money for: " +
                    recipeCoffee.getName2() + "-" + recipeCoffee.getPriseAmericano() + "$\n\n");
            chooseOrder();
        }
    }

    void putMoneyCappuccino() {
        if (CheckMoney.moneycm >= recipeCoffee.getPriseCappuccino()) {
            textArea1.setText(" You put: " + CheckMoney.moneycm + "$\n" + " Enough money for: " +
                    recipeCoffee.getName3() + "-" + recipeCoffee.getPriseCappuccino() + "$\n\n");
            chooseOrder();
        }
    }

    private void button1ActionPerformed(ActionEvent e) {
        selectAddRecipe();
    }

    private void button2ActionPerformed(ActionEvent e) {
        selesctMinusRecipe();
    }

    private void button3ActionPerformed(ActionEvent e) {
        if (textField1.getText().equals(recipeCoffee.getName1()) ||
                textField1.getText().equals(recipeCoffee.getName2()) ||
                textField1.getText().equals(recipeCoffee.getName3())) {
            menuSugar();
        }
        if (textField3.getText().equals("bank") && textField1.getText().equals(adminBank.loginBank)) {
            adminBank.controlLoginBank();
        }
        if (textField3.getText().equals("bank") && textField1.getText().equals(adminBank.passBank)) {
            adminBank.controlPaswordBank();
        }
        if (textField3.getText().equals("ingr") && textField1.getText().equals(adminIngr.loginIngr)) {
            adminIngr.controlLoginIngr();
        }
        if (textField3.getText().equals("ingr") && textField1.getText().equals(adminIngr.passIngr)) {
            adminIngr.controlPaswordIngr();
        }
    }

    private void button4ActionPerformed(ActionEvent e) {
        addSugar();
    }

    private void button5ActionPerformed(ActionEvent e) {
        minusSugar();
    }

    private void button6ActionPerformed(ActionEvent e) {
        menuMoney();
    }

    private void button7ActionPerformed(ActionEvent e) {
        insertAddMoney();
    }

    private void button8ActionPerformed(ActionEvent e) {
        iinsertSubtractMoney();
    }

    private void button9ActionPerformed(ActionEvent e) {
        if (textField1.getText().equals(menuList.get(0))) {
            if (textField1.getText().equals(recipeCoffee.getName1())) {
                sw1.set(new SWorker1(this));
                viewInsertMoney();
                checkMoney.checkMoneyEspresso();
                sw1.get().execute();
            }

        } else if (textField1.getText().equals(recipeCoffee.getName2())) {
            if (CheckMoney.moneycm < recipeCoffee.getPriseAmericano()) {
                sw1.set(new SWorker1(this));
                viewInsertMoney();
                checkMoney.checkMoneyAmericano();
                sw1.get().execute();
            }

        } else if (textField1.getText().equals(recipeCoffee.getName3())) {
            if (CheckMoney.moneycm < recipeCoffee.getPriseCappuccino()) {
                sw1.set(new SWorker1(this));
                viewInsertMoney();
                checkMoney.checkMoneyCappucino();
                sw1.get().execute();
            }
        }
    }

    private void button10ActionPerformed(ActionEvent e) {
        sw = new SWorker(this);
        sw.execute();
        if (textField1.getText().equals(recipeCoffee.getName1()) ||
                textField1.getText().equals(recipeCoffee.getName2()) ||
                textField1.getText().equals(recipeCoffee.getName3())) {
            cancelOrder();
            viewOutMoney();
        }
        if (textField3.getText().equals("bank")) {
            adminBank.takeMoney();
        } else {
            if (textField3.getText().equals("ingr")) {
                adminIngr.addIngradient();
            }
        }
    }

    private void button11ActionPerformed(ActionEvent e) {
        sw = new SWorker(this);
        sw.execute();
        if (textField3.getText().equals("bank")) {
            adminBank.lookMoney();
        } else {
            if (textField3.getText().equals("ingr")) {
                adminIngr.lookStockIngr();
            } else if ((!textField3.getText().equals("bank")) || (!textField3.getText().equals("ingr"))) {
                makeDrink();
                viewCoffeeDrink();
                sw.execute();
            }
        }
    }

    JTextField getTextField1() {
        return textField1;
    }

    JTextArea getTextArea1() {
        return textArea1;
    }

    JTextField getTextField3() {
        return textField3;
    }

    private void initComponents() {

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JScrollPane scrollPane1 = new JScrollPane();
        JScrollPane scrollPane2 = new JScrollPane();
        textArea1 = new JTextArea();
        JPanel panel3 = new JPanel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        button7 = new JButton();
        button8 = new JButton();
        button9 = new JButton();
        button10 = new JButton();
        button11 = new JButton();
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();
        JLabel label4 = new JLabel();
        JLabel label5 = new JLabel();
        panel4 = new JPanel();
        label6 = new JLabel();
        panel5 = new JPanel();
        label7 = new JLabel();

        //======== this ========
        setFont(new Font("DialogInput", Font.PLAIN, 16));
        setTitle("CoffeeMachin");
        setType(Window.Type.UTILITY);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout());

        //======== panel1 ========
        {
            panel1.setLayout(null);

            //======== panel2 ========
            {
                panel2.setLayout(null);
                panel2.add(scrollPane1);
                scrollPane1.setBounds(0, 0, 235, 0);

                //======== scrollPane2 ========
                {

                    //---- textArea1 ----
                    textArea1.setBackground(new Color(0, 0, 102));
                    textArea1.setForeground(new Color(255, 255, 51));
                    textArea1.setTabSize(10);
                    scrollPane2.setViewportView(textArea1);
                }
                panel2.add(scrollPane2);
                scrollPane2.setBounds(0, 0, 235, 160);

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for (int i = 0; i < panel2.getComponentCount(); i++) {
                        Rectangle bounds = panel2.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel2.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel2.setMinimumSize(preferredSize);
                    panel2.setPreferredSize(preferredSize);
                }
            }
            panel1.add(panel2);
            panel2.setBounds(0, 0, 235, 160);

            //======== panel3 ========
            {
                panel3.setBackground(new Color(204, 204, 255));
                panel3.setLayout(null);

                //---- button1 ----
                button1.setText("+");
                button1.addActionListener(this::button1ActionPerformed);
                panel3.add(button1);
                button1.setBounds(new Rectangle(new Point(15, 30), button1.getPreferredSize()));

                //---- button2 ----
                button2.setText("-");
                button2.addActionListener(this::button2ActionPerformed);
                panel3.add(button2);
                button2.setBounds(new Rectangle(new Point(55, 30), button2.getPreferredSize()));

                //---- button3 ----
                button3.setText(">");
                button3.addActionListener(this::button3ActionPerformed);
                panel3.add(button3);
                button3.setBounds(new Rectangle(new Point(185, 30), button3.getPreferredSize()));

                //---- label5 ----
                label5.setText("Menu");
                label5.setFont(new Font("Dialog", Font.BOLD, 16));
                label5.setForeground(new Color(204, 102, 0));
                panel3.add(label5);
                label5.setBounds(new Rectangle(new Point(15, 5), label5.getPreferredSize()));

                //---- label1 ----
                label1.setText("coffee drink");
                label1.setForeground(new Color(255, 153, 0));
                panel3.add(label1);
                label1.setBounds(105, 10, 70, 20);

                //---- textField1 ----
                textField1.setText("Espresso");
                textField1.setBackground(new Color(0, 0, 102));
                textField1.setForeground(Color.green);
                textField1.setFont(new Font("sansserif", Font.PLAIN, 14));
                panel3.add(textField1);
                textField1.setBounds(100, 30, 80, 25);

                //---- button4 ----
                button4.setText("+");
                button4.addActionListener(this::button4ActionPerformed);
                panel3.add(button4);
                button4.setBounds(new Rectangle(new Point(15, 60), button4.getPreferredSize()));

                //---- button5 ----
                button5.setText("-");
                button5.addActionListener(this::button5ActionPerformed);
                panel3.add(button5);
                button5.setBounds(new Rectangle(new Point(55, 60), button5.getPreferredSize()));

                //---- textField2 ----
                textField2.setSelectedTextColor(new Color(0, 0, 51));
                textField2.setForeground(Color.green);
                textField2.setFont(textField2.getFont().deriveFont(textField2.getFont().getSize() + 6f));
                textField2.setText("0");
                textField2.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
                textField2.setBackground(new Color(0, 0, 102));
                panel3.add(textField2);
                textField2.setBounds(100, 60, 45, 30);

                //---- label2 ----
                label2.setText("sugar");
                label2.setForeground(new Color(51, 51, 51));
                panel3.add(label2);
                label2.setBounds(new Rectangle(new Point(150, 65), label2.getPreferredSize()));

                //---- button6 ----
                button6.setText(">");
                button6.addActionListener(this::button6ActionPerformed);
                panel3.add(button6);
                button6.setBounds(new Rectangle(new Point(185, 60), button6.getPreferredSize()));

                //---- button7 ----
                button7.setText("+");
                button7.addActionListener(this::button7ActionPerformed);
                panel3.add(button7);
                button7.setBounds(new Rectangle(new Point(15, 90), button7.getPreferredSize()));

                //---- button8 ----
                button8.setText("-");
                button8.addActionListener(this::button8ActionPerformed);
                panel3.add(button8);
                button8.setBounds(new Rectangle(new Point(55, 90), button8.getPreferredSize()));

                //---- textField3 ----
                textField3.setBackground(new Color(0, 0, 102));
                textField3.setForeground(Color.green);
                textField3.setFont(new Font("sansserif", Font.PLAIN, 18));
                textField3.setText("1");
                textField3.setColumns(10);
                textField3.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
                panel3.add(textField3);
                textField3.setBounds(100, 90, 45, 30);

                //---- label3 ----
                label3.setText("money");
                label3.setForeground(new Color(51, 51, 51));
                panel3.add(label3);
                label3.setBounds(145, 95, 42, label3.getPreferredSize().height);

                //---- button9 ----
                button9.setText(">");
                button9.addActionListener(this::button9ActionPerformed);
                panel3.add(button9);
                button9.setBounds(new Rectangle(new Point(185, 90), button9.getPreferredSize()));

                //---- button10 ----
                button10.setText("Yes");
                button10.setFont(new Font("sansserif", Font.PLAIN, 11));
                button10.addActionListener(this::button10ActionPerformed);
                panel3.add(button10);
                button10.setBounds(new Rectangle(new Point(40, 120), button10.getPreferredSize()));

                //---- label4 ----
                label4.setText("   order");
                panel3.add(label4);
                label4.setBounds(110, 125, 45, label4.getPreferredSize().height);

                //---- button11 ----
                button11.setText("No");
                button11.setFont(new Font("sansserif", Font.PLAIN, 11));
                button11.addActionListener(this::button11ActionPerformed);
                panel3.add(button11);
                button11.setBounds(new Rectangle(new Point(180, 120), button11.getPreferredSize()));

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for (int i = 0; i < panel3.getComponentCount(); i++) {
                        Rectangle bounds = panel3.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel3.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel3.setMinimumSize(preferredSize);
                    panel3.setPreferredSize(preferredSize);
                }
            }
            panel1.add(panel3);
            panel3.setBounds(235, 0, 235, 160);

            //======== panel4 ========
            {
                panel4.setLayout(null);

                //---- label6 ----
                label6.setIcon(new ImageIcon("D:\\IntelliJIDEA\\coffeeMachineGui\\out\\production\\coffeeMachineGui\\images\\FALL.jpg"));
                label6.setOpaque(true);
                panel4.add(label6);
                label6.setBounds(0, 0, 235, 250);

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for (int i = 0; i < panel4.getComponentCount(); i++) {
                        Rectangle bounds = panel4.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel4.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel4.setMinimumSize(preferredSize);
                    panel4.setPreferredSize(preferredSize);
                }
            }
            panel1.add(panel4);
            panel4.setBounds(0, 160, 235, 250);

            //======== panel5 ========
            {
                panel5.setAutoscrolls(true);
                panel5.setLayout(null);

                //---- label7 ----
                label7.setBackground(new Color(153, 153, 153));
                label7.setIcon(new ImageIcon("D:\\IntelliJIDEA\\coffeeMachineGui\\out\\production\\coffeeMachineGui\\images\\MONEY.jpg"));
                label7.setOpaque(true);
                label7.setForeground(new Color(178, 60, 22));
                panel5.add(label7);
                label7.setBounds(0, 0, label7.getPreferredSize().width, 250);

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for (int i = 0; i < panel5.getComponentCount(); i++) {
                        Rectangle bounds = panel5.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel5.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel5.setMinimumSize(preferredSize);
                    panel5.setPreferredSize(preferredSize);
                }
            }
            panel1.add(panel5);
            panel5.setBounds(235, 160, 235, 250);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for (int i = 0; i < panel1.getComponentCount(); i++) {
                    Rectangle bounds = panel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel1.setMinimumSize(preferredSize);
                panel1.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel1);
        setSize(485, 450);
        setLocationRelativeTo(null);
    }

    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    JButton button10;
    JButton button11;
    private JTextArea textArea1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JPanel panel4;
    private JLabel label6;
    private JPanel panel5;
    private JLabel label7;

    void start() {
        EventQueue.invokeLater(() -> {
            try {
                Gui frame = new Gui();
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
