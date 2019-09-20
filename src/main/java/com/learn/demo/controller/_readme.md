# Controller

    @RestController 和 @Controller 区别
    
        @RestController => @Controller + @ResponseBody
    
# Mapping
 
    @RequestMapping  和  @GetMapping @PostMapping 区别
    
        @GetMapping是一个组合注解,是@RequestMapping(method = RequestMethod.GET)的缩写。

        @PostMapping是一个组合注解,是@RequestMapping(method = RequestMethod.POST)的缩写。
    
    类前加@RequestMapping增加接口层次，避免重名
    
    