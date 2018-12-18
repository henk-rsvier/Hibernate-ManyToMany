package rsvier;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Baas {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String naam;
	
	@ManyToMany
	@JoinTable(
			name="testtabel", 
			joinColumns=@JoinColumn(name="baas_kolom", referencedColumnName="id"),
			inverseJoinColumns=@JoinColumn(name="hond_kolom", referencedColumnName="id"))
	private List<Hond> hondList = new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}
	
	public void addHond(Hond hond) {
		hondList.add(hond);
	}
	
	
}
