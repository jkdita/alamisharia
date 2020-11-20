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
    @Column(unique=true, length = 50)
    private String nama;

    @Column(length = 15)
    private String satuan;

    @Min(1)
    @NotNull
    private double hargaSatuan;
}
