package com.example.makersharks.controller;

import com.example.makersharks.model.Supplier;
import com.example.makersharks.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping("/query")
    public Page<Supplier> querySuppliers(
            @RequestParam String location,
            @RequestParam String natureOfBusiness,
            @RequestParam String process,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return supplierService.getSuppliers(location, natureOfBusiness, process, page, size);
    }
}
