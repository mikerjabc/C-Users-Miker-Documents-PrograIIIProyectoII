package Logic;

public class Funcionario {

    private String id;
    private String nombre;
    private String puesto;
    private String password;

    public Funcionario(String id, String nombre, String puesto, String password) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
