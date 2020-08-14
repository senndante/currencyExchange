package com.arw.currencyconverter.repositories;

import com.arw.currencyconverter.entities.CurrencyValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Optional;

@Repository
public interface CurrencyValueRepository extends JpaRepository<CurrencyValue, Long> {
    Optional<CurrencyValue> findByCurrencyIdAndDate(Integer id, Date date);
}
