package App;

import java.util.ArrayList;
import javax.swing.*;
import GUI.*;

public class Main {


    public static void main(String[] args) {

        Company abc = new Company("ABC", "dfsafsfds", 50000, 45000, 49.8, 50.2, 60.0, 10);
        Company good = new Company("good co.", "fdbfsdfds", 100000, 100000, 47.0, 53.0, 23.6, 1);
        Company bad = new Company("bad inc.", "asfsfewewsd", 15000, 90000, 39.5, 60.5, 31.1, 5);
        Company a = new Company("rahh", "asdfewvf", 10000, 2000, 5, 95.0, 60.5, 24);
        Company b = new Company("idk", "AGSFFSA", 0, 0, 30.0, 60.0, 23.6, 1);
        Company c = new Company("kms", "aergdgsfsdf", 15000, 90000, 39.5, 60.5, 31.1, 5);
        Company d = new Company("slkjflskfs", "awtretgdfsd",  50000, 45000, 49.8, 50.2, 60.0, 10);
        Company e = new Company("send help", "agregerewsd", 100000, 100001, 82.0, 18.0, 32.4, 2);
        Company f = new Company("D:", "aweefsds", 15000, 90000, 39.5, 60.5, 31.1, 50);
        Company g = new Company(">:(", "utioyukjyumj", 50000, 45000, 49.8, 50.2, 60.0, 16);
        Company h = new Company("hatehatehate", "mvnnvne", 14000, 14000, 45.0, 55.0, 10.5, 3);
        Company i = new Company("AHHHHHH", "waoiejrsfjlksf", 15000, 60000, 50, 50, 50.0, 0);

        ArrayList<Company> companies = new ArrayList<Company>();
        companies.add(abc);
        companies.add(good);
        companies.add(bad);
        companies.add(a);
        companies.add(b);
        companies.add(c);
        companies.add(d);
        companies.add(e);
        companies.add(f);
        companies.add(g);
        companies.add(h);
        companies.add(i);

        Ranker ranker = new Ranker(companies);
        ranker.rankCompanies();

        SwingUtilities.invokeLater(() -> CompanyPage.createFrame());
        SwingUtilities.invokeLater(() -> CompanyPage.createRankingGUI());
        SwingUtilities.invokeLater(() -> StartingPage.createAndShowGUI(companies, ranker));

        
        
    }
}
