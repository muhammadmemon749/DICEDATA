/**
 * GRatioComparator implements the Comparator interface and can compare Company objects based on the ratio of males to females they hire.
 * @author Faith Tong
 */

package Comparators;

import java.util.Comparator;
import java.lang.Math;
import App.Company;

public class GRatioComparator implements Comparator<Company> {
    /**
     * Compares companies by seeing how similar the percentages of genders hired the company has.
     * @param c1 Company object which is being compared to another company.
     * @param c2 The second Company object being compared.
     * @return Returns an integer. -1 if c1 comes before c2, 0 if they are the same, 1 if c1 comes after c2.
     */
    public int compare(Company c1, Company c2) {
        double c1Difference = Math.abs(c1.getPercentM() - c1.getPercentF());
        double c2Difference = Math.abs(c2.getPercentM() - c2.getPercentF());

        if (c1Difference < c2Difference) {
            return -1;
        }
        else if (c1Difference == c2Difference) {
            //if more females than males, better?
            return 0;
        }
        else {
            return 1;
        }
    }
}
