# Controller

    @RestController 和 @Controller 区别
    
        @RestController => @Controller + @ResponseBody
    
    
# Mapping
 
    @RequestMapping  和  @GetMapping @PostMapping 区别
    
        @GetMapping是一个组合注解,是@RequestMapping(method = RequestMethod.GET)的缩写。

        @PostMapping是一个组合注解,是@RequestMapping(method = RequestMethod.POST)的缩写。
    
    类前加@RequestMapping增加接口层次，避免重名

# Request

### GET：   
 
    1、@PathVariable
    
    获取路径参数。即url/{id}这种形式。 
    
    配置url和方法的一个关系@RequestMapping("item/{itemId}")
    
    2、@RequestParam 
    
    获取查询参数。即url?name=这种形式
    
### DELETE：

    @PathVariable
    
### POST/PUT/PATCH
    
    @RequestBody 
    
        @Validated：对数据进行校验，注解报错会直接返回
        
            常用注解：
            属性	        描述	
            @AssertTrue	    应用于boolean属性，该属性值必须为true	
            
            @AssertFalse	应用于boolean属性，该属性值必须为false	
            
            @DecimalMax	    只能小于或等于指定值	
            
            @DecimalMin	    只能大于或等于指定值	
            
            @Digits	        该属性值必须在指定范围内，interger属性定义该数值的最大整数部分，fraction属性定义该数值的最大 小数部分
                            eg:@Digits(integer=5, fraction=2)	
           
            @Future	        检查该字段是否是属于未来的日期	
            
            @Max	        该字段的值只能小于或等于该值	
            
            @Min	        该字段的值只能大于或等于该值	
            
            @NotNull	    该字段不能为Null	
            
            @Null	        该字段必须是Null	
            
            @Past	        该字段必须是过去的一个日期	
            
            @Size	        检查该字段的size是否在min和max之间，可以是字符串、数组、集合、Map等	
                            eg:@Size(min=2, max=10)
                
            @Pattern	    该属性值必须与指定的常规表达式相匹配	
                            eg:@Pattern(regexp="\\d{3}")
                
            @NotBlank	    只用于String, 不能为Null且trim()之后size>0
            
            @NotEmpty	    不能为Null，且size>0	
            
            @Email	        被注释的元素必须是电子邮箱地址	 
            
            @Length	        被注释的字符串String 大小必须在指定范围内	
                            eg：@Length(min=6, max=12, message="密码长度必须在6~12")
            
            @Range	        BigDecimal,BigInteger,CharSequence, byte, short, int, long等原子类型和包装类型，验证注解的元素值在最小值和最大值之间	 
            
            @Valid	        指定递归验证（下篇讲）关联的对象； 如用户对象中有个地址对象属性，如果想在验证用户对象时一起验证地址对象的话，在地址对象上加@Valid注解即可级联验证
           
        对于多参数，又非对象的参数使用Map接受
        
            eg：getUserPage(@RequestBody Map data)
  
  
# Pageable
    
    启动类:@EnableSpringDataWebSupport
    
    接口:Pageable page
    
        eg:public ResultModel getUserPage(@RequestBody Map data,Pageable page)
        
    前端:?page=0&size=10&sort=realName&sort=account,desc
    
        page:查询页,默认为0
        
        size:页大小,默认为20
        
        sort:filed,sortType 排序字段,排序类型，无sortType默认为asc