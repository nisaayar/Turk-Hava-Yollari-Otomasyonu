-- Yeni bir veritabanı oluştur
CREATE DATABASE IF NOT EXISTS thy;

-- Oluşturulan veritabanını kullan
USE thy;

-- Kullanıcılar tablosunu oluştur
CREATE TABLE IF NOT EXISTS kullanicilar (
    id INT AUTO_INCREMENT PRIMARY KEY,
    kullanici_adi VARCHAR(50) NOT NULL,
    sifre VARCHAR(100) NOT NULL,
    e_posta VARCHAR(100) NOT NULL,
    ad VARCHAR(50) NOT NULL,
    soyad VARCHAR(50) NOT NULL,
    uyruk VARCHAR(50) NOT NULL,
    dil VARCHAR(50),
    dogum_tarihi DATE,
    cinsiyet VARCHAR(10),
    ulke VARCHAR(50),
    sehir VARCHAR(50),
    posta_kodu VARCHAR(20),
    cep_telefonu VARCHAR(20),
    adres TEXT,
    e_posta_adresi VARCHAR(100) UNIQUE,
    kayit_tarihi TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE IF NOT EXISTS kullanici_tablosu (
    id INT AUTO_INCREMENT PRIMARY KEY,
    uyelik_numarasi VARCHAR(50) NOT NULL,
    sifre VARCHAR(50) NOT NULL
);

INSERT INTO kullanici_tablosu (uyelik_numarasi, sifre) VALUES
('123456', 'sifre123'),
('789012', 'parola456'),
('345678', 'gucluSifre');


CREATE TABLE IF NOT EXISTS ucuslar (
    id INT AUTO_INCREMENT PRIMARY KEY,
    kalkis_yeri VARCHAR(100),
    varis_yeri VARCHAR(100),
    bilet_fiyati DECIMAL(10, 2)
);

INSERT INTO ucuslar (kalkis_yeri, varis_yeri, bilet_fiyati) VALUES 
('Ankara', 'İstanbul', 1000.00),
('İstanbul', 'Ankara', 1670.00),
('Ankara', 'İzmir', 2000.00),
('İzmir', 'Ankara', 5500.00),
('Ankara', 'Antalya', 2000.00),
('Antalya', 'Ankara', 1000.00),
('İstanbul', 'İzmir', 1260.00),
('İzmir', 'İstanbul', 1300.00),
('İstanbul', 'Antalya', 1400.00),
('Antalya', 'İstanbul', 1800.00),
('Ankara', 'Adana', 19000.00),
('Adana', 'Ankara', 1400.00),
('İstanbul', 'Adana', 1600.00),
('Adana', 'İstanbul', 1200.00),
('Ankara', 'Trabzon', 1780.00),
('Trabzon', 'Ankara', 1980.00),
('İstanbul', 'Trabzon', 2000.00),
('Trabzon', 'İstanbul', 1800.00),
('İstanbul', 'Gaziantep', 1500.00),
('Gaziantep', 'İstanbul', 1900.00),
('Ankara', 'Diyarbakır', 1500.00),
('Diyarbakır', 'Ankara', 2500.00),
('İstanbul', 'Antakya', 2000.00),
('Antakya', 'İstanbul', 1800.00),
('İstanbul', 'Van', 1700.00),
('Van', 'İstanbul', 1679.00),
('Ankara', 'Bursa', 3800.00),
('Bursa', 'Ankara', 1800.00),
('Ankara', 'Konya', 3000.00),
('Konya', 'Ankara', 1700.00);

CREATE TABLE IF NOT EXISTS yurt_disi_ucuslar (
    id INT AUTO_INCREMENT PRIMARY KEY,
    kalkis_yeri VARCHAR(255) NOT NULL,
    varis_yeri VARCHAR(255) NOT NULL,
    bilet_fiyati DECIMAL(10, 2) NOT NULL
);

INSERT INTO yurt_disi_ucuslar (kalkis_yeri, varis_yeri, bilet_fiyati)
VALUES ('İstanbul', 'New York', 1500.00);


CREATE TABLE IF NOT EXISTS yolcular (
    id INT AUTO_INCREMENT PRIMARY KEY,
    ad VARCHAR(50),
    soyad VARCHAR(50),
    dogum_tarihi VARCHAR(10),
    tc_kimlik VARCHAR(11),
    eposta VARCHAR(100),
    telefon VARCHAR(15),
    cinsiyet VARCHAR(10),
    vatandas VARCHAR(20),
    koltuk VARCHAR(5)
);


CREATE TABLE IF NOT EXISTS KrediKartiBilgileri (
    id INT AUTO_INCREMENT PRIMARY KEY,
    kart_numarasi VARCHAR(16) NOT NULL,
    cvv VARCHAR(4) NOT NULL,
    son_kullanma_ayi VARCHAR(2) NOT NULL,
    son_kullanma_yili VARCHAR(4) NOT NULL
);

select * from yolcular;
select * from ucuslar;

select * from cities;




