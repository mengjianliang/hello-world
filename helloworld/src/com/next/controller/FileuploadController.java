package com.next.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

/**
 * Created by jianliang.meng on 2016/11/7.
 */

@Controller
public class FileuploadController {

    @RequestMapping("/upload")
    public String upload(@RequestParam("file")CommonsMultipartFile file[], HttpServletRequest request) throws IOException {

        String path = request.getRealPath("/fileupload");
        for (int i = 0; i <file.length ; i++) {
            InputStream is = file[i].getInputStream();
            OutputStream os = new FileOutputStream(new File(path,file[i].getOriginalFilename()));
            int len = 0;
            byte[] buffer = new byte[400];
            while((len=is.read(buffer))!=-1){
                os.write(buffer,0,len);
            }
            os.close();
            is.close();


        }

        return "redirect:/index.jsp";
    }
}
