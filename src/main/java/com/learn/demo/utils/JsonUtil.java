package com.learn.demo.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/*
 * @author demo
 * @date 2019/9/20 16:16
 * @description
 * @version 1.0.0
 */
@Component
public class JsonUtil {

  private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);
  @Resource
  private ObjectMapper objectMapper;

  private static JsonUtil jsonUtil;

  @PostConstruct
  public void init() {
    jsonUtil = this;
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
      return jsonUtil.objectMapper.readValue(json, bean);
    } catch (Exception ex) {
      logger.error("toBean: error = {}", ex.getMessage());
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
      return jsonUtil.objectMapper.writeValueAsString(object);
    } catch (Exception ex) {
      logger.error("toJson: error = {}", ex.getMessage());
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
      return jsonUtil.objectMapper.readValue(json, typeReference);
    } catch (Exception ex) {
      logger.error("toBean: error = {}", ex.getMessage());
      return null;
    }
  }
}
