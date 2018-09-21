package entity.life;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.FileUtil;

import java.util.List;


public class Interest {

    private static Logger logger= LoggerFactory.getLogger(Interest.class);
    private int age;
    private String name;

    public static Interest getCurrentInterset(int age){
        try{
           Object interestList=FileUtil.readFile(System.getProperty("user.dir")+"/src/main/resources/data/interest.json", List.class);
           System.out.println(interestList);
        }catch(Exception ex){
            logger.error(ex.toString());
        }
        return new Interest();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
