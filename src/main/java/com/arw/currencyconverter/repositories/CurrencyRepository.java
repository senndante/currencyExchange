package com.arw.currencyconverter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.arw.currencyconverter.entities.Currency;

import java.util.Optional;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
    Optional<Currency> findByNumCode(String numCode);
}
