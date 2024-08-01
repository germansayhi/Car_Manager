package com.vti.kshop.kshopdemo.repository;

import com.vti.kshop.kshopdemo.entity.Accessory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessoryRepository extends JpaRepository<Accessory, Long> {
}
