package dev.aybarsacar.sfgpetclinic.services;

import dev.aybarsacar.sfgpetclinic.model.Owner;

/**
 * Service to interact with the Owner Repository
 * instead of directly interacting with the repository from the controller
 */
public interface OwnerService extends CrudService<Owner, Long>
{
  Owner findByLastName(String lastName);
}
