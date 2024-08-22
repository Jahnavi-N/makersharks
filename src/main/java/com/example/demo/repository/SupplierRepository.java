package com.example.makersharks.repository;

import com.example.makersharks.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    @Query("SELECT s FROM Supplier s WHERE s.location = :location AND s.natureOfBusiness = :natureOfBusiness AND s.manufacturingProcesses LIKE %:process%")
    Page<Supplier> findSuppliers(@Param("location") String location, @Param("natureOfBusiness") String natureOfBusiness, @Param("process") String process, Pageable pageable);
}
