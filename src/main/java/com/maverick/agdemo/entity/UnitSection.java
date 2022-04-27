package com.maverick.agdemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "unit_section")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UnitSection {
  @Id
  @SequenceGenerator(name = "unit_section_seq", sequenceName = "unit_section_seq", allocationSize = 1, initialValue = 10)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unit_section_seq")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "fk_unit")
  private Unit unit;
  // get unit for a given unitSection
  // C | D a unit for a unitSection
}
