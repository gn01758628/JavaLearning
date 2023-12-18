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

        Map<String, Double> totalPayMap = new HashMap<>();
        for (TimeClockEntity entity : data) {
            String employeeName = entity.getEmployeeName();
            long minutes = Duration.between(entity.getTimeIn(), entity.getTimeOut()).toMinutes();
            double dailyPay = getDailyPay(minutes, entity.getHourlyRate());
            double monthlyPay = totalPayMap.getOrDefault(employeeName, 0.0);
            monthlyPay += dailyPay;
            totalPayMap.put(employeeName, monthlyPay);
        }

        for (Map.Entry<String, Double> entry : totalPayMap.entrySet()) {
            printSomebodyPay(entry.getKey(), entry.getValue());
        }

        // 分月份
        Map<String, YearlyPay> totalPayByMonthMap = new HashMap<>();
        for (TimeClockEntity entity : data) {
            String employeeName = entity.getEmployeeName();
            LocalDateTime timeIn = entity.getTimeIn();
            int month = timeIn.getMonthValue();
            long minutes = Duration.between(timeIn, entity.getTimeOut()).toMinutes();
            double dailyPay = getDailyPay(minutes, entity.getHourlyRate());
            YearlyPay yearlyPay = totalPayByMonthMap.computeIfAbsent(employeeName, k -> new YearlyPay());
            yearlyPay.updateMonthlyPay(month, dailyPay);
        }

        for (Map.Entry<String, YearlyPay> entry : totalPayByMonthMap.entrySet()) {
            String employeeName = entry.getKey();
            TreeMap<Integer, Double> monthlyPayTreeMap = entry.getValue().getMonthlyPayTreeMap();
            for (Map.Entry<Integer, Double> entry2 : monthlyPayTreeMap.entrySet()) {
                printSomebodyPayByMonth(employeeName, entry2.getKey(), entry2.getValue());
            }
        }

        // 分年分
        Map<String, EmployeePay> totalPayByYearMap = new HashMap<>();
        for (TimeClockEntity entity : data) {
            String employeeName = entity.getEmployeeName();
            LocalDateTime timeIn = entity.getTimeIn();
            int month = timeIn.getMonthValue();
            int year = timeIn.getYear();
            long minutes = Duration.between(timeIn, entity.getTimeOut()).toMinutes();
            double dailyPay = getDailyPay(minutes, entity.getHourlyRate());

            EmployeePay employeePay = totalPayByYearMap.computeIfAbsent(employeeName, k -> new EmployeePay());
            employeePay.updateYearlyPay(year, month, dailyPay);
        }

        for (Map.Entry<String, EmployeePay> entry : totalPayByYearMap.entrySet()) {
            String employeeName = entry.getKey();
            TreeMap<Integer, Map<Integer, Double>> yearlyPayTreeMap = entry.getValue().getYearlyPayTreeMap();
            for (Map.Entry<Integer, Map<Integer, Double>> entry2 : yearlyPayTreeMap.entrySet()) {
                int year = entry2.getKey();
                for (Map.Entry<Integer, Double> entry3: entry2.getValue().entrySet()) {
                    printSomebodyPayByYear(employeeName,year,entry3.getKey(),entry3.getValue());
                }
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
        System.out.printf("%s %02d月份薪水: %.2f$\n", name, month, pay);
    }

    private static void printSomebodyPayByYear(String name, int year, int month, double pay) {
        System.out.printf("%s %d年%02d月份薪水: %.2f$\n", name, year, month, pay);
    }

    private static double[] getWorkHours(long minutes) {
        if (minutes <= 0) return null;
        double hours = minutes / 60.0;
        // 以30分鐘為單位四捨五入
        hours *= 2;
        hours = Math.round(hours);
        hours /= 2;

        double[] workHours = new double[3];
        workHours[0] = Math.min(hours, 8);
        workHours[1] = Math.max(Math.min(hours - 8, 4), 0);
        workHours[2] = Math.max(hours - 12, 0);

        return workHours;
    }

    private static double getDailyPay(long minutes, double hourlyRate) {
        double[] workHours = getWorkHours(minutes);
        double dailyPay = 0.0;
        if (workHours == null) return dailyPay;
        dailyPay += workHours[0] * hourlyRate;
        dailyPay += workHours[1] * hourlyRate * 1.5;
        dailyPay += workHours[2] * hourlyRate * 2;
        return dailyPay;
    }

}
