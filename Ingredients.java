/**
 * Created by mi on 14.03.2016.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Ingredients {

    static Map<String, Integer> map = new HashMap<>();
    private Gui gui;

    private MenuCoffee menuCoffee;
    static int coffee;
    static int water;
    static int milk;
    private static int sugar;

    private int coffeeMin = 7;
    private int coffeeMax = 14;

    private int waterMin = 30;
    private int waterMax = 350;

    private int milkrMin = 70;
    private int milkMax = 280;

    private int sugarMin = 4;
    private int sugarMax = 20;

    int countCoffee;
    int countWater;
    int countMilk;
    int countSugar;
    static int a;

    //   MenuCoffee mc = new MenuCoffee();
//    Bank bn = new Bank();

    public Ingredients(MenuCoffee menuCoffee) {
        this.menuCoffee = menuCoffee;
    }

    public Ingredients(Gui igredients) {
        this.gui = igredients;
        //       this.gui = a;
    }

    public Ingredients(int coffee, int water, int milk, int sugar) {
        Ingredients.coffee = coffee;
        Ingredients.water = water;
        Ingredients.milk = milk;
        Ingredients.sugar = sugar;
    }

    public Ingredients() {

    }

//    public Ingredients(int a) {
//        this.gui = a;
//    }

    public void addIngradientsStock() {

        System.out.println("Ingredients add in stock: " + map.toString());
        map.clear();
        fillStock();
    }

    public void fillStock() {

        map.clear();
        map.put("coffee", 0);
        map.put("milk", 0);
        map.put("water", 0);
        map.put("sugar", 0);
    }

    public void showIngradients() {

        countCoffee = coffeeMax - map.getOrDefault("coffee", coffee);
        countWater = waterMax - map.getOrDefault("water", water);
        countMilk = milkMax - map.getOrDefault("milk", milk);
        countSugar = sugarMax - map.getOrDefault("sugar", sugar);
        System.out.println("Ingredients  was in stock  : {" +
                "coffee=" + coffeeMax +
                ", milk=" + milkMax +
                ", water=" + waterMax +
                ", sugar=" + sugarMax +
                '}');
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Ingredients  are in stock  : {" +
                "coffee=" + countCoffee +
                ", milk=" + countMilk +
                ", water=" + countWater +
                ", sugar=" + countSugar +
                '}';
    }

    int checkIngradients() {

        if (map.getOrDefault("coffee", coffee) >= getCoffeeMax() ||
                map.getOrDefault("water", water) >= getWaterMax() ||
                map.getOrDefault("milk", milk) >= getMilkMax() ||
                map.getOrDefault("sugar", sugar) >= getSugarMax()) {
            System.out.println("Ingradients were cleared!!!");
 //           gui.getTextArea1().setText(" Ingradients were cleared !!!\n");
            gui.getTextArea1().append(Arrays.toString(gui.cleanedIngrItem));
            a = 1;
        } else
            a = 0;
        return a;
    }



    public void takeIngredientsStock() {

        if (!map.isEmpty()) {

            int value = map.get("coffee");
            map.put("coffee", value + coffee);
            System.out.println("У coffee стало " + map.get("coffee"));

            int value1 = map.get("milk");
            map.put("milk", value1 + milk);
            System.out.println("У milk стало " + map.get("milk"));

            int value2 = map.get("water");
            map.put("water", value2 + water);
            System.out.println("У water стало " + map.get("water"));

            int value3 = map.get("sugar");
            map.put("sugar", value3 + sugar);
            System.out.println("У sugar стало " + map.get("sugar"));
        } else
            fillStock();
    }

    public int getSugarMax() {
        return sugarMax;
    }

    public int getMilkMax() {
        return milkMax;
    }

    public int getWaterMax() {
        return waterMax;
    }

    public int getCoffeeMax() {
        return coffeeMax;
    }

    public static int getSugar() {
        return sugar;
    }

    public static void setSugar(int sugar) {
        Ingredients.sugar = sugar;
    }

    public static void setCoffee(int coffee) {
        Ingredients.coffee = coffee;
    }

    public static int getCoffee() {
        return coffee;
    }

    public static void setWater(int water) {
        Ingredients.water = water;
    }

    public static int getWater() {
        return water;
    }

    public static void setMilk(int milk) {
        Ingredients.milk = milk;
    }

    public static int getMilk() {
        return milk;
    }

}


