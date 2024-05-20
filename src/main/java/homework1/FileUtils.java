package homework1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static Entry[] readFile(String filePath) throws FileNotFoundException {
        List<Entry> entries = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Skip the header
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                entries.add(new Entry(data[0], data[1], data[2], data[3], data[4], data [5]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entries.toArray(new Entry[0]);
    }

    public static void writeToFile(Entry[] entries, String filePath) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("name;street_address;city;postcode;country;phone_number\n");
            for (Entry entry : entries) {
                bw.write(String.format("%s;%s;%s;%s;%s;%s\n",
                        entry.getName(),
                        entry.getStreetAddress(), entry.getCity(),
                        entry.getPostcode(), entry.getCountry(),
                        entry.getPhoneNumber()));
            }
        }
    }
}
