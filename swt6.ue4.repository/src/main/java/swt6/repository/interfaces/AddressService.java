package swt6.repository.interfaces;

import swt6.domain.*;
import java.util.Set;

public interface AddressService {
    Address create(Address address);
    Set<Address> readAll();
    Set<Address> readById();
    Address update(Address address);
    boolean delete(Address address);
}
