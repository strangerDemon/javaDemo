import entity.life.Person;
import entity.life.enumeration.Sex;

public class Main {

    public static void main(String[] args) {
        Person I=Person.born(Sex.MALE,"demo");
        System.out.println(I.toString());
    }
}
