package DAO;
import java.sql.*;
import java.util.ArrayList;

public class FuncionarioDao {
    
    private Connection connection;
    
    public FuncionarioDao(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void adiciona(Funcionario funcionario){
        String sql = "INSERT INTO funcionario VALUES (?,?,?,?,?,?)";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            
            stmt.setLong(1,funcionario.getMat());
            stmt.setString(2, funcionario.getNome());
            stmt.setDouble(3,funcionario.getSalario());
            stmt.setString(4,funcionario.getSexo());
            stmt.setLong(5,funcionario.getDpto());
            stmt.setLong(6,funcionario.getSupervisor());
            
            stmt.executeUpdate();
            stmt.close();
            
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    
    public ArrayList <Funcionario> getLista(){
        String sql = "SELECT * from funcionario";
        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
        
        try{
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                Funcionario funcionario = new Funcionario();
                
                funcionario.setMat(rs.getInt("numat"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setSalario(rs.getDouble("salario"));
                funcionario.setSexo(rs.getString("sexo"));
                funcionario.setDpto(rs.getInt("ndepto"));
                funcionario.setSupervisor(rs.getInt("nsuper"));
                
                funcionarios.add(funcionario);
            }
            rs.close();
            stmt.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return funcionarios;
    }
    
        public Funcionario consulta(int id){
        String sql = "SELECT * from funcionario where numat = ?";
        Funcionario funcionario = null;
        
        try{
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                funcionario = new Funcionario();
                
                funcionario.setMat(rs.getInt("numat"));
                funcionario.setNome(rs.getString("nome")); 
                funcionario.setSalario(rs.getDouble("salario"));   
                funcionario.setSexo(rs.getString("sexo"));
                funcionario.setDpto(rs.getInt("ndepto"));
                funcionario.setSupervisor(rs.getInt("nsuper"));
                
            }
            rs.close();
            stmt.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return funcionario;
    }
        
        public ArrayList <Funcionario> getSup(){
        String sql = "SELECT * from funcionario where numat in (SELECT DISTINCT nsuper from funcionario)";
        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
        
        try{
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                Funcionario funcionario = new Funcionario();
                
                funcionario.setMat(rs.getInt("numat"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setSalario(rs.getDouble("salario"));
                funcionario.setSexo(rs.getString("sexo"));
                funcionario.setDpto(rs.getInt("ndepto"));
                funcionario.setSupervisor(rs.getInt("nsuper"));
                
                funcionarios.add(funcionario);
            }
            rs.close();
            stmt.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return funcionarios;
    }
        
        
        public boolean remove(int id){
            String sql = "DELETE FROM funcionario WHERE numat = ?";
            int funcionariosRemovidos = 0;
            try{
                PreparedStatement stmt = this.connection.prepareStatement(sql);
                stmt.setLong(1, id);
                funcionariosRemovidos = stmt.executeUpdate();
                stmt.close();
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
            return funcionariosRemovidos == 1;
        }
        
        public boolean atualiza(Funcionario funcionario){
            String sql = "UPDATE FUNCIONARIO SET nome = ?, salario = ?, sexo = ?, ndepto = ?, nsuper = ? WHERE numat = ?";
            int funcionariosAtualizados = 0;
            try{
                PreparedStatement stmt = this.connection.prepareStatement(sql);
                
                stmt.setString(1, funcionario.getNome());
                stmt.setDouble(2,funcionario.getSalario());
                stmt.setString(3,funcionario.getSexo());
                stmt.setLong(4,funcionario.getDpto());
                stmt.setLong(5,funcionario.getSupervisor());
                stmt.setLong(6,funcionario.getMat());
                                
                funcionariosAtualizados = stmt.executeUpdate();
                stmt.close();
            }catch (SQLException e){
                 System.out.println("Erro ao executar consulta SQL: " + e.getMessage());
                throw new RuntimeException(e);
                
            }
            return funcionariosAtualizados == 1;
        }
}
