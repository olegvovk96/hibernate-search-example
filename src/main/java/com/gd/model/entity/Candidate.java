package com.gd.model.entity;

import com.gd.model.entity.converter.AvailabilityConverter;
import com.gd.model.entity.converter.EducationConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.GenericField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.IndexedEmbedded;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Indexed
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name", nullable = false)
    @FullTextField
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @FullTextField
    private String lastName;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String email;

    @Column(name = "zip_code", nullable = false)
    @FullTextField
    private String zipCode;

    @Convert(converter = EducationConverter.class)
    @GenericField
    private Education education;

    @ElementCollection(targetClass = Availability.class)
    @CollectionTable(name = "candidate_availability",
            joinColumns = @JoinColumn(name = "candidate_id"))
    @Convert(converter = AvailabilityConverter.class)
    @Column(name = "availability")
    @GenericField
    private Set<Availability> availabilities;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "candidate_hobby",
            joinColumns = {@JoinColumn(name = "candidate_id")},
            inverseJoinColumns = {@JoinColumn(name = "hobby_id")}
    )
    @OrderBy("id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @IndexedEmbedded
    private Set<Hobby> hobbies;
}
