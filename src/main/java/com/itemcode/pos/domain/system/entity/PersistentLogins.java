package com.itemcode.pos.domain.system.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//PersistentLogins
@Entity
@Table(name = "Persistent_Logins")
public class PersistentLogins implements Serializable {

	private static final long serialVersionUID = -414694422247947825L;

	@Id
	@Column(name = "series", unique = true, nullable = false)
	private String series;

	@Column(name = "username")
	private String username;

	@Column(name = "token")
	private String token;

	@Column(name = "last_used")
	@Temporal(TemporalType.TIMESTAMP)
	private Date last_used;

	public PersistentLogins() {
		super();
	}

	public PersistentLogins(String series, String username, String token, Date last_used) {
		super();
		this.series = series;
		this.username = username;
		this.token = token;
		this.last_used = last_used;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getLast_used() {
		return last_used;
	}

	public void setLast_used(Date last_used) {
		this.last_used = last_used;
	}

	@Override
	public String toString() {
		return "PersistentLogins [series=" + series + ", username=" + username + ", token=" + token + ", last_used="
				+ last_used + "]";
	}

}
