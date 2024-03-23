package com.hddev244.utils;

import java.util.Optional;

public class StringHelper {
      public static String getExtensionByStringHandling(String filename) {
            return Optional.ofNullable(filename)
              .filter(f -> f.contains("."))
              .map(f -> f.substring(filename.lastIndexOf(".") + 1)).get();
        }
}
