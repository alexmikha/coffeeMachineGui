
import java.util.Arrays;

class AdminIngradient {

    private Gui gui;
    private Ingredients ing = new Ingredients();
    String passIngr = "i";
    String loginIngr = "1";
    private String[] passwordIngrItem = {" Welcome to menuAdminIngradients\n" + " Enter password\n"};
    private String[] accessAdminIngrItem = {" \nAccess Granted!\n\n" + " Add Ingradients - \n" +
            "press button Yes\n" + " See how many Ingradients in store - \n" + "press button No\n"};
    private String[] addIngrItem = {" Added Ingradients in store\n"};
    private final ThreadLocal<String[]> showIngrItem = new ThreadLocal<String[]>() {
        @Override
        protected String[] initialValue() {
            return new String[]{" Ingradients in store is left:\n" + " coffee= " + Ingredients.getIsLeftCoffee() + ",\n" +
                    " milk=" + Ingredients.getIsLeftMilk() + ",\n" + " water=" + Ingredients.getIsLeftWater() + ",\n" +
                    " sugar=" + Ingredients.getIsLeftSugar() + "\n"};
        }
    };

    AdminIngradient(Gui gui) {
        this.gui = gui;
    }

    void controlLoginIngr() {
        if (gui.getTextField1().getText().equals(loginIngr)) {
            gui.getTextArea1().append(Arrays.toString(passwordIngrItem));
            gui.getTextField1().setText("password");
        }
    }

    void controlPaswordIngr() {
        if (gui.getTextField1().getText().equals(passIngr)) {
            gui.getTextArea1().append(Arrays.toString(accessAdminIngrItem));
            gui.button10.setEnabled(true);
            gui.button11.setEnabled(true);
        }
    }

    void lookStockIngr() {
        ing.showIngradients();
        gui.getTextArea1().append(Arrays.toString(ing.showIngr1Item.get()));
    }

    void addIngradient() {
        ing.showIngradients();
        gui.getTextArea1().append(Arrays.toString(showIngrItem.get()));
        gui.getTextArea1().append(Arrays.toString(ing.showIngr1Item.get()));
        gui.getTextArea1().append(Arrays.toString(addIngrItem));
        ing.addIngradientsStock();
    }
}


