/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.pucrs.sisinfo.persistencia.modelo;

import java.util.GregorianCalendar;


/**
 *
 * Nome, Sobrenome, Genero, Data_Nascimento, Endereco, Email, RG, CPF, Passaporte, Senha
 */
public class Passageiro {

    private int id;
    private String nome;
    private String sobrenome;
    private String genero;
    private GregorianCalendar dataNascimento;
    private String email;
    private String rg;
    private String cpf;
    private String passaporte;
    private String senha;

    public Passageiro(int id, String nome, String sobrenome, String genero, GregorianCalendar dataNascimento, String email, String rg, String cpf, String passaporte, String senha) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.genero = genero;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.rg = rg;
        this.cpf = cpf;
        this.passaporte = passaporte;
        this.senha = senha;
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
