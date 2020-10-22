package com.example.test.MaerskTest.service;

import com.example.test.MaerskTest.model.MaerskRequestBody;
import com.example.test.MaerskTest.model.MaerskResponseBody;

public interface MaerskService {

    public MaerskResponseBody checkAvailable(MaerskRequestBody maerskRequestBody);

    MaerskResponseBody saveBooking(MaerskRequestBody maerskRequestBody);
}
