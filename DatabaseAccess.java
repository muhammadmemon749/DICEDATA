package DataBase;
import java.sql.*;

/*
 * @Author: Muhammad Ahmed Memon
 * Converts DataBase table into a Java Object with each column converted to each respective feild
 */

public class DatabaseAccess {

    private String companyName;
    private String companyOverview;
    private int percentOfMinoritiesHired;
    private int percentFemalesHired;
    private int percentMalesHired;
    private int workplaceSafetyScore;

    // Constructor
    public DatabaseAccess(String companyName, String companyOverview, int percentOfMinoritiesHired, int percentFemalesHired, int percentMalesHired, int workplaceSafetyScore) {
        this.companyName = companyName;
        this.companyOverview = companyOverview;
        this.percentOfMinoritiesHired = percentOfMinoritiesHired;
        this.percentFemalesHired = percentFemalesHired;
        this.percentMalesHired = percentMalesHired;
        this.workplaceSafetyScore = workplaceSafetyScore;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyOverview() {
        return companyOverview;
    }

    public void setCompanyOverview(String companyOverview) {
        this.companyOverview = companyOverview;
    }

    public int getPercentOfMinoritiesHired() {
        return percentOfMinoritiesHired;
    }

    public void setPercentOfMinoritiesHired(int percentOfMinoritiesHired) {
        this.percentOfMinoritiesHired = percentOfMinoritiesHired;
    }

    public int getPercentFemalesHired() {
        return percentFemalesHired;
    }

    public void setPercentFemalesHired(int percentFemalesHired) {
        this.percentFemalesHired = percentFemalesHired;
    }

    public int getPercentMalesHired() {
        return percentMalesHired;
    }

    public void setPercentMalesHired(int percentMalesHired) {
        this.percentMalesHired = percentMalesHired;
    }

    public int getWorkplaceSafetyScore() {
        return workplaceSafetyScore;
    }

    public void setWorkplaceSafetyScore(int workplaceSafetyScore) {
        this.workplaceSafetyScore = workplaceSafetyScore;
    }


    // Method to convert a ResultSet row into a DatabaseAccess object
    public static DatabaseAccess fromResultSet(ResultSet rs) throws SQLException {
        String companyName = rs.getString("companyName");
        String companyOverview = rs.getString("companyOverview");
        int percentOfMinoritiesHired = rs.getInt("percentOfMinoritiesHired");
        int percentFemalesHired = rs.getInt("percentFemalesHired");
        int percentMalesHired = rs.getInt("percentMalesHired");
        int workplaceSafetyScore = rs.getInt("workplaceSafetyScore");

        return new DatabaseAccess(companyName, companyOverview, percentOfMinoritiesHired, percentFemalesHired, percentMalesHired, workplaceSafetyScore);
    }
}