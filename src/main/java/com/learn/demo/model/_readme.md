# PropertySource
    
    @PropertySources & @PropertySource 
    
        @PropertySources => { @PropertySource,@PropertySource,@PropertySource}
        
        eg:
        
        @PropertySource(value = {"classpath:unFilter.yml"},factory= YmlFactoryUtils.class,encoding="utf-8")
        
        @PropertySources({
            @PropertySource(value = {"classpath:system.yml"}),
            @PropertySource(value = {"classpath:unFilter.yml"})
            })
            
# Lombok 

    实体对象代码简化 https://www.jianshu.com/p/453c379c94bd
    
    @Data   自动实现get/set、tostring、equals、hashCode
    
        =>  @ToString
            @EqualsAndHashCode
            @Getter/@Setter
            @RequiredArgsConstructor的所有特性
    
    @Cleanup 自动调用close
    eg：
        @Cleanup InputStream in = new FileInputStream(args[0]);
        @Cleanup OutputStream out = new FileOutputStream(args[1]);
