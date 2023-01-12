import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;

public class SelectorPage extends IntoPage {
    private JButton topicButton1, topicButton2, topicButton3;
    private JLabel choiseLabel;

    //pocibles paginas siguientes
    private SelectorPage selectorPage;
    private IntoPage classPage;

    SelectorPage( int indexPage)
    {
        IntoPage.indexPage = indexPage;

        this.choiseLabel = new JLabel("Elige un " + pagesList[IntoPage.indexPage] + ":");
        this.choiseLabel.setBounds(10, 90, 768, 30);
        this.add(this.choiseLabel);

        this.topicButton1 = new JButton(pagesList[IntoPage.indexPage] + " 1");
        this.topicButton1.setBounds(30, 130, 724, 50);
        this.topicButton1.addActionListener(this);
        this.add(this.topicButton1);

        this.topicButton2 = new JButton(pagesList[IntoPage.indexPage] + " 2");
        this.topicButton2.setBounds(30, 190, 724, 50);
        this.topicButton2.addActionListener(this);
        this.add(this.topicButton2);

        this.topicButton3 = new JButton(pagesList[IntoPage.indexPage] + " 3");
        this.topicButton3.setBounds(30, 250, 724, 50);
        this.topicButton3.addActionListener(this);
        this.add(this.topicButton3);
    }
    /* (non-Javadoc)
     * @see Page#actionPerformed(java.awt.event.ActionEvent)
     * @param ActionEvent e captura el evento de hacer clic sobre un boton.
     * Tiene la misma función que el metodo heredado de IntoPage y ademas guarda la seleccion del usuario.
     * Abre una ventada de cursos, clases o clase segun el caso.
     */
    @Override
    public void actionPerformed(ActionEvent e){
        //Le otorga acciones a los botones de elección
        if ((e.getSource() == this.topicButton1)||(e.getSource() == this.topicButton2)||(e.getSource() == this.topicButton3)) {
            if (e.getSource() == this.topicButton1) {
                IntoPage.buttonsList[IntoPage.indexPage] = "1";
            }
            else if (e.getSource() == this.topicButton2) {
                IntoPage.buttonsList[IntoPage.indexPage] = "2";
            }
            else{
                IntoPage.buttonsList[IntoPage.indexPage] = "3";
            }

            //Crea la sigiente pagina
            IntoPage.contextPageString = "Inicio/";

            for (int i = 0; i <= IntoPage.indexPage; i++) {
                IntoPage.contextPageString += IntoPage.pagesList[i] + " " + IntoPage.buttonsList[i] + "/";
            }

            setVisible(false);
            if (IntoPage.indexPage == 2) {
                classPage = new IntoPage();
                classPage.setVisible(true);
            }
            else {
                IntoPage.indexPage += 1;
                selectorPage = new SelectorPage(IntoPage.indexPage);
                selectorPage.setVisible(true);
            }
        }
        //Si se preciona el boton de Atrás mientras se encuentre en las paginas de la clase SelectorPage
        else if (e.getSource() == this.backButton){
            setVisible(false);
            IntoPage.indexPage -= 1;
            
            IntoPage.buttonsList[indexPage] = "";

            IntoPage.contextPageString = "Inicio/";

            for (int i = 0; i <= (IntoPage.indexPage - 1); i++) {
                IntoPage.contextPageString += IntoPage.pagesList[i] + " " + IntoPage.buttonsList[i] + "/";
            }

            selectorPage = new SelectorPage(IntoPage.indexPage);
            selectorPage.setVisible(true);
        }
        //Le pregunta a la clase padre que hacer cuando se presionan el resto de botones
        else {
            super.actionPerformed(e);
        }
    }
}
