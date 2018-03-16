import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;

public class AnalysisGUI extends JFrame {

    // Algorithms and helpers
    private BubbleSort bubbleSort;
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

    public AnalysisGUI() {

        bubbleSort = new BubbleSort();
        insertionSort = new InsertionSort();
        selectionSort = new SelectionSort();
        arrayHelp = new Array();
        watch = new StopWatch();

        // Create and set up panel to hold sizes of array
        sizePanel = new JPanel();
        sizePanel.add(jlbSize = new JLabel("Select the number of elements for the array: "));
        jcbxSize = new JComboBox();
        // Add array sizes to combo box - 1,000, 10,000, 100,000.
        jcbxSize.addItem(Array.SMALL);
        jcbxSize.addItem(Array.MEDIUM);
        jcbxSize.addItem(Array.LARGE);
        sizePanel.add(jcbxSize);

        // set up middle panels that holds data
        randomPanel = new ElementPanel("Random Elements");
        sortedPanel = new ElementPanel("Sorted Elements");
        invertedPanel = new ElementPanel("Inverted Elements");

        analysisPanel = new JPanel();
        analysisPanel.setLayout(new GridLayout(3, 1));
        analysisPanel.add(randomPanel);
        analysisPanel.add(sortedPanel);
        analysisPanel.add(invertedPanel);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 4));
        buttonPanel.setAlignmentX(JPanel.RIGHT_ALIGNMENT);
        jbtnBubble = new JButton("Bubble");
        jbtnEnBubble = new JButton("E. Bubble");
        jbtnSelect = new JButton("Selection");
        jbtnInsert = new JButton("Insertion");
        buttonPanel.add(jbtnBubble);
        buttonPanel.add(jbtnEnBubble);
        buttonPanel.add(jbtnSelect);
        buttonPanel.add(jbtnInsert);

        add(sizePanel, BorderLayout.NORTH);
        add(analysisPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        BtnActionListener listener = new BtnActionListener();
        jbtnBubble.addActionListener(listener);
    }

    public static void main(String[] arg) {
        AnalysisGUI frame = new AnalysisGUI();
        frame.setSize(1000, 600);
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

            switch(e.getActionCommand()) {
                case "Bubble":
                    watch.start();
                    bubbleSort.sort(randomArray);
                    watch.stop();
                    randomPanel.getBubblePanel().getJtfTime().setText("" + watch.getElapsedTime());
                    randomPanel.getBubblePanel().getJtfSwaps().setText("" + bubbleSort.getSwaps());
                    randomPanel.getBubblePanel().getJtfChecks().setText("" + bubbleSort.getChecks());
                    watch.reset();
                    break;

                case "E. Bubble":
                    break;

                case "Selection":
                    break;

                case "Insertion":
                    break;
            }
        }
    }
}
