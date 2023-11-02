package com.mindgraph.service;

import com.mindgraph.model.Address;
import com.mindgraph.request.CreateAddress;
import com.mindgraph.response.CommonResponse;

public interface AddressService {
    public CommonResponse createAddressForUser(CreateAddress createAddress);
    public CommonResponse getAddressByUserId(Long userId);
    public CommonResponse updateAddress(Address address);
}
