package com.maverick.agdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "address")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {
  @Id
  @SequenceGenerator(name = "address_seq", sequenceName = "address_seq", allocationSize = 1, initialValue = 10)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
  private Long id;

  @Column(name = "district")
  private String district;

  @Column(name = "street")
  private String street;

  @Column(name = "province")
  private String province;

  @OneToOne(mappedBy = "address")
  private Office office;
  // C | D an office for a given address
}
