import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Page extends JFrame implements ActionListener {
    private JMenuBar menuBar;
    private JMenu settingsMenu, optionsMenu, resolutionMenu, modeMenu;
    private JMenuItem resolutionItem1, dayMode;
    public static String nameString, tipeWorkString;

    public Page() {
        this.menuBar = new JMenuBar();
        this.setJMenuBar(this.menuBar);

        this.optionsMenu = new JMenu("Opciones");
        this.menuBar.add(this.optionsMenu);

        this.settingsMenu = new JMenu("Ajustes");
        this.optionsMenu.add(this.settingsMenu);

        this.resolutionMenu = new JMenu("Resoluciones");
        this.settingsMenu.add(this.resolutionMenu);

        this.resolutionItem1 = new JMenuItem("800*600");
        this.resolutionItem1.addActionListener(this);
        this.resolutionMenu.add(this.resolutionItem1);

        this.modeMenu = new JMenu("Modos");
        this.settingsMenu.add(modeMenu);

        this.dayMode = new JMenuItem("Modo día");
        this.dayMode.addActionListener(this);
        this.modeMenu.add(this.dayMode);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setTitle("Company Courses");
        this.setBounds(0, 0, 800, 600);
        this.setLocationRelativeTo(null);
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     * @param ActionEvent e captura el evento de hacer clic sobre un boton.
     * Revisa que opcion se escojio en la barra de menus, y muestra el mensaje respectivo.
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.resolutionItem1) {
            JOptionPane.showMessageDialog(null, "Solo existe la resolución de 800*600");
        }
        else if (e.getSource() == this.dayMode) {
            JOptionPane.showMessageDialog(null, "Solo existe el Modo Día");
        }
    }


}
