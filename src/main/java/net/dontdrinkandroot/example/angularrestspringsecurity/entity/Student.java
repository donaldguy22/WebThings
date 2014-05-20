package net.dontdrinkandroot.example.angularrestspringsecurity.entity;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@javax.persistence.Entity
public class Student implements Entity, UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8236229971783557190L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(length = 25, nullable = false)
	private String fName;
	
	@Column(length = 25, nullable = false)
	private String lName;
	
	@Column(unique = true, length = 100, nullable = false)
	private String emailAddress;
	
	@Column(length = 100, nullable = false)
	private String confirmEmailAddress;

	@Column(length = 64, nullable = false)
	private String password;
	
	@Column(length = 64, nullable = false)
	private String confirmPassword;
	
	@Column(length = 5, nullable = false)
	private String zipCode;
	
	@Column(length = 64, nullable = false)
	private boolean isTermsAndCond;

	@ElementCollection(fetch = FetchType.EAGER)
	private Set<String> roles = new HashSet<String>();


	protected Student() {

		/* Reflection instantiation */
	}


	public Student(String fName, String lName, String emailAddress, String confirmEmailAddress, String passwordHash, String confirmPasswordHash, String zipCode, boolean isTermsAndCond) {

		this.fName = fName;
		this.lName = lName;
		this.emailAddress = emailAddress;
		this.confirmEmailAddress = confirmEmailAddress;
		this.password = passwordHash;
		this.confirmPassword = confirmPasswordHash;
		this.zipCode = zipCode;
		this.isTermsAndCond = isTermsAndCond;
	}


	public Long getId() {

		return this.id;
	}


	public void setId(Long id) {

		this.id = id;
	}


	

	public String getfName() {
		return fName;
	}


	public void setfName(String fName) {
		this.fName = fName;
	}


	public String getlName() {
		return lName;
	}


	public void setlName(String lName) {
		this.lName = lName;
	}


	public String getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	public String getConfirmEmailAddress() {
		return confirmEmailAddress;
	}


	public void setConfirmEmailAddress(String confirmEmailAddress) {
		this.confirmEmailAddress = confirmEmailAddress;
	}

	//@Override
	public String getPassword() {

		return this.password;
	}


	public void setPassword(String password) {

		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}


	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}


	public String getZipCode() {
		return zipCode;
	}


	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}


	public boolean isTermsAndCond() {
		return isTermsAndCond;
	}


	public void setTermsAndCond(boolean isTermsAndCond) {
		this.isTermsAndCond = isTermsAndCond;
	}


	public Set<String> getRoles() {

		return this.roles;
	}


	public void setRoles(Set<String> roles) {

		this.roles = roles;
	}


	public void addRole(String role) {

		this.roles.add(role);
	}


	//@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		Set<String> roles = this.getRoles();

		if (roles == null) {
			return Collections.emptyList();
		}

		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}

		return authorities;
	}


	//@Override
	public String getUsername() {

		return this.emailAddress;
	}


	//@Override
	public boolean isAccountNonExpired() {

		return true;
	}


	//@Override
	public boolean isAccountNonLocked() {

		return true;
	}


	//@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}


	//@Override
	public boolean isEnabled() {

		return true;
	}


}


