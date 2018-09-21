package entity.life;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Lesson {
    private String name;
    private Person teacher;
    private Book book;
    private Date startDate;
    private Date endDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getTeacher() {
        return teacher;
    }

    public void setTeacher(Person teacher) {
        this.teacher = teacher;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getStartDate() {
        return startDate;
    }

    public String getFormatStartDate(){
        SimpleDateFormat format=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        return format.format(startDate.getTime());
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getFormatEndDate(){
        if(endDate==null) return "未结束";
        SimpleDateFormat format=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        return format.format(endDate.getTime());
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Lesson studyLesson(){
        Lesson lesson=new Lesson();
        return lesson;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "name='" + name + '\'' +
                ", teacher=" + teacher.getName() +
                ", book=" + book.getName() +
                ", startDate=" + getFormatStartDate() +
                ", endDate=" + getFormatEndDate() +
                '}';
    }
}
