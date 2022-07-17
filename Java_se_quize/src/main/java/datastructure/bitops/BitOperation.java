package datastructure.bitops;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BitOperation
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/7/17 2:43
 **/
public class BitOperation {
    public static void main(String[] args) throws IOException {

        //bitEqualsTo1();
    }

    //整数的二进制位数为1的数量
    public static void bitEqualsTo1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int num2=num;
        int count=0;
        while (num != 0) {
            num = num & (num - 1);
            count++;
        }
        System.out.println(num2+":共有:"+count+"个::二进制为1的位");
    }

}
