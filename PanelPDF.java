import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;

public class PanelPDF extends JPanel {
    private JButton northButton, southButton, westButton, eastButton;
    private BorderLayout layout;
    private PanelPDFCenter panelPDFCenter;

    PanelPDF () {
        this.layout = new BorderLayout(5, 5);
        this.setLayout(layout);

        this.northButton = new JButton("North");
        this.add(this.northButton, BorderLayout.NORTH);

        this.westButton = new JButton("West");
        this.add(this.westButton, BorderLayout.WEST);

        this.panelPDFCenter = new PanelPDFCenter();
        this.add(this.panelPDFCenter, BorderLayout.CENTER);

        this.eastButton = new JButton("East");
        this.add(this.eastButton, BorderLayout.EAST);

        this.southButton = new JButton("South");
        this.add(this.southButton, BorderLayout.SOUTH);
    }
}