
package ClasesLogicas;

/**
 *
 * @author Fernández
 */
public class Persona {
    int id;
    String nombre;
    String nacionalidad;
    int edad;
    boolean vacunacionCovid19;
    boolean vacunaInflueza;

    public Persona(int id, String nombre, String nacionalidad, int edad, boolean vacunacionCovid19, boolean vacunaInflueza) {
        this.id = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
        this.vacunacionCovid19 = vacunacionCovid19;
        this.vacunaInflueza = vacunaInflueza;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isVacunacionCovid19() {
        return vacunacionCovid19;
    }

    public void setVacunacionCovid19(boolean vacunacionCovid19) {
        this.vacunacionCovid19 = vacunacionCovid19;
    }

    public boolean isVacunaInflueza() {
        return vacunaInflueza;
    }

    public void setVacunaInflueza(boolean vacunaInflueza) {
        this.vacunaInflueza = vacunaInflueza;
    }
    
    
}
