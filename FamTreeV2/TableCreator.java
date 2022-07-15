package FamTreeV2;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TableCreator {
    public void crateCSV(List<Person> familia) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new File("FamTreeV2/FamTree.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String columns = "id, family name, first name, age, gender, mothers id, fathers id";

        pw.write(columns + "\n");

        for (Person person : familia) {
            pw.write(person.getInfo().toString());
        }

        pw.close();
    }
}
