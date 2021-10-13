package app;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class App_Version2 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("E yyyy/MM/dd");
        Calendar calendar = Calendar.getInstance();

        // 防止錯誤輸入的變數
        int testGreenItem = 0;
        int testBlueItem = 0;
        int testPurpleItem = 0;
        int testCustomerMoney = 0;
        int testTryCustomerMoney = 0;

        int greenItem = 0;  // 綠色籤子
        int blueItem = 0;   // 藍色籤子
        int purpleItem = 0; // 紫色籤子
        String name = "歡迎光臨開心四川麻辣燙";
        String testValue = "輸入錯誤,請重新輸入 ";
        String symbol = "---------------------------";
        String Symbol2 = "串,共 $";
        String symbol3 = "-----已點選清單-----";

        System.out.println(name);
        System.out.println(sdf.format(calendar.getTime()));
        System.out.println(symbol);

        while (testGreenItem == 0) {
            System.out.print("請輸入綠色籤子的數目: ");
            input = new Scanner(System.in);
            testGreenItem = 1;
            try {
                greenItem = input.nextInt();
            } catch (Exception e) {
                System.out.println(testValue);
                testGreenItem = 0;
            }
        }
        while (testBlueItem == 0) {
            System.out.print("請輸入藍色籤子的數目: ");
            input = new Scanner(System.in);
            testBlueItem = 1;
            try {
                blueItem = input.nextInt();
            } catch (Exception e) {
                System.out.println(testValue);
                testBlueItem = 0;
            }
        }
        while (testPurpleItem == 0) {
            System.out.print("請輸入紫色籤子的數目: ");
            input = new Scanner(System.in);
            testPurpleItem = 1;
            try {
                purpleItem = input.nextInt();
            } catch (Exception e) {
                System.out.println(testValue);
                testPurpleItem = 0;
            }
        }
        System.out.println(symbol);

        int greenItemCost = greenItem * 6;      // 綠色籤子價錢
        int blueItemCost = blueItem * 8;        // 藍色籤子價錢
        int purpleItemCost = purpleItem * 10;   // 紫色籤子價錢

        System.out.println("綠色籤 ($6) x " + greenItem + Symbol2 + greenItemCost);
        System.out.println("藍色籤 ($8) x " + blueItem + Symbol2 + blueItemCost);
        System.out.println("紫色籤 ($10) x " + purpleItem + Symbol2 + purpleItemCost);

        System.out.println(symbol3);
        
        int totalItem = greenItem + blueItem + purpleItem; // 輸入的籤子總數
        int totalPrice = greenItemCost + blueItemCost + purpleItemCost; // 輸入的籤子總價錢
        int minPrice = 6; // 折扣變數

        System.out.println("總共 " + totalItem + "串");
        if ((greenItem == 0) & (blueItem > 0))
            minPrice = 8;
        else if ((blueItem == 0) & (purpleItem > 0))
            minPrice = 10;

        int minTotalItem = minPrice * (totalItem / 6);
     
        if (totalItem >= 6) {
            System.out.println("折扣前: " + totalPrice + "$");
            if (minPrice == 6) {
                double minPriceItemGreenItem = totalPrice - minTotalItem;
                System.out.println("已享用折扣:買滿6串免最低價格的一串收費,減" + minTotalItem + "$");
                System.out.println("折扣後" + minPriceItemGreenItem + "$");
            } else if (minPrice == 8) {
                double minPriceItemBlueItem = totalPrice - minTotalItem;
                System.out.println("已享用折扣:買滿6串免最低價格的一串收費,減" + minTotalItem + "$");
                System.out.println("折扣後" + minPriceItemBlueItem + "$");
            } else if (minPrice == 10) {
                double minPriceItemPurpleItem = totalPrice - minTotalItem;
                System.out.println("已享用折扣:買滿6串免最低價格的一串收費,減" + minTotalItem + "$");
                System.out.println("折扣後" + minPriceItemPurpleItem + "$");
            }
        }

        if (totalItem <= 6) {
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
        while (customerMoney < (totalPrice - minTotalItem)) {
            System.out.println("尚欠 $" + (customerMoney - (totalPrice - minTotalItem)));
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
            if (tryAgain >= (totalPrice - minTotalItem)) {
                System.out.println("收: $" + tryAgain + "找: $" + (tryAgain - (totalPrice - minTotalItem)));
                return;
            }
        }

        if (customerMoney >= totalPrice) {
            System.out.println("收: $" + customerMoney + "找: $" + (customerMoney - totalPrice));
            
        }
    }
}
