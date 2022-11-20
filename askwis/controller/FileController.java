package com.askwis.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/file")
public class FileController {

    @GetMapping("/download")
    public void download(HttpServletResponse response) throws Exception {
        response.setContentType("application/force-download");//强制性下载
        response.setHeader("Content-Disposition","attachement;filename=m.xls");
        Resource fileResource = new ClassPathResource("/files/msg.xls");
        InputStream inputStream = fileResource.getInputStream();
        byte data[] = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(data)) !=-1) {
            response.getOutputStream().write(data,0,len);
        }
    }
}
