package interviewquestions.calculatesalary;

import java.time.LocalDateTime;

public class TimeClockEntity {
    private String employeeName;
    private LocalDateTime timeIn;
    private LocalDateTime timeOut;
    private double hourlyRate;

    public TimeClockEntity(String employeeName, LocalDateTime timeIn, LocalDateTime timeOut, double hourlyRate) {
        this.employeeName = employeeName;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public String toString() {
        return "TimeClockEntity{" +
                "employeeName='" + employeeName + '\'' +
                ", timeIn=" + timeIn +
                ", timeOut=" + timeOut +
                ", hourlyRate=" + hourlyRate +
                '}';
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public LocalDateTime getTimeIn() {
        return timeIn;
    }

    public LocalDateTime getTimeOut() {
        return timeOut;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }
}
