package entity.life;

import entity.life.enumeration.Education;
import entity.life.enumeration.Sex;

import java.util.*;

public class Person {

    //region 属性 add set get
    private String name;
    private Sex sex;
    private int age;
    private boolean living=true;
    private float height;
    private float weight;
    private Date bornDate;
    private Date deadDate;
    private String address;
    private Education education;
    private List<House> houses;
    private List<Work> works;
    private List<Interest> interests;
    private List<Lesson> lessons;

    private List<Memory> memoryList;


    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void addAge(){
        this.age++;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public Date getDeadDate() {
        return deadDate;
    }

    public void setDeadDate(Date deadDate) {
        this.deadDate = deadDate;
    }

    public List<House> getHouses() {
        return houses;
    }

    public void setHouses(List<House> houses) {
        this.houses = houses;
    }

    public void buyHouse(House house) {
        if (this.houses == null)
            this.houses = new ArrayList<House>();
        this.houses.add(house);
    }

    public void sellHouse(House house) {
        this.houses.remove(house);
    }

    public List<Work> getWorks() {
        return works;
    }

    public void setWorks(List<Work> works) {
        this.works = works;
    }

    public void addWork(Work work) {
        if (this.works == null)
            this.works = new ArrayList<Work>();
        if(this.works.size()>1){
            Work lastWork=this.works.get(this.works.size()-1);
            if(lastWork.getCompanyName().equals(work.getCompanyName()))
                return;
        }
        this.works.add(work);
    }

    public List<Interest> getInterests() {
        return interests;
    }

    public void setInterests(List<Interest> interests) {
        this.interests = interests;
    }

    public void addInterests(Interest interest) {
        if (this.interests == null)
            this.interests = new ArrayList<Interest>();
        this.interests.add(interest);
    }

    public void delInterests(Interest interest) {
        this.interests.remove(interest);
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public void study(Lesson lesson){
        if(this.lessons==null)
            this.lessons=new ArrayList<Lesson>();
        this.lessons.add(lesson);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Memory> getMemoryList() {
        return memoryList;
    }

    public void setMemoryList(List<Memory> memoryList) {
        this.memoryList = memoryList;
    }

    public void addMenory(Memory memory) {
        if(this.memoryList==null)
            this.memoryList=new ArrayList<Memory>();
        this.memoryList.add(memory);
    }

    public void delMemory(Memory memory) {
        this.memoryList.remove(memory);
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public boolean isLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

    //endregion

    //region born

    /**
     * 出生
     */
    public static Person born(Sex sex, String name) {
        Person person = new Person();
        person.bornDate = new Date();
        person.sex = sex;
        person.name = name;
        return person;
    }
    //endregion

    //region tostring

    @Override
    public String toString() {
        String person = "Person{" +
                "\n\rname='" + name + '\'' +
                ", \n\rsex=" + sex +
                ", \n\rage=" + age +
                ", \n\rheight=" + height +
                ", \n\rweight=" + weight +
                ", \n\rbornDate=" + bornDate;
        person += deadDate == null ? "" : ", \n\rdeadDate=" + deadDate;
        person += ", \n\raddress='" + address + '\'' +
                ", education=" + education;
        if (houses != null) {
            person += ", \n\rAllHourse:";
            for (House house : houses) {
                person += "\n\r\rhouses=" + houses.toString();
            }
        }
        if (houses != null) {
            for (Work work : works) {
                person += "\n\n work=" + work.toString();
            }
        }
        if (interests != null) {
            for (Interest interest : interests) {
                person += "\n\r\rinterest=" + interest.toString();
            }
        }
        if (lessons != null) {
            for (Lesson lesson : lessons) {
                person += "\n\r\rlesson=" + lesson.toString();
            }
        }
        if (memoryList != null) {
            for (Memory memory : memoryList) {
                person += "\n\r\rmemory=" + memory.toString();
            }
        }
        return person;
    }

    //endregion
}
