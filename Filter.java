/**
 * The Filter class deals with all of the backend calculation needed to filter the ranking based on the user's input.
 * @author Faith Tong
 */

package App;

import javax.swing.*;
import java.util.ArrayList;

public class Filter {
    int min;
    int max;

    public Filter() {
        min = 1;
    }

    public int getMin() {
        return min;
    }

    /**
     * Checks which ranking the user selected to look at, and slices this ranking based on the input maximums and minimums.
     * @param filterOptions The ButtonGroup with the ranking options.
     * @param ranks The ranker that stores the different rankings, class Ranker.
     * @param minInput The minimum rank to be shown, Integer.
     * @param maxInput The maximum rank to be shown, Integer.
     * @return Returns the ArrayList of Company objects that fit the filter criteria.
     */
    public ArrayList<Company> applyFilters(ButtonGroup filterOptions, Ranker ranks, JTextPane minInput, JTextPane maxInput, JTextPane search) {
        ArrayList<Company> category;

                if (filterOptions.getSelection() != null) {
                    if (filterOptions.getSelection().getActionCommand().equals("D")) {
                        category = ranks.getDiversityRanking();
                    }
                    else if (filterOptions.getSelection().getActionCommand().equals("G")) {
                        category = ranks.getGenderRanking();
                    }
                    else if (filterOptions.getSelection().getActionCommand().equals("S")) {
                        category = ranks.getSafetyRanking();
                    }
                    else {
                        category = ranks.getOverallRanking();
                    }
                }
                else {
                    category = ranks.getOverallRanking();
                }

                try {
                    min = Integer.parseInt(minInput.getText());
                } catch (Exception ex) {
                    min = 1;
                }
                try {
                    max = Integer.parseInt(maxInput.getText()); 
                } catch (Exception ex) {
                    max = category.size();
                }

                ArrayList<Company> filtered = search(search, sliceList(category, min, max));

                return filtered;
    }

    /**
     * Takes an ArrayList of Company objects and returns a list slice from the given minimum to maximum indexes.
     * @param companies ArrayList of Company objects to be sliced.
     * @param min Minimum rank value to start from.
     * @param max Maximum rank value to end at.
     * @author Faith Tong
     */
    private ArrayList<Company> sliceList(ArrayList<Company> companies, int min, int max) {
        ArrayList<Company> visible = new ArrayList<Company>();

        for (int i = 0; i < companies.size(); i++) {
            if (i+1 < min || i+1 > max) {
                continue;
            }
            else {
                visible.add(companies.get(i));
            }
        }

        return visible;
    }

    /**
     * Loops through an ArrayList of companies searching for all companies with names matching the given text.
     * @param searchBar The JTextPane where the user typed their search query.
     * @param companies The companies to search for the matching text.
     * @return
     */
    private ArrayList<Company> search(JTextPane searchBar, ArrayList<Company> companies) {
        ArrayList<Company> matches = new ArrayList<Company>();

        String text = searchBar.getText().toLowerCase();

        if (!text.equals("")) {

            for (Company c : companies) {
                String name = c.getName().toLowerCase();
            
                if(name.contains(text)) {
                    matches.add(c);
                }
            }

            return matches;
        }
        else {
            return companies;
        }
    }
}
