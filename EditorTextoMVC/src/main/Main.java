package main;

import controllers.ControllerPrincipal;
import models.ModelPrincipal;
import views.ViewPrincipal;

/**
 *
 * @author Azael_Mendoza
 */
public class Main {
    
    public static void main(String oamg[]){
        ModelPrincipal model_principal = new ModelPrincipal();
        ViewPrincipal view_principal = new ViewPrincipal();
        
        Object views [] = new Object[1];
        views[0] = view_principal;
        
        ControllerPrincipal controller_principal = new ControllerPrincipal(model_principal, views);
    }
    
}
