/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author A S U S
 */

public class Order {
    private User user;
    private Cart cart;

    public Order(User user) {
        this.user = user;
        this.cart = new Cart();
    }

    public void addItemToCart(FoodItem foodItem) {
        cart.addItem(foodItem);
    }

    public void removeItemFromCart(int index) {
        cart.removeItem(index);
    }

    public Cart getCart() {
        return cart;
    }

    public User getUser() {
        return user;
    }
}
