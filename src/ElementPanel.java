/**
 * Author:  Sean Toman
 * Date:    16/03/2018
 * Desc:    A custom JPanel to hold four SortPanels. One for each algorithm.
 */

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;

public class ElementPanel extends JPanel {

    private SortPanel bubblePanel, enBubblePanel, selectPanel, insertPanel;

    public ElementPanel(String title) {
        setLayout(new GridLayout(1, 5, 10, 10));
        setBorder(new TitledBorder(title));

        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(3, 1));
        labelPanel.add(new JLabel("Time - Nanoseconds: "));
        labelPanel.add(new JLabel("Number of Writes: "));
        labelPanel.add(new JLabel("Number of Comparisons: "));

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
