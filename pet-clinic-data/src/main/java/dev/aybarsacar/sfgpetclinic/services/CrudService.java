package dev.aybarsacar.sfgpetclinic.services;

import java.util.Set;

/**
 * Common methods for all repositories
 *
 * @param <T>  - Object type
 * @param <ID> - id type - Long for this application
 */
public interface CrudService<T, ID>
{
  Set<T> findAll();

  T findById(ID id);

  T save(T object);

  void delete(T object);

  void deleteById(ID id);
}
