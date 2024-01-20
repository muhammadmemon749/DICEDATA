/**
 * SafetyComparator implements the Comparator interface and can compare Company objects based on how many safety incidents occurred.
 * @author Faith Tong
 */

package Comparators;

import java.util.Comparator;
import App.Company;

public class SafetyComparator implements Comparator<Company> {
    /**
     * Compares companies by seeing how many safety incidents were reported - the lower the better.
     * @param c1 Company object which is being compared to another company.
     * @param c2 The second Company object being compared.
     * @return Returns an integer. -1 if c1 comes before c2, 0 if they are the same, 1 if c1 comes after c2.
     */
    public int compare(Company c1, Company c2) {
        if (c1.getIncidents() < c2.getIncidents()) {
            return -1;
        }
        else if (c1.getIncidents() == c2.getIncidents()) {
            return 0;
        }
        else {
            return 1;
        }
    }
}
