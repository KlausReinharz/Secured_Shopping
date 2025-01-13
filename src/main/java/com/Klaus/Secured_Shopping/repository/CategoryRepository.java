package com.Klaus.Secured_Shopping.repository;

import com.Klaus.Secured_Shopping.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long > {

    Category findByName(String name);

    boolean existsByName(String name);
}
