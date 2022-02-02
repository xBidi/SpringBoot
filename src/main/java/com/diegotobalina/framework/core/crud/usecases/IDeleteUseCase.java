/* Autogenerated file. Do not edit manually. */

package com.diegotobalina.framework.core.crud.usecases;

import com.diegotobalina.framework.core.crud.services.ICrudService;
import com.diegotobalina.framework.core.crud.StaffitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDeleteUseCase<T extends StaffitEntity> {
  default T delete(long id, ICrudService<T> service, JpaRepository<T, Long> repository) {
    preLoad(id, service, repository);
    T t = service.findById(id, repository);
    postLoad(t, service, repository);
    service.deleteById(id, repository);
    postDelete(t, service, repository);
    return t;
  }

  void preLoad(long id, ICrudService<T> service, JpaRepository<T, Long> repository);

  void postLoad(T t, ICrudService<T> service, JpaRepository<T, Long> repository);

  void postDelete(T t, ICrudService<T> service, JpaRepository<T, Long> repository);
}
