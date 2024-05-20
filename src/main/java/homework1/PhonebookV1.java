package homework1;

import java.io.IOException;
import java.util.Scanner;

public class PhonebookV1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Loading the entries...");
        Entry[] entries;
        try {
            entries = FileUtils.readFile("/Users/eldardadic/Desktop/raw_phonebook_data.csv");
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        System.out.println("Sorting the entries...");
        MergeSort.sort(entries);

        System.out.println("Saving the sorted file...");
        try {
            FileUtils.writeToFile(entries, "/Users/eldardadic/Desktop/sorted_phonebook_data.csv");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
            return;
        }

        System.out.println("System is ready.");

        while (true) {
            System.out.println("Enter the name that you wish to search for, or -1 to exit: ");
            String input = scanner.nextLine();
            if (input.equals("-1")) {
                break;
            }

            int[] results = BinarySearch.search(entries, input);
            if (results.length == 0) {
                System.out.println("No entries with the given name exist in the phonebook.");
            } else {
                System.out.println("Entries found: " + results.length);
                for (int index : results) {
                    System.out.println(entries[index]);
                }
            }
        }

        scanner.close();
        System.out.println("Thank you for using the phonebook.");
    }

}
