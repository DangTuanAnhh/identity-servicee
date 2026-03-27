package com.devteria.identity_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "`permission`")
public class Permission {
    @Id
    String name;

    String description;
}
