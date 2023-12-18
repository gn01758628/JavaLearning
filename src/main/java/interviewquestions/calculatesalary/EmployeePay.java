package interviewquestions.calculatesalary;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class EmployeePay {
    private final Map<Integer, YearlyPay> yearlyPayMap = new HashMap<>();

    public void updateYearlyPay(int year, int month, double pay) {
        YearlyPay yearlyPay = yearlyPayMap.computeIfAbsent(year, k -> new YearlyPay());
        yearlyPay.updateMonthlyPay(month, pay);
    }

    public Map<Integer, Map<Integer, Double>> getYearlyPayMap() {
        Map<Integer, Map<Integer, Double>> map = new HashMap<>();
        for (Map.Entry<Integer, YearlyPay> entry: yearlyPayMap.entrySet()) {
            map.put(entry.getKey(),entry.getValue().getMonthlyPayTreeMap());
        }
        return map;
    }

    public TreeMap<Integer, Map<Integer, Double>> getYearlyPayTreeMap() {
        return new TreeMap<>(getYearlyPayMap());
    }
}
