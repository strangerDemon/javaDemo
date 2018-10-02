import entity.life.Interest;
import entity.life.Lesson;
import entity.life.Person;
import entity.life.enumeration.Education;
import entity.life.enumeration.Sex;

public class Main {

    public static void main(String[] args) {
        Person I=Person.born(Sex.MALE,"demo");

        while(I.getAge()<7){//paly stage
            Interest interest =Interest.getCurrentInterset(I.getAge());
            I.addAge();
        }
        while(I.getAge()<23){//learn stage
            I.study(new Lesson());
            I.addAge();
        }
        I.setEducation(Education.BACHELOR);
        while(!I.haveGirlFriend()){
            try {
                I.meetAGirlFrined();
            }catch(Exception ex){
                System.out.println("once more");
            }
        }

        /*while(I.isLiving()){//work

        }*/
        System.out.println("life log:"+I.toString());
    }
}
