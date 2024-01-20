/**
 * The class Ranker ranks the companies based on various metrics and stores these rankings in separate ArrayLists.
 * @author Faith Tong
 */

package App;

import java.util.ArrayList;
import Comparators.*;

public class Ranker {
    ArrayList<Company> companies;
    ArrayList<Company> genderWageRanking;
    ArrayList<Company> genderRatioRanking;
    ArrayList<Company> genderOverallRanking;
    ArrayList<Company> diversityRanking;
    ArrayList<Company> safetyRanking;
    ArrayList<Company> overallRanking;

    /**
     * Creates a Ranker object with a separate ArrayList for each ranking.
     * @param companies ArrayList of companies to be ranked.
     */
    Ranker(ArrayList<Company> companies) {
        this.companies = companies;
        genderWageRanking = new ArrayList<Company>(companies);
        genderRatioRanking = new ArrayList<Company>(companies);
        genderOverallRanking = new ArrayList<Company>(companies);
        diversityRanking = new ArrayList<Company>(companies);
        safetyRanking = new ArrayList<Company>(companies);
        overallRanking = new ArrayList<Company>(companies);
    }

    /**
     * Takes the given companies and sorts each ArrayList based on custom metric Comparators.
     */
    void rankCompanies() {
        genderWageRanking.sort(new WageComparator());
        genderRatioRanking.sort(new GRatioComparator());
        genderOverallRanking.sort(new GenderComparator(genderWageRanking, genderRatioRanking));
        diversityRanking.sort(new DiversityComparator());
        safetyRanking.sort(new SafetyComparator());
        overallRanking.sort(new OverallComparator(genderOverallRanking, diversityRanking, safetyRanking));
    }

    /**
     * Returns the ArrayList storing the overall ranking of companies.
     * @return ArrayList<Company> overallRanking storing the overall ranking.
     */
    public ArrayList<Company> getOverallRanking() {
        return overallRanking;
    }

    /**
     * Returns the ArrayList storing the diversity ranking of companies.
     * @return ArrayList<Company> diversityRanking storing the overall ranking.
     */
    public ArrayList<Company> getDiversityRanking() {
        return diversityRanking;
    }

    /**
     * Returns the ArrayList storing the gender ranking of companies.
     * @return ArrayList<Company> genderOverallRanking storing the overall ranking.
     */
    public ArrayList<Company> getGenderRanking() {
        return genderOverallRanking;
    }

    /**
     * Returns the ArrayList storing the safety ranking of companies.
     * @return ArrayList<Company> safetyRanking storing the overall ranking.
     */
    public ArrayList<Company> getSafetyRanking() {
        return safetyRanking;
    }

}