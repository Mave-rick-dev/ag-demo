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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "office")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Office {

  @Id
  @SequenceGenerator(name = "office_seq", sequenceName = "office_seq", allocationSize = 1, initialValue = 10)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "office_seq")
  private Long id;

  @Column(name = "ofc_name")
  private String name;

  @Column(name = "parent_id")
  private Long parentId;

  @OneToOne
  @JoinColumn(name = "fk_address", nullable = false)
  private Address address;
  // C | D an address for a given office
  @OneToMany
  @JoinColumn(name = "fk_section")
  private List<Section> sectionL;
  // get all sections of an office
  // C | D section to | from an Office


  public void addSection(Section section) {
    this.sectionL.add(section);
    section.setOffice(this);
  }
  // prevents adding and removing an entity from the relationship requires need to update
  // both sides of the association.
}
