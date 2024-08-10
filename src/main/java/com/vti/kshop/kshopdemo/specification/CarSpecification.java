package com.vti.kshop.kshopdemo.specification;

import com.vti.kshop.kshopdemo.entity.Car;
import com.vti.kshop.kshopdemo.form.CarFilterForm;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class CarSpecification {
    public static Specification<Car> buildSpec(CarFilterForm form){
        return form == null ? null : new Specification<Car>() {
            @Override
            public Predicate toPredicate(
                    Root<Car> root,
                    CriteriaQuery<?> query,
                    CriteriaBuilder builder
            ){
                // ...WHERE liscenPlatee LIKE '%SEARCH%'
              var predicates = new ArrayList<Predicate>();
              var search = form.getSearch();
              if(StringUtils.hasText(search)){
                  var pattern  = "%" + search + "%";
                  var predicate = builder.like(
                          root.get("licensePlate"), pattern);
                  predicates.add(predicate);
              }

              // WHERE createdAt >= ? And createdAt <= ?
                var minCreatedDate = form.getMinCreatedAt();
              if (minCreatedDate != null){
                  var minCreatedAt = LocalDateTime.of(minCreatedDate, LocalTime.MIN);
                  var predicate = builder.greaterThanOrEqualTo(root.get("repairDate"), minCreatedAt);
                  predicates.add(predicate);
              }
              var maxCreatedDate = form.getMaxCreatedAt();
              if(maxCreatedDate != null){
                  var maxCreatedAt = LocalDateTime.of(maxCreatedDate, LocalTime.MAX);
                  var predicate = builder.lessThanOrEqualTo(root.get("repairDate"), maxCreatedAt);
                  predicates.add(predicate);
              }

              // WHERE name like ?
               var searchName = form.getSearchName();
                if(StringUtils.hasText(searchName)){
                    var pattern  = "%" + searchName + "%";
                    var predicate = builder.like(
                            root.get("customerName"), pattern);
                    predicates.add(predicate);
                }

              return builder.and(predicates.toArray(new Predicate[0]));
            }
        };
    }
}
