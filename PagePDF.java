import javax.swing.JFrame;

public class PagePDF extends JFrame {
    PanelPDF panelPDF;

    PagePDF () {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Company Courses");
        this.setBounds(0, 0, 800, 600);
        this.setLocationRelativeTo(null);

        this.panelPDF = new PanelPDF();
        this.add(panelPDF);
    }
}
