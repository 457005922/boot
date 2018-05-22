package application.hbg.controller.mongo;


import application.hbg.common.model.demo.DomeEntity;
import application.hbg.common.model.user.UserEntity;
import application.hbg.common.service.demo.DemoEntityServer;
import application.hbg.common.tools.MD5Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * 描述:
 *
 * @author hubugui
 * @version 0.1
 * @email hubugui@izjjf.cn
 * @since  2018/5/4
 */
@Api(description = "MongoDB")
@RestController
public class MongoDbController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private DemoEntityServer fileEntityServer;

    @Value("${server.address}")
    private String serverAddress;

    @Value("${server.port}")
    private String serverPort;

    @ApiOperation(value = "测试MongoDB", notes = "测试MongoDB")
    @GetMapping(value = "/mongodb")
    public UserEntity mongodb() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId("1");
        userEntity.setAddress("武汉大学");
        userEntity.setAge(2);
        userEntity.setName("Mongodb");
        userEntity.setCaption("MongoDB");
        userEntity.setTel("0731-123456789");
        userEntity.setRole("admin");
        mongoTemplate.save(userEntity);
        String id = "1";
        UserEntity userEntity1 = mongoTemplate.findById(id, UserEntity.class);
        return userEntity1;
    }
    /**
     * 上传接口
     * @param file
     * @return
     */
    @ApiOperation(value = "测试MongoDB文件上传", notes = "测试MongoDB文件上传")
    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        DomeEntity returnFile = null;
        try {
            DomeEntity f = new DomeEntity();
            f.setName(file.getOriginalFilename());
            f.setContentType(file.getContentType());
            f.setSize(file.getSize());
            f.setContent(file.getBytes());
            f.setMd5( MD5Util.getMD5(file.getInputStream()) );
            returnFile = fileEntityServer.saveFile(f);
            String path = "//"+ serverAddress + ":" + serverPort + "/view/"+returnFile.getId();
            return ResponseEntity.status(HttpStatus.OK).body(path);

        } catch (IOException | NoSuchAlgorithmException ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }

    }
    /**
     * 在线显示文件
     * @param id
     * @return
     */
    @ApiOperation(value = "测试MongoDB文件上传", notes = "测试MongoDB文件上传")
    @GetMapping("/view/{id}")
    public ResponseEntity<Object> serveFileOnline(@PathVariable String id) {
        DomeEntity file = fileEntityServer.getFileById(id);

        if (file != null) {
            return ResponseEntity
                    .ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "fileName=\"" + file.getName() + "\"")
                    .header(HttpHeaders.CONTENT_TYPE, file.getContentType() )
                    .header(HttpHeaders.CONTENT_LENGTH, file.getSize()+"")
                    .header("Connection",  "close")
                    .body( file.getContent());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("File was not fount");
        }
    }
}
