
package Logic;


public class Dependencia  {
    
    private int codigoDependencia;
    private String nombreDependencia;

    public Dependencia() {
    }
	
    public Dependencia(int codigoDependencia, String nombreDependencia) {
        this.codigoDependencia = codigoDependencia;
        this.nombreDependencia = nombreDependencia;
    }
   
    public int getCodigoDependencia() {
        return this.codigoDependencia;
    }
    
    public void setCodigoDependencia(int codigoDependencia) {
        this.codigoDependencia = codigoDependencia;
    }
    public String getNombreDependencia() {
        return this.nombreDependencia;
    }
    
    public void setNombreDependencia(String nombreDependencia) {
        this.nombreDependencia = nombreDependencia;
    }
    
}


