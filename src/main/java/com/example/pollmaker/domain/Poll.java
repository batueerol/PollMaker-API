package com.example.pollmaker.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Poll {

    @Id
    private String id;
    private String title;
    private List<Option> options;
    private String ownerName;

    @CreatedDate
    private LocalDateTime createdAt;

   // @LastModifiedDate
   // private Date modifiedOn;

   // @Version
   // private Long version;
}
