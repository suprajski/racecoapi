package com.raceco.apii.Controller;

import com.raceco.apii.Entity.Address;
import com.raceco.apii.Service.AddressService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class AddressControllerTest {
    @InjectMocks
    private AddressController addressController;

    @Mock
    private AddressService addressService;

    @Test
    void testAddAddress() {
        Address address = new Address();
        address.setAddressId(1L);
        address.setStreet("123 Main St");

        when(addressService.addAddress(any(Address.class))).thenReturn(address);

        ResponseEntity<Address> response = addressController.addAddress(address);

        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody().getStreet()).isEqualTo("123 Main St");
        verify(addressService, times(1)).addAddress(any(Address.class));
    }

    @Test
    void testGetAddressById() {
        Address address = new Address();
        address.setAddressId(1L);
        address.setStreet("123 Main St");

        when(addressService.getAddressById(1L)).thenReturn(address);

        ResponseEntity<Address> response = addressController.getAddressById(1L);

        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody().getStreet()).isEqualTo("123 Main St");
        verify(addressService, times(1)).getAddressById(1L);
    }

    @Test
    void testDeleteAddress() {
        doNothing().when(addressService).deleteAddress(1L);

        ResponseEntity<Void> response = addressController.deleteAddress(1L);

        assertThat(response.getStatusCodeValue()).isEqualTo(204);
        verify(addressService, times(1)).deleteAddress(1L);
    }
}
