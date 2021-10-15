package com.smartphone.entity;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, nullable = false, length = 30)
	private String username;
	
	@Column(nullable = false, length = 100)
	private String password;
	
	
	@Column(unique = true,nullable = false, length = 50)
	private String email;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "users_roles",
			joinColumns = @JoinColumn(
					name="user_id",referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(
					name="role_id", referencedColumnName = "id"))	 
	private Set<Role> roles = new HashSet<>();
		
	
	
	public User() {

	}


	
	

	public User(String username, String password, String email, Set<Role> roles) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.roles = roles;
	}





	public Long getId() {
		return id;
	}




	public void setId(Long id) {
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




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public Set<Role> getRoles() {
		return roles;
	}




	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	
	public void addRole(Role role) {
        this.roles.add(role);
	}
	
	 public boolean hasRole(String roleName) {
	        Iterator<Role> iterator = this.roles.iterator();
	        while (iterator.hasNext()) {
	            Role role = iterator.next();
	            if (role.getName().equals(roleName)) {
	                return true;
	            }
	        }
	         
	        return false;
	    }
	
}
