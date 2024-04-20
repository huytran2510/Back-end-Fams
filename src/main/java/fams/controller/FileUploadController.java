package fams.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
public class FileUploadController {
    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                // Save the file to a location
                Files.write(Paths.get("D:\\FPT" + file.getOriginalFilename()), file.getBytes());
                return ResponseEntity.ok().body("File '" + file.getOriginalFilename() + "' uploaded successfully!");
            } catch (IOException e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save the file.");
            }
        } else {
            return ResponseEntity.badRequest().body("Failed to upload the file because it was empty.");
        }
    }
}
