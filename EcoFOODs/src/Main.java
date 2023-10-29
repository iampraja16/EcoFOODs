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
import java.util.ArrayList;
public class Main 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        boolean continueRunning = true;
        
        int currentProcess = 0;
        // Daftar pengguna
        ArrayList<User> users = new ArrayList<>();

        Restaurant restaurant = new Restaurant();
        restaurant.addFoodItem(new FoodItem("Nasi Goreng", 15000));
        restaurant.addFoodItem(new FoodItem("Mie Goreng", 10000));

        User currentUser = null;

        while (continueRunning) 
        {
            switch (currentProcess)
            {
                case 0:
                    System.out.println("Selamat datang!");
                    System.out.println("Pilih operasi yang ingin Anda lakukan:");
                    System.out.println("1. Sign Up");
                    System.out.println("2. Sign In");
                    System.out.println("3. Keluar");

                    int choice = scanner.nextInt();
                    scanner.nextLine(); 

                    if (choice == 1) 
                    {
                        // Sign Up
                        User newUser = User.signUp();
                        users.add(newUser);
                        System.out.println("Akun berhasil dibuat. Silakan login.");
                        currentProcess = 0; // Pindah ke proses sign in setelah sign up
                    } 
                    else if (choice == 2)
                    {
                        // Sign In
                        System.out.print("Masukkan email: ");
                        String email = scanner.nextLine();
                        System.out.print("Masukkan password: ");
                        String password = scanner.nextLine();

                        boolean isLoggedIn = false;
                        for (User user : users) 
                        {
                            if (email.equals(user.getEmail()) && password.equals(user.getPassword())) 
                            {
                                currentUser = user;
                                isLoggedIn = true;
                                break;
                            }
                        }
                        if (isLoggedIn) 
                        {
                            System.out.println("Login berhasil.");
                            currentProcess = 1; // Pindah ke proses setelah sign in
                        } 
                        else 
                        {
                            System.out.println("Email atau password salah. Silakan coba lagi.");
                        }
                    } 
                    else if (choice == 3) 
                    {
                        // keluar app
                        System.out.println("Terima kasih! Sampai jumpa lagi.");
                        continueRunning = false;
                    } 
                    else 
                    {
                        System.out.println("Pilihan tidak valid.");
                    }
                    break;

                case 1:
                    System.out.println("Pilih operasi yang ingin Anda lakukan:");
                    System.out.println("1. Tambah Makanan");
                    System.out.println("2. Lihat Makanan");
                    System.out.println("3. Perbarui Makanan");
                    System.out.println("4. Hapus Makanan");
                    System.out.println("5. Pesan Makanan");
                    System.out.println("6. Keluar");

                    int menuChoice = scanner.nextInt();
                    switch (menuChoice)
                    {
                        case 1:
                            // Tambah Makanan
                            System.out.print("Masukkan nama makanan: ");
                            scanner.nextLine();
                            String foodName = scanner.nextLine();
                            System.out.print("Masukkan harga makanan: ");
                            double foodPrice = scanner.nextDouble();
                            FoodItem newFoodItem = new FoodItem(foodName, foodPrice);
                            restaurant.addFoodItem(newFoodItem);
                            System.out.println("Makanan berhasil ditambahkan.");
                            currentProcess = 1;
                            break;
                            

                        case 2:
                            // Lihat Makanan
                            List<FoodItem> foods = restaurant.getAvailableFoods();
                            for (int i = 0; i < foods.size(); i++) {
                                System.out.println((i + 1) + ". " + foods.get(i).getItemName() +
                                        " - Rp" + foods.get(i).getPrice());
                            }
                            currentProcess = 1;
                            break;

                        case 3:
                            // Perbarui Makanan
                            System.out.println("List makanan: ");
                            List<FoodItem> foods2 = restaurant.getAvailableFoods();
                            for (int i = 0; i < foods2.size(); i++) {
                                System.out.println((i + 1) + ". " + foods2.get(i).getItemName() +
                                        " - Rp" + foods2.get(i).getPrice());
                            }
                            System.out.print("Masukkan nomor makanan yang ingin diperbarui: ");
                            int foodIndex = scanner.nextInt();
                            System.out.print("Masukkan nama makanan baru: ");
                            scanner.nextLine();
                            String updatedFoodName = scanner.nextLine();
                            System.out.print("Masukkan harga makanan baru: ");
                            double updatedFoodPrice = scanner.nextDouble();
                            FoodItem updatedFoodItem = new FoodItem(updatedFoodName, updatedFoodPrice);
                            restaurant.updateFoodItem(foodIndex - 1, updatedFoodItem);
                            System.out.println("Makanan berhasil diperbarui.");
                            currentProcess = 1;
                            break;

                        case 4:
                            // Hapus Makanan
                            List<FoodItem> foods3 = restaurant.getAvailableFoods();
                            System.out.println("List makanan: ");
                            for (int i = 0; i < foods3.size(); i++) {
                                System.out.println((i + 1) + ". " + foods3.get(i).getItemName() +
                                        " - Rp" + foods3.get(i).getPrice());
                            }

                            System.out.print("Masukkan nomor makanan yang ingin dihapus: ");
                            int deleteIndex = scanner.nextInt();
                            restaurant.removeFoodItem(deleteIndex - 1);
                            System.out.println("Makanan berhasil dihapus.");
                            currentProcess = 1;
                            break;

                        case 5:
                            // Pesan Makanan
                            Order order = new Order(currentUser);
                            Cart cart = order.getCart();

                            boolean continueOrdering = true;
                            while (continueOrdering) 
                            {
                                System.out.println("Daftar makanan yang tersedia:");
                                List<FoodItem> availableFoods = restaurant.getAvailableFoods();
                                for (int i = 0; i < availableFoods.size(); i++) 
                                {
                                    System.out.println((i + 1) + ". " + availableFoods.get(i).getItemName() +
                                            " - Rp" + availableFoods.get(i).getPrice());
                                }

                                System.out.print("Pilih nomor makanan yang ingin dipesan (0 untuk selesai): ");
                                int selectedFoodIndex = scanner.nextInt();

                                if (selectedFoodIndex == 0) 
                                {
                                    continueOrdering = false;
                                } 
                                else if (selectedFoodIndex >= 1 && selectedFoodIndex <= availableFoods.size()) 
                                {
                                    FoodItem selectedFood = availableFoods.get(selectedFoodIndex - 1);
                                    cart.addItem(selectedFood);
                                    System.out.println("Pesanan " + selectedFood.getItemName() + " ditambahkan ke dalam keranjang.");
                                } 
                                else 
                                {
                                    System.out.println("Nomor makanan tidak valid. Pesanan gagal ditambahkan.");
                                }
                            }

                            // Menampilkan keranjang dan total harga
                            List<FoodItem> cartItems = cart.getItems();
                            System.out.println("Pesanan Anda:");
                            for (int i = 0; i < cartItems.size(); i++) 
                            {
                                System.out.println( (i + 1)+ ". "  + cartItems.get(i).getItemName() +
                                        " - Rp" + cartItems.get(i).getPrice());
                            }
                            System.out.println("Total Harga: Rp" + cart.calculateTotal());
                            currentProcess = 1;
                            break;
                            
                        case 6:
                            System.out.println("Terimakasih! sampai jumpa lagi yaa!");
                            continueRunning = true;
                            currentProcess = 0;
                            break;
                       
                        default:
                            System.out.println("Pilihan tidak valid");
                            break;
                    }
                    break;
                default:
                    System.out.println("Proses tidak valid");
                    continueRunning = false;
                    break;
            }
        }
    } 
}
