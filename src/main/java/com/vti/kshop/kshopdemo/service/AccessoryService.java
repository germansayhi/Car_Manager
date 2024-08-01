package com.vti.kshop.kshopdemo.service;

import com.vti.kshop.kshopdemo.dto.AccessoryDto;
import com.vti.kshop.kshopdemo.form.AccessoryCreateForm;
import com.vti.kshop.kshopdemo.form.AccessoryUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AccessoryService {
    AccessoryDto create(AccessoryCreateForm form);

    Page<AccessoryDto> findAll(Pageable pageable);

    AccessoryDto findById(Long id);

    AccessoryDto  update(Long id,AccessoryUpdateForm form);

    void deleteByID(long id);
}
