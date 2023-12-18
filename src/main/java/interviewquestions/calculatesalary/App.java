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

        System.out.println("=======================");

        // 分月份
        Map<String, Map<Integer, Double>> employeePayByMonthTemp = new HashMap<>();

        for (TimeClockEntity entity : data) {
            String employeeName = entity.getEmployeeName();
            LocalDateTime timeIn = entity.getTimeIn();
            int month = timeIn.getMonthValue();
            Map<Integer, Double> monthlyPayMap = employeePayByMonthTemp.computeIfAbsent(employeeName, k -> new HashMap<>());
            double monthlyPay = monthlyPayMap.getOrDefault(month, 0.0);
            long minutes = Duration.between(timeIn, entity.getTimeOut()).toMinutes();
            double dailyPay = calculateDailyPay(minutes, entity.getHourlyRate());
            monthlyPay += dailyPay;
            monthlyPayMap.put(month, monthlyPay);
        }

        Map<String, TreeMap<Integer, Double>> employeePayByMonth = new HashMap<>();
        Set<Map.Entry<String, Map<Integer, Double>>> entries1 = employeePayByMonthTemp.entrySet();
        for (Map.Entry<String, Map<Integer, Double>> entry : entries1) {
            employeePayByMonth.put(entry.getKey(), new TreeMap<>(entry.getValue()));
        }

        Set<Map.Entry<String, TreeMap<Integer, Double>>> entries2 = employeePayByMonth.entrySet();
        for (Map.Entry<String, TreeMap<Integer, Double>> entry : entries2) {
            String employeeName = entry.getKey();
            TreeMap<Integer, Double> payByMonth = entry.getValue();
            Set<Map.Entry<Integer, Double>> entries3 = payByMonth.entrySet();
            for (Map.Entry<Integer, Double> entry2 : entries3) {
                printSomebodyPayByMonth(employeeName, entry2.getKey(), entry2.getValue());
            }
        }

        System.out.println("=======================");

        // 利用新增的類別，分月份
        Map<String, AnnualPay> employeeAnnualPay = new HashMap<>();

        for (TimeClockEntity entity : data) {
            String employeeName = entity.getEmployeeName();
            LocalDateTime timeIn = entity.getTimeIn();
            int month = timeIn.getMonthValue();

            long minutes = Duration.between(timeIn, entity.getTimeOut()).toMinutes();
            double dailyPay = calculateDailyPay(minutes, entity.getHourlyRate());

            AnnualPay annualPay = employeeAnnualPay.computeIfAbsent(employeeName, k -> new AnnualPay());
            annualPay.updateMonthlyPay(month, dailyPay);
        }

        Set<Map.Entry<String, AnnualPay>> entries4 = employeeAnnualPay.entrySet();
        for (Map.Entry<String, AnnualPay> entry : entries4) {
            String employeeName = entry.getKey();
            Set<Map.Entry<Integer, Double>> entries5 = entry.getValue().getMonthlyPayTreeMap().entrySet();
            for (Map.Entry<Integer, Double> entry2 : entries5) {
                printSomebodyPayByMonth(employeeName, entry2.getKey(), entry2.getValue());
            }
        }

        System.out.println("=======================");

        // 利用新增的類別，分年分
        Map<String, EmployeePay> employeePayMap = new HashMap<>();

        for (TimeClockEntity entity : data) {
            String employeeName = entity.getEmployeeName();
            LocalDateTime timeIn = entity.getTimeIn();
            int year = timeIn.getYear();
            int month = timeIn.getMonthValue();

            long minutes = Duration.between(timeIn, entity.getTimeOut()).toMinutes();
            double dailyPay = calculateDailyPay(minutes, entity.getHourlyRate());

            EmployeePay EMPPay = employeePayMap.computeIfAbsent(employeeName, k -> new EmployeePay());
            EMPPay.updateAnnualPay(year, month, dailyPay);
        }

        Set<Map.Entry<String, EmployeePay>> entries6 = employeePayMap.entrySet();
        for (Map.Entry<String, EmployeePay> entry : entries6) {
            String employeeName = entry.getKey();
            TreeMap<Integer, Map<Integer, Double>> yearlyPayTreeMap = entry.getValue().getYearlyPayTreeMap();
            for (Map.Entry<Integer, Map<Integer, Double>> entry2: yearlyPayTreeMap.entrySet()) {
                int year = entry2.getKey();
                for (Map.Entry<Integer, Double> entry3: entry2.getValue().entrySet()) {
                    printSomebodyPayByMonthAndYear(employeeName,year,entry3.getKey(),entry3.getValue());
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
        System.out.printf("%s %s月薪水: %.2f$\n", name, month, pay);
    }

    private static void printSomebodyPayByMonthAndYear(String name, int year, int month, double pay) {
        System.out.printf("%s %s年%s月薪水: %.2f$\n", name, year, month, pay);
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
