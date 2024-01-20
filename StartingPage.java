package GUI;

import java.util.ArrayList;
import App.Company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import App.Filter;
import App.Ranker;

public class StartingPage {

    //Yazan
    public static void createAndShowGUI(ArrayList<Company> companies, Ranker ranks) {
        JFrame frame = new JFrame("Starting Page");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        
        // Create a JPanel for filters
        JPanel filtersPanel = new JPanel(new BorderLayout());
        JButton filterButton = new JButton("Apply Filter");
        filtersPanel.add(filterButton, BorderLayout.NORTH);
        

        // Create a JPanel for results
        JPanel resultsPanel = new JPanel(null);
        JTextArea ourName = new JTextArea();
        ourName.setEditable(false);
        ourName.setText("DICE: Diversity Index for Corporate Equality");
        ourName.setLineWrap(true);
        ourName.setWrapStyleWord(true);
        ourName.setBackground(resultsPanel.getBackground()); // Match the background color
        ourName.setAlignmentX(Component.CENTER_ALIGNMENT); // Align text horizontally to the center
        ourName.setAlignmentY(Component.CENTER_ALIGNMENT); // Align text vertically to the center\

        resultsPanel.add(ourName, BorderLayout.NORTH);

        JTextArea resultTextArea = new JTextArea();
        resultTextArea.setEditable(false);
        JScrollPane resultScroll = new JScrollPane(resultTextArea);
        resultsPanel.add(resultScroll, BorderLayout.SOUTH);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, filtersPanel, resultsPanel);
        splitPane.setDividerLocation(250);

        frame.getContentPane().add(splitPane);

        

        //JList list = new JList();

        //Faith
        //This code creates panels for the filters and adds them to the starting page.
        JPanel filterInputPanel = new JPanel(null);
        filterInputPanel.setPreferredSize(new Dimension(250, 730));
        filtersPanel.add(filterInputPanel, BorderLayout.SOUTH);
        JTextPane minLabel = new JTextPane();
        minLabel.setEditable(false);
        minLabel.setText("Minimum Rank:");
        minLabel.setBounds(20, 20, 90, 25);
        JTextPane maxLabel = new JTextPane();
        maxLabel.setEditable(false);
        maxLabel.setText("Maximum Rank:");
        maxLabel.setBounds(20, 50, 100, 25);
        JTextPane minInput = new JTextPane();
        minInput.setBounds(120, 20, 50, 25);
        JTextPane maxInput = new JTextPane();
        maxInput.setBounds(130, 50, 50, 25);
        filterInputPanel.add(minLabel);
        filterInputPanel.add(maxLabel);
        filterInputPanel.add(minInput);
        filterInputPanel.add(maxInput);

        JTextPane optionsLabel = new JTextPane();
        optionsLabel.setText("Ranking Type:");
        optionsLabel.setEditable(false);
        optionsLabel.setBounds(20, 95, 200, 20);
        JRadioButton diversityOption = new JRadioButton("Diversity");
        diversityOption.setBounds(20, 125, 200, 20);
        diversityOption.setActionCommand("D");
        JRadioButton genderOption = new JRadioButton("Gender");
        genderOption.setBounds(20, 145, 200, 20);
        genderOption.setActionCommand("G");
        JRadioButton safetyOption = new JRadioButton("Workplace Safety");
        safetyOption.setBounds(20, 165, 200, 20);
        safetyOption.setActionCommand("S");
        JRadioButton overallOption = new JRadioButton("Overall");
        overallOption.setBounds(20, 185, 200, 20);
        overallOption.setActionCommand("O");

        ButtonGroup filterOptions = new ButtonGroup();
        filterOptions.add(diversityOption);
        filterOptions.add(genderOption);
        filterOptions.add(safetyOption);
        filterOptions.add(overallOption);

        filterInputPanel.add(diversityOption);
        filterInputPanel.add(genderOption);
        filterInputPanel.add(safetyOption);
        filterInputPanel.add(overallOption);
        filterInputPanel.add(optionsLabel);

        //Faith
        //This code creates the search bar and adds it to the filters panel.
        JTextPane searchLabel = new JTextPane();
        searchLabel.setText("Search for:");
        searchLabel.setEditable(false);
        searchLabel.setBounds(20, 225, 200, 20);
        JTextPane searchInput = new JTextPane();
        searchInput.setBounds(20, 245, 200, 20);
        filterInputPanel.add(searchLabel);
        filterInputPanel.add(searchInput);
        
        //Faith
        //This code creates a scrollable panel to display all of the companies in ranked order.
        JPanel companiesPanel = new JPanel(null);
        companiesPanel.setPreferredSize(new Dimension(500,3400));
        resultsPanel.add(companiesPanel);
        JScrollPane scrollableList = new JScrollPane(companiesPanel);
        scrollableList.setBounds(0, 135, 725, 650);
        resultsPanel.add(scrollableList);

        //Faith
        //This code adds functionality so that when the filter button is pressed, the filters are applied and only relevant companies are shown.
        filterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultTextArea.append("Filter applied!\n");

                Filter filter = new Filter();
                ArrayList<Company> filtered = filter.applyFilters(filterOptions, ranks, minInput, maxInput, searchInput);

                ArrayList<JPanel> companyRanks = StartingPage.displayRankings(filtered, filter.getMin());
                companiesPanel.removeAll();
                for (JPanel p : companyRanks) {
                    companiesPanel.add(p);
                }
                
            }
        });
        
    }


    /**
     * Creates an ArrayList of JPanels with company ranks, information, and JButtons leading to the company page to be added to the GUI.
     * @param companies ArrayList<Company> of all companies, some of which may be displayed on screen.
     * @param min Takes the minimum filter number to begin ranks at that value.
     * @return Returns ArrayList<JPanel> rankPanels to be displayed on screen.
     * @author Faith Tong
     */
    public static ArrayList<JPanel> displayRankings(ArrayList<Company> companies, int min) {
        ArrayList<JPanel> rankPanels = new ArrayList<JPanel>();

        int rank = min;
        for (int i = 0; i < companies.size(); i++) {
            Company current = companies.get(i);
            
            int position = i*85;
            
            JPanel newPanel = new JPanel(null);
            newPanel.setBounds(0, position, 750, 80);
            newPanel.setBackground(Color.white);

            JTextArea rankText = new JTextArea(Integer.toString(rank));
            rankText.setBounds(0, 0, 80, 80);
            rankText.setEditable(false);
            JTextArea cText = new JTextArea("Company: " + current.getName() + "\nDescription: " + current.getDesc());
            cText.setBounds(80, 0, 450, 80);
            cText.setEditable(false);

            JButton companyButton = new JButton("See Company");
            companyButton.setBounds(550, 15, 120, 50);
            companyButton.setVisible(true);

            newPanel.add(rankText);
            newPanel.add(cText);
            newPanel.add(companyButton);

            rankPanels.add(newPanel);

            rank++;
        }

        return rankPanels;
    }

    
    
}
