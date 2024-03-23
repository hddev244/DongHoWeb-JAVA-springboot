package com.hddev244.service.scope;

import java.io.File;
import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hddev244.model.ModelAttributeKey;
import com.hddev244.utils.FileUtil;
import com.hddev244.utils.StringHelper;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class ParamService {
      @Autowired
      ServletContext app;
      @Autowired
      HttpServletRequest request;

      /**
       * Đọc chuỗi giá trị của tham số
       * 
       * @param name         tên tham số
       * @param defaultValue giá trị mặc định
       * @return giá trị tham số hoặc giá trị mặc định nếu không tồn tại
       */
      public String getString(String name, String defaultValue) {
            String value = request.getParameter(name);
            return value == null ? defaultValue : value.trim();
      }

      /**
       * Đọc số nguyên giá trị của tham số
       * 
       * @param name         tên tham số
       * @param defaultValue giá trị mặc định
       * @return giá trị tham số hoặc giá trị mặc định nếu không tồn tại
       */
      public int getInt(String name, int defaultValue) {
            String value = request.getParameter(name);
            return value == null ? defaultValue : Integer.parseInt(value);
      }

      /**
       * Đọc số thực giá trị của tham số
       * 
       * @param name         tên tham số
       * @param defaultValue giá trị mặc định
       * @return giá trị tham số hoặc giá trị mặc định nếu không tồn tại
       */
      public double getDouble(String name, double defaultValue) {
            String value = request.getParameter(name);
            return value == null ? defaultValue : Double.parseDouble(value);
      }

      /**
       * Đọc giá trị boolean của tham số
       * 
       * @param name         tên tham số
       * @param defaultValue giá trị mặc định
       * @return giá trị tham số hoặc giá trị mặc định nếu không tồn tại
       */
      public boolean getBoolean(String name, boolean defaultValue) {
            String value = request.getParameter(name);
            return value == null ? defaultValue : Boolean.parseBoolean(value);
      }

      /**
       * Đọc giá trị thời gian của tham số
       * 
       * @param name    tên tham số
       * @param pattern là định dạng thời gian
       * @return giá trị tham số hoặc null nếu không tồn tại
       * @throws RuntimeException lỗi sai định dạng
       */
      public Date getDate(String name, String pattern) {
            String value = request.getParameter(name);
            if (value == null)
                  return null;
            try {
                  return new java.text.SimpleDateFormat(pattern).parse(value);
            } catch (Exception e) {
                  throw new RuntimeException(e);
            }
      }

      /**
       * Lưu file upload vào thư mục
       * 
       * @param file chứa file upload từ client
       * @param path đường dẫn tính từ webroot
       * @return đối tượng chứa file đã lưu hoặc null nếu không có file upload
       * @throws RuntimeException lỗi lưu file
       */
      public File save(MultipartFile multipartFile, String path) {
            if (multipartFile == null)
                  return null;
            try {

                  String destination = path
                              + "PRO"
                              + new Date().getTime()
                              + "."
                              + StringHelper.getExtensionByStringHandling(multipartFile.getOriginalFilename());
                  File file = new File(app.getRealPath(destination));
                  if (!file.exists()) {
                        file.mkdirs();
                  }
                  multipartFile.transferTo(file);
                  return file;
            } catch (Exception e) {
                  throw new RuntimeException(e);
            }
      }

      public String saveFile(MultipartFile multipartFile, String path) {
            if (multipartFile.isEmpty())
                  return null;
            try {

                  String destination = FileUtil.generateDestination(multipartFile, path);
                  File file = new File(app.getRealPath(destination));
                  if (!file.exists()) {
                        file.mkdirs();
                  }
                  multipartFile.transferTo(file);
                  return destination;
            } catch (Exception e) {
                  throw new RuntimeException(e);
            }
      }

      /**
       * lưu ảnh vào folder
       * @param multipartFile
       * @return destination's file
       */
      public String saveProductImage(MultipartFile multipartFile) {
            if (multipartFile.isEmpty())
                  return null;
            try {
                  String destination = FileUtil.generateDestination(multipartFile, ModelAttributeKey.PRODUCTS_IMAGE_EDITTING);
                  File file = new File(app.getRealPath(destination));
                  if (!file.exists()) {
                        file.mkdirs();
                  }
                  multipartFile.transferTo(file);
                  return destination;
            } catch (Exception e) {
                  throw new RuntimeException(e);
            }
      }
}
