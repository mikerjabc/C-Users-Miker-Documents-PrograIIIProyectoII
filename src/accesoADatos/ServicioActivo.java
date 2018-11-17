/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoADatos;

import Logic.Activo;
import Logic.Bien;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;

public class ServicioActivo extends Servicio {

    private static final String INSERTARACTIVO = "{call insertarActivo(?,?,?,?,?,?)}";
    private static final String ELIMINARACTIVO = "{call eliminarActivo(?)}";
    private static final String MODIFICARACTIVO = "{call modificarActivo(?,?,?,?,?)}";
    private static final String LISTARACTIVO = "{?=call listarActivo}";
    private static final String CONSULTARACTIVO = "{?=call buscarActivo(?)}";    
    private static final String BUSCARACTIVOPORDEPENDENCIA = "{?=call buscarActivoPorDependencia(?)}";
    private static final String BUSCARACTIVOPORBIEN = "{?=call buscarActivoPorBien(?)}";

    
    private static ServicioActivo servicioActivo = new ServicioActivo();
    
    public void insertarActivo(Activo elActivo, int elCodigoDependencia) throws GlobalException, NoDataException {
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt = null;

        try {
            pstmt = conexion.prepareCall(INSERTARACTIVO);

            pstmt.setInt(1, elActivo.getCodigoActivo());
            pstmt.setString(2, elActivo.getBien().getSerial());
            pstmt.setString(3, elActivo.getDescripcionActivo());
            pstmt.setString(4, elActivo.getFuncionario().getId());
            pstmt.setString(5, elActivo.getUbicacion());
            pstmt.setInt(6, elCodigoDependencia);
            
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                throw new NoDataException("No se realizo la insercion");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new GlobalException("Ya fue añadido este activo");
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

    public void eliminarBien(String elCodigo) throws GlobalException, NoDataException {
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
            pstmt = conexion.prepareCall(ELIMINARACTIVO);
            pstmt.setString(1, elCodigo);
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

    public void modificarActivo(Activo elActivo) throws GlobalException, NoDataException {
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt = null;

        try {
            pstmt = conexion.prepareCall(MODIFICARACTIVO);

            pstmt.setInt(1, elActivo.getCodigoActivo());
            pstmt.setString(2, elActivo.getBien().getSerial());
            pstmt.setString(3, elActivo.getDescripcionActivo());
            pstmt.setString(4, elActivo.getFuncionario().getId());
            pstmt.setString(5, elActivo.getUbicacion());

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

    public Activo buscarActivo(int elCodigo) throws GlobalException, NoDataException {
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }

        ResultSet rs = null;
        CallableStatement pstmt = null;
        Activo elActivo = null;
        ArrayList<Activo> coleccion = new ArrayList();

        try {
            pstmt = conexion.prepareCall(CONSULTARACTIVO);
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.setInt(2, elCodigo);
            pstmt.execute();
            rs = (ResultSet) pstmt.getObject(1);

            while (rs.next()) {
                if (rs.getInt("codigoactivo") == elCodigo) {
                    elActivo = new Activo(rs.getInt("codigoactivo"),
                            ServicioBien.getServicioBien().buscarBien(rs.getString("bien")),
                            rs.getString("descripcion"),
                            ServicioFuncionario.getServicioFuncionario().consultarFuncionario(rs.getString("funcionario")),
                            rs.getString("ubicacion")
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
        if (elActivo == null) {
            throw new NoDataException("No existe un activo con este número");
        }
        return elActivo;
    }
    
    public Activo buscarActivoPorBien(String elSerial) throws GlobalException, NoDataException {
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }

        ResultSet rs = null;
        CallableStatement pstmt = null;
        Activo elActivo = null;
        ArrayList<Activo> coleccion = new ArrayList();

        try {
            pstmt = conexion.prepareCall(BUSCARACTIVOPORBIEN);
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.setString(2, elSerial);
            pstmt.execute();
            rs = (ResultSet) pstmt.getObject(1);

            while (rs.next()) {
                if (rs.getString("bien").equals(elSerial)) {
                    elActivo = new Activo(rs.getInt("codigoactivo"),
                            ServicioBien.getServicioBien().buscarBien(rs.getString("bien")),
                            rs.getString("descripcion"),
                            ServicioFuncionario.getServicioFuncionario().consultarFuncionario(rs.getString("funcionario")),
                            rs.getString("ubicacion")
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
        if (elActivo == null) {
            throw new NoDataException("No existe un activo con este número");
        }
        return elActivo;
    }

    public ArrayList<Activo> listarActivo() throws GlobalException, NoDataException, SQLException {

        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        ResultSet rs = null;
        Activo elActivo = null;
        ArrayList<Activo> coleccion = new ArrayList();
        CallableStatement pstmt = null;
        try {
            pstmt = conexion.prepareCall(LISTARACTIVO);
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);	
            pstmt.execute();
            rs = (ResultSet) pstmt.getObject(1);
            while (rs.next()) {
                elActivo = new Activo(rs.getInt("codigoactivo"),
                            ServicioBien.getServicioBien().buscarBien(rs.getString("bien")),
                            rs.getString("descripcion"),
                            ServicioFuncionario.getServicioFuncionario().consultarFuncionario(rs.getString("funcionario")),
                            rs.getString("ubicacion")
                    );
                 coleccion.add(elActivo);
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
    
    public ArrayList<Activo> buscarActivoPorDependencia(int codigoDependencia) throws GlobalException, NoDataException, SQLException {
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        ResultSet rs = null;
        Activo elActivo = null;
        ArrayList<Activo> coleccion = new ArrayList();
        CallableStatement pstmt = null;
        try {
            pstmt = conexion.prepareCall(BUSCARACTIVOPORDEPENDENCIA);
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);	
            pstmt.setInt(2,codigoDependencia);
            pstmt.execute();
            rs = (ResultSet) pstmt.getObject(1);
            while (rs.next()) {
                elActivo = new Activo(rs.getInt("codigoactivo"),
                            ServicioBien.getServicioBien().buscarBien(rs.getString("bien")),
                            rs.getString("descripcion"),
                            ServicioFuncionario.getServicioFuncionario().consultarFuncionario(rs.getString("funcionario")),
                            rs.getString("ubicacion")
                    );
                 coleccion.add(elActivo);
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
    
    public static ServicioActivo getServicioActivo() {
        return servicioActivo;
    }

    
    
}
