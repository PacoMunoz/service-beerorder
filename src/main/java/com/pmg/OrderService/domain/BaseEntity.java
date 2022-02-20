package com.pmg.OrderService.domain;

import lombok.*;

import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@NoArgsConstructor
@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    private UUID id;

    private Long version;

    private Timestamp createDate;

    private Timestamp lastModifiedDate;

}
