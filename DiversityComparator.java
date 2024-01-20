/**
 * Diversity Comparator implements the Comparator interface and can compare Company objects based on how many minorities they hire.
 * @author Faith Tong
 */

package Comparators;

import java.util.Comparator;
import java.lang.Math;
import App.Company;

public class DiversityComparator implements Comparator<Company>{
    /**
     * Compares companies by seeing how close to 30% minorities a company hires.
     * @param c1 Company object which is being compared to another company.
     * @param c2 The second Company object being compared.
     * @return Returns an integer. -1 if c1 comes before c2, 0 if they are the same, 1 if c1 comes after c2.
     */
    public int compare(Company c1, Company c2) {
        double c1Difference = Math.abs(30 - c1.getPercentMinority());
        double c2Difference = Math.abs(30 - c2.getPercentMinority());

        if (c1Difference < c2Difference) {
            return -1;
        }
        else if (c1Difference == c2Difference) {
            return 0;
        }
        else {
            return 1;
        }
    }
}
