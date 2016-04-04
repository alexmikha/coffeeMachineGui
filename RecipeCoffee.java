
class RecipeCoffee {

    private Gui gui;
    private static String name = " ";
    private String name1;
    private String name2;
    private String name3;
    private int priseAmericano;
    private int priseEspresso;
    private int priseCappuccino;
    private static int prise;
    private int cost = 0;

    RecipeCoffee(Gui recipeCoffee) {
        this.gui = recipeCoffee;
        name = " ";
        name1 = "Espresso";
        name2 = "Americano";
        name3 = "Cappuccino";
        prise = 0;
        priseEspresso = 5;
        priseAmericano = 7;
        priseCappuccino = 9;
    }

    RecipeCoffee() {
        priseEspresso = 5;
        priseAmericano = 7;
        priseCappuccino = 9;
    }

    private void selectSugar(String name) {
        if (Ingredients.getSugar() > 0) {
            gui.getTextArea1().setText(" Preparing drink: " + name + "\n" +
                    " coffee- " + Ingredients.getCoffee() + " water-" +
                    Ingredients.getWater() + " milk-" + Ingredients.getMilk() + " cost-" + getCost() + "$\n" + " coffee ready with sugar-" +
                    Ingredients.getSugar() + "\n\n");

        } else {
            if (Ingredients.getSugar() == 0) {
                gui.getTextArea1().setText(" Preparing drink: " + name + "\n" +
                        " coffee- " + Ingredients.getCoffee() + " water-" +
                        Ingredients.getWater() + " milk-" + Ingredients.getMilk() + " cost-" + getCost() + "$\n" + " coffee ready sugarless\n\n");
            }
        }
    }

    void recipeEspresso(int coffee, int water, int sugar) {
        name = setName(name1);
        int milk = 0;
        cost = 0;
        Ingredients ingr = new Ingredients(coffee, water, milk, sugar);
        Ingredients.setCoffee(7);
        Ingredients.setWater(30);
        Ingredients.setSugar(Ingredients.getSugar());
        setCost(5);
        prise = setPrise(priseCappuccino);
        selectSugar(name);
        ingr.takeIngredientsStock();
    }

    void recipeAmericano(int coffee, int water, int sugar) {
        name = setName(name2);
        int milk = 0;
        Ingredients ingr = new Ingredients(coffee, water, milk, sugar);
        Ingredients.setCoffee(7);
        Ingredients.setWater(100);
        Ingredients.setSugar(Ingredients.getSugar());
        setCost(7);
        prise = setPrise(priseAmericano);
        selectSugar(name);
        ingr.takeIngredientsStock();
    }

    void recipeCappuccino(int coffee, int water, int milk, int sugar) {
        name = setName(name3);
        Ingredients ingr = new Ingredients(coffee, water, milk, sugar);
        Ingredients.setCoffee(7);
        Ingredients.setWater(30);
        Ingredients.setMilk(70);
        Ingredients.setSugar(Ingredients.getSugar());
        setCost(9);
        prise = setPrise(priseCappuccino);
        selectSugar(name);
        ingr.takeIngredientsStock();
    }

    int getCost() {
        return cost;
    }


    private void setCost(int cost) {
        this.cost = cost;
    }

    String getName() {
        return name;
    }

    String getName1() {
        return name1;
    }

    String getName2() {
        return name2;
    }

    String getName3() {
        return name3;
    }

    int getPriseAmericano() {
        return priseAmericano;
    }

    int getPriseEspresso() {
        return priseEspresso;
    }

    int getPriseCappuccino() {
        return priseCappuccino;
    }

    int getPrise() {
        return prise;
    }

    private static String setName(String name) {
        RecipeCoffee.name = name;
        return name;
    }

    private static int setPrise(int prise) {
        RecipeCoffee.prise = prise;
        return prise;
    }
}

