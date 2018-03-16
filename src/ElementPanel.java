/**
 * Author:  Sean Toman
 * Date:    16/03/2018
 * Desc:    A custom JPanel to hold four SortPanels. One for each algorithm.
 */

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class ElementPanel extends JPanel {

    private SortPanel bubblePanel, enBubblePanel, selectPanel, insertPanel;
    private JPanel labelPanel;
    private JLabel jlbTime, jlbSwaps, jlbChecks;

    public ElementPanel(String title) {
        setLayout(new GridLayout(1, 5));
        setBorder(new TitledBorder(title));

        labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(3, 1));
        labelPanel.add(jlbTime = new JLabel("Time - Nanoseconds: "));
        labelPanel.add(jlbSwaps = new JLabel("Number of Writes: "));
        labelPanel.add(jlbChecks = new JLabel("Number of Comparisons: "));

        // set up Sort Panels
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
