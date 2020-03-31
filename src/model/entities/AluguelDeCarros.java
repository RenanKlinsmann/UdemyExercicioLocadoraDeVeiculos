package model.entities;

import java.util.Date;

public class AluguelDeCarros {

	private Date start;
	private Date finish;
	
	private Veiculos veiculos;
	private Fatura fatura;
	
	public AluguelDeCarros() {
	}

	public AluguelDeCarros(Date start, Date finish, Veiculos veiculos) {
		this.start = start;
		this.finish = finish;
		this.veiculos = veiculos;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getFinish() {
		return finish;
	}

	public void setFinish(Date finish) {
		this.finish = finish;
	}

	public Veiculos getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(Veiculos veiculos) {
		this.veiculos = veiculos;
	}

	public Fatura getFatura() {
		return fatura;
	}

	public void setFatura(Fatura fatura) {
		this.fatura = fatura;
	}
	
	
	
}
