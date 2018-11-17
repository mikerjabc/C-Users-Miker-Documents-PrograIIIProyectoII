package Modelo;


import Logic.Activo;
import Logic.Funcionario;
import Logic.Solicitud;
import accesoADatos.GlobalException;
import accesoADatos.NoDataException;
import accesoADatos.ServicioActivo;
import accesoADatos.ServicioBien;
import accesoADatos.ServicioFuncionario;
import accesoADatos.ServicioSolicitud;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModeloRegistrador extends Observable {
    private ServicioSolicitud servicioSolicitud;
    private ServicioFuncionario servicioFuncionario;
    private ServicioBien servicioBien;
    private ServicioActivo servicioActivo;
    public final String[] tiposSolicitud = {"Incorporación","Catálogo"};
    public final Object[] VARIABLESTABLA = {"Número","Fecha","Tipo","Estado","Cantidad de Bienes","Monto Total","Código","Bien","Descripción","Funcionario","Ubicación"};
    private String tipo;
    private Solicitud solicitud;
    private Activo activo;
    private Funcionario funcionario;

    public ModeloRegistrador(Funcionario funcionario) {
        tipo = tiposSolicitud[0];
        this.funcionario = funcionario;
    }
    
    public void setServicioSolicitud(ServicioSolicitud servicioDependencia) {
        this.servicioSolicitud = servicioDependencia;
        this.setChanged();
        this.notifyObservers();
    }
    
    public void setServicioFuncionario(ServicioFuncionario servicioFuncionario) {
        this.servicioFuncionario = servicioFuncionario;
        this.setChanged();
        this.notifyObservers();
    }
    public void setServicioActivo(ServicioActivo servicioActivo) {
        this.servicioActivo = servicioActivo;
        this.setChanged();
        this.notifyObservers();
    }
    
    public void agregarActivo(String codigo, String bien, String descripcion, String funcionario, String ubicacion) throws Exception {
        try {
            if (codigo.equals("")) {
                throw (new Exception("Código invalido"));
            }
            if (bien.equals("")) {
                throw (new Exception("Bien invalido"));
            }
            if (descripcion.equals("")) {
                throw (new Exception("Descripción invalida"));
            }
            if (funcionario.equals("")) {
                throw (new Exception("Funcionario invalido"));
            }
            if (ubicacion.equals("")) {
                throw (new Exception("Ubicación invalida"));
            }
            Activo activo = new Activo(Integer.valueOf(codigo), servicioBien.buscarBien(bien), descripcion, servicioFuncionario.consultarFuncionario(funcionario), ubicacion);
            //Cambiar por dependencia
            servicioActivo.insertarActivo(activo, 0);
            this.setChanged();
            this.notifyObservers();
        } catch (Exception ex) {
            throw (new Exception(ex.getMessage()));
        }
    }
    
    public void modificarActivo(String codigo, String bien, String descripcion, String funcionario, String ubicacion) throws Exception {
        try {
            if (codigo.equals("")) {
                throw (new Exception("Código invalido"));
            }
            if (bien.equals("")) {
                throw (new Exception("Bien invalido"));
            }
            if (descripcion.equals("")) {
                throw (new Exception("Descripción invalida"));
            }
            if (funcionario.equals("")) {
                throw (new Exception("Funcionario invalido"));
            }
            if (ubicacion.equals("")) {
                throw (new Exception("Ubicación invalida"));
            }
            Activo activo = new Activo(Integer.valueOf(codigo), servicioBien.buscarBien(bien), descripcion, servicioFuncionario.consultarFuncionario(funcionario), ubicacion);
            //Cambiar por dependencia
            servicioActivo.modificarActivo(activo);
            this.setChanged();
            this.notifyObservers();
        } catch (Exception ex) {
            throw (new Exception(ex.getMessage()));
        }
    }
    
    public void eliminarActivo(String codigo) throws Exception {
        try {
            servicioActivo.eliminarBien(codigo);
            this.setChanged();
            this.notifyObservers();
        } catch (Exception ex) {
            throw (new Exception(ex.getMessage()));
        }
    }
    
    public void buscarIncorporacion_Activo(String numero) throws Exception {
        try {
            if (numero.equals("")) {
                throw (new Exception("Número invalido"));
            }
            if (tipo.equalsIgnoreCase(tiposSolicitud[0])) {
                solicitud = servicioSolicitud.buscarSolicitud(Integer.valueOf(numero));
                activo = null;
            }
            this.setChanged();
            this.notifyObservers();
        } catch (Exception ex) {
            throw (new Exception(ex.getMessage()));
        }
    }
    
    public void AsignarArticulosADependencia(String numero, String id) throws Exception {
        try {
            if (numero.equals("")) {
                throw (new Exception("numero invalido"));
            }
            if (id.equals("")) {
                throw (new Exception("ID invalido"));
            }
            servicioFuncionario.consultarFuncionario(id);
            //Asignar solicitud a funcionario
            this.setChanged();
            this.notifyObservers();
        } catch (Exception ex) {
            throw (new Exception(ex.getMessage()));
        }
    }
    
    public void cambiarTipo(String tipo) throws Exception {
        try {
            if (tipo.equals("")) {
                throw (new Exception("Debe ingresar un codigo"));
            }
            this.tipo = tipo;
            solicitud = null;
            activo = null;
            this.setChanged();
            this.notifyObservers();
        } catch (Exception ex) {
            throw (new Exception(ex.getMessage()));
        }
    }
    
    public ArrayList<Object> getListaSolicitudes() {
        ArrayList<Object> list = new ArrayList();
        try {
            if (tipo.equals(tiposSolicitud[0])) {
                Iterator<Solicitud> ite = servicioSolicitud.listarSolicitudes().iterator();
                while (ite.hasNext()) {
                    Solicitud solicitud = ite.next();
                    if (solicitud.getEstado().equalsIgnoreCase("por verificar")) {
                        Object[] fila = {solicitud.getNumeroSolicitud(),
                            solicitud.getFecha(),
                            solicitud.getTipo(),
                            solicitud.getEstado(),
                            solicitud.getCantiadadBienes(),
                            solicitud.getMontoTotal()
                        };
                        list.add(fila);
                    }
                }
            } else if (tipo.equals(tiposSolicitud[1])) {
                Iterator<Activo> ite = servicioActivo.listarActivo().iterator();
                while (ite.hasNext()) {
                    Activo activo = ite.next();
                    Object[] fila = {activo.getCodigoActivo(),
                        activo.getBien().getDescripcion(),
                        activo.getDescripcionActivo(),
                        activo.getFuncionario().getNombre(),
                        activo.getUbicacion()};
                    list.add(fila);
                }
            } else if (solicitud != null) {
                Object[] fila = {solicitud.getNumeroSolicitud(),
                    solicitud.getFecha(),
                    solicitud.getTipo(),
                    solicitud.getEstado(),
                    solicitud.getCantiadadBienes(),
                    solicitud.getMontoTotal()
                };
                list.add(fila);
            } else if (activo != null) {
                Object[] fila = {activo.getCodigoActivo(),
                    activo.getBien().getDescripcion(),
                    activo.getDescripcionActivo(),
                    activo.getFuncionario().getNombre(),
                    activo.getUbicacion()};
                list.add(fila);
            }
        } catch (GlobalException | NoDataException ex) {
        } catch (SQLException ex) {
            Logger.getLogger(ModeloRecurHumanos.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return list;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public Activo getActivo() {
        return activo;
    }
    
    public int numeroConsecutivoParaActivo() throws Exception {
        int aux;
        try{
           aux = servicioActivo.listarActivo().size();
        }catch(Exception ex){
            throw(new Exception(ex.getMessage()));
        }
        return aux + 1;
    }
    
    @Override
    public void notifyObservers() {
        super.notifyObservers(getListaSolicitudes());
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }
    
    public void limpiar() {
        solicitud = null;
        this.setChanged();
        this.notifyObservers();
    }
}
