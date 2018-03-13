package com.wuraalese.todo.repos;

import com.wuraalese.todo.models.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListRepo extends CrudRepository<List, Long> {

}
