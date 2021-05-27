DROP DATABASE meianly_music_store;
CREATE DATABASE meianly_music_store;
use meianly_music_store;

CREATE TABLE tb_artist_meianly (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    balance DECIMAL NOT NULL DEFAULT 0,
    email VARCHAR(50) NOT NULL UNIQUE ,
    phone VARCHAR(12) NOT NULL UNIQUE,
    genre VARCHAR(50) NOT NULL UNIQUE,
    instagram VARCHAR(200)
);

CREATE TABLE login(
    username VARCHAR(100) NOT NULL UNIQUE PRIMARY KEY,
    password VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE tb_album_meianly (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) UNIQUE NOT NULL,
    category VARCHAR(50) NOT NULL,
    release_year INT UNSIGNED NOT NULL
);

CREATE TABLE tb_song_meianly (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(50) NOT NULL UNIQUE,
    duration INT NOT NULL,
    price DECIMAL NOT NULL DEFAULT 0,
    album_id INT NOT NULL,
    FOREIGN KEY (album_id) REFERENCES tb_album_meianly(id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE tb_transaction_meianly(
    id INT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(200) NOT NULL,
    title VARCHAR(200) NOT NULL,
    status ENUM('SELL','BUY') NOT NULL
);


INSERT INTO login VALUES ('salsa','salsa12345');
INSERT INTO login VALUES ('sammi','sammi12345');
INSERT INTO login VALUES ('meianly','meianly12345');

INSERT INTO tb_artist_meianly VALUES ('1','sammi','20000','sammi@gmail.com','xxxxxxxx','yyyyy','igg_account');
INSERT INTO tb_artist_meianly VALUES ('2','salsa','50000','salsa@gmail.com','xxxxxxxx2','yyyyy3','igg_account');
INSERT INTO tb_artist_meianly VALUES ('3','meianly','220000','meianly@gmail.com','xxxxxxxx3','yyyy4','igg_account');

insert into tb_album_meianly(title, category, release_year)
values ('album1','cat11',2020);
insert into tb_album_meianly(title, category, release_year)
values ('album2','cat12',2021);
insert into tb_album_meianly(title, category, release_year)
values ('album3','cat13',2019);

insert into tb_song_meianly(title, duration, price, album_id) values
('nanananana1','20','900000','1'),
('nanananana2','30','200000','2'),
('nanananana3','40','300000','3'),
('nanananana4','50','400000','1'),
('nanananana5','60','500000','1');
