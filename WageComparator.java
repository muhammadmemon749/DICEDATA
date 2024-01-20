/**
 * WageComparator implements the Comparator interface and can compare Company objects based on the difference in average pay for male and female workers.
 * @author Faith Tong
 */

package Comparators;

import java.util.Comparator;
import java.lang.Math;
import App.Company;

/**
     * Compares companies by seeing how similarly a company pays their male and female employees.
     * @param c1 Company object which is being compared to another company.
     * @param c2 The second Company object being compared.
     * @return Returns an integer. -1 if c1 comes before c2, 0 if they are the same, 1 if c1 comes after c2.
     */
public class WageComparator implements Comparator<Company>{

    public int compare(Company c1, Company c2) {
        int c1Gap = Math.abs(c1.getMaleWage() - c1.getFemWage());
        int c2Gap = Math.abs(c2.getMaleWage() - c2.getFemWage());

        if (c1Gap < c2Gap) {
            return -1;
        }
        else if (c1Gap == c2Gap) {
            //if fem wage higher, better?
            return 0;
        }
        else {
            return 1;
        }
    }
    
}

