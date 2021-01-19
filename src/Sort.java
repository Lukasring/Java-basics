public class Sort {
    public static void main (String[] args) {
        int[] data = {5,7,4,0,8,9,-5, 16, 0};
        int[] sortedData = simpleSort(data);

        for (int num : sortedData) {
            System.out.print(num + " ");
        }
    }

    public static int[] simpleSort(int[] data) {
        for(int i = 0; i<data.length; i++) {
            for (int j = i+1; j<data.length; j++) {
             if (data[j] > data[i]) {
                 int temp = data[j];
                 data[j] = data[i];
                 data[i] = temp;
             }
            }
        }
        return data;
    }
}
