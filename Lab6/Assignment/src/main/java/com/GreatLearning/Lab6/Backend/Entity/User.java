package com.GreatLearning.Lab6.Backend.Entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String username;
	String password;

	LocalDate accountExpiryDate;
	int accountLockedStatus;
	LocalDate credentialsExpiryDate;
	int accountEnabledStatus;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	List<Roles> roles;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getAccountExpiryDate() {
		return accountExpiryDate;
	}

	public void setAccountExpiryDate(LocalDate accountExpiryDate) {
		this.accountExpiryDate = accountExpiryDate;
	}

	public int getAccountLockedStatus() {
		return accountLockedStatus;
	}

	public void setAccountLockedStatus(int accountLockedStatus) {
		this.accountLockedStatus = accountLockedStatus;
	}

	public LocalDate getCredentialsExpiryDate() {
		return credentialsExpiryDate;
	}

	public void setCredentialsExpiryDate(LocalDate credentialsExpiryDate) {
		this.credentialsExpiryDate = credentialsExpiryDate;
	}

	public int getAccountEnabledStatus() {
		return accountEnabledStatus;
	}

	public void setAccountEnabledStatus(int accountEnabledStatus) {
		this.accountEnabledStatus = accountEnabledStatus;
	}

	public List<Roles> getRoles() {
		return roles;
	}

	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", accountExpiryDate="
				+ accountExpiryDate + ", accountLockedStatus=" + accountLockedStatus + ", credentialsExpiryDate="
				+ credentialsExpiryDate + ", accountEnabledStatus=" + accountEnabledStatus + ", roles=" + roles + "]";
	}

}
