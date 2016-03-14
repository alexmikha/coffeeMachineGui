/**
 * Created by mi on 14.03.2016.
 */

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Gui extends JFrame {

    List<String> moneyList = new ArrayList<String>();
    List<Integer> moneyInsertList = new ArrayList<Integer>();
    List<String> sugarList = new ArrayList<String>();
    List<String> menuList = new ArrayList<String>();
    List<Integer> checkMoneyList = new ArrayList<Integer>();
    RecipeCoffee recipeCoffee = new RecipeCoffee(this);
    CheckMoney checkMoney = new CheckMoney(this);
    Ingredients ingr = new Ingredients(this);
    //   ChecrkMoney checkMoney = new CheckMoney();
    Bank bank = new Bank(this);
    //    DefaultListModel menuModel;
    //   private ActionEvent e;
//    static int sugar = 0;
    int moneycm = 0;
    int money;
    static int model;
    static int mode = 0;
    int change;
    static int sugar;

    public static int getSugar() {
        return sugar;
    }

    public static void setSugar(int sugar) {
        Gui.sugar = sugar;
    }


    //  int item;
//    String[] menu = {"Espresso, Americano, Cappuccino"};
//    String[] selectSugar = {"1", "2", "3", "4"};
//    Integer[] money = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    String[] menuItem = {" Espresso    prise 5$\n" + " Americano   prise 7$\n" + " Cappuccino  prise 9&\n\n"};
    ////    String[] selectEspressoItem = {"You put: " + moneycm + "$\n" +
////            "Enough money for: " + recipeCoffee.getName1() + "-" + recipeCoffee.getPriseEspresso() + "$\n"};
    String[] checkAddMoneyItem = {" Not enough money for a drink\n", " Add money\n"};
    //    String[] checkBadMoneyItem = {"Introduced not correct money\n", "Take this money " + money + "$\n"};
    String[] chooseOrderItem = {" Do You want to cancel your order?\n" + " yes\n" + "  not\n"};
    //    String[] takeChangeItem = {"Take the change: " + change + "$\n"};
    String[] menuSugarItem = {" Do You want with sugar ?\n" + " 0", "1", "2", "3", "4\n\n"};
    String[] menuMoneyItem = {" Insert money: ", "1", "2", "5", "10\n\n"};
    String[] crowdedBankItem = {" The Bank is full !!!\n"};
    String[] cleanedIngrItem = {" Ingradients were cleared !!!\n"};

    final ThreadLocal<String[]> cancelOrderItem = new ThreadLocal<String[]>() {
        @Override
        protected String[] initialValue() {
            return new String[]{" Take Your the money: " + moneycm + "$\n" + " Come again\n\n"};
        }
    };

    final ThreadLocal<String[]> takeChangeItem = new ThreadLocal<String[]>() {
        @Override
        protected String[] initialValue() {
            return new String[]{" Take the change: " + change + "$\n\n"};
        }
    };

    final ThreadLocal<String[]> checkBadMoneyItem = new ThreadLocal<String[]>() {
        @Override
        protected String[] initialValue() {
            return new String[]{" Introduced not correct money\n", " Take this money " + money + "$\n"};
        }
    };


    private ActionEvent e;

    public Gui() {

        initComponents();
        startCoffeeMachine();
//        menu();
        selectDrink();
    }

    void cleanedIngr() {
        ingr.checkIngradients();
        int a = Ingredients.a;
        if (a == 0)
            selectDrink();
    }

    void crowdedBank() {
        bank.checkBank();
        int b = Bank.b;
        if (b == 0)
            selectDrink();

    }

    void checkIngBank() {
//        ingr.checkIngradients();
//        bank.checkBank();
        cleanedIngr();
        crowdedBank();
    }

    public int checkMoneyEspresso() {

        money = Integer.parseInt(textField3.getText());
        if (money == 1 || money == 2 || money == 5 || money == 10) {
            moneycm = money;
            checkMoneyList.add(moneycm);
            int sum = 0;
            for (Integer m : checkMoneyList) {
                sum = sum + m;
            }
            moneycm = sum;
            if (moneycm < recipeCoffee.getEspresso()) {
                checkAddMoney();
            }
        } else {
            checkBadMoney();
        }
        if (moneycm >= recipeCoffee.getEspresso()) {
            change = moneycm - recipeCoffee.getEspresso();
            textArea1.setText("You put: " + moneycm + "$\n" + "Enough money for: " +
                    recipeCoffee.getName1() + "-" + recipeCoffee.getPriseEspresso() + "$\n\n");
            chooseOrder();
        }
        return 0;
    }

    public int checkMoneyAmericano() {

        money = Integer.parseInt(textField3.getText());
        if (money == 1 || money == 2 || money == 5 || money == 10) {
            moneycm = money;
            checkMoneyList.add(moneycm);
            int sum = 0;
            for (Integer m : checkMoneyList) {
                sum = sum + m;
            }
            moneycm = sum;
            if (moneycm < recipeCoffee.getAmericano()) {
                checkAddMoney();
            }
        } else {
            checkBadMoney();
        }
        if (moneycm >= recipeCoffee.getAmericano()) {
            change = moneycm - recipeCoffee.getAmericano();
            textArea1.setText("You put: " + moneycm + "$\n" + "Enough money for: " +
                    recipeCoffee.getName2() + "-" + recipeCoffee.getPriseAmericano() + "$\n\n");
            chooseOrder();
        }
        return 0;
    }

    public int checkMoneyCappuccino() {

        money = Integer.parseInt(textField3.getText());
        if (money == 1 || money == 2 || money == 5 || money == 10) {
            moneycm = money;
            checkMoneyList.add(moneycm);
            int sum = 0;
            for (Integer m : checkMoneyList) {
                sum = sum + m;
            }
            moneycm = sum;
            if (moneycm < recipeCoffee.getCappuccino()) {
                checkAddMoney();
            }
        } else {
            checkBadMoney();
        }
        if (moneycm >= recipeCoffee.getCappuccino()) {
            change = moneycm - recipeCoffee.getCappuccino();
            textArea1.setText("You put: " + moneycm + "$\n" + "Enough money for: " +
                    recipeCoffee.getName3() + "-" + recipeCoffee.getPriseCappuccino() + "$\n\n");
            chooseOrder();
        }
        return 0;
    }


    void makeDrink() {
        if (textField1.getText().equals(menuList.get(0)))
            //           checkMoneyEspresso();
            recipeCoffee.recipeEspresso(7, 30, sugar, 5);
        else if (textField1.getText().equals(menuList.get(1)))
            recipeCoffee.recipeAmericano(7, 100, sugar, 7);
        else if (textField1.getText().equals(menuList.get(2)))
            recipeCoffee.recipeCappuccino(7, 30, 70, sugar, 9);
        //  }

        bank.putBank(recipeCoffee.getCost());
        takeChange(change);
//        selectDrink();
        checkIngBank();
        //  menu();
        checkMoneyList.clear();
    }

    //   void menu() {
    void selectDrink() {
        //       checkIngBank();
        try {
            Thread.sleep(1000);
            // any action
            textArea1.append(Arrays.toString(menuItem));
//            textArea1.setText("Espresso prise 5$\n" + "Americano prise 7$\n" + "Cappuccino prise 9&\n\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    void startCoffeeMachine() {

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
//        textArea1.setText("Do You want with sugar ?\n" + "0, " + "1, " + "2, " + "3, " + "4\n");
    }


    void addSugar() {// button4+

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
        setSugar(Integer.parseInt(textField2.getText()));
        ingr.setSugar(getSugar());
        System.out.println("sugar " + Integer.parseInt(textField2.getText()));

    }

    void minusSugar() {

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
        setSugar(Integer.parseInt(textField2.getText()));
        ingr.setSugar(getSugar());
    }

    void menuMoney() {
        textArea1.append(Arrays.toString(menuMoneyItem));
//       textArea1.setText("Insert money: " + "1, " + "2, " + "5, " + "10\n");
    }

    void insertAddMoney() { //button7+
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

    void iinsertSubtractMoney() {  //button8-

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


    void chooseOrder() {

//        textArea1.setText("Do you want to cancel your order?\n" + " yes\n" + "not\n");
        textArea1.append(Arrays.toString(chooseOrderItem));
    }

    void takeChange(int change) {
        if (change != 0)
            textArea1.append(Arrays.toString(takeChangeItem.get()));
//            textArea1.setText("Take the change: " + change + "$\n");
    }

    void cancelOrder() {
        textArea1.append(Arrays.toString(cancelOrderItem.get()));
//        textArea1.setText("Take Your the money: " + textField3.getText() + "$\n" + "Come again\n\n");
//        menu();
        selectDrink();
    }


    void checkAddMoney() {
        textArea1.append(Arrays.toString(checkAddMoneyItem));
//        textArea1.setText("Not enough money for a drink\n" + "Add money\n");
    }

    public void checkBadMoney() {
        money = Integer.parseInt(textField3.getText());
        textArea1.append(Arrays.toString(checkBadMoneyItem.get()));
//        textArea1.setText("Introduced not correct money\n" + "Take this money " + money + "$\n");
//        menu();
        selectDrink();
    }


    void selectAddRecipe() {

        for (int i = 0; i < menuList.size(); i++) {
            i++;
        }
        if (menuList.get(0).equals(textField1.getText()))
            textField1.setText(recipeCoffee.getName2());
        else if (menuList.get(1).equals(textField1.getText()))
            textField1.setText(recipeCoffee.getName3());
    }

    void selesctMinusRecipe() {

        int i = 0;
        for (menuList.size(); i >= 0; i--) {
            i--;
        }
        if (menuList.get(2).equals(textField1.getText()))
            textField1.setText(recipeCoffee.getName2());
        else if (menuList.get(1).equals(textField1.getText()))
            textField1.setText(recipeCoffee.getName1());
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public void setTextField1(JTextField textField1) {
        this.textField1 = textField1;
    }

    private void button1ActionPerformed(ActionEvent e) {

        selectAddRecipe();
    }

    private void button2ActionPerformed(ActionEvent e) {
        selesctMinusRecipe();

    }

    private void button3ActionPerformed(ActionEvent e) {
        menuSugar();
    }

    private void button4ActionPerformed(ActionEvent e) {
        addSugar();
    }

    private void button5ActionPerformed(ActionEvent e) {
        this.e = e;
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

        if (textField1.getText().equals(menuList.get(0)))
            checkMoneyEspresso();
        else if (textField1.getText().equals(menuList.get(1)))
            checkMoneyAmericano();
        else if (textField1.getText().equals(menuList.get(2)))
            checkMoneyCappuccino();
    }

    private void button10ActionPerformed(ActionEvent e) {
        checkMoneyList.clear();
        cancelOrder();
    }

    private void button11ActionPerformed(ActionEvent e) {

        makeDrink();
    }

    private void list1ValueChanged(ListSelectionEvent e) {

    }

    public JTextArea getTextArea1() {
        return textArea1;
    }

    private void button9ItemStateChanged(ItemEvent e) {

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Nik Nik
        panel1 = new JPanel();
        panel2 = new JPanel();
        scrollPane1 = new JScrollPane();
        scrollPane2 = new JScrollPane();
        textArea1 = new JTextArea();
        panel3 = new JPanel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        label5 = new JLabel();
        label1 = new JLabel();
        textField1 = new JTextField();
        button4 = new JButton();
        button5 = new JButton();
        textField2 = new JTextField();
        label2 = new JLabel();
        button6 = new JButton();
        button7 = new JButton();
        button8 = new JButton();
        textField3 = new JTextField();
        label3 = new JLabel();
        button9 = new JButton();
        button10 = new JButton();
        label4 = new JLabel();
        button11 = new JButton();
        desktopPane2 = new JDesktopPane();
        label6 = new JLabel();

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

            // JFormDesigner evaluation mark
            panel1.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                            "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                            javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                            java.awt.Color.red), panel1.getBorder()));
            panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                public void propertyChange(java.beans.PropertyChangeEvent e) {
                    if ("border".equals(e.getPropertyName())) throw new RuntimeException();
                }
            });

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
                panel3.setBackground(new Color(204, 204, 204));
                panel3.setLayout(null);

                //---- button1 ----
                button1.setText("+");
                button1.addActionListener(e -> button1ActionPerformed(e));
                panel3.add(button1);
                button1.setBounds(new Rectangle(new Point(20, 30), button1.getPreferredSize()));

                //---- button2 ----
                button2.setText("-");
                button2.addActionListener(e -> button2ActionPerformed(e));
                panel3.add(button2);
                button2.setBounds(new Rectangle(new Point(60, 30), button2.getPreferredSize()));

                //---- button3 ----
                button3.setText(">");
                button3.addActionListener(e -> button3ActionPerformed(e));
                panel3.add(button3);
                button3.setBounds(new Rectangle(new Point(180, 30), button3.getPreferredSize()));

                //---- label5 ----
                label5.setText("Menu");
                label5.setFont(new Font("Dialog", Font.BOLD, 16));
                panel3.add(label5);
                label5.setBounds(new Rectangle(new Point(15, 5), label5.getPreferredSize()));

                //---- label1 ----
                label1.setText("coffee drink");
                label1.setForeground(new Color(153, 102, 0));
                panel3.add(label1);
                label1.setBounds(105, 10, 70, 20);

                //---- textField1 ----
                textField1.setText("Espresso");
                textField1.setBackground(new Color(0, 0, 153));
                textField1.setForeground(new Color(255, 153, 102));
                textField1.setFont(new Font("sansserif", Font.PLAIN, 14));
                panel3.add(textField1);
                textField1.setBounds(100, 30, 80, 25);

                //---- button4 ----
                button4.setText("+");
                button4.addActionListener(e -> button4ActionPerformed(e));
                panel3.add(button4);
                button4.setBounds(new Rectangle(new Point(20, 60), button4.getPreferredSize()));

                //---- button5 ----
                button5.setText("-");
                button5.addActionListener(e -> button5ActionPerformed(e));
                panel3.add(button5);
                button5.setBounds(new Rectangle(new Point(60, 60), button5.getPreferredSize()));

                //---- textField2 ----
                textField2.setSelectedTextColor(new Color(0, 0, 51));
                textField2.setBackground(new Color(0, 0, 102));
                textField2.setForeground(Color.yellow);
                textField2.setFont(textField2.getFont().deriveFont(textField2.getFont().getSize() + 6f));
                textField2.setText("0");
                textField2.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
                panel3.add(textField2);
                textField2.setBounds(100, 55, 35, 30);

                //---- label2 ----
                label2.setText("sugar");
                label2.setForeground(new Color(51, 51, 51));
                panel3.add(label2);
                label2.setBounds(new Rectangle(new Point(140, 60), label2.getPreferredSize()));

                //---- button6 ----
                button6.setText(">");
                button6.addActionListener(e -> button6ActionPerformed(e));
                panel3.add(button6);
                button6.setBounds(new Rectangle(new Point(180, 60), button6.getPreferredSize()));

                //---- button7 ----
                button7.setText("+");
                button7.addActionListener(e -> button7ActionPerformed(e));
                panel3.add(button7);
                button7.setBounds(new Rectangle(new Point(20, 90), button7.getPreferredSize()));

                //---- button8 ----
                button8.setText("-");
                button8.addActionListener(e -> button8ActionPerformed(e));
                panel3.add(button8);
                button8.setBounds(new Rectangle(new Point(60, 90), button8.getPreferredSize()));

                //---- textField3 ----
                textField3.setBackground(new Color(0, 0, 102));
                textField3.setForeground(Color.green);
                textField3.setFont(new Font("sansserif", Font.PLAIN, 18));
                textField3.setText("1");
                textField3.setColumns(10);
                textField3.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
                panel3.add(textField3);
                textField3.setBounds(100, 90, 35, 30);

                //---- label3 ----
                label3.setText("money");
                label3.setForeground(new Color(0, 153, 102));
                panel3.add(label3);
                label3.setBounds(new Rectangle(new Point(140, 95), label3.getPreferredSize()));

                //---- button9 ----
                button9.setText(">");
                button9.addActionListener(e -> button9ActionPerformed(e));
                button9.addItemListener(e -> button9ItemStateChanged(e));
                panel3.add(button9);
                button9.setBounds(new Rectangle(new Point(180, 90), button9.getPreferredSize()));

                //---- button10 ----
                button10.setText("Yes");
                button10.addActionListener(e -> button10ActionPerformed(e));
                panel3.add(button10);
                button10.setBounds(new Rectangle(new Point(40, 120), button10.getPreferredSize()));

                //---- label4 ----
                label4.setText("   order");
                panel3.add(label4);
                label4.setBounds(95, 125, 45, label4.getPreferredSize().height);

                //---- button11 ----
                button11.setText("Non");
                button11.addActionListener(e -> button11ActionPerformed(e));
                panel3.add(button11);
                button11.setBounds(new Rectangle(new Point(150, 120), button11.getPreferredSize()));

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
            panel1.add(desktopPane2);
            desktopPane2.setBounds(235, 160, 235, 250);
            panel1.add(label6);
            label6.setBounds(0, 160, 235, 250);

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
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration -  MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Nik Nik
    private JPanel panel1;
    private JPanel panel2;
    private JScrollPane scrollPane1;
    private JScrollPane scrollPane2;
    private JTextArea textArea1;
    private JPanel panel3;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JLabel label5;
    private JLabel label1;
    private JTextField textField1;
    private JButton button4;
    private JButton button5;
    JTextField textField2;
    private JLabel label2;
    private JButton button6;
    JButton button7;
    JButton button8;
    JTextField textField3;
    private JLabel label3;
    JButton button9;
    private JButton button10;
    private JLabel label4;
    private JButton button11;
    private JDesktopPane desktopPane2;
    private JLabel label6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public void start() {
        EventQueue.invokeLater(() -> {
            try {
                Gui frame = new Gui();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

}

