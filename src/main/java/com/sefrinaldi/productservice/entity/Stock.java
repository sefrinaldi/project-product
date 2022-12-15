package com.sefrinaldi.productservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import net.logstash.logback.encoder.org.apache.commons.lang3.math.NumberUtils;
import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(targetEntity = Product.class, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @JsonBackReference
    private Product product;

    @Builder.Default
    private Integer stockProduct = NumberUtils.INTEGER_ZERO;
}