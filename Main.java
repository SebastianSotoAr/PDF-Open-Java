import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        /*PagePDF pagePDF = new PagePDF();
        pagePDF.setVisible(true);*/
        File file = new File("Horario_del_Alumno.pdf");
        try{
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            System.out.println("No se pudo abrir en archivo: Horario_del_Alumno.pdf");
        } catch (IllegalArgumentException e) {
            System.out.println("No se encontro el archivo: Horario_del_Alumno.pdf");
        }
        file.finalize();
        System.out.println(file);
    }
}