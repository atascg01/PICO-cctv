package com.pico.cctv.service;

import com.pico.cctv.domain.Camera;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author atascg01
 */

@Service
public class CameraSvc {
    
    public List<Camera> findCameras(){
        List<Camera> cameras = new ArrayList<>();
        
        Camera camera1 = new Camera();
        camera1.setName("Camera 1");
        camera1.setDescription("PICO CCTV camera from raspberry 1");
        camera1.setUrlImage("https://www.bhphotovideo.com/images/images1000x1000/canon_eos_r_mirrorless_digital_1433711.jpg");
        cameras.add(camera1);
        
        Camera camera2 = new Camera();
        camera2.setName("Camera 2");
        camera2.setDescription("PICO CCTV camera from raspberry 2");
        camera2.setUrlImage("https://www.bhphotovideo.com/images/images1000x1000/canon_eos_r_mirrorless_digital_1433711.jpg");
        cameras.add(camera2);
        
        Camera camera3 = new Camera();
        camera3.setName("Camera 3");
        camera3.setDescription("PICO CCTV camera from raspberry 3");
        camera3.setUrlImage("https://www.bhphotovideo.com/images/images1000x1000/canon_eos_r_mirrorless_digital_1433711.jpg");
        cameras.add(camera3);
        
        Camera camera4 = new Camera();
        camera4.setName("Camera 4");
        camera4.setDescription("PICO CCTV camera from raspberry 4");
        camera4.setUrlImage("https://www.bhphotovideo.com/images/images1000x1000/canon_eos_r_mirrorless_digital_1433711.jpg");
        cameras.add(camera4);
        
        return cameras;
    }
}
