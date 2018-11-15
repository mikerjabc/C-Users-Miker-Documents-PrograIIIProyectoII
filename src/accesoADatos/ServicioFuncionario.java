/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoADatos;

import Logic.Bien;
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
//import oracle.jdbc.OracleTypes;

/**
 *
 * @author Fernando
 */
public class ServicioFuncionario extends Servicio {

    private static final String INSERTARFUNCIONARIO = "{call insertarFuncionario(?,?,?,?,?)}";
    private static final String ELIMINARFUNCIONARIO = "{call eliminarFuncionario(?)}";
    private static final String MODIFICARFUNCIONARIO = "{call modificarFuncionario(?,?,?,?)}";
    private static final String LISTARFUNCIONARIO = "{?=call listarFuncionario}";
    private static final String CONSULTARFUNCIONARIO = "{?=call consultarFuncionario(?)}";
    private static final String CONSULTARFUNCIONARIOASOCIADODEPENDENCIA = "{?=call consultarFuncionarioAsociadoDependencia(?)}";

    private static ServicioFuncionario servicioFuncionario = new ServicioFuncionario();

    public void insertarFuncionario(Funcionario elFuncionario, int elCodigoDependencia) throws GlobalException, NoDataException {
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt = null;

        try {
            pstmt = conexion.prepareCall(INSERTARFUNCIONARIO);
            
            pstmt.setString(1, elFuncionario.getId());
            pstmt.setString(2, elFuncionario.getNombre());
            pstmt.setString(3, elFuncionario.getPuesto());
            pstmt.setString(4, elFuncionario.getPassword());
            pstmt.setInt(5, elCodigoDependencia);
            
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

    public void eliminarFuncionario(String elId) throws GlobalException, NoDataException {
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        
        CallableStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            pstmt = conexion.prepareCall(ELIMINARFUNCIONARIO);
            pstmt.setString(1, elId);
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

    public void modificarFuncionario(Funcionario elFuncionario) throws GlobalException, NoDataException {
        
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt = null;

        try {
            pstmt = conexion.prepareCall(MODIFICARFUNCIONARIO);
            pstmt.setString(1, elFuncionario.getId());
            pstmt.setString(2, elFuncionario.getNombre());
            pstmt.setString(3, elFuncionario.getPuesto());
            pstmt.setString(4, elFuncionario.getPassword());

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

    public Funcionario consultarFuncionario(String elId) throws GlobalException, NoDataException {
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }

        ResultSet rs = null;
        Funcionario elFuncionario = null;
        CallableStatement pstmt = null;

        try {
            pstmt = conexion.prepareCall(CONSULTARFUNCIONARIO);
            //pstmt.registerOutParameter(1, OracleTypes.CURSOR);            
            pstmt.setString(2, elId);
            pstmt.execute();
            rs = (ResultSet) pstmt.getObject(1);

            while (rs.next()) {
                if (rs.getString("id").equalsIgnoreCase(elId)){
                    elFuncionario = new Funcionario(rs.getString("id"),
                            rs.getString("nombre"),
                            rs.getString("puesto"),
                            rs.getString("password")
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

        return elFuncionario;
    }

    public ArrayList<Funcionario> listarFuncionario() throws GlobalException, NoDataException, SQLException {

        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        ResultSet rs = null;
        Funcionario elFuncionario = null;
        ArrayList<Funcionario> coleccion = new ArrayList();
        
        CallableStatement pstmt = null;
        try {
            pstmt = conexion.prepareCall(LISTARFUNCIONARIO);
            //pstmt.registerOutParameter(1, OracleTypes.CURSOR);	
            while (rs.next()) {
                    elFuncionario = new Funcionario(rs.getString("id"),
                            rs.getString("nombre"),
                            rs.getString("puesto"),
                            rs.getString("password")
                    );
                    coleccion.add(elFuncionario);
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
    
    public ArrayList<Funcionario> consultarFuncionarioPorDependencia(int elCodigoDependencia) throws GlobalException, NoDataException {
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }

        ResultSet rs = null;
        CallableStatement pstmt = null;
        ArrayList<Funcionario> coleccion = new ArrayList();

        try {
            pstmt = conexion.prepareCall(CONSULTARFUNCIONARIOASOCIADODEPENDENCIA);
            //pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.setInt(2, elCodigoDependencia);
            pstmt.execute();
            rs = (ResultSet) pstmt.getObject(1);

            while (rs.next()) {
                Funcionario elBien = null;
                if (rs.getInt("numeroSolicitud") == elCodigoDependencia) {
                    elBien = new Funcionario(rs.getString("id"),
                            rs.getString("nombre"),
                            rs.getString("puesto"),
                            rs.getString("password")
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

    public static ServicioFuncionario getServicioFuncionario() {
        return servicioFuncionario;
    }
}
