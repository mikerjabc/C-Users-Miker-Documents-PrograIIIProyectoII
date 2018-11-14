/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoADatos;

import Logic.Bien;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
//import oracle.jdbc.OracleTypes;
//import oracle.jdbc.OracleTypes;

/**
 *
 * @author Fernando
 */
public class ServicioBien extends Servicio {

    private static final String INGRESABIEN = "{call ingresaBien(?,?,?,?,?,?)}";
    private static final String ELIMINARBIEN = "{call eliminarBien(?)}";
    private static final String MODIFICARBIEN = "{call modificarBien(?,?,?,?,?)}";
    private static final String LISTARBIEN = "{?=call listarBien}";
    private static final String CONSULTARBIEN = "{?=call consultarBien(?)}";    
    private static final String BUSCARBIENPORSOLICITUD = "{?=call buscarBienPorSolicitud(?)}";

    
    private static ServicioBien servicioBien = new ServicioBien();
    
    public void insertarBien(Bien elBien) throws GlobalException, NoDataException {
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt = null;

        try {
            pstmt = conexion.prepareCall(INGRESABIEN);

            pstmt.setString(1, elBien.getSerial());
            pstmt.setString(2, elBien.getDescripcion());
            pstmt.setString(3, elBien.getMarca());
            pstmt.setString(4, elBien.getModelo());
            pstmt.setFloat(5, elBien.getPrecio());
            pstmt.setInt(6, elBien.getCantidad());

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

    public void eliminarBien(String serial) throws GlobalException, NoDataException {
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt = null;
        ResultSet rs = null;
        Bien elBien = null;

        try {
            pstmt = conexion.prepareCall(ELIMINARBIEN);
            pstmt.setString(1, serial);
            pstmt.execute();
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

    public void modificarBien(Bien elBien) throws GlobalException, NoDataException {

        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt = null;

        try {
            pstmt = conexion.prepareCall(MODIFICARBIEN);

            pstmt.setString(1, elBien.getSerial());
            pstmt.setString(2, elBien.getDescripcion());
            pstmt.setString(3, elBien.getMarca());
            pstmt.setString(4, elBien.getModelo());
            pstmt.setFloat(5, elBien.getPrecio());

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

    public Bien consultarBien(String elSerial) throws GlobalException, NoDataException {
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }

        ResultSet rs = null;
        CallableStatement pstmt = null;
        Bien elBien = null;
        ArrayList<Bien> coleccion = new ArrayList();

        try {
            pstmt = conexion.prepareCall(CONSULTARBIEN);
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.setString(2, elSerial);
            pstmt.execute();
            rs = (ResultSet) pstmt.getObject(1);

            while (rs.next()) {
                if (rs.getString("serial").equals(elSerial)) {
                    elBien = new Bien(rs.getString("serial"),
                            rs.getString("descripcion"),
                            rs.getString("marca"),
                            rs.getString("modelo"),
                            rs.getInt("precio"),rs.getInt("cantidad")
                    );
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

        return elBien;
    }

    public ArrayList<Bien> listarBien() throws GlobalException, NoDataException, SQLException {

        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        ResultSet rs = null;
        Bien elBien = null;
        ArrayList<Bien> coleccion = new ArrayList();
        CallableStatement pstmt = null;
        try {
            pstmt = conexion.prepareCall(LISTARBIEN);
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);	
            pstmt.execute();
            rs = (ResultSet) pstmt.getObject(1);
            while (rs.next()) {
                elBien = new Bien(rs.getString("serial"),
                        rs.getString("descripcion"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getFloat("precio"),rs.getInt("cantidad")
                );
            }
            coleccion.add(elBien);
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
    
    public ArrayList<Bien> buscarBienPorSolicitud(int numeroSolicitud) throws GlobalException, NoDataException, SQLException {

        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        ResultSet rs = null;
        Bien elBien = null;
        ArrayList<Bien> coleccion = new ArrayList();
        CallableStatement pstmt = null;
        try {
            pstmt = conexion.prepareCall(BUSCARBIENPORSOLICITUD);
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);	
            pstmt.execute();
            pstmt.setInt(2,numeroSolicitud);
            rs = (ResultSet) pstmt.getObject(1);
            while (rs.next()) {
                elBien = new Bien(rs.getString("serial"),
                        rs.getString("descripcion"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getFloat("precio"),
                        rs.getInt("cantidad")
                );
            }
            coleccion.add(elBien);
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
    
    
    public ArrayList<Bien> consultarBienPorSolicitud(int elNumeroSolicitud) throws GlobalException, NoDataException {
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }

        ResultSet rs = null;
        CallableStatement pstmt = null;
        ArrayList<Bien> coleccion = new ArrayList();

        try {
            pstmt = conexion.prepareCall(CONSULTARBIEN);
            //pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.setInt(2, elNumeroSolicitud);
            pstmt.execute();
            rs = (ResultSet) pstmt.getObject(1);

            while (rs.next()) {
                Bien elBien = null;
                if (rs.getInt("numeroSolicitud") == elNumeroSolicitud) {
                    elBien = new Bien(rs.getString("serial"),
                            rs.getString("descripcion"),
                            rs.getString("marca"),
                            rs.getString("modelo"),
                            rs.getInt("precio"),rs.getInt("cantidad")
                    );
                }
                if(elBien != null){
                coleccion.add(elBien);
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

        return coleccion;
    }

    public static ServicioBien getServicioBien() {
        return servicioBien;
    }

    
    
}
