package homework1;

public class BinarySearch {
    public static int[] search(Entry[] entries, String searchableName) {
        int start = -1;
        int end = -1;
        int low = 0;
        int high = entries.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = entries[mid].getName().compareTo(searchableName);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                start = mid;
                end = mid;
                // Expand to find all duplicates
                while (start > 0 && entries[start - 1].getName().equals(searchableName)) {
                    start--;
                }
                while (end < entries.length - 1 && entries[end + 1].getName().equals(searchableName)) {
                    end++;
                }
                break;
            }
        }

        if (start == -1 || end == -1) {
            return new int[0];
        }

        int[] result = new int[end - start + 1];
        for (int i = start; i <= end; i++) {
            result[i - start] = i;
        }
        return result;
    }
}
