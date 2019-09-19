package com.learn.demo.Model;

import com.learn.demo.Utils.YmlFactoryUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author demo
 * @date 2019/9/19 13:55
 * @description
 */
@Component
@PropertySource(value = {"classpath:filter.yml"},factory= YmlFactoryUtils.class,encoding="utf-8")
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

    @Override
    public String toString() {
        return "FilterModel{" +
                "unFilterList=" + unFilterList +
                ", filterList=" + filterList +
                '}';
    }
}
