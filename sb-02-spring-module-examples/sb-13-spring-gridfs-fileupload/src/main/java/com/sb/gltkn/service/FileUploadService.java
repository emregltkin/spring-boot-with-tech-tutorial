package com.sb.gltkn.service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileUploadService {

    @Autowired
    private GridFsTemplate gridFsTemplate;

    public void uploadFile(MultipartFile file) throws IOException {
        DBObject dbObject = new BasicDBObject();
        String fileName = file.getOriginalFilename();
        dbObject.put("fileName", fileName);
        dbObject.put("contentType", file.getContentType());
        dbObject.put("size", file.getSize());
        dbObject.put("userId", "user1234");
        ObjectId objectId = gridFsTemplate.store(file.getInputStream(), fileName, dbObject);
        System.out.println(objectId.toString());
    }
}
