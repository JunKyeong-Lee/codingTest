package com.baekjoon.BaaaaaaaaaaarkingDog0x01.p2441;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        for (int i = 0; i < num; i++) {
            for (int j = num; j > num - i; j--) {
                System.out.print(' ');
            }
            for (int j = 0; j < num - i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }
}
