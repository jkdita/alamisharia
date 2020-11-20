package id.co.alamisharia.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUCT_TBL")
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @NonNull
    private int sellerId;

    @NonNull
    @NotBlank(message = "nama is mandatory")
    private String nama;

    private String satuan;

    @Min(1)
    @NotNull
    private double hargaSatuan;
}
