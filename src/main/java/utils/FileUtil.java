package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;

/**
 * @author demo
 * @date 2018/9/20 12:01
 */
public class FileUtil {
    protected static Logger logger = LoggerFactory.getLogger(FileUtil.class);
    /**
     * 根据文件url读取文件
     *
     * @param url
     * @param myClass
     * @return
     * @throws Exception
     */
    public static Object readFile(String url, Class myClass) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File(url), myClass);
        } catch (Exception ex) {
            logger.info(ex.toString());
            logger.error(ex.toString());
            throw ex;
        }
    }

    /**
     * 写string 到文件
     *
     * @param url
     * @param value
     * @throws Exception
     */
    public void writeFile(String url, String value) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(url), value); // 写到文件中
        } catch (Exception ex) {
            throw ex;
        }
    }

    /**
     * 将对象写入文件
     *
     * @param url
     * @param value
     * @throws Exception
     */
    public void writeFile(String url, Object value) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(url), value); // 写到文件中
        } catch (Exception ex) {
            throw ex;
        }
    }
}


