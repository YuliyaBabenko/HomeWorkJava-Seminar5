// Учитывая два целочисленных массива nums1 и nums2, верните максимальную длину подмассива, который
// появляется в обоих массивах.
// Example 1:
// Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
// Output: 3
// Explanation: Повторяющийся подмассив с максимальной длиной равен [3,2,1].
// Example 2:
// Input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
// Output: 5
// Explanation: Повторяющийся подмассив с максимальной длиной равен [0,0,0,0,0].

import java.util.*;

class homeWork {
    public static void main(String[] args) {
        ArrayList<Integer> nums1 = new ArrayList<Integer>();
        ArrayList<Integer> nums2 = new ArrayList<Integer>();
        fillArray(nums1);
        fillArray(nums2);
        ArrayList<ArrayList<Integer>> arr_nums1 = subArrayArray(nums1);
        ArrayList<ArrayList<Integer>> arr_nums2 = subArrayArray(nums2);
        subArrayMaxLen(arr_nums1, arr_nums2);
    }

    static public void fillArray(ArrayList<Integer> arr) {
        for (int i = 0; i < 5; i++) {
            int num = (int) (Math.random() * 7);
            arr.add(num);
        }
        System.out.println(arr);
    }

    static public ArrayList<ArrayList<Integer>> subArrayArray(ArrayList<Integer> arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int k = 0;
        for (int j = 0; j < arr.size() - 1; j++) {
            k = j;
            ArrayList<Integer> pre_res = new ArrayList<Integer>();
            while (k < arr.size()) {
                pre_res.add(arr.get(k));
                k++;
            }
            result.add(pre_res);
        }
        for (int l = 1; l < arr.size() - 1; l++) {
            ArrayList<Integer> pre_res = new ArrayList<Integer>();
            pre_res.add(arr.get(l - 1));
            pre_res.add(arr.get(l));
            pre_res.add(arr.get(l + 1));
            result.add(pre_res);
        }
        for (int o = 0; o < arr.size() - 1; o++) {
            ArrayList<Integer> pre_res = new ArrayList<Integer>();
            pre_res.add(arr.get(o));
            pre_res.add(arr.get(o + 1));
            result.add(pre_res);
        }
        return result;
    }

    static public void subArrayMaxLen(ArrayList<ArrayList<Integer>> arr1, ArrayList<ArrayList<Integer>> arr2) {
        Set<ArrayList<Integer>> numsTwo = new HashSet<ArrayList<Integer>>(arr2);
        Set<ArrayList<Integer>> intersection = new HashSet<ArrayList<Integer>>(arr1);
        intersection.retainAll(numsTwo);
        if (intersection.size() > 1) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            int len = 2;
            for (ArrayList<Integer> item : intersection) {
                if (item.size() > len) {
                    len = item.size();
                    temp = item;
                }
            }
            if (len == 2) {
                for (ArrayList<Integer> item : intersection) {
                    System.out.println("Максимальная длина подмассива = " + item.size());
                    break;
                }
            } else {
                System.out.print("Максимальная длина подмассива = " + temp.size());
            }
        }
        if (intersection.size() == 1) {
            System.out.println("Максимальная длина подмассива = 2");
        }
        if (intersection.size() == 0) {
            System.out.println("Общего подмассива минимум из двух элементов в данных массивах нет");
        }
    }
}