import java.util.Arrays;

public class Array {
    public static void main(String[] args) {

        // c2
        int[] array = new int[5]; // 10 so luong toi da cac phan tu
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        array[3] = 4;
        array[4] = 5;
        array = removeItemByIndex(3, array);
        System.out.println(Arrays.toString(array));
        array=addItem(6, array);
        System.out.println(Arrays.toString(array));
        int number = 3;
        number = findIndexByValue(number, array);
        System.out.println(number);


    }

    static int[] removeItem(int a, int b, int[] arrayRemove) {
        int countItemRemove = b - a + 1;
        int[] newArray2 = new int[arrayRemove.length - countItemRemove];
        for (int i = 0; i < arrayRemove.length; i++) {
            if (i < a) {
                newArray2[i] = arrayRemove[i]; // [1,0]
            } else {
                if(i == arrayRemove.length - countItemRemove) {
                    break;
                }
                newArray2[i] = arrayRemove[i + countItemRemove];
            }
        }
        arrayRemove = newArray2;
        return arrayRemove;
    }

    // xoa phan tu theo index
    static int[] removeItemByIndex(int index, int[] array) {
        int[] newArray = new int[array.length - 1];
        for (int i = 0; i < newArray.length; i++) {
            if (i < index) {
                newArray[i] = array[i];
            } else {
                newArray[i] = array[i + 1];
            }
        }
        return newArray;
    }

    // them phan tu
    static int[] addItem(int item, int[] array) {
        int[] newArray = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[newArray.length - 1] = item;
        return newArray;
    }

    // Tim index cua phan tu
    static int findIndexByValue(int value, int[] array) {
        for (int i = 0; i < array.length;i++){
            if(array[i] == value){
                return i;
            }
        }
        return -1;
    }
}