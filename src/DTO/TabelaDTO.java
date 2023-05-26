package DTO;

import java.sql.Date;

public class TabelaDTO {
	
	private String responsavel;
	private String status;
	private String PrazoEstimado;
	private String entrega;
	private String respo2;
	
	

	public String getRespo2() {
		return respo2;
	}

	public void setRespo2(String respo2) {
		this.respo2 = respo2;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPrazoEstimado() {
		return PrazoEstimado;
	}

	public void setPrazoEstimado(String prazoEstimado) {
		PrazoEstimado = prazoEstimado;
	}

	public String getEntrega() {
		return entrega;
	}

	public void setEntrega(String entrega) {
		this.entrega = entrega;
	}

	

	
	
}
