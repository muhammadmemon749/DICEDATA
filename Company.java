/**
 * The class Company stores data about the companies to be used for ranking.
 * @author Faith Tong
 */

package App;

public class Company {
    private String name;
    private String desc;
    private int avgMaleWage;
    private int avgFemWage;
    private double percentM;
    private double percentF;
    private double percentMinority;
    private int numIncidents;

    /**
     * Creates a Company object initialized with all of the given data.
     * @param n String name of company.
     * @param d String description of company.
     * @param m Integer average wage of males.
     * @param f Integer average wage of females.
     * @param pM Double percentage of male workers.
     * @param pF Double percentage of female workers.
     * @param pMin Double percentage of minorities hired.
     * @param i Integer number of workplace incidents reported.
     */
    Company(String n, String d, int m, int f, double pM, double pF, double pMin, int i) {
        name = n;
        avgMaleWage = m;
        avgFemWage = f;
        percentM = pM;
        percentF = pF;
        percentMinority = pMin;
        numIncidents = i;
        desc = d;
    }

    /**
     * Returns the name of the company.
     * @return Returns the name field.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the description of the company.
     * @return Returns the desc field.
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Returns the average wage of males of the company.
     * @return Returns the avgMaleWage field.
     */
    public int getMaleWage() {
        return avgMaleWage;
    }

    /**
     * Returns the average wage of females of the company.
     * @return Returns the avgFemWage field.
     */
    public int getFemWage() {
        return avgFemWage;
    }

    /**
     * Returns the percentage of males hired in the company.
     * @return Returns the percentM field.
     */
    public double getPercentM() {
        return percentM;
    }

    /**
     * Returns the percentage of females hired in the company.
     * @return Returns the percentF field.
     */
    public double getPercentF() {
        return percentF;
    }

    /**
     * Returns the percentage of minorities hired in the company.
     * @return Returns the percentMinority field.
     */
    public double getPercentMinority() {
        return percentMinority;
    }

    /**
     * Returns the number of reported safety incidents of the company.
     * @return Returns the numIncidents field.
     */
    public int getIncidents() {
        return numIncidents;
    }

}
