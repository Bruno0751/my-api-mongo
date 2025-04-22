package com.developers.myapimongo.documents;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document(collection = "cliente")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    private String id;
    @NotBlank(message = "O campo 'name' não pode ser vazio. Por favor, forneça um valor válido.")
    private String name;
    @Nullable
    private String old_year;
    @Nullable
    private String height;
    @NotBlank(message = "O campo 'date_time" +
            "' não pode ser vazio. Por favor, forneça um valor válido.")
    private LocalDate date_time;

}
