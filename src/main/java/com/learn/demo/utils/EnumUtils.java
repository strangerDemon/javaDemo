package com.learn.demo.utils;

import com.learn.demo.enums.PlatformEnum;
import org.springframework.stereotype.Component;

/**
 * 枚举工具类.
 *
 * @author demo
 * @version 1.0.0
 * @date 2019/10/9 15:38
 */
@Component
public class EnumUtils {

  String getSessionKey(String platform) {
    try {
      return PlatformEnum.valueOf(platform).getSessionKey();
    } catch (Exception ex) {
      return PlatformEnum.Default.getSessionKey();
    }
  }
}
