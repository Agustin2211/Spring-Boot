package proyecto.springboot.eventos.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

@Entity
public class User implements UserDetails {

    @Version
    private int version;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idUser")
    private long idUser;

    @Valid
    @Email(message="Ingrese una direccion de email valido")
    @NotEmpty(message="No ha ingresado un email")
    @Column(name="email", nullable= false, length = 150)
    private String email;

    @Valid
	@NotEmpty(message = "El password debe completarse")
	@Column(name = "password", nullable = false, length = 60)
	private String password;

	@Valid
	@NotEmpty(message = "El nombre debe completarse")
	@Column(name = "firstname", nullable = false, length = 45)
	private String firstName;
	
	@Valid
	@NotEmpty(message = "El apellido debe completarse")
	@Column(name = "lastname", nullable = false, length = 45)
	private String lastName;

	public long getId() {
		return idUser;
	}

	public void setId(long idUser) {
		this.idUser = idUser;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "User [id=" + idUser + ", email=" + email + ", password=" + password + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}


	public User orElseThrow(Object object) {
		return null;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
		
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}


	public void setVersionNum(int version){
		this.version=version;
	}
	
	public int getVersionNum(){
		 return version; 
		}
    
}
