package controllers;
import models.ModelPrincipal;
import views.ViewPrincipal;

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
/**
 *
 * @author Azael_Mendoza
 */
public class ControllerPrincipal {
    private FileWriter file_writter = null;
    private FileReader file_reader = null;
    private JFileChooser file_chooser = new JFileChooser();
    private final ModelPrincipal model_principal;
    private final ViewPrincipal view_principal;
    
    public ControllerPrincipal(ModelPrincipal model_principal, Object views[]){
        this.model_principal = model_principal;
        this.view_principal = (ViewPrincipal) views[0];
        initView();
    }
    
    public void initView(){
        view_principal.setTitle("Editor de Textto MVC");
        view_principal.jmi_abrir.addActionListener(e -> jmi_abrirMouseClicked());
        view_principal.jmi_guardar.addActionListener(e -> jmi_guardarMouseClicked());
        view_principal.jmi_salir.addActionListener(e -> jmi_salirMouseClicked());
        view_principal.setLocationRelativeTo(null);
        view_principal.setVisible(true);
    }
    
    private void jmi_abrirMouseClicked(){
        try{
            file_chooser.showOpenDialog(view_principal);
            model_principal.setArchivo(file_chooser.getSelectedFile());
            file_reader = new FileReader(model_principal.getArchivo());
            int character = 0;
            String content = "";
            while((character = file_reader.read()) != -1){
                content += (char) character;
            }
            file_reader.close();
            System.out.println(content);
            view_principal.jta_archivo.setText(content);
        }
        catch(FileNotFoundException err){
            System.err.println("Archivo no encontrado");
        }
        catch(IOException err){
            System.err.println("Error en el archivo");
        }
        finally{
            try{
                file_reader.close();
            }
            catch(IOException err){
                System.err.println("Error al cerrar");
            }
        }
    }
    
    public void jmi_guardarMouseClicked(){
        try{
        file_writter = new FileWriter(model_principal.getArchivo(),false);
        file_writter.write(view_principal.jta_archivo.getText());
        file_writter.close();
        
        }
        catch(FileNotFoundException err){
            System.err.println("Archivo no Encontrado");
        }
        catch(IOException err){
            System.err.println("Error en el archivo");
        }
    }
    
    public void jmi_salirMouseClicked(){
        view_principal.dispose();
    }
    
}