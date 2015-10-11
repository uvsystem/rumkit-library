package com.dbsys.rs.lib.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("KELUAR")
public class StokKeluar extends Stok {

	@Override
	public String getName() {
		return "STOK KELUAR";
	}
}
