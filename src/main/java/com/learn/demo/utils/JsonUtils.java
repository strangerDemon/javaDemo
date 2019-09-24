package com.learn.demo.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 对象json转换.
 *
 * @author demo
 * @version 1.0.0
 * @date 2019/9/20 16:16
 */
@Slf4j
@Component
public class JsonUtils {

  @Resource
  private ObjectMapper objectMapper;

  private static JsonUtils jsonUtils;

  @PostConstruct
  public void init() {
    jsonUtils = this;
  }

  /**
   * json转对象.
   *
   * @param json json字符串
   * @param bean 要转换的对象的class
   * @param <T>  类型
   */
  public static <T> T toBean(String json, Class<T> bean) {
    try {
      return jsonUtils.objectMapper.readValue(json, bean);
    } catch (Exception ex) {
      log.error("toBean:{}", ex.getMessage());
      return null;
    }
  }

  /**
   * 对象转json.
   *
   * @param object 对象
   * @return json
   */
  public static String toJson(Object object) {
    try {
      return jsonUtils.objectMapper.writeValueAsString(object);
    } catch (Exception ex) {
      log.error("toJson:{}", ex.getMessage());
      return "";
    }
  }

  /**
   * json转对象列表.
   *
   * @param json          json
   * @param typeReference typeReference
   * @param <T>           类型
   * @return 列表
   */
  public static <T> List<T> toBeanList(String json, TypeReference<List<T>> typeReference) {
    try {
      return jsonUtils.objectMapper.readValue(json, typeReference);
    } catch (Exception ex) {
      log.error("toBean:{}", ex.getMessage());
      return null;
    }
  }

  /**
   * 对象转其他类型.
   *
   * @param object 对象
   * @param <T>    类型
   * @return 类型数据
   */
  @SuppressWarnings("unchecked")
  public static <T> T cast(Object object) {
    return (T) object;
  }
}
