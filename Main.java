/**
 * Created by mi on 14.03.2016.
 */
public class Main {

        public static void main(String[] args) {

//        CoffeeMachinGui coffeeMachinGui = new CoffeeMachinGui();
//        coffeeMachinGui.start();
            Ingredients ingr = new Ingredients();
            ingr.fillStock();
            Gui gui = new Gui();
            gui.start();
        }
    }

