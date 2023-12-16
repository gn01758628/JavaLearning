package interviewquestions.calculatesalary;
//  題目：
//  計算每位員工的總應付總薪資,並請使用 printSomebodyPay 將結果顯示在console上

//  細部描述：
//  目前已有取得每人每日打卡資料的功能 TimeClockService.getData()
//  請依據打卡資料計算日薪，然後計算每人月薪
//  最後將每人月薪傳入 printSomebodyPay 方法進行顯示

//  根據美國勞基法規定：
//  第0~8小時給予基本時薪
//  第8~12小時給予基本時薪x1.5倍
//  第12小時開始給予基本時薪x2倍

//  答題題示：
//  1.除了本試題說明的註解外，你可以對這支程式的任何邏輯(含printSomebodyPay)做修改
//  2.承1，但正常只需要於 main 撰寫邏輯即可完成此題
//  3.本程式所用的日期時間物件為 LocalDateTime，這是一個於java8後才引入的class
//    LocalDateTime有一套相關的Api可以計算兩個時間的間距，請自行搜索

//  若要測試程式是否可以運作，可以直接執行main方法

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class App {

    public static void main(String[] args) {
        List<TimeClockEntity> data = TimeClockService.getData();

        // 不分月份
        Map<String, Double> employeePay = new HashMap<>();
        for (TimeClockEntity entity : data) {
            String employeeName = entity.getEmployeeName();
            double monthlyPay = employeePay.getOrDefault(employeeName, 0.0);
            Duration duration = Duration.between(entity.getTimeIn(), entity.getTimeOut());
            double dailyPay = calculateDailyPay(duration.toMinutes(), entity.getHourlyRate());
            monthlyPay += dailyPay;
            employeePay.put(employeeName, monthlyPay);
        }

        Set<Map.Entry<String, Double>> entries = employeePay.entrySet();
        for (Map.Entry<String, Double> entry : entries) {
            printSomebodyPay(entry.getKey(), entry.getValue());
        }

        // 分月份
        Map<String, TreeMap<Integer, Double>> employeePayByMonth = new HashMap<>();
        for (TimeClockEntity entity : data) {
            String employeeName = entity.getEmployeeName();
            LocalDateTime timeIn = entity.getTimeIn();
            int month = timeIn.getMonthValue();

            TreeMap<Integer, Double> payByMonth = employeePayByMonth.getOrDefault(employeeName, new TreeMap<>());
            double monthlyPay = payByMonth.getOrDefault(month, 0.0);

            Duration duration = Duration.between(timeIn, entity.getTimeOut());
            double dailyPay = calculateDailyPay(duration.toMinutes(), entity.getHourlyRate());

            monthlyPay += dailyPay;
            payByMonth.put(month, monthlyPay);
            employeePayByMonth.put(employeeName, payByMonth);
        }

        Set<Map.Entry<String, TreeMap<Integer, Double>>> entries1 = employeePayByMonth.entrySet();
        for (Map.Entry<String, TreeMap<Integer, Double>> entry : entries1) {
            String employeeName = entry.getKey();
            TreeMap<Integer, Double> payByMonth = entry.getValue();
            Set<Map.Entry<Integer, Double>> entries2 = payByMonth.entrySet();
            for (Map.Entry<Integer, Double> entry2 : entries2) {
                printSomebodyPayByMonth(employeeName,entry2.getKey(),entry2.getValue());
            }
        }
    }


    /**
     * 格式化於console印出某人的薪資
     *
     * @param name 姓名
     * @param pay  薪資
     */
    private static void printSomebodyPay(String name, double pay) {
        System.out.printf("%s: %.2f$\n", name, pay);
    }

    private static void printSomebodyPayByMonth(String name, int month, double pay) {
        System.out.printf("%s %s月薪水: %.2f$\n", name, month, pay);
    }

    private static double[] calculateWorkHours(long minutes) {
        if (minutes < 15) return null;
        double[] workHours = new double[3];
        double hours = minutes / 60.0;
        // 以30分鐘為單位4捨5入
        hours *= 2;
        hours = Math.round(hours);
        hours /= 2;
        // 沒加班的正常時數
        workHours[0] = Math.min(hours, 8);
        // 加班4小時內的時數
        workHours[1] = Math.max(Math.min(hours - 8, 4), 0);
        // 加班超過4小時的時數
        workHours[2] = Math.max(hours - 12, 0);
        return workHours;
    }

    private static double calculateDailyPay(long minutes, double hourlyRate) {
        double[] workHours = calculateWorkHours(minutes);
        if (workHours == null) return 0.0;
        double dailyPay = 0.0;
        dailyPay += workHours[0] * hourlyRate;
        dailyPay += workHours[1] * hourlyRate * 1.5;
        dailyPay += workHours[2] * hourlyRate * 2;
        return dailyPay;
    }
}
