/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

/**
 *
 * @author Fael
 */
public class Investimentos {
    private int id;
    private String cpf;
    private double bitcoin;
    private double valorbitcoinComprado;
    private double ethereum;
    private double valorethereumComprado;
    private double dolar;
    private double valordolarComprado;
    
    public Investimentos(int id, String cpf, double bitcoin, double valorbitcoinComprado, double ethereum, double valorethereumComprado, double dolar, double valordolarComprado){
        this.id = id;
        this.cpf = cpf;
        this.bitcoin = bitcoin;
        this.valorbitcoinComprado = valorbitcoinComprado;
        this.ethereum = ethereum;
        this.valorethereumComprado = valorethereumComprado;
        this.dolar = dolar;
        this.valordolarComprado = valordolarComprado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getBitcoin() {
        return bitcoin;
    }

    public void setBitcoin(double bitcoin) {
        this.bitcoin = bitcoin;
    }

    public double getValorbitcoinComprado() {
        return valorbitcoinComprado;
    }

    public void setValorbitcoinComprado(double valorbitcoinComprado) {
        this.valorbitcoinComprado = valorbitcoinComprado;
    }

    public double getEthereum() {
        return ethereum;
    }

    public void setEthereum(double ethereum) {
        this.ethereum = ethereum;
    }

    public double getValorethereumComprado() {
        return valorethereumComprado;
    }

    public void setValorethereumComprado(double valorethereumComprado) {
        this.valorethereumComprado = valorethereumComprado;
    }

    public double getDolar() {
        return dolar;
    }

    public void setDolar(double dolar) {
        this.dolar = dolar;
    }

    public double getValordolarComprado() {
        return valordolarComprado;
    }

    public void setValordolarComprado(double valordolarComprado) {
        this.valordolarComprado = valordolarComprado;
    }
    
    
    
}
