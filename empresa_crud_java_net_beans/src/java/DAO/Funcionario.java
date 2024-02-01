package DAO;

public class Funcionario {
    private int mat;
    private String nome;
    private Double salario;
    private String sexo;
    private int dpto;
    private int supervisor;
    
    public int getMat(){
        return mat;
    }
    
    public String getNome(){
        return nome;
    }
    
    public Double getSalario(){
        return salario;
    }
    
    public String getSexo(){
        return sexo;
    }
    
    public int getDpto(){
        return dpto;
    }
    
    public int getSupervisor(){
        return supervisor;
    }
          
    
    public void setMat(int mat){
        this.mat= mat;
    }
    
    public void setNome(String nome){
        this.nome=nome;
    }
    
    public void setSalario(Double salario){
        this.salario=salario;
    }
    
    public void setSexo(String sexo){
        this.sexo=sexo;
    }
    
    public void setDpto(int dpto){
        this.dpto=dpto;
    }
    
    public void setSupervisor(int supervisor){
        this.supervisor=supervisor;
    }
            
}
