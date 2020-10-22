package com.example.test.MaerskTest.service;

import com.example.test.MaerskTest.Entity.Bookings;
import com.example.test.MaerskTest.Repository.MaerskRepository;
import com.example.test.MaerskTest.model.ContainerType;
import com.example.test.MaerskTest.model.MaerskRequestBody;
import com.example.test.MaerskTest.model.MaerskResponseBody;
import com.example.test.MaerskTest.model.MaerskServiceResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class MaerskServiceImpl implements MaerskService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    MaerskRepository maerskRepository;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Override
    public MaerskResponseBody checkAvailable(MaerskRequestBody maerskRequestBody) {

        MaerskResponseBody maerskResponseBody = new MaerskResponseBody();
        maerskResponseBody.setAvailable(true);

        final String uri = "https://maersk.com/api/bookings/checkAvailable";

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<MaerskRequestBody> entity = new HttpEntity<MaerskRequestBody>(maerskRequestBody, headers);

            MaerskServiceResponseBody result = restTemplate.exchange(
                    uri, HttpMethod.POST, entity, MaerskServiceResponseBody.class).getBody();

            if(result.getAvailableSpace() == 0){
                maerskResponseBody.setAvailable(false);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return maerskResponseBody;
    }

    @Override
    public MaerskResponseBody saveBooking(MaerskRequestBody maerskRequestBody) {

        MaerskResponseBody maerskResponseBody = new MaerskResponseBody();

        try {
            //   save in Cassandra table 'Bookings'
            Bookings bookings = new Bookings();

            // set primary key as '957xxxxxx' and increment 1
            bookings.setId("957000001");
            bookings.setContainer_Size(maerskRequestBody.getContainerSize());
            bookings.setContainer_Type(String.valueOf(ContainerType.valueOf(maerskRequestBody.getContainerType().toString())));
            bookings.setDestination(maerskRequestBody.getDestination());
            bookings.setOrigin(maerskRequestBody.getOrigin());
            bookings.setQuantity(maerskRequestBody.getQuantity());
            bookings.setTimestamp(maerskRequestBody.getTimestamp());

            Bookings _booking = maerskRepository.save(bookings);
            maerskResponseBody.setBookingRef(_booking.getId());
        }
        catch (Exception e){
            logger.error("Exception : " , e.getMessage());
            maerskResponseBody.setExceptionMessage(HttpStatus.INTERNAL_SERVER_ERROR.toString());

        }
        return maerskResponseBody;
    }
}
