package entity.life;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Memory {
    private String describe;
    private Date createDate;

    public Memory createMemory(Object thing){
        Memory memory=new Memory();
        memory.createDate=new Date();
        memory.describe=thing.toString();
        return memory;
    }

    @Override
    public String toString() {
        return "Memory{" +
                "describe='" + describe + '\'' +
                ", createDate=" + getFormatCreateDate() +
                '}';
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getFormatCreateDate(){
        SimpleDateFormat format=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        return format.format(createDate.getTime());
    }
}
