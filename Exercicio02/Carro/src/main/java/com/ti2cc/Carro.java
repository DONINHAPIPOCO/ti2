package com.ti2cc;

public class Carro {
	private int codigo;
	private String modelo;
	private String marca;
	private String placa;
	
	public Carro() {
		this.codigo = -1;
		this.modelo = "";
		this.marca = "";
		this.placa = "";
	}
	
	public Carro(int codigo, String modelo, String marca, String placa) {
		this.codigo = codigo;
		this.modelo = modelo;
		this.marca = marca;
		this.placa = placa;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	@Override
	public String toString() {
		return "codigo=" + codigo + "[modelo=" + modelo + ", marca=" + marca + ", placa=" + placa + "]";
	}	
}
