package FamTreeV2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) throws IOException {
        List<Person> family = new ArrayList<Person>();
        TableCreator table = new TableCreator();
        ArrayList<String[]> data = new ArrayList<>();
        TableReader reader = new TableReader();
        Person vasilii = new Person(1, "Petrov", "Vasya", 38, "male", 0, 0);
        Person anna = new Person(2, "Petrova", "Anna", 37, "female", 0, 0);
        Person anatole = new Person(3, "Petrov", "Anatoley", 27, "male", 2, 1);
        Person vita = new Person(4, "Shliapina", "Vita", 26, "female", 2, 1);
        Person viktor = new Person(5, "Shliapin", "Viktor", 30, "male", 0, 0);
        Person axel = new Person(6, "Shliapin", "Axel", 5, "male", 4, 5);
        Person alla = new Person(7, "Shliapina", "Alla", 12, "female", 4, 5);
        Person feofontii = new Person(8, "Petrov", "Feofontii", 6, "male", 0, 3);

        family.add(vasilii);
        family.add(anna);
        family.add(anatole);
        family.add(vita);
        family.add(viktor);
        family.add(axel);
        family.add(alla);
        family.add(feofontii);

        table.crateCSV(family);
        data = reader.csvReader();
        Research r = new Research(data);
        r.researchHeritage(8);

    }
}