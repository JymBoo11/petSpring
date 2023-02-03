package org.springframework.samples.petclinic.vet;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Specialties {
	private List<Specialty> specialties;

	@XmlElement
	public List<Specialty> getSpecialtyList() {

		if (specialties == null) {
			specialties = new ArrayList<>();

		}

		return specialties;

	}
}
