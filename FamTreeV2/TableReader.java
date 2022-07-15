package FamTreeV2;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class TableReader {

    public ArrayList<String[]> csvReader() throws IOException {
        ArrayList<String[]> data = new ArrayList<>();
        BufferedReader bf = null;
        String line = "";
        try {
            bf = new BufferedReader(new FileReader("FamTreeV2/FamTree.csv"));
            while ((line = bf.readLine()) != null) {
                String[] rowData = line.split(",");
                data.add(rowData);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bf != null) {
                try {
                    bf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        data.remove(0);
        return data;
    }
}
