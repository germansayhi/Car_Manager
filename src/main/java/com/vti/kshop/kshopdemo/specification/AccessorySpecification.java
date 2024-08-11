package com.vti.kshop.kshopdemo.specification;

import com.vti.kshop.kshopdemo.entity.Accessory;
import com.vti.kshop.kshopdemo.form.AccessoryFilterForm;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.LocalTime;
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
                var searchName = form.getSearchName();
                if(StringUtils.hasText(searchName)){
                    var pattern  = "%" + searchName + "%";
                    var predicate = builder.like(
                            root.get("name"), pattern);
                    predicates.add(predicate);
                }

                var searchPrice = form.getSearchPrice();
                if(searchPrice != null){
                    var pattern  = Integer.toString(Math.toIntExact(searchPrice));
                    var predicate = builder.equal(root.get("price"),pattern);
                    predicates.add(predicate);
                }

                var search = form.getSearch();
                if(StringUtils.hasText(search)){
                    var pattern  = "%" + search + "%";
                    var predicate = builder.like(
                            root.get("car").get("licensePlate"), pattern);
                    predicates.add(predicate);
                }
                return builder.and(predicates.toArray(new Predicate[0]));
            }
        };
    }
}
