package Logic;

public class Activo {

    private int codigoActivo;
    private Bien bien;
    private String descripcionActivo;
    private Funcionario funcionario;
    private String ubicacion;

    public Activo(int codigoActivo, Bien bien, String descripcionActivo, Funcionario funcionario, String ubicacion) {
        this.codigoActivo = codigoActivo;
        this.bien = bien;
        this.descripcionActivo = descripcionActivo;
        this.funcionario = funcionario;
        this.ubicacion = ubicacion;
    }

    public int getCodigoActivo() {
        return codigoActivo;
    }

    public void setCodigoActivo(int codigoActivo) {
        this.codigoActivo = codigoActivo;
    }

    public Bien getBien() {
        return bien;
    }

    public void setBien(Bien bien) {
        this.bien = bien;
    }

    public String getDescripcionActivo() {
        return descripcionActivo;
    }

    public void setDescripcionActivo(String descripcionActivo) {
        this.descripcionActivo = descripcionActivo;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    
}
