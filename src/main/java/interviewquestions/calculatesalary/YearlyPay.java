package interviewquestions.calculatesalary;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class YearlyPay {
    private final Map<Integer, MonthlyPay> monthlyPayMap = new HashMap<>();

    public void updateMonthlyPay(int month, double pay) {
        MonthlyPay monthlyPay = monthlyPayMap.computeIfAbsent(month, k -> new MonthlyPay());
        monthlyPay.addPay(pay);
    }

    public Map<Integer, Double> getMonthlyPayMap() {
        Map<Integer, Double> map = new HashMap<>();
        for (Map.Entry<Integer,MonthlyPay> entry: monthlyPayMap.entrySet()) {
            map.put(entry.getKey(),entry.getValue().getTotalPay());
        }
        return map;
    }

    public TreeMap<Integer, Double> getMonthlyPayTreeMap() {
        return new TreeMap<>(getMonthlyPayMap());
    }
}
