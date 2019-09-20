package com.learn.demo.model;

import com.learn.demo.utils.YmlFactoryUtils;
import java.util.List;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/*
 * @author demo
 * @version 1.0.0
 * @date 2019/9/19 13:55
 * @description
 */
@Data
@Component
@PropertySource(value = {
    "classpath:filter.yml"}, factory = YmlFactoryUtils.class, encoding = "utf-8")
@ConfigurationProperties(prefix = "filter")
public class FilterModel {

  private List<String> unFilterList;

  private List<String> filterList;

  public List<String> getUnFilterList() {
    return unFilterList;
  }

  public void setUnFilterList(List<String> unFilterList) {
    this.unFilterList = unFilterList;
  }

  public List<String> getFilterList() {
    return filterList;
  }

  public void setFilterList(List<String> filterList) {
    this.filterList = filterList;
  }

}
