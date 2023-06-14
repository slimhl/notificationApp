package com.casavo.notificationApp.repository;

import com.casavo.notificationApp.entity.Client;
import com.casavo.notificationApp.entity.Preference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
}
