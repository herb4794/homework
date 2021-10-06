/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;
import java.util.Scanner;
/**
 * 
 * @Data Oct/06
 * @author Lawrence
 *
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        System.out.println("歡迎光臨開心四川麻辣燙");
        System.out.println("---------------------------");
        System.out.print("請輸入綠色籤子的數目: ");
        int greenItem = s.nextInt();    //綠色籤子
        System.out.print("請輸入藍色籤子的數目: ");
        int blueItem = s.nextInt();     //藍色籤子
        System.out.print("請輸入紫色籤子的數目: ");
        int purpleItem = s.nextInt();   //紫色籤子
        System.out.println("-----已點選清單-----");
        
        int greenItemCost = greenItem * 6;      //綠色籤子價錢
        int blueItemCost = blueItem * 8;        //藍色籤子價錢
        int purpleItemCost = purpleItem * 10;   //紫色籤子價錢

        System.out.println("綠色籤 ($6) x " + greenItem + "技,共 $" + (greenItemCost));
        System.out.println("藍色籤 ($8) x " + blueItem + "技,共 $" + (blueItemCost));
        System.out.println("紫色籤 ($10) x " + purpleItem + "技,共 $" + (purpleItemCost));
        System.out.println("-------------------");
        
        int totalItem = greenItem + blueItem + purpleItem ;     //輸入的籤子總數
        int totalPrice = greenItemCost + blueItemCost + purpleItemCost;     //輸入的籤子總價錢
        int minPrice = 6;       //  折扣變數

        if ( (greenItem == 0) & (blueItem > 0) )
        minPrice = 8;
            else if ((blueItem == 0 ) & (purpleItem > 0))
            minPrice = 10;

        if (totalItem >= 6){
            System.out.println("折扣前: " + totalPrice);
            System.out.println("已享用折扣:買滿6串免一串收費,減" + (minPrice));
            totalPrice = totalPrice - minPrice;
            System.out.println("折扣後" + totalPrice);
            System.out.println("-------------------");
        }else if (totalItem <= 6){
            System.out.println("總銀碼:$: " + totalPrice);
            System.out.println("-------------------");
        }        

        System.out.print("請輸入食客給予的銀碼($): ");
        double customerMoney = s.nextInt();     //銀碼       
        while (customerMoney < totalPrice) {
            System.out.println("尚欠 $" + (customerMoney - totalPrice));
            
                System.out.print("請輸入食客給予的銀碼($): ");
                double tryAgain = s.nextInt(); 
                    if (tryAgain >= totalPrice){
                        System.out.println("收: $" + tryAgain + "找: $" + (tryAgain - totalPrice));
                        return;
            }           
        }
        
        if (customerMoney >= totalPrice){
            System.out.println("收: $" + customerMoney + "找: $" + (customerMoney - totalPrice));
        }

    }
}