package week6.labTask;

import java.util.Random;

public class DualPivotQuickSort {

    public static <Data extends Comparable<Data>> void sort(Data[] elements) {
        shuffle(elements);
        sort(elements, 0, elements.length - 1);
    }

    private static <Data extends Comparable<Data>> void shuffle(Data[] elements) {
        Random random = new Random();
        for (int i = 1; i < elements.length; i++) {
            int r = random.nextInt(i + 1);
            swap(elements, i, r);
        }
    }

    private static <Data extends Comparable<Data>> void sort(Data[] elements, int low, int high) {
        if (high <= low) return;
        int[] pivots = partition(elements, low, high);
        sort(elements, low, pivots[0] - 1);
        sort(elements, pivots[0] + 1, pivots[1] - 1);
        sort(elements, pivots[1] + 1, high);
    }

    public static <Data extends Comparable<Data>> int[] partition(Data[] elements, int low, int high) {
        if (elements[low].compareTo(elements[high]) > 0) swap(elements, low, high);
        int lt = low + 1, gt = high - 1, i = low + 1;
        while (i <= gt) {
            if (elements[i].compareTo(elements[low]) < 0) swap(elements, lt++, i++);
            else if (elements[high].compareTo(elements[i]) < 0) swap(elements, i, gt--);
            else i++;
        }
        swap(elements, low, --lt);
        swap(elements, high, ++gt);
        return new int[]{lt, gt};
    }

    private static <Data extends Comparable<Data>> void swap(Data[] elements, int i, int j) {
        Data tmp = elements[i];
        elements[i] = elements[j];
        elements[j] = tmp;
    }
}