//package com.develop.devcourse.common.util;
//
//import com.google.cloud.storage.*;
//import jakarta.servlet.ServletContext;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.util.FileCopyUtils;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class UploadService {
//    private final String bucketName = "sll-project-14-12-2023.appspot.com";
//    private final ServletContext servletContext;
//    private final Storage storage;
//
//    public String uploadFile(MultipartFile fileUpload){
//        String uploadPath = servletContext.getRealPath("/uploads");
//        File file = new File(uploadPath);
//        if (!file.exists()) {
//            file.mkdirs();
//        }
//
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
//        String fileName = dtf.format(LocalDateTime.now())+ fileUpload.getOriginalFilename();
//        try {
//            FileCopyUtils.copy(fileUpload.getBytes(),new File(uploadPath+File.separator+fileName));
//            String filePath = uploadPath+File.separator+fileName;
//            String imageUrlFirebase = uploadFileFromServerToFirebase(filePath);
//            File fileImage = new File(filePath);
//            if (fileImage.exists()){
//                fileImage.delete();
//            }
//            return  imageUrlFirebase;
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private String uploadFileFromServerToFirebase(String filePath){
//        Path localPath = Paths.get(filePath); // lấy ra đối tượng Paths của ảnh vừa upload lên server
//        String fileName = localPath.getFileName().toString(); // lấy ra tên file upload
//        BlobId blobId = BlobId.of(bucketName, fileName); // tạo file trên storage bằng tên và bucketname chỉ đinh
//
//        // Thiết lập quyền truy cập công cộng
//        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
//        List<Acl> acls = new ArrayList<>();
//        acls.add(Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER));
//        blobInfo = blobInfo.toBuilder().setAcl(acls).build();
//        try {
//            Blob blob = storage.create(blobInfo, Files.readAllBytes(localPath));
//            // trả về đường dẫn ảnh online
//            return blob.getMediaLink();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
