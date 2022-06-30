package com.test.designmode;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.*;

import org.junit.Test;

/**
 * TestDate
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/21 15:49
 **/

public class TestDate {
    private static int a;

    public static void main2(String[] args) throws ParseException {
        Date date = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(simpleDateFormat.format(date));
        //simpleDateFormat.parse(, )
        String format = "yy";
        Date date1 = new Date(date.getTime());
        java.sql.Date date2 = new java.sql.Date(date.getTime());
        System.out.println(date2);
        Date parse = simpleDateFormat.parse("2022-05-21 10:02:56");
        System.out.println("parse = " + parse);
    }

    //字符串转为sql.date
    @Test
    public void test02() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = simpleDateFormat.parse("2010-02-03");
        System.out.println(parse);
        java.sql.Date date = new java.sql.Date(parse.getTime());
        System.out.println(date);
    }

    //三天打鱼两天晒网,算出今天应该做什么
    @Test
    public void test03() throws ParseException {
        String date1 = "2010-01-02";
        String date2 = "2020-01-09";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = simpleDateFormat.parse(date1);
        Date parse1 = simpleDateFormat.parse(date2);
        //获取天数
        long days = (parse1.getTime() - parse.getTime()) / (1000 * 60 * 60 * 24) + 1;
        System.out.println(date1 + date2 + ":共有天数:" + days);
        if (days % 5 == 1 || days % 5 == 2 || days % 5 == 3) {
            System.out.println(date2 + ":应该:" + "打鱼");
        } else {
            System.out.println(date2 + ":应该:" + "晒网");
        }
    }

    @Test
    public void test04() throws ParseException {
        Calendar instance = Calendar.getInstance();
        LocalDate of = LocalDate.of(2010, 1, 2);
        LocalDate of1 = LocalDate.of(2012, 2, 10);

//        long l = of.toEpochDay();
//        System.out.println("l = " + l);
//        long l1 = of1.toEpochDay();
//        System.out.println("l1 = " + l1);
//        System.out.println("l1-l = " + (l1 - l+1));

        Duration between = Duration.between(of, of1);
        long l = between.toDays();
        System.out.println("l = " + l);


    }

    @Test
    public void test05() throws Exception {
        Instant now = Instant.now();
        System.out.println("now = " + now);
        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println("offsetDateTime = " + offsetDateTime);


        LocalDate now1 = LocalDate.now();

        DateTimeFormatter isoLocalDate = DateTimeFormatter.ISO_LOCAL_DATE;

        String format = isoLocalDate.format(now1);
        System.out.println("format = " + format);

        TemporalAccessor parse = isoLocalDate.parse("2022-05-22");
        System.out.println(parse);

    }

    @Test
    public void test06() throws Exception {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        DateTimeFormatter dateTimeFormatter3 = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        System.out.println("dateTimeFormatter.format(LocalDate.now()) = " + dateTimeFormatter.format(LocalDate.now()));
        System.out.println("dateTimeFormatter.format(LocalDate.now()) = " + dateTimeFormatter1.format(LocalDate.now()));
        System.out.println("dateTimeFormatter.format(LocalDate.now()) = " + dateTimeFormatter2.format(LocalDate.now()));
        System.out.println("dateTimeFormatter.format(LocalDate.now()) = " + dateTimeFormatter3.format(LocalDate.now()));

    }

    @Test
    public void test08() {
//        String[] x={"ab","cd","ef",};
//        Arrays.sort(x, (o1, o2) -> {
//            return -o1.compareToIgnoreCase(o2);
//        });
//        for (String s : x) {
//            System.out.println("s = " + s);
//            System.exit(-1);
//        }
//        Properties properties = System.getProperties();
//        for (Map.Entry<Object, Object> objectObjectEntry : properties.entrySet()) {
//            System.out.println(objectObjectEntry.getKey().toString() +"::"+ objectObjectEntry.getValue());
//        }
        System.out.println("Math.round(-11.3) = " + Math.round(-11.3));
        System.out.println("Math.round(-11.3) = " + Math.round(-11.6));
        System.out.println("Math.round(11.2) = " + Math.round(11.2));
        System.out.println("Math.round(11.2) = " + Math.round(11.7));
    }

    @Test
    public void test09() {
        BigDecimal bigDecimal = new BigDecimal(2222222.123);
        BigDecimal divisor = new BigDecimal(2);
        BigDecimal divide = bigDecimal.divide(divisor);
        BigDecimal divide1 = bigDecimal.divide(divisor, 5, RoundingMode.UP);
        System.out.println("divide = " + divide);
        System.out.println("divide1 = " + divide1);
    }

    //冒泡排序
    @Test
    public void bubbleSort() {
        int[] arr = {1, 2, 5, 6, 89, 2};
        //只需要进行length-1次比较
        for (int i = 0; i < arr.length - 1; i++) {
            //每次比较出一个最大值,并使比较的上限下标减去1
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }

    public static int[] bubbleSort2(int[] arr) {
        //只需要进行length-1次比较
        for (int i = 0; i < arr.length - 1; i++) {
            //每次比较出一个最大值,并使比较的上限下标减去1
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int cap = 10;
        //生成数组
//        int[] arr = new int[cap];
//        for (int i = 0; i < cap; i++) {
//            int i1 = new Random().nextInt(100);
//            arr[i]=i1;
//        }
        int[] arr = {5, 4, 3, 2, 1};
        int right = arr.length - 1;
        int left = 0;
        System.out.println("快速排序开始");
        long quickSortStart = System.currentTimeMillis();
        quickSortV3(arr, left, right);
        long quickSortEnd = System.currentTimeMillis();
        System.out.println("快速排序结束,耗时: " + (quickSortEnd - quickSortStart) + " ms");
        System.out.println(Arrays.toString(arr));

//        System.out.println(":::::::::::::::::::::::::::::::::");
//        int[] arr2 = new int[cap];
//        for (int i = 0; i < cap; i++) {
//            int i1 = new Random().nextInt(100);
//            arr2[i]=i1;
//        }
//        System.out.println("冒泡排序开始");
//        long bubbleSortStart = System.currentTimeMillis();
//        bubbleSort2(arr2);
//        long bubbleSortEnd= System.currentTimeMillis();
//        System.out.println("快速排序结束,耗时: "+(bubbleSortEnd-bubbleSortStart)+" ms");

//        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
//        System.out.println("a = " + a);
    }

    private static int[] quickSortV3(int[] arr, int left, int right) {
        a++;
        //递归退出条件
        if (left >= right)
            return arr;
        int pivot = arr[left];
        int low = left;
        int high = right;
        //走到重合下标
        while (low != high) {
            //从右往左开始
            while (low < high && arr[high] >= arr[left]) {
                high--;
            }
            //继而从左往右
            while (low < high && arr[low] < arr[left]) {
                low++;
            }
            //判断是否仍在两边,才可交换
            if (low != high) {
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
            }
        }
        //交换pivot和重合位置的值
        int temp2 = arr[left];
        arr[left] = arr[high];
        arr[high] = temp2;
        quickSortV3(arr, left, high - 1);
        quickSortV3(arr, high + 1, right);

        return arr;

    }

    //失败的快速排序  22/5/22 06:26
    //快速排序
    //@Test
    public static void quickSort(int[] arr, int right, int left) {
        //递归结束条件,
        if (left < right) {
            int start = left;
            int end = right;

            int pivot = arr[left];

            while (start < end) {
                for (; ; ) {
                    if (arr[start] <= pivot && start < end) {
                        start++;
                    } else {
                        break;
                    }
                }
                for (; ; ) {
                    if (arr[end] > pivot && start < end) {
                        end--;
                    } else {
                        break;
                    }
                }
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
            int temp = arr[left];
            arr[left] = arr[end];
            arr[end] = temp;

            quickSort(arr, end - 1, left);
            quickSort(arr, right, end + 1);
        }
    }

    public static int[] quickSortV2(int[] arr, int low, int high) {
        if (low < high) {
            int left = low;
            int right = high;
            int pivot = arr[low];
            while (left != right) {
                while (arr[right] >= arr[low] && left < right)
                    right--;
                while (arr[left] < arr[low] && left < right)
                    left++;
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
            int temp = arr[low];
            arr[low] = arr[right];
            arr[right] = temp;
            quickSortV2(arr, low, right - 1);
            quickSortV2(arr, right + 1, high);
        }
        return arr;
    }

    public static void qSort(int[] arr, int low, int high) {
        if (low < high) {
            int left = low;
            int right = high;
            while (left != right) {
                while (arr[right] >= arr[low] && right > left) {
                    right--;
                }
                while (arr[left] < arr[low] && left < right) {
                    left++;
                }
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
            int temp1 = arr[low];
            arr[low] = arr[right];
            arr[right] = temp1;
            qSort(arr, low, right - 1);
            qSort(arr, right + 1, high);
        }
    }

    public static void main3(String[] args) {
        int[] x = {1, 2, 4, 5, 8, 9, 10};
        System.out.println("test10BinarySearch(x,3) = " + test10BinarySearch(x, 3));
    }

    public static int test10BinarySearch(int[] arr, int para) {

        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = arr[mid];
            if (para > midVal)
                low = mid + 1;
            else if (para < midVal)
                high = mid - 1;
            else
                return mid;
        }

        return -1;
    }
}

































































































































































