import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;

public class IntoPage extends Page {
    protected JButton signOffButton, backButton;
    private JLabel helloNameLabel, contextLabel;
    public static int indexPage;
    public static String contextPageString;
    public static String[] buttonsList = {"", "", ""}, pagesList = {"Tema", "Curso", "Clase"};

    //posibles paginas siguientes
    private LoginPage loginPage;
    private SelectorPage selectorPage;

    public IntoPage() {
        this.helloNameLabel = new JLabel("Hola " + Page.nameString + ", " + Page.tipeWorkString + ".");
        this.helloNameLabel.setBounds(10, 10, 534, 30);
        this.add(this.helloNameLabel);

        this.backButton = new JButton("Atrás");
        this.backButton.setBounds( 544, 10, 100, 30);
        //Desactiva el boton Atrás si esta en la pagina de seleccion de temas
        if (IntoPage.indexPage == 0) {
            this.backButton.setEnabled(false);
        }
        this.backButton.addActionListener(this);
        this.add(this.backButton);

        this.signOffButton = new JButton("Cerrar sesión");
        this.signOffButton.setBounds( 654, 10, 120, 30);
        this.signOffButton.addActionListener(this);
        this.add(this.signOffButton);

        this.contextLabel = new JLabel(contextPageString);
        this.contextLabel.setBounds(10, 50, 768, 30);
        this.add(this.contextLabel);
    }

    
    /* (non-Javadoc)
     * @see Page#actionPerformed(java.awt.event.ActionEvent)
     * @param ActionEvent e captura el evento de hacer clic sobre un boton.
     * Tiene la misma función que el metodo heredado de Page, ademas revisa si se presiono el boton para volver a la LoginPages
     * o el boto para regrazar a la pagina anterior
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //Si se presiono el boton de cerrar sección, vuelve a loginPage
        if (e.getSource() == this.signOffButton) {
            setVisible(false);
            //Inicializa los botones seleccionados y el indice
            IntoPage.indexPage = 0;
            IntoPage.buttonsList[0] = "";
            IntoPage.buttonsList[1] = "";
            IntoPage.buttonsList[2] = "";
            
            loginPage = new LoginPage();
            loginPage.setVisible(true);

        //Si se presiono el boton de atrás, vuelve a la seleccion de clases
        } else if (e.getSource() == this.backButton) {
            setVisible(false);
            IntoPage.buttonsList[indexPage] = "";

            IntoPage.contextPageString = "Inicio/";
            for (int i = 0; i <= (IntoPage.indexPage - 1); i++) {
                IntoPage.contextPageString += IntoPage.pagesList[i] + " " + IntoPage.buttonsList[i] + "/";
            }

            selectorPage = new SelectorPage(indexPage);
            selectorPage.setVisible(true);
        }
        //Si se preciono in boton diferente a los anteriores, le pregunta a la clase padre que hacer
        else {
            super.actionPerformed(e);
        }
    }

}
