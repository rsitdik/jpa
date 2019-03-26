package io.jpa.jpa;

import io.jpa.entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CatCrud extends JpaRepository<Cat, Long> {
    Cat findById(long id);
    List<Cat> findByName(String name);

}
