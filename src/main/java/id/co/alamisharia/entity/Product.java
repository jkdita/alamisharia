package id.co.alamisharia.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private long id;

    @NotBlank(message = "nama is mandatory")
    @Column(nullable = false, unique = true, length = 50)
    private String nama;

    @Column(length = 15)
    private String satuan;

    @Min(1)
    @Column(name = "harga_satuan", nullable = false)
    private double hargaSatuan;

    @ManyToOne
    @JoinColumn(name = "seller_id", nullable = false)
    private Seller seller;

}
