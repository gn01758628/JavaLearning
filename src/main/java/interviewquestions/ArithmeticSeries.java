package interviewquestions;

import java.math.BigInteger;

public class ArithmeticSeries {

    /**
     * @param initial    初始值
     * @param difference 差值
     * @param length     數列長度
     * @return 等差數列的合
     */
    public static long getArithmeticSeriesSum(Long initial, Long difference, Long length) {

        if (initial == null || difference == null || length == null) {
            throw new IllegalArgumentException("Input values cannot be null");
        }

        if (length < 0) {
            throw new IllegalArgumentException("Length cannot be negative");
        }

        BigInteger bigInitial = BigInteger.valueOf(initial);
        BigInteger bigDifference = BigInteger.valueOf(difference);
        BigInteger bigLength = BigInteger.valueOf(length);

        BigInteger twoA = bigInitial.multiply(BigInteger.valueOf(2));
        BigInteger nMinusOneD = bigLength.subtract(BigInteger.ONE).multiply(bigDifference);
        BigInteger twoAPlusNMinusOneD = twoA.add(nMinusOneD);

        BigInteger bigSum = bigLength.multiply(twoAPlusNMinusOneD).divide(BigInteger.valueOf(2));

        if (bigSum.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) > 0
                || bigSum.compareTo(BigInteger.valueOf(Long.MIN_VALUE)) < 0) {
            throw new ArithmeticException("Result exceeds the range of Long");
        }

        return bigSum.longValue();
    }

    public static void main(String[] args) {
        // 打印55
        System.out.println(getArithmeticSeriesSum(1L, 1L, 10L));
        // 打印25
        System.out.println(getArithmeticSeriesSum(1L, 2L, 5L));
        // 長度小於0要拋出例外
        try {
            System.out.println(getArithmeticSeriesSum(1L, 2L, -10L));
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 打印9000000000005000000
        System.out.println(getArithmeticSeriesSum(899995000001L, 1L, 10000000L));

        // 結果超出範圍要拋出例外
        System.out.println(getArithmeticSeriesSum(Long.MAX_VALUE, 1L, 10L));
    }
}
