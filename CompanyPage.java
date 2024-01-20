package GUI;

import javax.swing.*;
import java.awt.*;
import javax.swing.JPanel;


public class CompanyPage {

    //Yazan
    public static void createFrame() {
        JFrame frame = new JFrame("Company Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void createRankingGUI() {
        // Creates a panel for the company's rank
        JPanel rankingPanel = new JPanel(new BorderLayout());
        // Creates a text box for the company's rank
        JTextArea companyRanking = new JTextArea();
        companyRanking.setText(" "); // Rank goes here
        companyRanking.setEditable(false); // Makes the user unable to edit the text box
        companyRanking.setLineWrap(true);
        companyRanking.setWrapStyleWord(true);
        companyRanking.setBackground(rankingPanel.getBackground()); // Match the background color
        companyRanking.setAlignmentX(Component.CENTER_ALIGNMENT); // Align text horizontally to the center
        companyRanking.setAlignmentY(Component.CENTER_ALIGNMENT); // Align text vertically to the center
        rankingPanel.add(companyRanking, BorderLayout.NORTH);

    }

    public static void createGraph() {
        JPanel graphPanel = new JPanel(new BorderLayout());
        
    }


    


    /** public static void createGraphics() {
        BufferedImage image;
        JPanel graphicsPanel = new JPanel(new BorderLayout());
        
        try {
            BufferedImage myPicture = imageIO.read(new File("path-to-file"));
        } catch (IOException ex) {
            // handle exception
        }
        JLabel picture = new JLabel(new ImageIcon(myPicture));
        

    }
    */

}