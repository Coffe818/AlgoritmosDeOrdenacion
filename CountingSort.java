public class CountingSort {
    static int mov = 0;

    public static void ImprimirArray(int[] array) {
        // System.out.println("\n");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " , ");
        } // end for
    }// end llenar array

    public static void countingSort(int[] arr) {
        int max = Maximo(arr);
        int[] count = new int[max + 1];

        for (int num : arr) {
            count[num]++;
            // mov++; // Incrementa el contador de movimientos
        } // end for

        ImprimirArray(arr);
        System.out.println(" ");
        ImprimirArray(count);
        System.out.println("\n=========================================");
        int i = 0;
        for (int j = 0; j <= max; j++) {

            while (count[j] > 0) {
                System.out.println("\n=========================================");
                arr[i++] = j;
                count[j]--;
                mov++; // Incrementa el contador de movimientos
                ImprimirArray(arr);
                System.out.println(" ");
                ImprimirArray(count);
            } // end while
        } // end for
    }// end CountingSort

    private static int Maximo(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            } // end if
        } // end for
        return max;
    }// end maximo

    public static void main(String[] args) {
        int[] array = { 4, 7, 5, 3 };
        countingSort(array);

    }
}// end class