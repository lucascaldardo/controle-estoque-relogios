package lucas.estoque.relogio.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "relogio", indexes = {
        @Index(name = "IDX_RELOGIO_DATA", columnList = "marca"),
        @Index(name = "IDX_RELOGIO_CRIADO_EM", columnList = "criadoEm"),
        @Index(name = "IDX_RELOGIO_PRECO", columnList = "precoEmCentavos")
})

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Relogio {

    @Id
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Column(nullable = false, length = 80)
    private String marca;

    @Column(nullable = false, length = 125)
    private String modelo;

    @Column(nullable = false, length = 80)
    private String referencia;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TipoMovimento tipoMovimento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private MaterialCaixa materialCaixa;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TipoVidro tipoVidro;

    @Column(nullable = false)
    private int resistenciaAguaM;

    @Column(nullable = false)
    private int diametroMm;

    @Column(nullable = false)
    private int lugTolugMm;

    @Column(nullable = false)
    private int espessuraMm;

    @Column(nullable = false)
    private int larguraLugMm;

    @Column(nullable = false)
    private long precoEmCentavos;

    @Column(nullable = false, length = 600)

    private String urlImagem;
    private Instant criadoEm;

}
