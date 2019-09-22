package com.learn.demo.utils;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.env.CompositePropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.DefaultPropertySourceFactory;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

/*
 * @author demo
 * @date 2019/9/17 13:40
 * @description
 */
@Component
public class YmlFactoryUtils extends DefaultPropertySourceFactory {

  @Override
  public PropertySource<?> createPropertySource(String name, EncodedResource resource)
      throws IOException {

    CompositePropertySource sources = new CompositePropertySource(
        Optional.ofNullable(name).orElse(resource.getResource().getFilename()));
    List<PropertySource<?>> propertySources = new YamlPropertySourceLoader()
        .load(resource.getResource().getFilename(), resource.getResource());
    if (CollectionUtils.isEmpty(propertySources)) {
      return super.createPropertySource(name, resource);
    }
    propertySources.forEach(sources::addPropertySource);
    return sources;
  }
}