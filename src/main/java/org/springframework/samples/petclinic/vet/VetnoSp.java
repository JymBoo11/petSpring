package org.springframework.samples.petclinic.vet;
import jakarta.persistence.*;
import org.springframework.samples.petclinic.model.Person;

@Entity
@Table(name = "vets")
public class VetnoSp {
	private int id;
	private String name;
	private String last_name;


	public void setId(Integer id) {
		this.id = id;
	}

	@Id
	public Integer getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

}
/*
@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "vets", joinColumns = @JoinColumn(name = "id"))


	protected void setSpecialtiesInternal(Set<Specialty> specialties) {
		this.specialties = specialties;
	}

	@XmlElement
	public List<Specialty> getSpecialties() {
		List<Specialty> sortedSpecs = new ArrayList<>(getSpecialtiesInternal());
		PropertyComparator.sort(sortedSpecs, new MutableSortDefinition("name", true, true));
		return Collections.unmodifiableList(sortedSpecs);
	}

	public int getNrOfSpecialties() {
		return getSpecialtiesInternal().size();
	}
*/


