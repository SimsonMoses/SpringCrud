package com.mindgraph.service;

import com.mindgraph.request.CreateAddress;
import com.mindgraph.response.CommonResponse;

public interface AddressService {
    public CommonResponse createAddressForUser(Long userId, CreateAddress createAddress);
}
