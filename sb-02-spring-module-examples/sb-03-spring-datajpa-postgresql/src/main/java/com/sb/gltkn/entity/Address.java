package com.sb.gltkn.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class Address {

    @Id
    @SequenceGenerator(name = "seq_address", allocationSize = 1)
    @GeneratedValue(generator = "seq_address", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 500, name = "address")
    private String address;

    @Enumerated
    private AddressType addressType;

    @Column(name = "active")
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "person_address_id")
    private Person person;

    public enum AddressType {
        HOME,
        WORK,
        OTHER
    }
}
