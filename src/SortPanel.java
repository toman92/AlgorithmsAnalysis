/**
 * Author:  Sean Toman
 * Date:    16/03/2018
 * Desc:    A Custom panel to hold the sorting algorithms time, swaps and checks.
 *          SortPanel IS-A JPanel
 */

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class SortPanel extends JPanel {

    private JTextField jtfTime, jtfSwaps, jtfChecks;

    public SortPanel(String heading) {
        setLayout(new GridLayout(4,1, 5, 5));
        setBorder(new LineBorder(Color.BLACK, 2));

        JLabel jlbHeading = new JLabel(heading);
        jlbHeading.setHorizontalAlignment(JLabel.CENTER);

        add(jlbHeading);
        add(jtfTime = new JTextField(20));
        add(jtfSwaps = new JTextField(20));
        add(jtfChecks = new JTextField(20));
    }

    public JTextField getJtfTime() {
        return jtfTime;
    }

    public JTextField getJtfSwaps() {
        return jtfSwaps;
    }

    public JTextField getJtfChecks() {
        return jtfChecks;
    }
}
