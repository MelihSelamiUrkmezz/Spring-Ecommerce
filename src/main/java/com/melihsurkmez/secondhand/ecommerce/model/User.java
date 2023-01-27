package com.melihsurkmez.secondhand.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id=null;
    @NonNull
    String firstName;
    @NonNull
    String middleName;
    @NonNull
    String lastName;
    @Column(unique = true)
    @NonNull
    String mail;
   }

