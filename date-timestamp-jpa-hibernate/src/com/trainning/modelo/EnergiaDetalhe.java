package com.trainning.modelo;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

@Entity
@TypeDefs({
	@TypeDef(name="dateTimeUserType", typeClass=DateTimeUserType.class)
})
public class EnergiaDetalhe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(columnDefinition="TIMESTAMP(3)")
	@Temporal(TemporalType.TIMESTAMP)
	//@Type(type = "dateTimeUserType")
	private Date dataCriacao;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Override
	public String toString() {
		return "EnergiaDetalhe [codigo=" + codigo + ", dataCriacao=" + dataCriacao + ", dataCriacao-timestamp=" + dataCriacao.getTime() + "]";
	}
}
