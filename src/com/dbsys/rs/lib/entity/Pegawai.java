package com.dbsys.rs.lib.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "pegawai")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
	name = "tipe",
	discriminatorType = DiscriminatorType.STRING
)
public abstract class Pegawai {

	protected Long id;
	protected String nip;
	protected Penduduk penduduk;

	public Pegawai() {
		super();
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	@Column(name = "nip")
	public String getNip() {
		return nip;
	}

	@OneToOne(cascade = CascadeType.PERSIST, targetEntity = Penduduk.class)
	@JoinColumn(name = "penduduk")
	public Penduduk getPenduduk() {
		return penduduk;
	}
	
	@Transient
	public abstract String getName();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nip == null) ? 0 : nip.hashCode());
		result = prime * result
				+ ((penduduk == null) ? 0 : penduduk.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pegawai other = (Pegawai) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nip == null) {
			if (other.nip != null)
				return false;
		} else if (!nip.equals(other.nip))
			return false;
		if (penduduk == null) {
			if (other.penduduk != null)
				return false;
		} else if (!penduduk.equals(other.penduduk))
			return false;
		return true;
	}
}
