package lesson8.HomeWork.StudentLigs;

public class Demo {


    Student createHighestParent(){

        Course[] coursesTaken = {};

        return new Student("Mykyta", "King", 1, coursesTaken);
    }

    SpecialStudent createLowestChild(){

        Course[] coursesTakenTesla = {};
        return new SpecialStudent("Nikola", "Tesla", 2, coursesTakenTesla, 0000, "tesla@");
    }
}
