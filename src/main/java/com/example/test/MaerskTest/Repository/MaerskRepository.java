package com.example.test.MaerskTest.Repository;

import com.example.test.MaerskTest.Entity.Bookings;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface MaerskRepository extends CassandraRepository<Bookings, String> {


}
