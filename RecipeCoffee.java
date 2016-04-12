
class RecipeCoffee {

    private Gui gui;
    private static String name = " ";
    private String name1;
    private String name2;
    private String name3;
    private int priceAmericano;
    private int priceEspresso;
    private int priceCappuccino;
    private static int price;
    private int cost = 0;

    RecipeCoffee(Gui recipeCoffee) {
        this.gui = recipeCoffee;
        name = " ";
        name1 = "Espresso";
        name2 = "Americano";
        name3 = "Cappuccino";
        price = 0;
        priceEspresso = 5;
        priceAmericano = 7;
        priceCappuccino = 9;
    }

    RecipeCoffee() {
        priceEspresso = 5;
        priceAmericano = 7;
        priceCappuccino = 9;
    }

    private void selectSugar(String name) {
        if (Ingredients.getSugar() > 0)
            gui.getTextArea1().setText(" Preparing drink: " + name + "\n" +
                    " coffee- " + Ingredients.getCoffee() + ", water-" +
                    Ingredients.getWater() + ", milk-" + Ingredients.getMilk() + " cost-" + getCost() + "$\n" +
                    " coffee ready with sugar-" + Ingredients.getSugar() + "\n\n");
        else
            gui.getTextArea1().setText(" Preparing drink: " + name + "\n" +
                    " coffee- " + Ingredients.getCoffee() + ", water-" +
                    Ingredients.getWater() + ", milk-" + Ingredients.getMilk() + ", cost-" + getCost() + "$\n" +
                    " coffee ready sugarless\n\n");
    }

    void recipeEspresso() {
        name = setName(name1);
        cost = 0;
        Ingredients ingr = new Ingredients();
        Ingredients.setCoffee(7);
        Ingredients.setWater(30);
        Ingredients.setSugar(Ingredients.getSugar());
        setCost(5);
        price = setPrice(priceCappuccino);
        ingr.takeIngredientsStock();
        selectSugar(name);
    }

    void recipeAmericano() {
        name = setName(name2);
        Ingredients ingr = new Ingredients();
        Ingredients.setCoffee(7);
        Ingredients.setWater(100);
        Ingredients.setSugar(Ingredients.getSugar());
        setCost(7);
        price = setPrice(priceAmericano);
        ingr.takeIngredientsStock();
        selectSugar(name);
    }

    void recipeCappuccino() {
        name = setName(name3);
        Ingredients ingr = new Ingredients();
        Ingredients.setCoffee(7);
        Ingredients.setWater(30);
        Ingredients.setMilk(70);
        Ingredients.setSugar(Ingredients.getSugar());
        setCost(9);
        price = setPrice(priceCappuccino);
        ingr.takeIngredientsStock();
        selectSugar(name);
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
        return priceAmericano;
    }

    int getPriceEspresso() {
        return priceEspresso;
    }

    int getPriseCappuccino() {
        return priceCappuccino;
    }

    int getPrice() {
        return price;
    }

    private static String setName(String name) {
        RecipeCoffee.name = name;
        return name;
    }

    private static int setPrice(int price) {
        RecipeCoffee.price = price;
        return price;
    }
}

