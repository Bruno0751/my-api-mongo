package com.developers.myapimongo.documents;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document(collection = "sid")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Sid {

    @Id
    private String id;
    private String sid;
    private LocalDate date_time;
}
