package entity.life;

import java.text.SimpleDateFormat;
import java.util.Date;


public class GirlFriend extends Person {
    private Date debutDate;
    private Date fallInLoveDate;
    private Date overDate;
    private Date marryDate;

    public Date getDebutDate() {
        return debutDate;
    }

    public void setDebutDate(Date debutDate) {
        this.debutDate = debutDate;
    }

    public String getFormatDebutDate(){
        SimpleDateFormat format=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        return format.format(debutDate.getTime());
    }

    public Date getFallInLoveDate() {
        return fallInLoveDate;
    }

    public void setFallInLoveDate(Date fallInLoveDate) {
        this.fallInLoveDate = fallInLoveDate;
    }

    public String getFormatFallInLoveDate(){
        SimpleDateFormat format=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        return format.format(fallInLoveDate.getTime());
    }

    public Date getOverDate() {
        return overDate;
    }

    public void setOverDate(Date overDate) {
        this.overDate = overDate;
    }

    public String getFormatOverDate(){
        if(overDate==null)return "在谈";
        SimpleDateFormat format=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        return format.format(overDate.getTime());
    }

    public Date getMarryDate() {
        return marryDate;
    }

    public void setMarryDate(Date marryDate) {
        this.marryDate = marryDate;
    }

    public String getFormatMarryDate(){
        if(marryDate==null)return "未结婚";
        SimpleDateFormat format=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        return format.format(marryDate.getTime());
    }

    @Override
    public String toString() {
        return "GirlFriend{" +
                "debutDate=" + getFormatDebutDate() +
                ", fallInLoveDate=" + getFormatFallInLoveDate() +
                ", overDate=" + getFormatOverDate() +
                ", marryDate=" + getFormatMarryDate() +
                '}';
    }
}
