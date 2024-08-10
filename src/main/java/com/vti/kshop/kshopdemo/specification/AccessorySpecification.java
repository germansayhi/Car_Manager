package com.vti.kshop.kshopdemo.specification;

import com.vti.kshop.kshopdemo.entity.Accessory;
import com.vti.kshop.kshopdemo.form.AccessoryFilterForm;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.util.ArrayList;

public class AccessorySpecification {
    public static Specification<Accessory> buildSpec(AccessoryFilterForm form){
        return form == null ? null : new Specification<Accessory>() {
            @Override
            public Predicate toPredicate(
                    Root<Accessory> root,
                    CriteriaQuery<?> query,
                    CriteriaBuilder builder
            ){
                var predicates = new ArrayList<Predicate>();
                var search = form.getSearch();
                if(StringUtils.hasText(search)){
                    var pattern  = "%" + search + "%";
                    var predicate = builder.like(
                            root.get("name"), pattern);
                    predicates.add(predicate);
                }
                return builder.and(predicates.toArray(new Predicate[0]));
            }
        };
    }
}
