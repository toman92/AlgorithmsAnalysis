import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;

public class AnalysisGUI extends JFrame {

    private SortPanel bubblePanel, enBubblePanel, selectPanel, insertPanel;
    private JPanel labelPanel;
    private JLabel jlbTime, jlbSwaps, jlbChecks, jlblSize, jlblBubble, jlblEnBubble, jlblInsert, jlblSelect;
    private JComboBox jcbxSize;
    private JButton jbtnBubble, jbtnEnBubble, jbtnInser, jbtnSelect;
    private JTextField jtfTime, jtfSwaps, jtfChecks;

    public AnalysisGUI() {
        setLayout(new GridLayout(1, 5));

        labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(3, 1));
        labelPanel.add(jlbTime = new JLabel("Time - Nanoseconds: "));
        labelPanel.add(jlbSwaps = new JLabel("Number of Writes: "));
        labelPanel.add(jlbChecks = new JLabel("Number of Comparisons: "));

        // set up bubble panel
        bubblePanel = new SortPanel("Standard Bubble");


        add(bubblePanel);
    }

    public static void main(String[] arg) {
        AnalysisGUI frame = new AnalysisGUI();
        frame.pack();
        frame.setTitle("Algorithms");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
