/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  atascg01
 * Created: 20 abr. 2020
 */

DROP table if exists user;
DROP table if exists camera;
DROP table if exists configuration;

CREATE table user (
    id int primary key auto_increment,
    full_name varchar(100) not null,
    username varchar(20) not null,
    email varchar(50) not null,
    password varchar(500) not null,
    birth_date varchar(50)
);

CREATE table camera (
    id int primary key auto_increment,
    name varchar(100) not null,
    description varchar(2000),
    url_image varchar(500),
    ip varchar(50)
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

alter table camera
add column configuration_id int, 
add foreign key (configuration_id) references configuration(id);

update camera set configuration_id = 1 where id = 1;
update camera set configuration_id = 2 where id = 2;
update camera set configuration_id = 3 where id = 3;
update camera set configuration_id = 4 where id = 4;

alter table  camera
modify configuration_id int not null;