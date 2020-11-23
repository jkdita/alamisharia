package id.co.alamisharia.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    @Column(nullable = false, unique = true, length = 50)
    @NotBlank
    @NotEmpty
    @NotNull
    @Size(max = 50)
    private String nama;

    @Column(nullable = false, length = 15)
    @NotBlank
    @NotEmpty
    @NotNull
    @Size(max = 15)
    private String satuan;


    @Column(name = "harga_satuan", nullable = false)
    @NotNull
    @Min(1)
    private double hargaSatuan;

    @ManyToOne
    @JoinColumn(
            name = "seller_id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "fk_product_seller_id"
            ),
            insertable = false,
            updatable = false
    )
    @JsonIgnore
    private Seller seller;

    @NotNull
    @Column(name = "seller_id", nullable = false)
    private long sellerId;

}
