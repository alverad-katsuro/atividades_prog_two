package com.system;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Interface interface_one = new Interface(sc);
        sc.close();
    }
}
