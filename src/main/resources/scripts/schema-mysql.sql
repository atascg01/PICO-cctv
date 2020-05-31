/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  atascg01
 * Created: 20 abr. 2020
 */


DROP table if exists camera;
DROP table if exists configuration;
DROP table if exists image;
DROP table if exists object;
DROP table if exists user;
DROP table if exists role;

CREATE table user (
    id int primary key auto_increment,
    full_name varchar(100) not null,
    username varchar(20) not null,
    email varchar(50) not null,
    password varchar(500) not null,
    token varchar(8),
    birth_date varchar(50)
);

CREATE table camera (
    id int primary key auto_increment,
    name varchar(100) not null,
    description varchar(2000),
    url_image varchar(500),
    ip varchar(50)
);

CREATE table image (
    id int primary key auto_increment,
    image_url varchar(100) not null,
    timestamp varchar(100) not null
);

CREATE table object (
    id int primary key auto_increment,
    name varchar(100) not null,
    description varchar(2000),
    times_recognized int DEFAULT 0
);

CREATE table role (
    id int primary key auto_increment,
    name varchar(100) not null,
    permissions varchar(2000)
);

INSERT into camera
(name, description, url_image, ip) values
("Camera 1", "PICO CCTV camera from raspberry 1", "https://www.bhphotovideo.com/images/images1000x1000/canon_eos_r_mirrorless_digital_1433711.jpg", "192.168.1.20"),
("Camera 2", "PICO CCTV camera from raspberry 2", "https://www.bhphotovideo.com/images/images1000x1000/canon_eos_r_mirrorless_digital_1433711.jpg", "192.168.1.21"),
("Camera 3", "PICO CCTV camera from raspberry 3", "https://www.bhphotovideo.com/images/images1000x1000/canon_eos_r_mirrorless_digital_1433711.jpg", "192.168.1.22"),
("Camera 4", "PICO CCTV camera from raspberry 4", "https://www.bhphotovideo.com/images/images1000x1000/canon_eos_r_mirrorless_digital_1433711.jpg", "192.168.1.23");

CREATE table configuration (
    id int primary key auto_increment,
    resolution varchar(20),
    color varchar(50),
    name varchar(50)
);

INSERT into configuration
(resolution, color, name) values
("1024x768", "RGB", "Configuration 1"),
("640×480", "RGB", "Configuration 2"),
("1024x768", "RGB", "Configuration 3"),
("1024x768", "RGB", "Configuration 4");

INSERT into role
(name, permissions) values
("USER", "VIEW_CAMERAS, ADD_CAMERAS"),
("ADMIN", "VIEW_CAMERAS, ADD_CAMERAS, ADD_OBJECTS");

INSERT into object
(name, description) values
("dog", "Recognizing dogs of all races"),
("cat", "Recognizing black and white cats");

alter table object
add column user_id int,
add foreign key (user_id) references user(id);

alter table camera
add column configuration_id int, 
add foreign key (configuration_id) references configuration(id),
add column user_id int,
add foreign key (user_id) references user(id);

alter table user
add column role_id int default 1,
add foreign key (role_id) references role(id);

alter table configuration
add column user_id int,
add foreign key (user_id) references user(id);

INSERT into user
(full_name, username, email, password, role_id) values
("Admin", "admin", "pico.cctv@gmail.com", "81dc9bdb52d04dc20036dbd8313ed055", "2");

update camera set configuration_id = 1 where id = 1;
update camera set configuration_id = 2 where id = 2;
update camera set configuration_id = 3 where id = 3;
update camera set configuration_id = 4 where id = 4;

alter table  camera
modify configuration_id int not null;