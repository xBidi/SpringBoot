/* Autogenerated file. Do not edit manually. */

package com.diegotobalina.framework.provided.interfaces.usecase;

import com.diegotobalina.framework.provided.interfaces.service.CrudService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreateUseCase<T> {
  default T create(T t, CrudService<T> service, JpaRepository<T, Long> repository) {
    preSave(t, service, repository);
    T save = service.save(t, repository);
    postSave(t, service, repository);
    return save;
  }

  void preSave(T t, CrudService<T> service, JpaRepository<T, Long> repository);

  void postSave(T t, CrudService<T> service, JpaRepository<T, Long> repository);
}
