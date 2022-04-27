package com.maverick.agdemo.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "unit")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Unit {
  @Id
  @SequenceGenerator(name = "unit_seq", sequenceName = "unit_seq", allocationSize = 1, initialValue = 10)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unit_seq")
  private Long id;


  @OneToOne
  @JoinColumn(name = "fk_office")
  private Office office;

  @ManyToOne
  @JoinColumn(name = "fk_section")
  private Section section;
  // get section for a given unit
  // C | D a section for a unit

  @OneToMany(mappedBy = "unit")
  private List<UnitSection> unitSectionL;
  // get all unitSections for a given unit
  // C | D a unitSections from a given unit
}
