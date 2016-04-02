
import java.util.Arrays;

public class AdminIngradient {

    private Gui gui;
    Ingredients ing = new Ingredients(this);
    String passIngr = "i";
    String loginIngr = "1";
    String[] passwordIngrItem = {" Welcome to menuAdminIngradients\n" + " Enter password\n"};
    String[] accessAdminIngrItem = {" \nAccess Granted!\n\n" + " add Ingradients - \n" +
            "press button Yes\n" + " See how many Ingradients in store - \n" + "press button No\n"};
    String[] addIngrItem = {" Added Ingradients in store\n"};
    final ThreadLocal<String[]> showIngrItem = new ThreadLocal<String[]>() {
        @Override
        protected String[] initialValue() {
            return new String[]{" Ingradients in store is left:\n" + " coffee= " + ing.getIsLeftCoffee() + ",\n" +
                    " milk=" + ing.getIsLeftMilk() + ",\n" + " water=" + ing.getIsLeftWater() + ",\n" + " sugar=" + ing.getIsLeftSugar() + "\n"};
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


