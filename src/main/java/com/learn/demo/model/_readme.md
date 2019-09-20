# PropertySource
    
    @PropertySources & @PropertySource 
    
        @PropertySources => { @PropertySource,@PropertySource,@PropertySource}
        
        eg:
        
        @PropertySource(value = {"classpath:unFilter.yml"},factory= YmlFactoryUtils.class,encoding="utf-8")
        
        @PropertySources({
            @PropertySource(value = {"classpath:system.yml"}),
            @PropertySource(value = {"classpath:unFilter.yml"})
            })