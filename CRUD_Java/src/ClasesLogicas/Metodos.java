
package ClasesLogicas;

import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fernández
 */
public class Metodos {

    private LinkedList<Persona> listaPersonas = new LinkedList<Persona>();
    private Persona personaBuscada = null;
    
    public boolean ValidarNombre(String nombre) {
        if (nombre.isEmpty()) {
            JOptionPane.showConfirmDialog(null, "Debe ingresar un nombre", "Nombre", -1, 0);
            return false;
        } else {
            return true;
        }
    }

    //Método para validar la edad (Número entero entre 0 y 125)
    public boolean ValidarEdad(String edad) {
        if (edad.isEmpty()) {
            JOptionPane.showConfirmDialog(null, "Debe ingresar una edad", "Edad", -1, 0);
            return false;
        }
        try {
            if (Integer.parseInt(edad) < 0 || Integer.parseInt(edad) > 125) {
                JOptionPane.showConfirmDialog(null, "Debe ingresar una edad entre 0 y 125 años", "Edad", -1, 0);
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "La edad debe ser un número", "Edad", -1, 0);
            return false;
        }
        return true;
    }

    // Método para validar que se escoja una nacionalidad
    public boolean ValidarNacionalidad(String nacionalidad) {
        if (nacionalidad != "Costarricense" && nacionalidad != "Extranjero") {
            JOptionPane.showConfirmDialog(null, "Debe escoger una nacionalidad", "Nacionalidad", -1, 0);
            return false;
        } else {
            return true;
        }
    }
    
    /*-----------------------------------------------------------------------------*/
    //Método para agregar personas a la lista
    public void AgregarPersonas(Persona nueva){
        listaPersonas.add(nueva);
    }
    
    //Método que retorna la lista de personas
    public LinkedList<Persona> ObtenerLista(){
        return listaPersonas;
    }
    
    /*-----------------------------------------------------------------------------*/
    //Método para limpiar la tabla antes de mostrar los datos
    public void LimpiarTabla(DefaultTableModel modelo){
        while(modelo.getRowCount () != 0){
            modelo.removeRow(0);
        }
    }
    
    //Método para Mostrar Personas
    public void MostrarPersonas(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

        //Limpia la tabla
        LimpiarTabla(modelo);
        
        Iterator<Persona> iterator = listaPersonas.iterator();
        Persona item;
        while (iterator.hasNext()) {
            item = iterator.next();
            modelo.addRow(new Object[]{item.getId(), item.getNombre(), item.getNacionalidad(), item.getEdad(),
                item.isVacunacionCovid19() ? "Completo" : "Incompleto", item.isVacunaInflueza() ? "Si" : "No"});
        }
    }
    
    /*-----------------------------------------------------------------------------*/
    /*Buscar y Editar Personas*/
    //Método para buscar personas en la lista enlazada con recursividad
    public Persona Buscar(LinkedList<Persona> list,Iterator<Persona> itr, int id){
        if(itr.hasNext()){
            personaBuscada = itr.next();
            if(personaBuscada.getId() == id){
                return personaBuscada;
            }else{
                return Buscar(list, itr, id);
            }
        }else{
            return null;
        } 
    }
    
    //Método para guardar las personas editadas
    public boolean Guardar(int id, String nombre, String edad, String nacionalidad, boolean vacunaCovid, boolean vacunaInflueza){
        Iterator<Persona> iterator = listaPersonas.iterator();
        Persona item;
        while (iterator.hasNext()){
            item = iterator.next();
            if(item.getId() == id){
                if (ValidarNombre(nombre) && ValidarNacionalidad(nacionalidad) && ValidarEdad(edad)) {
                    item.setNombre(nombre);
                    item.setEdad(Integer.parseInt(edad));
                    item.setNacionalidad(nacionalidad);
                    item.setVacunacionCovid19(vacunaCovid);
                    item.setVacunaInflueza(vacunaInflueza);
                    return true;
                }else{
                    return false;
                }
            }
        }
        return false;
    }
}
