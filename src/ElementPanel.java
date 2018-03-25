/**
 * Author:  Sean Toman
 * Date:    16/03/2018
 * Desc:    A custom JPanel to hold four SortPanels. One for each algorithm.
 *          ElementPanel IS-A JPanel
 *          ElementPanel HAS-A SortPanel
 */

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;

public class ElementPanel extends JPanel {

    private SortPanel bubblePanel, enBubblePanel, selectPanel, insertPanel;

    public ElementPanel(String title) {
        ArrayList<JLabel> labels = new ArrayList<>();
        setLayout(new GridLayout(1, 5, 10, 10));
        setBorder(new TitledBorder(title));

        JPanel labelPanel = new JPanel();
        labels.add(new JLabel());
        labels.add(new JLabel("Time - NanoSeconds: "));
        labels.add(new JLabel("Number of Swaps: "));
        labels.add(new JLabel("Number of Comparisons: "));
        labelPanel.setLayout(new GridLayout(4, 1));
        for(JLabel l : labels) {
            l.setHorizontalAlignment(JLabel.RIGHT);
            labelPanel.add(l);
        }


        // set up Sort Panels to hold data on each algorithm
        bubblePanel = new SortPanel("Standard Bubble");
        enBubblePanel = new SortPanel("Enhanced Bubble Sort");
        selectPanel = new SortPanel("Selection Sort");
        insertPanel = new SortPanel("InsertionSort");

        add(labelPanel);
        add(bubblePanel);
        add(enBubblePanel);
        add(selectPanel);
        add(insertPanel);
    }

    public SortPanel getBubblePanel() {
        return bubblePanel;
    }

    public SortPanel getEnBubblePanel() {
        return enBubblePanel;
    }

    public SortPanel getSelectPanel() {
        return selectPanel;
    }

    public SortPanel getInsertPanel() {
        return insertPanel;
    }
}
