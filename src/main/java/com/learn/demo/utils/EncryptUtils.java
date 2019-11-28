package com.learn.demo.utils;

import com.learn.demo.model.MyExceptionModel;
import com.learn.demo.model.SystemConfigModel;
import java.util.Base64;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 加解密.
 *
 * @author demo
 * @version 1.0.0
 * @date 2019/9/17 15:01
 */
@Component
public class EncryptUtils {

  @Resource
  private SystemConfigModel systemConfig;

  private static EncryptUtils encryptUtils;

  /**
   * 初始化的时候，将本类中的EncryptUtils赋值给静态的本类变量.
   */
  @PostConstruct
  public void init() {
    encryptUtils = this;
  }

  /**
   * 加密.
   *
   * @param data 加密数据
   * @return 机密结果
   */
  public static String encrypt(String data) {
    return encrypt(data, encryptUtils.systemConfig.getEncryptKey());
  }

  /**
   * 加密.
   *
   * @param data 数据
   * @param key  公钥
   * @return 解密结果
   */
  private static String encrypt(String data, String key) {
    try {
      if (data == null) {
        throw new MyExceptionModel("加密数据为空！");
      }
      //"算法/模式/补码方式"NoPadding PkcsPadding
      Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
      int blockSize = cipher.getBlockSize();

      byte[] dataBytes = data.getBytes();
      int plaintextLength = dataBytes.length;
      if (plaintextLength % blockSize != 0) {
        plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
      }

      byte[] plaintext = new byte[plaintextLength];
      System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);

      SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
      IvParameterSpec ivSpec = new IvParameterSpec(key.getBytes());

      cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
      byte[] encrypted = cipher.doFinal(plaintext);

      return Base64.getEncoder().encodeToString(encrypted);

    } catch (Exception e) {
      throw new MyExceptionModel(e.getMessage());
    }
  }

  /**
   * 解密.
   *
   * @param data 解密数据
   * @return 解密结果
   */
  public static String decrypt(String data) {
    return decrypt(data, encryptUtils.systemConfig.getEncryptKey());
  }

  /**
   * 解密.
   *
   * @param data 数据
   * @param key  公钥
   * @return 解密结果
   */
  private static String decrypt(String data, String key) {
    try {
      if (data == null) {
        throw new MyExceptionModel("解密数据未空！");
      }

      byte[] encrypted1 = Base64.getDecoder().decode(data);

      Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");

      SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
      IvParameterSpec ivSpec = new IvParameterSpec(key.getBytes());

      cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);

      byte[] original = cipher.doFinal(encrypted1);
      return new String(original);
    } catch (Exception e) {
      throw new MyExceptionModel(e.getMessage());
    }
  }

  /**
   * test.
   *
   * @param args args
   */
  public static void main(String[] args) {
    String key = "123456";
    String value = encrypt(key, "123456789encrypt");
    System.out.println("key:" + value);
  }
}
