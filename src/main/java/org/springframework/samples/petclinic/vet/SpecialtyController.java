package org.springframework.samples.petclinic.vet;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public class SpecialtyController {

	private final SpecialtyRepository specialtyRepository;

	public SpecialtyController() {
		specialtyRepository = null;
	}

	@GetMapping("/vets.html")
	public String showSpecialtyList(@RequestParam(defaultValue = "1") int page, Model model) {
		// Here we are returning an object of type 'Vets' rather than a collection of Vet
		// objects so it is simpler for Object-Xml mapping
		Specialties specialties = new Specialties();
		Page<Specialty> paginated = findPaginated(page);
		specialties.getSpecialtyList().addAll(paginated.toList());
		return addPaginationModel(page, paginated, model);

	}

	private String addPaginationModel(int page, Page<Specialty> paginated, Model model) {
		List<Specialty> SpecialtyList = paginated.getContent();
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", paginated.getTotalPages());
		model.addAttribute("totalItems", paginated.getTotalElements());
		model.addAttribute("listVets", SpecialtyList);
		return "specialties/specialtyList";
	}

	private Page<Specialty> findPaginated(int page) {
		int pageSize = 5;
		Pageable pageable = PageRequest.of(page - 1, pageSize);
		return specialtyRepository.findAll(pageable);
	}

	@GetMapping({ "/specialty" })
	public @ResponseBody Specialties showResourcesSpecialtiesList() {
		// Here we are returning an object of type 'Vets' rather than a collection of Vet
		// objects so it is simpler for JSon/Object mapping
		Specialties specialties = new Specialties();
		specialties.getSpecialtyList().addAll(this.specialtyRepository.findAll());
		return specialties;
	}

}
