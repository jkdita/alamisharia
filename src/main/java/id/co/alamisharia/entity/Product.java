package id.co.alamisharia.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.format.annotation.NumberFormat;

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
    @NotBlank(message = "Nama is mandatory")
    private String nama;

    private String satuan;

    @Min(1)
    private double hargaSatuan;
}
