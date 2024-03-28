package com.project.shoppeeclone.cloudinary;

import com.cloudinary.Cloudinary;
import com.project.shoppeeclone.common.Common;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CloudinaryConfig {
    public Cloudinary config() {
        Cloudinary cloudinary = null;
        Map config = new HashMap();
        config.put(Common.CLOUDINARY_NAME,"dhhhnazvn");
        config.put(Common.CLOUDINARY_API_KEY, Common.CLOUDINARY_API_KEY_VALUE);
        config.put(Common.CLOUDINARY_API_SECRET, Common.CLOUDINARY_API_SECRET_VALUE);
        cloudinary = new Cloudinary(config);
        return cloudinary;
    }

}
