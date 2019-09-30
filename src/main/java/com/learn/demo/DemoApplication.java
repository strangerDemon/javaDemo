package com.learn.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@Slf4j
@SpringBootApplication
@EnableSpringDataWebSupport
public class DemoApplication {

  /**
   * 程序启动.
   *
   * @param args args
   * @throws UnknownHostException 异常
   */
  public static void main(String[] args) throws UnknownHostException {

    ConfigurableApplicationContext application = SpringApplication.run(DemoApplication.class, args);
    Environment env = application.getEnvironment();
    String ip = InetAddress.getLocalHost().getHostAddress();
    String port = env.getProperty("server.port");
    String path = env.getProperty("server.servlet.context-path");
    log.info("\n----------------------------------------------------------\n\t"
        + "Application CAS-Demo-Boot is running! Access URLs:\n\t"
        + "Local: \t\thttp://localhost:" + port + path + "/\n\t"
        + "External: \thttp://" + ip + ":" + port + path + "/\n\t"
        + "swagger-ui: \thttp://" + ip + ":" + port + path + "/swagger-ui.html\n\t"
        + "Doc: \t\thttp://" + ip + ":" + port + path + "/doc.html\n"
        + "----------------------------------------------------------");
  }


}
