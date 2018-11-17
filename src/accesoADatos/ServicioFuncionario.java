/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoADatos;

import Logic.Dependencia;
import Logic.Funcionario;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
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
    private static final String CONSULTARFUNCIONARIO = "{?=call buscarFuncionario(?)}";
    private static final String CONSULTARFUNCIONARIOIDNOMBRE = "{?=call buscarFuncionarioidNombre(?)}";
    private static final String CONSULTARFUNCIONARIOPORDEPENDENCIA = "{?=call buscarPorDependencia(?)}";
    private static final String CONSULTARFUNCIONARIOPORTRANSFERENCIA = "{?=call buscarFuncionarioPorTransferencia(?)}";
    private static final String CONSULTARDEPENDENCIAPORFUNCIONARIO= "{?=call buscarDependenciaFuncionario(?)}";

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
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.setString(2, elId);
            pstmt.execute();
            rs = (ResultSet) pstmt.getObject(1);

            while (rs.next()) {
                if (rs.getString("id").equalsIgnoreCase(elId)) {
                    elFuncionario = new Funcionario(rs.getString("id"),
                            rs.getString("nombre"),
                            rs.getString("puesto"),
                            rs.getString("contrasena")
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
        if (elFuncionario == null) {
            throw new NoDataException("El funcionario no existe en la base de datos");
        }

        return elFuncionario;
    }

    public Dependencia consultarDependenciaPorFuncionario(String elId) throws GlobalException, NoDataException {
        Dependencia dependencia = null;
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }

        ResultSet rs = null;
        CallableStatement pstmt = null;

        try {
            pstmt = conexion.prepareCall(CONSULTARDEPENDENCIAPORFUNCIONARIO);
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.setString(2, elId);
            pstmt.execute();
            rs = (ResultSet) pstmt.getObject(1);

            while (rs.next()) {
                if (rs.getString("id").equalsIgnoreCase(elId)) {
                    dependencia = ServicioDependencia.getServicioDependencia().buscarDependencia(rs.getInt("codigoDependencia"));
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
        if (dependencia == null) {
            throw new NoDataException("El funcionario no existe en la base de datos");
        }

        return dependencia;
    }

    public Funcionario consultarFuncionario_Nombre_ID(String elId_Nombre) throws GlobalException, NoDataException {
        Funcionario elFuncionario = null;
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }

        ResultSet rs = null;
        CallableStatement pstmt = null;

        try {
            pstmt = conexion.prepareCall(CONSULTARFUNCIONARIOIDNOMBRE);
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.setString(2, elId_Nombre);
            pstmt.execute();
            rs = (ResultSet) pstmt.getObject(1);

            while (rs.next()) {
                if (rs.getString("id").equalsIgnoreCase(elId_Nombre) || rs.getString("nombre").equalsIgnoreCase(elId_Nombre)) {
                    elFuncionario = new Funcionario(rs.getString("id"),
                            rs.getString("nombre"),
                            rs.getString("puesto"),
                            rs.getString("contrasena")
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
        if (elFuncionario == null) {
            throw new NoDataException("El funcionario no existe en la base de datos");
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
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
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
            pstmt = conexion.prepareCall(CONSULTARFUNCIONARIOPORDEPENDENCIA);
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.setInt(2, elCodigoDependencia);
            pstmt.execute();
            rs = (ResultSet) pstmt.getObject(1);

            while (rs.next()) {
                Funcionario elFuncionario = null;
                if (rs.getInt("codigodependencia") == elCodigoDependencia) {
                    elFuncionario = new Funcionario(rs.getString("id"),
                            rs.getString("nombre"),
                            rs.getString("puesto"),
                            rs.getString("contrasena")
                    );
                    coleccion.add(elFuncionario);
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

    public Funcionario buscarFuncionarioPorTransferencia(int numeroTrasferencia) throws GlobalException, NoDataException {
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }

        ResultSet rs = null;
        CallableStatement pstmt = null;
        Funcionario elFuncionario = null;
        try {
            pstmt = conexion.prepareCall(CONSULTARFUNCIONARIOPORDEPENDENCIA);
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.setInt(2, numeroTrasferencia);
            pstmt.execute();
            rs = (ResultSet) pstmt.getObject(1);

            while (rs.next()) {

                if (rs.getInt("numeroTrasferencia") == numeroTrasferencia) {
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
        if (elFuncionario == null) {
            throw new NoDataException("No existe una transferencia con este número");
        }
        if (elFuncionario == null) {
            throw new NoDataException("El funcionario no existe en la base de datos");
        }
        return elFuncionario;
    }

    public static ServicioFuncionario getServicioFuncionario() {
        return servicioFuncionario;
    }
}
