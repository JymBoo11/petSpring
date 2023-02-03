/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.samples.petclinic;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportRuntimeHints;
import org.springframework.dao.DataAccessException;
import org.springframework.data.annotation.Persistent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.samples.petclinic.model.Person;
import org.springframework.samples.petclinic.vet.SpecialtyRepository;
import org.springframework.samples.petclinic.vet.Vet;
import org.springframework.samples.petclinic.vet.VetRepository;
import org.springframework.samples.petclinic.vet.VetnoSp;
import org.springframework.transaction.annotation.Transactional;

import java.util.Scanner;

/**
 * PetClinic Spring Boot Application.
 *
 * @author Dave Syer
 *
 */
@SpringBootApplication
@ImportRuntimeHints(PetClinicRuntimeHints.class)
public class PetClinicApplication {
	/*
	1.Crear un objeto Vet sin Speciality
	2.Persistir el objeto Vet en BBDD
	3.Consultar por ID y comprobar que se ha creado correctamente
	4.Editar el elemento recién creado para añadir una Speciality concreta
	5.Listar todos los veterinarios existentes
	6.Subirlo a GitHub
	 */
	//Vet no tiene como obligatorio una especialidad, van por separado.
	public static void main(String[] args) {
		SpringApplication.run(PetClinicApplication.class, args);
	}
	Vet vet = new Vet();
	Scanner teclado = new Scanner(System.in);
	@Bean
	public CommandLineRunner demoVetRepository(VetRepository vetRepository, SpecialtyRepository specialtyRepository) {
		return (args) -> {
			System.out.println("Introduce el id: ");
			int id = Integer.parseInt(teclado.nextLine());
			vet.setId(id);
			System.out.println("Introduce el nombre: ");
			String nombre = teclado.nextLine();
			vet.setFirstName(nombre);
			System.out.println("Introduce el apellido: ");
			String apellido = teclado.nextLine();
			vet.setLastName(apellido);
			System.out.println(vet.getFirstName()+" "+ vet.getLastName());



		};
	}

	@Transactional
	@Cacheable("vets")
	Vet save( ) throws DataAccessException {
		return null;
	}
}
