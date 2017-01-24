package io.placeholder.resources;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Pascal Lombard
 * @since 15/01/2017.
 */
public class Rest {

  public static Map<String, String> errorMap(Exception exception) {
    Map<String, String> error = new HashMap<>();
    error.put("exception", exception.getClass().getName());
    error.put("message", exception.getMessage());
    return error;
  }
}
