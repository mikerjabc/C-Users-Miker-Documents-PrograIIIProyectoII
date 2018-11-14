/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoADatos;

import Logic.Bien;
import Logic.Dependencia;
import Logic.Funcionario;
import accesoADatos.GlobalException;
import accesoADatos.NoDataException;
import accesoADatos.Servicio;
import Logic.Solicitud;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Fernando
 */
public class ServicioDependencia extends Servicio {

    private static final String INSERTARDEPENDENCIA = "{call insertarDependencia(?,?)}";
    private static final String ELIMINARDEPENDENCIA = "{call eliminarDependencia(?)}";
    private static final String MODIFICARDEPENDENCIA = "{call modificarDependencia(?,?)}";
    private static final String LISTARDEPENDENCIA = "{?=call listarDependencia}";
    private static final String CONSULTARDEPENDENCIA = "{?=call consultarDependencia(?)}";

    private static ServicioDependencia servicioDependencia = new ServicioDependencia();

    public void insertarDependencia(Dependencia laDependencia) throws GlobalException, NoDataException {
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt = null;

        try {
            pstmt = conexion.prepareCall(INSERTARDEPENDENCIA);
            
            pstmt.setInt(1, laDependencia.getCodigo());
            pstmt.setString(2, laDependencia.getNombre());

            Iterator<Funcionario> ite = laDependencia.getListaFuncionarios().iterator();

            while (ite.hasNext()) {
                ServicioFuncionario.getServicioFuncionario().insertarFuncionario(ite.next(), laDependencia.getCodigo());
            }
            
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

    public void eliminarDependencia(int elCodigo) throws GlobalException, NoDataException {
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        
        CallableStatement pstmt = null;
        ResultSet rs = null;
        Dependencia laDependencia = this.consultarDependencia(elCodigo);
        
        try {
            pstmt = conexion.prepareCall(ELIMINARDEPENDENCIA);
            pstmt.setInt(1, elCodigo);
            pstmt.execute();
            
            Iterator<Funcionario> ite = laDependencia.getListaFuncionarios().iterator();
            
            while (ite.hasNext()) {
                ServicioFuncionario.getServicioFuncionario().eliminarFuncionario(ite.next().getId());
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

    public void modificarDependencia(Dependencia laDependencia) throws GlobalException, NoDataException {
        
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt = null;

        try {
            pstmt = conexion.prepareCall(MODIFICARDEPENDENCIA);
            pstmt.setInt(1, laDependencia.getCodigo());
            pstmt.setString(2, laDependencia.getNombre());

            Iterator<Funcionario> ite = laDependencia.getListaFuncionarios().iterator();

            while (ite.hasNext()) {
                ServicioFuncionario.getServicioFuncionario().modificarFuncionario(ite.next());
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

    public Dependencia consultarDependencia(int elCodigo) throws GlobalException, NoDataException {
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }

        ResultSet rs = null;
        Dependencia laDependencia = null;
        CallableStatement pstmt = null;

        try {
            pstmt = conexion.prepareCall(CONSULTARDEPENDENCIA);
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);            
            pstmt.setInt(2, elCodigo);
            pstmt.execute();
            rs = (ResultSet) pstmt.getObject(1);

            while (rs.next()) {
                if (rs.getInt("codigo") == elCodigo){
                    laDependencia = new Dependencia(rs.getInt("codigo"),
                                                    rs.getString("nombre")
                    );
                    laDependencia.setListaFuncionarios(ServicioFuncionario.getServicioFuncionario().consultarFuncionarioPorDependencia(elCodigo));
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

        return laDependencia;
    }

    public ArrayList<Dependencia> listarDependencia() throws GlobalException, NoDataException, SQLException {

        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        ResultSet rs = null;
        Dependencia laDependencia = null;
        ArrayList<Dependencia> coleccion = new ArrayList();
        
        CallableStatement pstmt = null;
        try {
            pstmt = conexion.prepareCall(LISTARDEPENDENCIA);
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);	
            while (rs.next()) {
                    laDependencia = new Dependencia(rs.getInt("codigo"),
                                                    rs.getString("nombre")
                    );
                    laDependencia.setListaFuncionarios(ServicioFuncionario.getServicioFuncionario().consultarFuncionarioPorDependencia(laDependencia.getCodigo()));
                    coleccion.add(laDependencia);
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

    public static ServicioDependencia getServicioDependencia() {
        return servicioDependencia;
    }
}