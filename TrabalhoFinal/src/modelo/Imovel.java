/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Ruan
 */
public class Imovel {
    int codigo;//Codigo do imovel
    String tipo;//Tipo do imovel
    String descricao;//Descrição do imovel
    String nomeVendedor;//Nome do vendedor que esta vendendo o imovel
    double precoSolicitado;//Preço proposto pelo vendedor
    String data;//Data de cadastro

    public Imovel(int codigo, String tipo, String descricao, String nomeVendedor, double precoSolicitado, String data) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.descricao = descricao;
        this.nomeVendedor = nomeVendedor;
        this.precoSolicitado = precoSolicitado;
        this.data = data;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public double getPrecoSolicitado() {
        return precoSolicitado;
    }

    public String getData() {
        return data;
    }
    
}
