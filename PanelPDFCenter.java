import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;

public class PanelPDFCenter extends JPanel {
    private String[] pdfList = {"Concentrados", "Ganaderia", "Avicultura", "Porcicultura", "Mascotas", "Aquicultura", "Equinos", "Conejos"};
    private JList<String> jListPDF;
    private JScrollPane scrollPane;
    private FlowLayout flowLayout;

    PanelPDFCenter () {
        this.flowLayout = new FlowLayout(FlowLayout.LEFT);
        this.setLayout(flowLayout);

        this.jListPDF = new JList<String>(this.pdfList);
        this.jListPDF.setFixedCellHeight(30);
        this.jListPDF.setVisibleRowCount(10);

        this.scrollPane = new JScrollPane(jListPDF);
        this.add(scrollPane);
    }
}