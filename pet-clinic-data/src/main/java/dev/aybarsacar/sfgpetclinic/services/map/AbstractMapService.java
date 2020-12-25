package dev.aybarsacar.sfgpetclinic.services.map;

import dev.aybarsacar.sfgpetclinic.model.BaseEntity;

import java.util.*;

/**
 * @param <T>
 * @param <ID>
 */
public abstract class AbstractMapService<T extends BaseEntity, ID extends Long>
{
  protected Map<Long, T> map = new HashMap<>();

  Set<T> findAll()
  {
    return new HashSet<>(map.values());
  }

  T findById(ID id)
  {
    return map.get(id);
  }

  T save(T object)
  {
    if (object != null)
    {
      if (object.getId() == null)
      {
        object.setId(getNextId());
      }
      map.put(object.getId(), object);
    }
    else
    {
      throw new RuntimeException("Object cannot be null");
    }

    return object;
  }

  void deleteById(ID id)
  {
    map.remove(id);
  }

  void delete(T object)
  {
    map.entrySet().removeIf(entry -> entry.getValue().equals(object));
  }

  /**
   * Auto generate the id
   *
   * @return the next available id in the table
   */
  private Long getNextId()
  {
    Long nextId = null;

    try
    {
      nextId = Collections.max(map.keySet()) + 1;
    } catch (NoSuchElementException e)
    {
      nextId = 1L;
    }
    return nextId;
  }
}
