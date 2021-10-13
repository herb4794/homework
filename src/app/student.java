package javaapplication1;

import java.util.Scanner;

/**
 * @author Cheng Man Hon Lawrence
 * @Data 2021 Oct/06
 * @Function: This program is allows customer to make transactions and using
 * discount functions
 */
public class JavaApplication1 {

    public static void main(String[] args) {

        System.out.println("歡迎光臨開心四川麻辣燙");
        System.out.println("---------------------------");

        Scanner s = new Scanner(System.in);
        int testGreenItem = 0, testBlueItem = 0, testPurpleItem = 0, testCustomerMoney = 0, testTryCustomerMoney = 0;

        int greenItem = 0;    //綠色籤子
        int blueItem = 0;     //藍色籤子
        int purpleItem = 0;   //紫色籤子       

        Scanner input = new Scanner(System.in);

        while (testGreenItem == 0) {
            System.out.print("請輸入綠色籤子的數目: ");//綠色籤子
            input = new Scanner(System.in);
            testGreenItem = 1;
            try {
                greenItem = input.nextInt();
            } catch (Exception e) {
                System.out.println("輸入錯誤,請重新輸入 ");
                testGreenItem = 0;
            }
        }
        while (testBlueItem == 0) {
            System.out.print("請輸入藍色籤子的數目: ");//藍色籤子
            input = new Scanner(System.in);
            testBlueItem = 1;
            try {
                blueItem = input.nextInt();
            } catch (Exception e) {
                System.out.println("輸入錯誤,請重新輸入 ");
                testBlueItem = 0;
            }
        }
        while (testPurpleItem == 0) {
            System.out.print("請輸入紫色籤子的數目: ");//紫色籤子
            input = new Scanner(System.in);
            testPurpleItem = 1;
            try {
                purpleItem = input.nextInt();
            } catch (Exception e) {
                System.out.println("輸入錯誤,請重新輸入 ");
                testPurpleItem = 0;
            }
        }

        System.out.println("-----已點選清單-----");

        int greenItemCost = greenItem * 6;      //綠色籤子價錢
        int blueItemCost = blueItem * 8;        //藍色籤子價錢
        int purpleItemCost = purpleItem * 10;   //紫色籤子價錢

        System.out.println("綠色籤 ($6) x " + greenItem + "技,共 $" + (greenItemCost));
        System.out.println("藍色籤 ($8) x " + blueItem + "技,共 $" + (blueItemCost));
        System.out.println("紫色籤 ($10) x " + purpleItem + "技,共 $" + (purpleItemCost));
        System.out.println("-------------------");

        int totalItem = greenItem + blueItem + purpleItem;     //輸入的籤子總數
        int totalPrice = greenItemCost + blueItemCost + purpleItemCost;     //輸入的籤子總價錢
        int minPrice = 6;       //  折扣變數

        if ((greenItem == 0) & (blueItem > 0)) {
            minPrice = 8;
        } else if ((blueItem == 0) & (purpleItem > 0)) {
            minPrice = 10;
        }

        if (totalItem >= 6) {
            System.out.println("折扣前: " + totalPrice);
            System.out.println("已享用折扣:買滿6串免一串收費,減" + (minPrice));
            totalPrice = totalPrice - minPrice;
            System.out.println("折扣後" + totalPrice);
            System.out.println("-------------------");
        } else if (totalItem <= 6) {
            System.out.println("總銀碼:$: " + totalPrice);
            System.out.println("-------------------");
        }

        double customerMoney = 0;

        while (testCustomerMoney == 0) {
            System.out.print("請輸入食客給予的銀碼($): ");
            input = new Scanner(System.in);
            testCustomerMoney = 1;
            try {
                customerMoney = input.nextInt();
            } catch (Exception e) {
                System.out.println("輸入錯誤,請重新輸入 ");
                testCustomerMoney = 0;
            }
        }

        double tryAgain = 0;

        while (customerMoney < totalPrice) {
            System.out.println("尚欠 $" + (customerMoney - totalPrice));

            while (testTryCustomerMoney == 0) {
                System.out.print("請輸入食客給予的銀碼($): ");
                input = new Scanner(System.in);
                testTryCustomerMoney = 1;
                try {
                    tryAgain = input.nextInt();
                } catch (Exception e) {
                    System.out.println("輸入錯誤,請重新輸入 ");
                    testTryCustomerMoney = 0;
                }

            }

            if (tryAgain >= totalPrice) {
                System.out.println("收: $" + tryAgain + "找: $" + (tryAgain - totalPrice));
                return;
            }
        }

        if (customerMoney >= totalPrice) {
            System.out.println("收: $" + customerMoney + "找: $" + (customerMoney - totalPrice));
        }
    }
}
