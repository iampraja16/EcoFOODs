/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author A S U S
 */
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private List<FoodItem> availableFoods;

    public Restaurant() {
        this.availableFoods = new ArrayList<>();
    }

    public void addFoodItem(FoodItem foodItem) {
        availableFoods.add(foodItem);
    }

    public List<FoodItem> getAvailableFoods() {
        return availableFoods;
    }

    public void updateFoodItem(int index, FoodItem foodItem) {
        availableFoods.set(index, foodItem);
    }

    public void removeFoodItem(int index) {
        availableFoods.remove(index);
    }
}
