import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class LoginPage extends Page implements ItemListener{
    private JLabel welcomeLabel, signalLabel, authorLabel;
    private JTextField inNameTextField;
    private JComboBox<String> tipeWorkComboBox;
    private JButton aceptButton;
    
    //posibles paginas siguientes
    private SelectorPage selectorPage;

    public LoginPage() {
        this.welcomeLabel = new JLabel("Bienvenido al Company Courses");
        this.welcomeLabel.setBounds(301, 10, 182, 30);
        this.add(this.welcomeLabel);

        this.inNameTextField = new JTextField();
        this.inNameTextField.setBounds(292, 50, 200, 30);
        this.add(this.inNameTextField);

        this.tipeWorkComboBox = new JComboBox<String>();
        this.tipeWorkComboBox.setBounds(292, 90, 200, 30);
        this.add(this.tipeWorkComboBox);
        this.tipeWorkComboBox.addItem("");
        this.tipeWorkComboBox.addItem("Perfil Administrativo");
        this.tipeWorkComboBox.addItem("Perfil de Ventas");
        this.tipeWorkComboBox.addItem("Empleado tipo 3");
        this.tipeWorkComboBox.addItemListener(this);

        this.aceptButton = new JButton("Aceptar");
        this.aceptButton.setBounds(342, 130, 100, 30);
        this.aceptButton.addActionListener(this);
        this.aceptButton.setEnabled(false);
        this.add(this.aceptButton);

        this.signalLabel = new JLabel("Si no puede ingresar comuniqueselo a soporte.");
        this.signalLabel.setBounds(258, 170, 268, 30);
        this.add(this.signalLabel);

        this.authorLabel = new JLabel("Author: Sebastián Soto Arcila");
        this.authorLabel.setBounds(608, 508, 166, 30);
        this.add(this.authorLabel);
    }

    /* (non-Javadoc)
     * @see java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
     * @param captura el evento de seleción de un item haciendo clic sobre él.
     * Abre el boton de acaptar si el usuario selecciono un item y guarda el texto selecionado.
     */
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == this.tipeWorkComboBox) {
            this.aceptButton.setEnabled(true);
            Page.tipeWorkString = e.getItem().toString();
        }
    }

    /* (non-Javadoc)
     * @see Page#actionPerformed(java.awt.event.ActionEvent)
     * @param ActionEvent e captura el evento de hacer clic en los botones.
     * Tiene la misma función que el metodo heredado de Page y ademas revisa si se preciono el boton de aceptar.
     * Si el usuario diligencio bien el formulario lo dirige a la topicsPage; muestra un mensaje si no.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Page.nameString = this.inNameTextField.getText();
        //Si se presiona el boton acptar
        if (e.getSource() == this.aceptButton){
            if ((Page.tipeWorkString.equals("")) || (Page.nameString.equals(""))) {
                JOptionPane.showMessageDialog(null, "No a puesto su nombre");
            } else {
                setVisible(false);
                //Inicializa el contexto
                IntoPage.contextPageString = "Inicio/";

                selectorPage = new SelectorPage(0);
                selectorPage.setVisible(true);
            }
        }
        else {
            super.actionPerformed(e);
        }
    }
}
