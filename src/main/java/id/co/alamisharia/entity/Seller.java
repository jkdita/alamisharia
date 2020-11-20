package id.co.alamisharia.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SELLER_TBL")
public class Seller {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nama;
    private String kota;
}
