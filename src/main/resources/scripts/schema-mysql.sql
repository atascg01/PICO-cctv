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

CREATE table camera (
    id int primary key auto_increment,
    name varchar(100) not null, 
    description varchar(2000),
    url_image varchar(500)
);

INSERT into camera
(name, description, url_image) values
("Camera 1", "PICO CCTV camera from raspberry 1", "https://www.bhphotovideo.com/images/images1000x1000/canon_eos_r_mirrorless_digital_1433711.jpg"),
("Camera 2", "PICO CCTV camera from raspberry 2", "https://www.bhphotovideo.com/images/images1000x1000/canon_eos_r_mirrorless_digital_1433711.jpg"),
("Camera 3", "PICO CCTV camera from raspberry 3", "https://www.bhphotovideo.com/images/images1000x1000/canon_eos_r_mirrorless_digital_1433711.jpg"),
("Camera 4", "PICO CCTV camera from raspberry 4", "https://www.bhphotovideo.com/images/images1000x1000/canon_eos_r_mirrorless_digital_1433711.jpg");