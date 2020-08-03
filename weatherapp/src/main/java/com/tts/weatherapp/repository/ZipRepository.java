package com.tts.weatherapp.repository;

import com.tts.weatherapp.model.ZipCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZipRepository extends JpaRepository<ZipCode, Long> {
    public ZipCode findByZip(String zipCode);
}