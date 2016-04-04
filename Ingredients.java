
import java.util.HashMap;
import java.util.Map;

class Ingredients {

    private static Map<String, Integer> map = new HashMap<>();
    final ThreadLocal<String[]> showIngr1Item = new ThreadLocal<String[]>() {
        @Override
        protected String[] initialValue() {
            return new String[]{"Ingredients added to the store: \n" + map.toString()};
        }
    };
    private static int coffee;
    private static int water;
    private static int milk;
    private static int sugar;
    //    private int coffeeMin = 7;
    private int coffeeMax = 21;
    //    private int waterMin = 30;
    private int waterMax = 350;
    //    private int milkrMin = 70;
    private int milkMax = 280;
    //    private int sugarMin = 4;
    private int sugarMax = 20;

    private static int isLeftCoffee = 0;
    private static int isLeftWater = 0;
    private static int isLeftMilk = 0;
    private static int isLeftSugar = 0;
    static int a;

    Ingredients() {
    }

    Ingredients(int coffee, int water, int milk, int sugar) {
        Ingredients.coffee = coffee;
        Ingredients.water = water;
        Ingredients.milk = milk;
        Ingredients.sugar = sugar;
    }

    void addIngradientsStock() {
        map.clear();
        fillStock();
    }

    void fillStock() {
        map.clear();
        map.put("coffee", 0);
        map.put("milk", 0);
        map.put("water", 0);
        map.put("sugar", 0);
    }

    void showIngradients() {
        isLeftCoffee = coffeeMax - map.getOrDefault("coffee", coffee);
        setIsLeftCoffee(isLeftCoffee);
        isLeftWater = waterMax - map.getOrDefault("water", water);
        setIsLeftWater(isLeftWater);
        isLeftMilk = milkMax - map.getOrDefault("milk", milk);
        setIsLeftMilk(isLeftMilk);
        isLeftSugar = sugarMax - map.getOrDefault("sugar", sugar);
        setIsLeftSugar(isLeftSugar);
    }

    @Override
    public String toString() {
        return " Ingredients  are in stock: \n" +
                " coffee=" + isLeftCoffee + "\n" +
                " milk=" + isLeftMilk + "\n" +
                " water=" + isLeftWater + "\n" +
                " sugar=" + isLeftSugar + "\n";
    }

    int checkIngradients() {
        if (map.getOrDefault("coffee", coffee) >= getCoffeeMax() ||
                map.getOrDefault("water", water) >= getWaterMax() ||
                map.getOrDefault("milk", milk) >= getMilkMax() ||
                map.getOrDefault("sugar", sugar) >= getSugarMax()) {
            a = 1;
        } else
            a = 0;
        return a;
    }

    void takeIngredientsStock() {
        if (!map.isEmpty()) {

            int value = map.get("coffee");
            map.put("coffee", value + coffee);

            int value1 = map.get("milk");
            map.put("milk", value1 + milk);

            int value2 = map.get("water");
            map.put("water", value2 + water);

            int value3 = map.get("sugar");
            map.put("sugar", value3 + sugar);
        } else
            fillStock();
    }

    private int getSugarMax() {
        return sugarMax;
    }

    private int getMilkMax() {
        return milkMax;
    }

    private int getWaterMax() {
        return waterMax;
    }

    private int getCoffeeMax() {
        return coffeeMax;
    }

    static int getSugar() {
        return sugar;
    }

    static void setSugar(int sugar) {
        Ingredients.sugar = sugar;
    }

    static void setCoffee(int coffee) {
        Ingredients.coffee = coffee;
    }

    static int getCoffee() {
        return coffee;
    }

    static void setWater(int water) {
        Ingredients.water = water;
    }

    static int getWater() {
        return water;
    }

    static void setMilk(int milk) {
        Ingredients.milk = milk;
    }

    static int getMilk() {
        return milk;
    }

//    public static Map<String, Integer> getMap() {
//        return map;
//    }

    static int getIsLeftCoffee() {
        return isLeftCoffee;
    }

    private static void setIsLeftCoffee(int isLeftCoffee) {
        Ingredients.isLeftCoffee = isLeftCoffee;
    }

    static int getIsLeftWater() {
        return isLeftWater;
    }

    private static void setIsLeftWater(int isLeftWater) {
        Ingredients.isLeftWater = isLeftWater;
    }

    static int getIsLeftMilk() {
        return isLeftMilk;
    }

    private static void setIsLeftMilk(int isLeftMilk) {
        Ingredients.isLeftMilk = isLeftMilk;
    }

    static int getIsLeftSugar() {
        return isLeftSugar;
    }

    private static void setIsLeftSugar(int isLeftSugar) {
        Ingredients.isLeftSugar = isLeftSugar;
    }
}


