package com.example.test.MaerskTest.controller;

import com.example.test.MaerskTest.model.MaerskRequestBody;
import com.example.test.MaerskTest.model.MaerskResponseBody;
import com.example.test.MaerskTest.service.MaerskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/bookings")
@Validated
public class MaerskController {

    @Autowired
    MaerskService maerskService;

    @PostMapping("/checkAvailable")
    public MaerskResponseBody checkAvailable(@Valid @RequestBody MaerskRequestBody maerskRequestBody) {

        MaerskResponseBody maerskResponseBody = maerskService.checkAvailable(maerskRequestBody);
        return maerskResponseBody ;
    }

    @PostMapping("/saveBooking")
    public MaerskResponseBody saveBooking(@Valid @RequestBody MaerskRequestBody maerskRequestBody) {

        MaerskResponseBody maerskResponseBody = maerskService.saveBooking(maerskRequestBody);
        return maerskResponseBody ;
    }

}
