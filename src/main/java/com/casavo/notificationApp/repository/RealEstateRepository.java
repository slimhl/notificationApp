package com.casavo.notificationApp.repository;

import com.casavo.notificationApp.entity.Preference;
import com.casavo.notificationApp.entity.RealEstate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealEstateRepository extends JpaRepository<RealEstate,Long> {
}
