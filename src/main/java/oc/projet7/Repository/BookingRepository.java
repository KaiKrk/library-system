package oc.projet7.Repository;

import oc.projet7.Entity.Booking;
import oc.projet7.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

    List<Booking> findAllByMember(Member member);

    List<Booking> findAllByStatus(String status);

    Booking findBookingById(int id);
}
