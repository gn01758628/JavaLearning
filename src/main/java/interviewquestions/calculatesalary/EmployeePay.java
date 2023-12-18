package interviewquestions.calculatesalary;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class EmployeePay {
    private final Map<Integer, AnnualPay> annualPayMap = new HashMap<>();

    public void updateAnnualPay(int year, int month, double pay) {
        AnnualPay annualPay = annualPayMap.computeIfAbsent(year, k -> new AnnualPay());
        annualPay.updateMonthlyPay(month, pay);
    }

    public Map<Integer, Map<Integer, Double>> getYearlyPayMap() {
        Map<Integer, Map<Integer, Double>> totalPayMap = new HashMap<>();
        for (Map.Entry<Integer,AnnualPay> entry: annualPayMap.entrySet()) {
            totalPayMap.put(entry.getKey(),entry.getValue().getMonthlyPayTreeMap());
        }
        return totalPayMap;
    }

    public TreeMap<Integer, Map<Integer, Double>> getYearlyPayTreeMap() {
        Map<Integer, Map<Integer, Double>> totalPayMap = getYearlyPayMap();
        return new TreeMap<>(totalPayMap);
    }
}
