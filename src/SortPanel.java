import javax.swing.*;
import java.awt.*;

public class SortPanel extends JPanel {

    private JLabel heading;
    private JTextField jtfTime, jtfSwaps, jtfChecks;

    public SortPanel(String heading) {
        setLayout(new GridLayout(4,1));

        add(this.heading = new JLabel(heading));
        this.heading.setHorizontalAlignment(JLabel.CENTER);

        add(jtfTime = new JTextField(20));
        add(jtfSwaps = new JTextField(20));
        add(jtfChecks = new JTextField(20));
    }
}
