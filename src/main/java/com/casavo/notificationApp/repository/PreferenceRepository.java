package com.casavo.notificationApp.repository;

import com.casavo.notificationApp.entity.Preference;
import com.casavo.notificationApp.entity.RealEstate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface PreferenceRepository extends JpaRepository<Preference,Long> {

    @Query("select p from Preference p where p.minimumPrice <= :price and p.maximumPrice >= :price and p.numberOfRooms >= :rooms and p.city like :city  and p.area>= :area and p.builtDate <= :date ")
    List<Preference> findByRealEstate(@Param("price")BigDecimal price, @Param("rooms")Integer numberOfRooms, @Param("city") String city, @Param("area")Integer area,@Param("date") LocalDate builtDate);
}
