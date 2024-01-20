/**
 * OverallComparator implements the Comparator interface and can compare Company objects by combining all other rankings to get a total score.
 * @author Faith Tong
 */

package Comparators;

import java.util.Comparator;
import java.util.ArrayList;
import App.Company;

public class OverallComparator implements Comparator<Company>{
    ArrayList<Company> genderRanking;
    ArrayList<Company> diversityRanking;
    ArrayList<Company> safetyRanking;

    /**
     * The construtor takes ArrayLists with rankings that need to be saved in the OverallComparator object's fields.
     * @param g ArrayList<Company> with the ranking based on gender treatment.
     * @param d ArrayList<Company> with the ranking of how diverse the hires are.
     * @param s ArrayList<Company> with the ranking of how many safety incidents there were.
     */
    public OverallComparator(ArrayList<Company> g, ArrayList<Company> d, ArrayList<Company> s) {
        genderRanking = g;
        diversityRanking = d;
        safetyRanking = s;
    }

    /**
     * Compares companies by seeing how well they are ranked in all other categories.
     * @param c1 Company object which is being compared to another company.
     * @param c2 The second Company object being compared.
     * @return Returns an integer. -1 if c1 comes before c2, 0 if they are the same, 1 if c1 comes after c2.
     */
    public int compare(Company c1, Company c2) {
        int c1Score = genderRanking.indexOf(c1) + diversityRanking.indexOf(c1) + safetyRanking.indexOf(c1);
        int c2Score = genderRanking.indexOf(c2) + diversityRanking.indexOf(c2) + safetyRanking.indexOf(c2);

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
