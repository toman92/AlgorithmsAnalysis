/**
 * Author:  Sean Toman
 * Date:    16/03/2018
 * Desc:    A Custom panel to hold the sorting algorithms time, swaps and checks
 */

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class SortPanel extends JPanel {

    private JLabel heading;
    private JTextField jtfTime, jtfSwaps, jtfChecks;

    public SortPanel(String heading) {
        setLayout(new GridLayout(4,1));
        setBorder(new LineBorder(Color.BLACK, 2));

        add(this.heading = new JLabel(heading));
        this.heading.setHorizontalAlignment(JLabel.CENTER);

        add(jtfTime = new JTextField(30));
        add(jtfSwaps = new JTextField(30));
        add(jtfChecks = new JTextField(30));
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
