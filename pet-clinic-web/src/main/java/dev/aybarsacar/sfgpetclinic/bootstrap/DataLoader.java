package dev.aybarsacar.sfgpetclinic.bootstrap;

import dev.aybarsacar.sfgpetclinic.model.Owner;
import dev.aybarsacar.sfgpetclinic.model.Vet;
import dev.aybarsacar.sfgpetclinic.services.OwnerService;
import dev.aybarsacar.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner
{
  private final OwnerService ownerService;
  private final VetService vetService;

  public DataLoader(OwnerService ownerService, VetService vetService)
  {
    this.ownerService = ownerService;
    this.vetService = vetService;
  }

  @Override
  public void run(String... args) throws Exception
  {
    Owner owner1 = new Owner();
    owner1.setFirstName("Aybars");
    owner1.setLastName("Acar");

    ownerService.save(owner1);

    Owner owner2 = new Owner();
    owner2.setFirstName("Shuang");
    owner2.setLastName("Zhao");

    ownerService.save(owner2);

    System.out.println("Loaded owners");

    Vet vet1 = new Vet();
    vet1.setFirstName("Zuhre");
    vet1.setLastName("Acar");

    vetService.save(vet1);

    Vet vet2 = new Vet();
    vet2.setFirstName("Isil");
    vet2.setLastName("Sozgec");

    vetService.save(vet2);

    System.out.println("Loaded vets");
  }
}
