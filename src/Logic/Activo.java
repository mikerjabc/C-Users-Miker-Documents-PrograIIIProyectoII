package Logic;

public class Activo {

    private int codigoActivo;
    private Bien bien;
    private String descripcionActivo;
    private Funcionario funcionario;
    private String ubicacion;

    public Activo() {}

    public Activo(int codigoActivo, Bien bien, String descripcionActivo, Funcionario funcionario) {
        this.codigoActivo = codigoActivo;
        this.bien = bien;
        this.descripcionActivo = descripcionActivo;
    }

    public int getCodigoActivo() {
        return this.codigoActivo;
    }

    public void setCodigoActivo(int codigoActivo) {
        this.codigoActivo = codigoActivo;
    }

    public Bien getBien() {
        return this.bien;
    }

    public void setBien(Bien bien) {
        this.bien = bien;
    }

    public String getDescripcionActivo() {
        return this.descripcionActivo;
    }

    public void setDescripcionActivo(String descripcionActivo) {
        this.descripcionActivo = descripcionActivo;
    }
}
