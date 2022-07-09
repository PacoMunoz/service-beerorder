package com.pmg.orderservice.domain;

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

    public BaseEntity(UUID id, Long version, Timestamp createDate, Timestamp lastModifiedDate) {
        this.id = id;
        this.version = version;
        this.createdDate = createDate;
        this.lastModifiedDate = lastModifiedDate;
    }

    private UUID id;

    private Long version;

    private Timestamp createdDate;

    private Timestamp lastModifiedDate;

}
