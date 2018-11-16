package Modelo;


import Logic.Activo;
import Logic.Bien;
import Logic.Solicitud;
import Logic.Transferencia;
import accesoADatos.GlobalException;
import accesoADatos.NoDataException;
import accesoADatos.ServicioActivo;
import accesoADatos.ServicioBien;
import accesoADatos.ServicioFuncionario;
import accesoADatos.ServicioSolicitud;
import accesoADatos.ServicioTransferencia;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModeloRegistrador extends Observable {
    private ServicioSolicitud servicioSolicitud;
    private ServicioTransferencia servicioTransferencia;
    private ServicioFuncionario servicioFuncionario;
    private ServicioBien servicioBien;
    private ServicioActivo servicioActivo;
    public final String[] tiposSolicitud = {"Incorporación","Traslado"};
    public final String[] tiposBienes = {"Compra","Donación","Producción institucional"};
    public final Object[] VARIABLESTABLA = {"Número","Fecha","Tipo","Estado","Cantidad de Bienes","Monto Total","Origen","Destino","Ubicación","Funcionario","Autorización"};
    private String tipo;
    private Solicitud solicitud;
    private Transferencia transferencia;
    private Bien bien;

    public ModeloRegistrador() {
        tipo = tiposSolicitud[0];
    }
    
    public void setServicioSolicitud(ServicioSolicitud servicioDependencia) {
        this.servicioSolicitud = servicioDependencia;
        this.setChanged();
        this.notifyObservers();
    }
    
    public void setServicioTransferencia(ServicioTransferencia servicioTransferencia) {
        this.servicioTransferencia = servicioTransferencia;
        this.setChanged();
        this.notifyObservers();
    }
    
    public void setServicioFuncionario(ServicioFuncionario servicioFuncionario) {
        this.servicioFuncionario = servicioFuncionario;
        this.setChanged();
        this.notifyObservers();
    }
    
    public void buscarSolicitud(String numero) throws Exception {
        try {
            if (numero.equals("")) {
                throw (new Exception("numero invalido"));
            }
            if(tipo.equalsIgnoreCase(tiposSolicitud[0])){
                solicitud = servicioSolicitud.buscarSolicitud(Integer.valueOf(numero));
                transferencia = null;
            }else{
                transferencia = servicioTransferencia.buscarTransferencia(Integer.valueOf(numero));
                solicitud = null;
            }
            this.setChanged();
            this.notifyObservers();
        } catch (Exception ex) {
            throw (new Exception(ex.getMessage()));
        }
    }
    
    public Bien RegistrarListaBien(String codigo, String descripcion, String ubicacion, String funcionario ,String bien) throws Exception {
        Bien aux = null;
        try {
            if (codigo.equals("")) {
                throw (new Exception("Numero invalido"));
            }
            servicioActivo.insertarActivo(new Activo(Integer.valueOf(codigo),servicioBien.buscarBien(bien),descripcion,servicioFuncionario.consultarFuncionario(funcionario),ubicacion), 0);
        } catch (Exception ex) {
            throw (new Exception(ex.getMessage()));
        }
        return aux;
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
    
    public void AutorizarTransferencia(String numero, String estado) throws Exception {
        try {
            if (numero.equals("")) {
                throw (new Exception("numero invalido"));
            }
            if (numero.equals("")) {
                throw (new Exception("estado invalido"));
            }
            transferencia = servicioTransferencia.buscarTransferencia(Integer.valueOf(numero));
            transferencia.setAutorizacion(estado);
            servicioTransferencia.modificarTransferencia(transferencia);
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
                    Solicitud d = ite.next();
                    if (d.getEstado().equalsIgnoreCase("por verificar")) {
                        Object[] fila = new Object[6];
                        fila[0] = d.getNumeroSolicitud();
                        fila[1] = d.getFecha();
                        fila[2] = d.getTipo();
                        fila[3] = d.getEstado();
                        fila[4] = d.getCantiadadBienes();
                        fila[5] = d.getMontoTotal();
                        
                        list.add(fila);
                    }
                }
            } else {
                Iterator<Transferencia> ite = servicioTransferencia.listarTransferencia().iterator();
                while (ite.hasNext()) {
                    Transferencia t = ite.next();
                    if (t.getAutorizacion().equalsIgnoreCase("Recibida")) {
                        Object[] fila = new Object[6];
                        fila[0] = t.getNumero();
                        fila[1] = t.getOrigen().getNombre();
                        fila[2] = t.getDestino().getNombre();
                        fila[3] = t.getUbicacion();
                        fila[4] = t.getFuncionario();
                        fila[5] = t.getAutorizacion();
                        
                        list.add(fila);
                    }
                }
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

    public Transferencia getTransferencia() {
        return transferencia;
    }
    
    @Override
    public void notifyObservers() {
        super.notifyObservers(getListaSolicitudes());
    }

    public void limpiar() {
        solicitud = null;
        transferencia = null;
        this.setChanged();
        this.notifyObservers();
    }
}
