/**
 * Author:  Sean Toman
 * Date:    16/03/2018
 * Desc:    GUI Program to analise efficiency of four inefficient sorting algorithms
 *          Bubble sort, enhanced bubble sort, selection sort and insertion sort.
 *          It displays the time it took to sort three arrays of random, sorted and inversely sorted elements
 *          It also displays how many swaps (writes) and comparisons (reads) took place
 */

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class AnalysisGUI extends JFrame {

    // Finals for each sorting algorithm
    private static final int BUBBLE = 1;
    private static final int EN_BUBBLE = 2;
    private static final int SELECT = 3;
    private static final int INSERT = 4;

    // Algorithms and helpers
    private BubbleSort bubbleSort;
    private EnBubbleSort enBubbleSort;
    private InsertionSort insertionSort;
    private SelectionSort selectionSort;
    private Array arrayHelp;
    private StopWatch watch;

    // GUI stuff
    private ElementPanel randomPanel, sortedPanel, invertedPanel;
    private JPanel sizePanel, analysisPanel, buttonPanel;
    private JLabel jlbSize;
    private JComboBox jcbxSize;
    private JButton jbtnBubble, jbtnEnBubble, jbtnInsert, jbtnSelect;

    // Arrays
//    private int[] randomArray;
//    private int[] sortedArray;
//    private int[] invertedArray;

    private ArrayList<ElementPanel> elementPanels;
    private ArrayList<JButton> sortBtns;

    public AnalysisGUI() {
        // initialise algorithms, array, and stopwatch
        bubbleSort = new BubbleSort();
        enBubbleSort = new EnBubbleSort();
        insertionSort = new InsertionSort();
        selectionSort = new SelectionSort();
        arrayHelp = new Array();
        watch = new StopWatch();
        elementPanels = new ArrayList<>();
        sortBtns = new ArrayList<>();

        // Create and set up panel to hold sizes of array
        sizePanel = new JPanel();
        sizePanel.add(jlbSize = new JLabel("Select the number of elements for the array: "));
        jcbxSize = new JComboBox();
        // Add array sizes to combo box - 1,000, 10,000, 100,000.
        jcbxSize.addItem(Array.SMALL);
        jcbxSize.addItem(Array.MEDIUM);
        jcbxSize.addItem(Array.LARGE);
        sizePanel.add(jcbxSize);

        // set up middle panels that holds data and add them to array list
        elementPanels.add(randomPanel = new ElementPanel("Random Elements"));
        elementPanels.add(sortedPanel = new ElementPanel("Sorted Elements"));
        elementPanels.add(invertedPanel = new ElementPanel("Inverted Elements"));

        analysisPanel = new JPanel();
        analysisPanel.setLayout(new GridLayout(3, 1));
        for(ElementPanel p : elementPanels) {
            analysisPanel.add(p);
        }

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 4));
        buttonPanel.setAlignmentX(JPanel.RIGHT_ALIGNMENT);
        sortBtns.add(jbtnBubble = new JButton("Bubble"));
        sortBtns.add(jbtnEnBubble = new JButton("E. Bubble"));
        sortBtns.add(jbtnSelect = new JButton("Selection"));
        sortBtns.add(jbtnInsert = new JButton("Insertion"));
        for(JButton btn : sortBtns) {
            buttonPanel.add(btn);
        }

        add(sizePanel, BorderLayout.NORTH);
        add(analysisPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        BtnActionListener listener = new BtnActionListener();
        for(JButton btn : sortBtns) {
            btn.addActionListener(listener);
        }

//        jcbxSize.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                switch((int)jcbxSize.getSelectedItem()) {
//                    case Array.SMALL:
//                        randomArray = arrayHelp.getRandomArray(Array.SMALL);
//                        sortedArray = arrayHelp.getSortedArray(Array.SMALL);
//                        invertedArray = arrayHelp.getInvertedArray(Array.SMALL);
//                        break;
//                    case Array.MEDIUM:
//                        randomArray = arrayHelp.getRandomArray(Array.MEDIUM);
//                        sortedArray = arrayHelp.getSortedArray(Array.MEDIUM);
//                        invertedArray = arrayHelp.getInvertedArray(Array.MEDIUM);
//                        break;
//                    case Array.LARGE:
//                        randomArray = arrayHelp.getRandomArray(Array.LARGE);
//                        sortedArray = arrayHelp.getSortedArray(Array.LARGE);
//                        invertedArray = arrayHelp.getInvertedArray(Array.LARGE);
//                        break;
//                }
//            }
//        });
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

            int size = (int) jcbxSize.getSelectedItem();
            int[] randomArray = arrayHelp.getRandomArray(size);
            int[] sortedArray = arrayHelp.getSortedArray(size);
            int[] invertedArray = arrayHelp.getInvertedArray(size);

            // store times, swaps and checks on text fields to compare against the other algorithms
            switch(e.getActionCommand()) {
                case "Bubble":
                    randomPanel.getBubblePanel().getJtfTime().setText("" + sortTime(BUBBLE, randomArray));
                    randomPanel.getBubblePanel().getJtfSwaps().setText("" + bubbleSort.getSwaps());
                    randomPanel.getBubblePanel().getJtfChecks().setText("" + bubbleSort.getChecks());
                    bubbleSort.reset();
                    sortedPanel.getBubblePanel().getJtfTime().setText("" + sortTime(BUBBLE, sortedArray));
                    sortedPanel.getBubblePanel().getJtfSwaps().setText("" + bubbleSort.getSwaps());
                    sortedPanel.getBubblePanel().getJtfChecks().setText("" + bubbleSort.getChecks());
                    bubbleSort.reset();
                    invertedPanel.getBubblePanel().getJtfTime().setText("" + sortTime(BUBBLE, invertedArray));
                    invertedPanel.getBubblePanel().getJtfSwaps().setText("" + bubbleSort.getSwaps());
                    invertedPanel.getBubblePanel().getJtfChecks().setText("" + bubbleSort.getChecks());
                    bubbleSort.reset();
                    break;

                case "E. Bubble":
                    randomPanel.getEnBubblePanel().getJtfTime().setText("" + sortTime(EN_BUBBLE, randomArray));
                    randomPanel.getEnBubblePanel().getJtfSwaps().setText("" + enBubbleSort.getSwaps());
                    randomPanel.getEnBubblePanel().getJtfChecks().setText("" + enBubbleSort.getChecks());
                    enBubbleSort.reset();
                    sortedPanel.getEnBubblePanel().getJtfTime().setText("" + sortTime(EN_BUBBLE, sortedArray));
                    sortedPanel.getEnBubblePanel().getJtfSwaps().setText("" + enBubbleSort.getSwaps());
                    sortedPanel.getEnBubblePanel().getJtfChecks().setText("" + enBubbleSort.getChecks());
                    enBubbleSort.reset();
                    invertedPanel.getEnBubblePanel().getJtfTime().setText("" + sortTime(EN_BUBBLE, invertedArray));
                    invertedPanel.getEnBubblePanel().getJtfSwaps().setText("" + enBubbleSort.getSwaps());
                    invertedPanel.getEnBubblePanel().getJtfChecks().setText("" + enBubbleSort.getChecks());
                    enBubbleSort.reset();
                    break;

                case "Selection":
                    randomPanel.getSelectPanel().getJtfTime().setText("" + sortTime(SELECT, randomArray));
                    randomPanel.getSelectPanel().getJtfSwaps().setText("" + selectionSort.getSwaps());
                    randomPanel.getSelectPanel().getJtfChecks().setText("" + selectionSort.getChecks());
                    selectionSort.reset();
                    sortedPanel.getSelectPanel().getJtfTime().setText("" + sortTime(SELECT, sortedArray));
                    sortedPanel.getSelectPanel().getJtfSwaps().setText("" + selectionSort.getSwaps());
                    sortedPanel.getSelectPanel().getJtfChecks().setText("" + selectionSort.getChecks());
                    selectionSort.reset();
                    invertedPanel.getSelectPanel().getJtfTime().setText("" + sortTime(SELECT, invertedArray));
                    invertedPanel.getSelectPanel().getJtfSwaps().setText("" + selectionSort.getSwaps());
                    invertedPanel.getSelectPanel().getJtfChecks().setText("" + selectionSort.getChecks());
                    selectionSort.reset();
                    break;

                case "Insertion":
                    randomPanel.getInsertPanel().getJtfTime().setText("" + sortTime(INSERT, randomArray));
                    randomPanel.getInsertPanel().getJtfSwaps().setText("" + insertionSort.getSwaps());
                    randomPanel.getInsertPanel().getJtfChecks().setText("" + insertionSort.getChecks());
                    insertionSort.reset();
                    sortedPanel.getInsertPanel().getJtfTime().setText("" + sortTime(INSERT, sortedArray));
                    sortedPanel.getInsertPanel().getJtfSwaps().setText("" + insertionSort.getSwaps());
                    sortedPanel.getInsertPanel().getJtfChecks().setText("" + insertionSort.getChecks());
                    insertionSort.reset();
                    invertedPanel.getInsertPanel().getJtfTime().setText("" + sortTime(INSERT, invertedArray));
                    invertedPanel.getInsertPanel().getJtfSwaps().setText("" + insertionSort.getSwaps());
                    invertedPanel.getInsertPanel().getJtfChecks().setText("" + insertionSort.getChecks());
                    insertionSort.reset();
                    break;
            }
        }

        /**
         * Times how long it takes to sort giving int array
         * @param algorithm - Algorithm to use to sort. Use class finals
         * @param elements - int array of elements to sort
         * @return - time it took to sort the array
         */
        private float sortTime(int algorithm, int[] elements) {
            watch.reset();
            watch.start();
            switch(algorithm) {
                case BUBBLE:
                    bubbleSort.sort(elements);
                    break;
                case EN_BUBBLE:
                    enBubbleSort.sort(elements);
                    break;
                case SELECT:
                    selectionSort.sort(elements);
                    break;
                case INSERT:
                    insertionSort.sort(elements);
            }
            watch.stop();
            return watch.getElapsedTime();
        }
    }
}
