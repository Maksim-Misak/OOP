package FamTreeV2;

public class Person {
    int id;
    String familyName;
    String firstName;
    int age;
    String gender;
    int mothersId;
    int fathersId;

    public Person(int id, String familyName, String firstName, int age, String gender, int mothersId, int fathersId) {
        this.id = id;
        this.familyName = familyName;
        this.firstName = firstName;
        this.age = age;
        this.gender = gender;
        this.mothersId = mothersId;
        this.fathersId = fathersId;
    }
    
    public StringBuilder getInfo() {
        StringBuilder human = new StringBuilder();
        human.append(this.id + ",");
        human.append(this.familyName + ",");
        human.append(this.firstName + ",");
        human.append(this.age + ",");
        human.append(this.gender + ",");
        human.append(this.mothersId + ",");
        human.append(this.fathersId + "\n");
        return human;
    }
}
