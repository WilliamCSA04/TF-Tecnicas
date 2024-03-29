package br.pucrs.sisinfo.persistencia.modelo;

import java.util.GregorianCalendar;


public class Passageiro {

    private int id;
    private String nome;
    private String sobrenome;
    private String genero;
    private GregorianCalendar dataNascimento;
    private String endereco;
    private String email;
    private String rg;
    private String cpf;
    private String passaporte;
    private String senha;

    public Passageiro(int id, String nome, String sobrenome, String genero, GregorianCalendar dataNascimento, String endereco, String email, String rg, String cpf, String passaporte, String senha) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.genero = genero;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.email = email;
        this.rg = rg;
        this.cpf = cpf;
        this.passaporte = passaporte;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getGenero() {
        return genero;
    }

    public GregorianCalendar getDataNascimento() {
        return dataNascimento;
    }

    public String getRg() {
        return rg;
    }

    public String getCpf() {
        return cpf;
    }

    public String getPassaporte() {
        return passaporte;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    @Override
    public String toString() {
        return "Passageiro{" + "nome=" + nome + ", sobrenome=" + sobrenome + ", genero=" + genero + ", dataNascimento=" + dataNascimento + ", email=" + email + ", rg=" + rg + ", cpf=" + cpf + ", passaporte=" + passaporte + ", senha=" + senha + '}';
    }

    
    
    
    
    
    
   
    
}
