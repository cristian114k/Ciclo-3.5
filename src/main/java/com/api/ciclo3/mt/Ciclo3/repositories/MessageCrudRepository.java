package com.api.ciclo3.mt.Ciclo3.repositories;

import com.api.ciclo3.mt.Ciclo3.models.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}
