package fr.diginamic.BestiolesRest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fr.diginamic.BestiolesRest.enums.Sex;
import fr.diginamic.BestiolesRest.model.Animal;
import fr.diginamic.BestiolesRest.model.Species;

public interface AnimalRepository extends CrudRepository<Animal, Integer> {

    List<Animal> findBySpecies(Species species);

    List<Animal> findByColor(String color);

    @Query("SELECT COUNT(a) FROM Animal a WHERE a.sex = :sex")
    Long countBySex(@Param("sex") Sex m);

    @Query("SELECT CASE WHEN SIZE(a.person) > 0 THEN true ELSE false END FROM Animal a WHERE a = :id")
    Boolean hasOwner(@Param("id") Animal id);

}
