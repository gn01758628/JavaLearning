package interviewquestions.calculatesalary;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AnnualPay {
    private final Map<Integer, MonthlyPay> monthlyPayMap = new HashMap<>();

    public void updateMonthlyPay(int month, double pay) {
        MonthlyPay monthlyPay = monthlyPayMap.computeIfAbsent(month, k -> new MonthlyPay());
        monthlyPay.addPay(pay);
    }

    public Map<Integer,Double> getMonthlyPayMap() {
        Map<Integer, Double> totalPayMap = new HashMap<>();
        for (Map.Entry<Integer, MonthlyPay> entry : monthlyPayMap.entrySet()) {
            totalPayMap.put(entry.getKey(), entry.getValue().getTotalPay());
        }
        return totalPayMap;
    }

    public TreeMap<Integer,Double> getMonthlyPayTreeMap() {
        Map<Integer, Double> totalPayMap = getMonthlyPayMap();
        return new TreeMap<>(totalPayMap);
    }
}
