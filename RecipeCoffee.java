/**
 * Created by mi on 14.03.2016.
 */
//import static coffeeMachineGui.Ingredients.*;

public class RecipeCoffee {

    private Gui gui;
    private String name = " ";
    private String name1;
    private String name2;
    private String name3;
    private int priseAmericano;
    private int priseEspresso;
    private int priseCappuccino;

    Ingredients ingr = new Ingredients();
    private int cost = 0;

    public RecipeCoffee(Gui recipeCoffee) {
        this.gui = recipeCoffee;
        //       this.gui = selectSugar;
        name = " ";
        name1 = "Espresso";
        name2 = "Americano";
        name3 = "Cappuccino";

        priseEspresso = 5;
        priseAmericano = 7;
        priseCappuccino = 9;
    }

    public RecipeCoffee() {

    }


    void selectSugar(String name) {

        if (ingr.getSugar() > 0) {
            System.out.println(" coffee- " + ingr.getCoffee() + " water-" +
                    ingr.getWater() + " cost-" + getCost() + "$" + " coffee ready with sugar-" + ingr.getSugar());

            gui.getTextArea1().setText(" Preparing drink: " + name + "\n" +
                    " coffee- " + ingr.getCoffee() + " water-" +
                    ingr.getWater() + " cost-" + getCost() + "$\n" + " coffee ready with sugar-" + ingr.getSugar()+ "\n\n");

        }else {
            if (ingr.getSugar() == 0) {
                System.out.println(" coffee- " + ingr.getCoffee() + " water-" +
                        ingr.getWater() + " cost-" + getCost() + "$" + " coffee ready sugarless");
                gui.getTextArea1().setText(" Preparing drink: " + name + "\n" +
                        " coffee- " + ingr.getCoffee() + " water-" +
                        ingr.getWater() + " cost-" + getCost() + "$\n" + " coffee ready sugarless\n\n");
            }
        }
    }

    void recipeEspresso(int coffee, int water, int sugar, int cost) {

        name = name1;
        int milk = 0;
        Ingredients ingr = new Ingredients(coffee, water, milk, sugar);
        ingr.setCoffee(7);
        ingr.setWater(30);
        ingr.setSugar(Gui.getSugar());
        setCost(5);
//        System.out.println("Preparing drink: " + getName1());
//        System.out.println("sugar_gui " + sugar);
//        System.out.println("sugar_ing " + getSugar());
        selectSugar(name);
        ingr.takeIngredientsStock();

    }

    public int recipeAmericano(int coffee, int water, int sugar, int cost) {
        name = name2;
        int milk = 0;
        Ingredients ingr = new Ingredients(coffee, water, milk, sugar);
        ingr.setCoffee(7);
        ingr.setWater(100);
        ingr.setSugar(ingr.getSugar());
        setCost(7);
        selectSugar(name);
        ingr.takeIngredientsStock();
        return 0;
    }

    public int recipeCappuccino(int coffee, int water, int milk, int sugar, int cost) {
        name = name3;
        Ingredients ingr = new Ingredients(coffee, water, milk, sugar);
        ingr.setCoffee(7);
        ingr.setWater(30);
        ingr.setMilk(70);
        ingr.setSugar(ingr.getSugar());
        setCost(9);
        selectSugar(name);
        ingr.takeIngredientsStock();
        return 0;
    }

    public int getEspresso() {
        return 5;
    }

    public int getAmericano() {
        return 7;
    }

    public int getCappuccino() {
        return 9;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public String getName1() {
        return name1;
    }

    public String getName2() {
        return name2;
    }

    public String getName3() {
        return name3;
    }

    public int getPriseAmericano() {
        return priseAmericano;
    }

    public void setPriseAmericano(int priseAmericano) {
        this.priseAmericano = priseAmericano;
    }

    public int getPriseEspresso() {
        return priseEspresso;
    }

    public void setPriseEspresso(int priseEspresso) {
        this.priseEspresso = priseEspresso;
    }

    public int getPriseCappuccino() {
        return priseCappuccino;
    }

    public void setPriseCappuccino(int priseCappucino) {
        this.priseCappuccino = priseCappucino;
    }

}

