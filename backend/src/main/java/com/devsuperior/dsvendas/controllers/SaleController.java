package com.devsuperior.dsvendas.controllers;
import com.devsuperior.dsvendas.dto.*;
import com.devsuperior.dsvendas.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SaleService service;
 
    @GetMapping
    public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable){

        Page<SaleDTO> list = service.findAll(pageable);
        return ResponseEntity.ok(list);

    }

    @GetMapping(value = "/amount-by-seller")

    public ResponseEntity<List<SaleSumDTO>> amountGroupdBySeller(){
        List<SaleSumDTO> list = service.amountGrupedBySeller();
        return ResponseEntity.ok(list);

    }

    @GetMapping(value = "/success-by-seller")

    public ResponseEntity<List<SaleSuccessDTO>> successGroupdBySeller(){
        List<SaleSuccessDTO> list = service.successGrupedBySeller();
        return ResponseEntity.ok(list);

    }


    
}
