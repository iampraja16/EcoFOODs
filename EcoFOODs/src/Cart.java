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

public class Cart {
        private List<FoodItem> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void addItem(FoodItem foodItem) {
        items.add(foodItem);
    }

    public void removeItem(int index) {
        items.remove(index);
    }

    public List<FoodItem> getItems() {
        return items;
    }

    public double calculateTotal() {
        double total = 0;
        for (FoodItem item : items) {
            total += item.getPrice();
        }
        return total;
    }
}
