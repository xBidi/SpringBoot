/* Autogenerated file. Do not edit manually. */

package com.xbidi.spring.content.example.domain;

import com.xbidi.spring.content.shared.Auditable;
import com.xbidi.spring.content.shared.interfaces.domain.Updatable;
import com.xbidi.spring.content.shared.interfaces.domain.Valid;
import lombok.*;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Audited
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "O_MSTR_EXAMPLE")
@EntityListeners({ExampleListener.class})
@FilterDef(
    name = "tenantFilter",
    parameters = {@ParamDef(name = "tenantId", type = "string")})
@Filter(name = "tenantFilter", condition = "tenant_id = :tenantId")
public class Example extends Auditable<String> implements Valid, Updatable {

  @Id
  @GeneratedValue
  @Column(name = "ID")
  protected Long id;

  /* FIELDS */

  @Override
  public String getNotValidCause() {
    return null;
  }
}