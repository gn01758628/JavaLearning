package interviewquestions.calculatesalary;

public class MonthlyPay {
    private double totalPay;

    public void addPay(double pay) {
        this.totalPay += pay;
    }

    public double getTotalPay() {
        return totalPay;
    }
}
