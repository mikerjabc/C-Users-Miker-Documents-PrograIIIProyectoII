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
    public final String[] tiposSolicitud = {"Incorporación","Traslado","Catálogo"};
    public final Object[] VARIABLESTABLA = {"Número","Fecha","Tipo","Estado","Cantidad de Bienes","Monto Total","Origen","Destino","Ubicación","Funcionario","Autorización","Código","Bien","Descripción"};
    private String tipo;
    private Solicitud solicitud;
    private Transferencia transferencia;
    private Bien bien;
    private Activo activo;

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
    public void setServicioActivo(ServicioActivo servicioActivo) {
        this.servicioActivo = servicioActivo;
        this.setChanged();
        this.notifyObservers();
    }
    
    public void buscarTransferencia_Incorporacion_Activo(String numero) throws Exception {
        try {
            if (numero.equals("")) {
                throw (new Exception("numero invalido"));
            }
            if(tipo.equalsIgnoreCase(tiposSolicitud[0])){
                solicitud = servicioSolicitud.buscarSolicitud(Integer.valueOf(numero));
                transferencia = null;
                activo = null;
            } else if(tipo.equalsIgnoreCase(tiposSolicitud[1])){
                transferencia = servicioTransferencia.buscarTransferencia(Integer.valueOf(numero));
                solicitud = null;
                activo = null;
            }else if(tipo.equalsIgnoreCase(tiposSolicitud[2])){
                activo = servicioActivo.buscarActivo(Integer.valueOf(numero));
                solicitud = null;
                transferencia = null;
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
            if (ubicacion.equals("")) {
                throw (new Exception("Ubicación invalida"));
            }
            if (funcionario.equals("")) {
                throw (new Exception("Funcionario invalido"));
            }
            if (bien.equals("")) {
                throw (new Exception("Bien invalido"));
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
            solicitud = null;
            transferencia = null;
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
                Iterator<Transferencia> ite = servicioTransferencia.listarTransferencia().iterator();
                while (ite.hasNext()) {
                    Transferencia transferencia = ite.next();
                    if (transferencia.getAutorizacion().equalsIgnoreCase("Recibida")) {
                        Object[] fila = {transferencia.getNumero(),
                            transferencia.getOrigen().getNombre(),
                            transferencia.getDestino().getNombre(),
                            transferencia.getUbicacion(),
                            transferencia.getFuncionario(),
                            transferencia.getAutorizacion()
                        };
                        list.add(fila);
                    }
                }
            } else if (tipo.equals(tiposSolicitud[2])) {
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
            } else if (transferencia != null) {
                Object[] fila = {transferencia.getNumero(),
                    transferencia.getOrigen().getNombre(),
                    transferencia.getDestino().getNombre(),
                    transferencia.getUbicacion(),
                    transferencia.getFuncionario(),
                    transferencia.getAutorizacion()
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
