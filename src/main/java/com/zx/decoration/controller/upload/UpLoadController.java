package com.zx.decoration.controller.upload;

import com.zx.decoration.util.restutil.RestReturn;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

@RestController
@RequestMapping("/api/upload")
public class UpLoadController {

    @Value("${upload.picture.path}")
    private String uploadPicturePath;
    @Resource
    private ResourceLoader resourceLoader;


    /**
     * 将图片上传
     * @param file
     * @return
     * @throws Exception
     */
    @PostMapping("/uploadFile")
    @ResponseBody
    public ResponseEntity fileUpload(@RequestParam("file") MultipartFile file) throws Exception {

        System.out.println(file.getOriginalFilename()+">>>>>>>>>");
        if(file.isEmpty()){
            throw new Exception("图片不能为空");
        }
        //z.png
        String fileName = file.getOriginalFilename();
//        int size = (int) file.getSize();
//        fileName=fileName.substring(fileName.lastIndexOf("\\")+1);
//        System.out.println(fileName);

//        String path = System.getProperty("user.dir");
//        String newpath =path+"/src/main/resources/static/images/user/";
        File dest = new File(fileName);
//        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
//            dest.getParentFile().mkdir();
//        }

        try {
            file.transferTo(dest); //保存文件
            return new RestReturn().success(file.getName(),"成功");
        } catch (IOException e) {
            return new RestReturn().error(e);
        }
    }

    /**
     *
     * @param fileName
     * @return
     */
    @RequestMapping("/{fileName:.+}")
    @ResponseBody
    public ResponseEntity show(@PathVariable String fileName){
        try
        {
            //resourceLoader.getResource("file:" + uploadPicturePath + fileName) 返回指定路径的资源句柄，这里返回的就是URL [file:D:/springboot/upload/test.png]
            //ResponseEntity.ok(T) 返回指定内容主体
            return ResponseEntity.ok(resourceLoader.getResource("file:" + uploadPicturePath + fileName));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


}
