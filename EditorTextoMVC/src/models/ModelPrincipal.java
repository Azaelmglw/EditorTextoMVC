package models;

import java.io.File;
/**
 *
 * @author Azael_Mendoza
 */
public class ModelPrincipal {
    private File archivo;
    
    public File getArchivo(){
        return archivo;
    }
    
    public void setArchivo(File archivo){
        this.archivo = archivo;
    }
    
}