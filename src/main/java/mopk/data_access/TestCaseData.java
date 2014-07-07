/**
 * Created by Mopk
 * on 2014-07-06 22:51.
 */
package mopk.data_access;

import org.springframework.data.annotation.Id;

public class TestCaseData {

    @Id
    private String id;

    private String testGroupId;

    private String dividend;
    private String divisor;
    private String quotientExpected;

    public TestCaseData() {
    }

    public TestCaseData(
            String testGroupId,
            String dividend,
            String divisor,
            String quotientExpected
    ) {
        this.testGroupId = testGroupId;
        this.dividend = dividend;
        this.divisor = divisor;
        this.quotientExpected = quotientExpected;
    }

    public String getTestGroupId() {
        return testGroupId;
    }

    public void setTestGroupId(String testGroupId) {
        this.testGroupId = testGroupId;
    }

    public String getDividend() {
        return dividend;
    }

    public void setDividend(String dividend) {
        this.dividend = dividend;
    }

    public String getDivisor() {
        return divisor;
    }

    public void setDivisor(String divisor) {
        this.divisor = divisor;
    }

    public String getQuotientExpected() {
        return quotientExpected;
    }

    public void setQuotientExpected(String quotientExpected) {
        this.quotientExpected = quotientExpected;
    }

    @Override
    public String toString() {
        return "TestCaseData{" +
                "id='" + id + '\'' +
                ", testGroupId='" + testGroupId + '\'' +
                ", dividend='" + dividend + '\'' +
                ", divisor='" + divisor + '\'' +
                ", quotientExpected='" + quotientExpected + '\'' +
                '}';
    }
}