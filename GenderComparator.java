/**
 * GenderComparator implements the Comparator interface and can compare Company objects by combining how well they pay and hire the genders. Depends on rankings of Gender Ratio and Wage.
 * @author Faith Tong
 */

package Comparators;

import java.util.Comparator;
import java.util.ArrayList;
import App.Company;

public class GenderComparator implements Comparator<Company>{
    ArrayList<Company> wageRanking;
    ArrayList<Company> ratioRanking;

    /**
     * Takes two ranking ArrayLists and sets them to the fields of the GenderComparator object.
     * @param w ArrayList<Company> with the wage ranking.
     * @param r ArrayList<Company with the gender ratio ranking.
     */
    public GenderComparator(ArrayList<Company> w, ArrayList<Company> r) {
        wageRanking = w;
        ratioRanking = r;
    }

    /**
     * Compares companies by seeing how highly ranked the company is in the wage and gender ratio rankings.
     * @param c1 Company object which is being compared to another company.
     * @param c2 The second Company object being compared.
     * @return Returns an integer. -1 if c1 comes before c2, 0 if they are the same, 1 if c1 comes after c2.
     */
    public int compare(Company c1, Company c2) {
        int c1Score = wageRanking.indexOf(c1) + ratioRanking.indexOf(c1);
        int c2Score = wageRanking.indexOf(c2) + ratioRanking.indexOf(c2);

        if(c1Score < c2Score) {
            return -1;
        }
        else if (c1Score == c2Score) {
            return 0;
        }
        else {
            return 1;
        }
    }
}
