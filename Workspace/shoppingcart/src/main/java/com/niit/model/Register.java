package com.niit.model;

	import javax.persistence.Column;
		import javax.persistence.Entity;
		import javax.persistence.Id;

		import org.springframework.stereotype.Component;

		@Component
		@Entity

		public class Register {
			@Column
			private String name;
			
			@Id
			private String username;
				
			@Column 
			private String password;
			
			@Column
			private String email;
			@Column(name = "role")
			private String role = "ROLE_USER";
			
			@Column
			private Boolean enabled = true;

			
			@Column
			private String address;
			
			@Column
			private String mobilenumber;

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
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

			public String getRole() {
				return role;
			}

			public void setRole(String role) {
				this.role = role;
			}

			public Boolean getEnabled() {
				return enabled;
			}

			public void setEnabled(Boolean enabled) {
				this.enabled = enabled;
			}

			public String getAddress() {
				return address;
			}

			public void setAddress(String address) {
				this.address = address;
			}

			public String getMobilenumber() {
				return mobilenumber;
			}

			public void setMobilenumber(String mobilenumber) {
				this.mobilenumber = mobilenumber;
			}

			
			
			
		}