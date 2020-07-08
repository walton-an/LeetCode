import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5, 1, 2, 3, 6, 4, 6, 2, 8, 9, 7};
        quickSort(0, arr.length - 1, arr);
        System.out.println();
    }

    public static void quickSort(int left, int right, int[] arr) {
        if (left < right) {
            int mid = getIndex2(left, right, arr);
            quickSort(left, mid - 1, arr);
            quickSort(mid + 1, right, arr);
        }
    }

    public static int getIndex(int l, int r, int[] arr) {
        int mid = arr[l];
        int midIndex = l;
        while (true) {
            while (l <= r && arr[l] <= mid)
                l++;
            while (l <= r && arr[r] >= mid)
                r--;
            if (l >= r) break;
            // 左右指针的数字进行位置交换
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
        }
        // 遍历完成，r肯定在l的左边，即r指针为中轴数
        arr[midIndex] = arr[r];
        arr[r] = mid;
        return r;
    }

    public static int getIndex2(int l, int r, int[] arr) {
        int mid = arr[l];
        while (l < r) {
            while (l < r && arr[r] >= mid)
                r--;
            arr[l] = arr[r];
            while (l < r && arr[l] <= mid)
                l++;
            arr[r] = arr[l];
        }
        arr[r] = mid;
        return r;
    }


}
