package com.maverick.agdemo.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "section")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Section {
  @Id
  @SequenceGenerator(name = "section_seq", sequenceName = "section_seq", allocationSize = 1, initialValue = 10)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "section_seq")
  private Long id;

  @Column(name = "sec_name")
  private String sectionName;

  @ManyToOne
  @JoinColumn(name = "fk_office")
  private Office office;
  // get office for a given section
  // C | D a section to | from an existing office

  @OneToMany(mappedBy = "section")
  private List<Unit> unitList;
  // get all units for a given section
  // C | D a unit from a given section


}
