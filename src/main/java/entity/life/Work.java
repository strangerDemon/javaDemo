package entity.life;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Work {
    private String companyName;
    private String companyAddress;
    private float salary;
    private String position;
    private Date startDate;
    private Date endDate;

    public static Work createWork(String companyName, String companyAddress, float salary, String position) {
        Work work = new Work();
        work.companyName = companyName;
        work.companyAddress = companyAddress;
        work.salary = salary;
        work.position = position;
        work.startDate = new Date();
        return work;
    }

    @Override
    public String toString() {
        String work = "Work{" +
                "companyName='" + companyName + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                ", salary=" + salary +
                ", position='" + position + '\'' +
                ", startDate=" + getFormatStartDate();
        work += this.endDate == null ? "" : ", endDate=" + getFormatEndDate();
        work += '}';
        return work;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void addSalary(float money){
        this.salary+=money;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getFormatStartDate(){
        SimpleDateFormat format=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        return format.format(startDate.getTime());
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getFormatEndDate(){
        if(endDate==null) return "在职";
        SimpleDateFormat format=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        return format.format(endDate.getTime());
    }
}
