package com.hddev244.utils;

import java.io.File;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.ServletContext;

@Component
public class FileUtil {
      @Autowired
      ServletContext servletContext;

      public static String generateProductImageName() {
            return "PRO" + new Date().getTime();
      }

      public static String generateDestination(MultipartFile multipartFile, String path) {
            return path
                        + generateProductImageName()
                        + "."
                        + StringHelper
                                    .getExtensionByStringHandling(multipartFile.getOriginalFilename());
      }

      public void deleteImage(String path) {
            String fileRealPath = servletContext.getRealPath(path);
            File fileToDelete = new File(fileRealPath);
            if (fileToDelete.exists()) {
                boolean deletionResult = fileToDelete.delete();
                if (!deletionResult) {
                    // Handle deletion failure gracefully
                    System.err.println("Failed to delete the file: " + fileToDelete);
                }
            } else {
                // Handle case where the file doesn't exist
                System.err.println("The file doesn't exist: " + fileToDelete);
            }
      }
}
