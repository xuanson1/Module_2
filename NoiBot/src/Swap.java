public class Swap {

    // Hàm thực hiện thuật toán sắp xếp nổi bọt
    public static void bubbleSort(int[] scores) {
        int n = scores.length;
        boolean swapped;
        int count  = 0;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (scores[j] > scores[j + 1]) {
                    // Hoán đổi scores[j] và scores[j + 1]
                    int temp = scores[j];
                    scores[j] = scores[j + 1];
                    scores[j + 1] = temp;
                    swapped = true;
                }
                count++;
            }
            // Nếu không có phần tử nào bị hoán đổi trong vòng lặp này, mảng đã được sắp xếp
            if (!swapped) break;
        }
    }

    // Hàm in ra mảng
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Mảng chứa điểm số của học sinh
        int[] scores = {85, 70, 95, 60, 90, 78, 88, 76};

        System.out.println("Điểm số chưa sắp xếp:");
        printArray(scores);

        // Sắp xếp điểm số bằng thuật toán sắp xếp nổi bọt
        bubbleSort(scores);

        System.out.println("Điểm số sau khi sắp xếp:");
        printArray(scores);

    }
}