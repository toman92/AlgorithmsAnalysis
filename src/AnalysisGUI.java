/** Author:  Sean Toman
 *  Date:    16/03/2018
 *  Desc:    GUI Program to analise efficiency of four inefficient sorting algorithms against one another
 *           Bubble sort, enhanced bubble sort, selection sort and insertion sort.
 *           It displays the time it took to sort three arrays of random, sorted and inversely sorted elements
 *           It also displays how many swaps and comparisons took place
 */

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class AnalysisGUI extends JFrame {

    // Algorithm classes and helpers
    private BubbleSort bubbleSort;
    private EnBubbleSort enBubbleSort;
    private InsertionSort insertionSort;
    private SelectionSort selectionSort;
    private Array arrayHelp;
    private StopWatch watch;

    // GUI stuff
    private ElementPanel randomPanel, sortedPanel, invertedPanel;
    private JComboBox jcbxSize;

    public AnalysisGUI() {
        // initialise algorithms, array, and stopwatch classes
        bubbleSort = new BubbleSort();
        enBubbleSort = new EnBubbleSort();
        insertionSort = new InsertionSort();
        selectionSort = new SelectionSort();
        arrayHelp = new Array();
        watch = new StopWatch();
        ArrayList<ElementPanel> elementPanels = new ArrayList<>();
        ArrayList<JButton> sortBtns = new ArrayList<>();

        // Create and set up top panel to hold sizes of array
        JPanel sizePanel = new JPanel();
        jcbxSize = new JComboBox();
        // Add array sizes to combo box - 1,000, 10,000, 100,000.
        jcbxSize.addItem(Array.SMALL);
        jcbxSize.addItem(Array.MEDIUM);
        jcbxSize.addItem(Array.LARGE);
        sizePanel.add(new JLabel("Select the number of elements for the array: "));
        sizePanel.add(jcbxSize);

        // set up middle panels that holds data and add them to array list
        elementPanels.add(randomPanel = new ElementPanel("Random Elements"));
        elementPanels.add(sortedPanel = new ElementPanel("Sorted Elements"));
        elementPanels.add(invertedPanel = new ElementPanel("Inverted Elements"));
        // add the 3 panels to a single panel to fit in frame
        JPanel analysisPanel = new JPanel();
        analysisPanel.setLayout(new GridLayout(3, 1, 10, 10));
        for(ElementPanel p : elementPanels) {
            analysisPanel.add(p);
        }

        // create, setup and add buttons to bottom panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 5, 10, 10));
        buttonPanel.add(new JLabel());
        sortBtns.add(new JButton("Bubble"));
        sortBtns.add(new JButton("E. Bubble"));
        sortBtns.add(new JButton("Selection"));
        sortBtns.add(new JButton("Insertion"));
        for(JButton btn : sortBtns) {
            // Set mnemonic of each button to the first character
            btn.setMnemonic(btn.getText().charAt(0));
            buttonPanel.add(btn);
        }

        // add 3 panels to frame.
        add(sizePanel, BorderLayout.NORTH);
        add(analysisPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // create and add listener to buttons
        BtnActionListener listener = new BtnActionListener();
        for(JButton btn : sortBtns) {
            btn.addActionListener(listener);
        }

        // initially create 3 arrays of 1000 elements.
        int arraySize = (int) jcbxSize.getSelectedItem();
        arrayHelp.createRandom(arraySize);
        arrayHelp.createSorted(arraySize);
        arrayHelp.createInverted(arraySize);
        // anonymous listener to listen for the array size combo box changing. If it changes, create 3 new arrays of giving size
        jcbxSize.addActionListener((ActionEvent e) -> {
            int newArraySize = (int) jcbxSize.getSelectedItem();
            arrayHelp.createRandom(newArraySize);
            arrayHelp.createSorted(newArraySize);
            arrayHelp.createInverted(newArraySize);
        });
    }

    public static void main(String[] arg) {
        AnalysisGUI frame = new AnalysisGUI();
        frame.pack();
        frame.setTitle("Algorithms");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public class BtnActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // store times, swaps and checks on text fields to compare against the other algorithms
            // TODO : Find a way to shorten this repeating code
            switch(e.getActionCommand()) {
                case "Bubble":
                    randomPanel.getBubblePanel().getJtfTime().setText("" + sortTime(bubbleSort, arrayHelp.getRandomOriginal()));
                    randomPanel.getBubblePanel().getJtfSwaps().setText("" + bubbleSort.getWrites());
                    randomPanel.getBubblePanel().getJtfChecks().setText("" + bubbleSort.getChecks());
                    bubbleSort.reset();
                    sortedPanel.getBubblePanel().getJtfTime().setText("" + sortTime(bubbleSort, arrayHelp.getSortedOriginal()));
                    sortedPanel.getBubblePanel().getJtfSwaps().setText("" + bubbleSort.getWrites());
                    sortedPanel.getBubblePanel().getJtfChecks().setText("" + bubbleSort.getChecks());
                    bubbleSort.reset();
                    invertedPanel.getBubblePanel().getJtfTime().setText("" + sortTime(bubbleSort, arrayHelp.getInvertedOriginal()));
                    invertedPanel.getBubblePanel().getJtfSwaps().setText("" + bubbleSort.getWrites());
                    invertedPanel.getBubblePanel().getJtfChecks().setText("" + bubbleSort.getChecks());
                    bubbleSort.reset();
                    break;

                case "E. Bubble":
                    randomPanel.getEnBubblePanel().getJtfTime().setText("" + sortTime(enBubbleSort, arrayHelp.getRandomOriginal()));
                    randomPanel.getEnBubblePanel().getJtfSwaps().setText("" + enBubbleSort.getWrites());
                    randomPanel.getEnBubblePanel().getJtfChecks().setText("" + enBubbleSort.getChecks());
                    enBubbleSort.reset();
                    sortedPanel.getEnBubblePanel().getJtfTime().setText("" + sortTime(enBubbleSort, arrayHelp.getSortedOriginal()));
                    sortedPanel.getEnBubblePanel().getJtfSwaps().setText("" + enBubbleSort.getWrites());
                    sortedPanel.getEnBubblePanel().getJtfChecks().setText("" + enBubbleSort.getChecks());
                    enBubbleSort.reset();
                    invertedPanel.getEnBubblePanel().getJtfTime().setText("" + sortTime(enBubbleSort, arrayHelp.getInvertedOriginal()));
                    invertedPanel.getEnBubblePanel().getJtfSwaps().setText("" + enBubbleSort.getWrites());
                    invertedPanel.getEnBubblePanel().getJtfChecks().setText("" + enBubbleSort.getChecks());
                    enBubbleSort.reset();
                    break;

                case "Selection":
                    randomPanel.getSelectPanel().getJtfTime().setText("" + sortTime(selectionSort, arrayHelp.getRandomOriginal()));
                    randomPanel.getSelectPanel().getJtfSwaps().setText("" + selectionSort.getWrites());
                    randomPanel.getSelectPanel().getJtfChecks().setText("" + selectionSort.getChecks());
                    selectionSort.reset();
                    sortedPanel.getSelectPanel().getJtfTime().setText("" + sortTime(selectionSort, arrayHelp.getSortedOriginal()));
                    sortedPanel.getSelectPanel().getJtfSwaps().setText("" + selectionSort.getWrites());
                    sortedPanel.getSelectPanel().getJtfChecks().setText("" + selectionSort.getChecks());
                    selectionSort.reset();
                    invertedPanel.getSelectPanel().getJtfTime().setText("" + sortTime(selectionSort, arrayHelp.getInvertedOriginal()));
                    invertedPanel.getSelectPanel().getJtfSwaps().setText("" + selectionSort.getWrites());
                    invertedPanel.getSelectPanel().getJtfChecks().setText("" + selectionSort.getChecks());
                    selectionSort.reset();
                    break;

                case "Insertion":
                    randomPanel.getInsertPanel().getJtfTime().setText("" + sortTime(insertionSort, arrayHelp.getRandomOriginal()));
                    randomPanel.getInsertPanel().getJtfSwaps().setText("" + insertionSort.getWrites());
                    randomPanel.getInsertPanel().getJtfChecks().setText("" + insertionSort.getChecks());
                    insertionSort.reset();
                    sortedPanel.getInsertPanel().getJtfTime().setText("" + sortTime(insertionSort, arrayHelp.getSortedOriginal()));
                    sortedPanel.getInsertPanel().getJtfSwaps().setText("" + insertionSort.getWrites());
                    sortedPanel.getInsertPanel().getJtfChecks().setText("" + insertionSort.getChecks());
                    insertionSort.reset();
                    invertedPanel.getInsertPanel().getJtfTime().setText("" + sortTime(insertionSort, arrayHelp.getInvertedOriginal()));
                    invertedPanel.getInsertPanel().getJtfSwaps().setText("" + insertionSort.getWrites());
                    invertedPanel.getInsertPanel().getJtfChecks().setText("" + insertionSort.getChecks());
                    insertionSort.reset();
                    break;
            }
        }

        /**
         * Times how long it takes to sort giving int array
         * @param algorithm - Sort Algorithm to use to sort. Bubble, EnBubble, selection, and insertion sort
         * @param elements - int array of elements to sort
         * @return - time it took to sort the array
         */
        private long sortTime(Sort algorithm, int[] elements) {
            watch.reset();
            watch.start();

            if(algorithm instanceof BubbleSort)
                bubbleSort.sort(elements);
            else if(algorithm instanceof EnBubbleSort)
                enBubbleSort.sort(elements);
            else if(algorithm instanceof SelectionSort)
                selectionSort.sort(elements);
            else if(algorithm instanceof InsertionSort)
                insertionSort.sort(elements);

            watch.stop();
            return watch.getElapsedTime();
        }
    }
}
