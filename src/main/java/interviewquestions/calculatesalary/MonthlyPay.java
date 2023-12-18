package interviewquestions.calculatesalary;

public class MonthlyPay {
    private double totalPay;

    public double getTotalPay() {
        return totalPay;
    }

    public void addPay(double dailyPay) {
        totalPay += dailyPay;
    }
}
