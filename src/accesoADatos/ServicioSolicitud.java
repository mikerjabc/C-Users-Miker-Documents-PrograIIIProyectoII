/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoADatos;

import Logic.Bien;
import accesoADatos.GlobalException;
import accesoADatos.NoDataException;
import accesoADatos.Servicio;
import Logic.Solicitud;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JTextPane;
//import oracle.jdbc.OracleTypes;

/**
 *
 * @author Fernando
 */
public class ServicioSolicitud extends Servicio {

    private static final String INSERTARSOLICITUD = "{call insertarSolicitud(?,?,?,?,?)}";
    private static final String ELIMINARSOLICITUD = "{call eliminarSolicitud(?)}";
    private static final String MODIFICARSOLICITUD = "{call modificarSolicitud(?,?,?,?,?)}";
    private static final String LISTARSOLICITUD = "{?=call listarSolicitud}";
    private static final String CONSULTARSOLICITUD = "{?=call consultarSolicitud(?)}";

    public ServicioSolicitud() {
    }

    public void insertarBienMueble(Solicitud laSolicitud) throws GlobalException, NoDataException {
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt = null;

        try {
            pstmt = conexion.prepareCall(INSERTARSOLICITUD);
            
            pstmt.setString(1, laSolicitud.getFecha().toString());
            
            pstmt.setString(2, laSolicitud.getTipo());

            pstmt.setString(3, laSolicitud.getEstado());
            
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                throw new NoDataException("No se realizo la insercion");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new GlobalException("Llave duplicada");
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                throw new GlobalException("Estatutos invalidos o nulos");
            }
        }
    }

    public void eliminarBienesMuebles(int elNumero) throws GlobalException, NoDataException {
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        
        CallableStatement pstmt = null;
        ResultSet rs = null;
        Solicitud laSolicitud = this.consultarBienesMuebles(elNumero);
        
        try {
            pstmt = conexion.prepareCall(ELIMINARSOLICITUD);
            pstmt.setInt(1, elNumero);
            pstmt.execute();
            
            Iterator<Bien> ite = laSolicitud.getListaBienes().iterator();
            
            while (ite.hasNext()) {
                ServicioBien.getServicioBien().eliminarBien(ite.next().getSerial());
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            throw new GlobalException("Sentencia no valida");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                throw new GlobalException("Estatutos invalidos o nulos");
            }
        }

    }

    public void modificarBienesMuebles(Solicitud laSolicitud) throws GlobalException, NoDataException {
        
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt = null;

        try {
            pstmt = conexion.prepareCall(MODIFICARSOLICITUD);
            pstmt.setInt(1, laSolicitud.getNumeroSolicitud());
            pstmt.setDate(2, laSolicitud.getFecha());
            pstmt.setString(3, laSolicitud.getTipo());
            pstmt.setString(4, laSolicitud.getEstado());
            pstmt.setInt(5, laSolicitud.getCantiadadBienes());
            pstmt.setFloat(6, laSolicitud.getMontoTotal());

            Iterator<Bien> ite = laSolicitud.getListaBienes().iterator();

            while (ite.hasNext()) {
                ServicioBien.getServicioBien().modificarBien(ite.next());
            }

            boolean resultado = pstmt.execute();

            if (resultado == true) {
                throw new NoDataException("No se realizo la modificacion");

            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new GlobalException("-------------Llave no existe");
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                throw new GlobalException("Estatutos invalidos o nulos");
            }
        }
    }

    public Solicitud consultarBienesMuebles(int elNumero) throws GlobalException, NoDataException {
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }

        ResultSet rs = null;
        Solicitud laSolicitud = null;
        CallableStatement pstmt = null;

        try {
            pstmt = conexion.prepareCall(CONSULTARSOLICITUD);
            //pstmt.registerOutParameter(1, OracleTypes.CURSOR);            
            pstmt.setInt(2, elNumero);
            pstmt.execute();
            rs = (ResultSet) pstmt.getObject(1);

            while (rs.next()) {
                if (rs.getInt("numero") == elNumero){
                    laSolicitud = new Solicitud(rs.getInt("numero"),
                            rs.getDate("fecha"),
                            rs.getString("tipo"),
                            rs.getString("estado"),
                            rs.getInt("cantidadBienes"),
                            rs.getFloat("montoTotal")
                    );
                    laSolicitud.setListaBienes(ServicioBien.getServicioBien().consultarBienPorSolicitud(elNumero));
                    break;
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();

            throw new GlobalException("Sentencia no valida");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                throw new GlobalException("Estatutos invalidos o nulos");
            }
        }

        return laSolicitud;
    }

    public ArrayList<Solicitud> listarBienes() throws GlobalException, NoDataException, SQLException {

        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        ResultSet rs = null;
        Solicitud laSolicitud = null;
        ArrayList<Solicitud> coleccion = new ArrayList();
        
        CallableStatement pstmt = null;
        try {
            pstmt = conexion.prepareCall(LISTARSOLICITUD);
            //pstmt.registerOutParameter(1, OracleTypes.CURSOR);	
            while (rs.next()) {
                    laSolicitud = new Solicitud(rs.getInt("numero"),
                            rs.getDate("fecha"),
                            rs.getString("tipo"),
                            rs.getString("estado"),
                            rs.getInt("cantidadBienes"),
                            rs.getFloat("montoTotal")
                    );
                    laSolicitud.setListaBienes(ServicioBien.getServicioBien().consultarBienPorSolicitud(laSolicitud.getNumeroSolicitud()));
                    coleccion.add(laSolicitud);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new GlobalException("Sentencia no valida");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                throw new GlobalException("Estatutos invalidos o nulos");
            }
        }
        if (coleccion == null) {
            throw new NoDataException("No hay datos");
        }
        return coleccion;
    }

    public void insertarSolicitud(String tipo, String campoMontoTotal, ArrayList<Bien> bienes) {
     }
}
