-- tabel data pengguna
CREATE TABLE Pengguna (
    UserID SERIAL PRIMARY KEY,
    Nama VARCHAR(50) NOT NULL,
    Email VARCHAR(50) NOT NULL,
    Password VARCHAR(25) NOT NULL,
    Alamat VARCHAR(100) NOT NULL,
    NomorTelepon VARCHAR(15) NOT NULL
);

-- tabel data restoran
CREATE TABLE Restaurant (
    RestaurantID SERIAL PRIMARY KEY,
    NamaRestoran VARCHAR(50) NOT NULL,
    Alamat VARCHAR(100) NOT NULL,
    NomorTelepon VARCHAR(15) NOT NULL,
    JamOperasional VARCHAR(50) NOT NULL
);

-- tabel pemesanan
CREATE TABLE Pemesanan (
    OrderID SERIAL PRIMARY KEY,
    UserID INTEGER REFERENCES Pengguna(UserID),
    RestaurantID INTEGER REFERENCES Restaurant(RestaurantID),
    TanggalPemesanan DATE,
    StatusPemesanan VARCHAR(20)
);

-- tabel data makanan
CREATE TABLE FoodItem (
    FoodItemID SERIAL PRIMARY KEY,
    NamaMakanan VARCHAR(100) NOT NULL,
    Deskripsi TEXT,
    Harga DECIMAL(10, 2)
);

-- tabel keranjang belanja
CREATE TABLE Cart (
    CartID SERIAL PRIMARY KEY,
    UserID INTEGER REFERENCES Pengguna(UserID),
    FoodItemID INTEGER REFERENCES FoodItem(FoodItemID),
    Kuantitas INTEGER
);

SELECT * FROM pengguna;