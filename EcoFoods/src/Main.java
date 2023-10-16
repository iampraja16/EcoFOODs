/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author A S U S
 */
import java.util.List;
import java.util.Scanner;
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Daftar pengguna
        User user1 = new User("yada.mo171094@gmail.com", "Yakuza171094*");

        // Restoran
        Restaurant restaurant = new Restaurant();
        restaurant.addFoodItem(new FoodItem("Nasi Goreng", 5.0));
        restaurant.addFoodItem(new FoodItem("Mie Goreng", 4.5));

        User currentUser = null;
        boolean isLoggedIn = false;

        // Login
        while (!isLoggedIn) {
            System.out.print("Masukkan email: ");
            String email = scanner.next();
            System.out.print("Masukkan password: ");
            String password = scanner.next();

            if (email.equals(user1.getEmail()) && password.equals(user1.getPassword())) {
                currentUser = user1;
                isLoggedIn = true;
            } else {
                System.out.println("email atau password salah. Silakan coba lagi.");
            }
        }

        // Operasi CRUD
        boolean continueRunning = true;
        while (continueRunning) {
            System.out.println("Pilih operasi yang ingin Anda lakukan:");
            System.out.println("1. Tambah Makanan");
            System.out.println("2. Lihat Makanan");
            System.out.println("3. Perbarui Makanan");
            System.out.println("4. Hapus Makanan");
            System.out.println("5. Pesan Makanan");
            System.out.println("6. Keluar");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    // Tambah Makanan
                    System.out.print("Masukkan nama makanan: ");
                    String foodName = scanner.next();
                    System.out.print("Masukkan harga makanan: ");
                    double foodPrice = scanner.nextDouble();
                    FoodItem newFoodItem = new FoodItem(foodName, foodPrice);
                    restaurant.addFoodItem(newFoodItem);
                    System.out.println("Makanan berhasil ditambahkan.");
                    break;
                case 2:
                    // Lihat Makanan
                    List<FoodItem> foods = restaurant.getAvailableFoods();
                    for (int i = 0; i < foods.size(); i++) {
                        System.out.println((i + 1) + ". " + foods.get(i).getItemName() +
                                " - Rp" + foods.get(i).getPrice());
                    }
                    break;
                case 3:
                    // Perbarui Makanan
                    System.out.print("Masukkan nomor makanan yang ingin diperbarui: ");
                    int foodIndex = scanner.nextInt();
                    System.out.print("Masukkan nama makanan baru: ");
                    String updatedFoodName = scanner.next();
                    System.out.print("Masukkan harga makanan baru: ");
                    double updatedFoodPrice = scanner.nextDouble();
                    FoodItem updatedFoodItem = new FoodItem(updatedFoodName, updatedFoodPrice);
                    restaurant.updateFoodItem(foodIndex - 1, updatedFoodItem);
                    System.out.println("Makanan berhasil diperbarui.");
                    break;
                case 4:
                    // Hapus Makanan
                    System.out.print("Masukkan nomor makanan yang ingin dihapus: ");
                    int deleteIndex = scanner.nextInt();
                    restaurant.removeFoodItem(deleteIndex - 1);
                    System.out.println("Makanan berhasil dihapus.");
                    break;
                case 5:
                    // Pesan Makanan
                    Order order = new Order(currentUser);
                    Cart cart = order.getCart();

                    boolean continueOrdering = true;
                    while (continueOrdering) {
                        System.out.println("Daftar makanan yang tersedia:");
                        List<FoodItem> availableFoods = restaurant.getAvailableFoods();
                        for (int i = 0; i < availableFoods.size(); i++) {
                            System.out.println((i + 1) + ". " + availableFoods.get(i).getItemName() +
                                    " - Rp" + availableFoods.get(i).getPrice());
                        }

                        System.out.print("Pilih nomor makanan yang ingin dipesan (0 untuk selesai): ");
                        int selectedFoodIndex = scanner.nextInt();

                        if (selectedFoodIndex == 0) {
                            continueOrdering = false;
                        } else if (selectedFoodIndex >= 1 && selectedFoodIndex <= availableFoods.size()) {
                            FoodItem selectedFood = availableFoods.get(selectedFoodIndex - 1);
                            cart.addItem(selectedFood);
                            System.out.println("Pesanan " + selectedFood.getItemName() + " ditambahkan ke dalam keranjang.");
                        } else {
                            System.out.println("Nomor makanan tidak valid. Pesanan gagal ditambahkan.");
                        }
                    }

                    // Menampilkan keranjang dan total harga
                    List<FoodItem> cartItems = cart.getItems();
                    System.out.println("Pesanan Anda:");
                    for (int i = 0; i < cartItems.size(); i++) {
                        System.out.println((i + 1) + ". " + cartItems.get(i).getItemName() +
                                " - Rp" + cartItems.get(i).getPrice());
                    }
                    System.out.println("Total Harga: Rp" + cart.calculateTotal());
                    break;
                    case 6:
                    // Keluar dari aplikasi
                    continueRunning = false;
                    break;
                    default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }
    } 
}
