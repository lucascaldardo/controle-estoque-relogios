package lucas.estoque.relogio.mapper;

import lucas.estoque.relogio.dto.RelogioDTO;
import lucas.estoque.relogio.entity.Relogio;
import lucas.estoque.relogio.entity.enums.MaterialCaixa;
import lucas.estoque.relogio.entity.enums.TipoMovimento;
import lucas.estoque.relogio.entity.enums.TipoVidro;
import org.springframework.stereotype.Component;

@Component
public class RelogioMapper {

    public RelogioDTO toDto(Relogio r){
        return RelogioDTO.builder()
                .id(r.getId())
                .marca(r.getMarca())
                .referencia(r.getReferencia())
                .tipoMovimento(r.getTipoMovimento().toApi())
                .materialCaixa(r.getMaterialCaixa().toApi())
                .tipoVidro(r.getTipoVidro().toApi())
                .resistenciaAguaM(r.getResistenciaAguaM())
                .diametroMm(r.getDiametroMm())
                .lugToLugMm(r.getLugTolugMm())
                .espessuraMm(r.getEspessuraMm())
                .larguraLugMm(r.getLarguraLugMm())
                .precoEmCentavos(r.getPrecoEmCentavos())
                .urlImagem(r.getUrlImagem());
    }

    private String etiquetaResistencia(int resistenciaM){
        if (resistenciaM < 50) return "respingos";
        if (resistenciaM < 100) return "uso_diario";
        if (resistenciaM < 200) return "natacao";
        return "mergulho";
    }

    private  int pontuacaoColecionador(Relogio r){
        int pontos =0;

        if (r.getTipoVidro() == TipoVidro.SAFIRA) pontos +=25;

        if (r.getResistenciaAguaM() >= 100) pontos +=15;
        if (r.getResistenciaAguaM() >= 200) pontos +=10;

        if (r.getTipoMovimento() == TipoMovimento.AUTOMATICO) pontos +=20;

        if (r.getMaterialCaixa() == MaterialCaixa.CERAMICA || r.getMaterialCaixa() == MaterialCaixa.TITANIO) pontos +=12;

        if (r.getDiametroMm() >= 38 && r.getDiametroMm() <= 42) pontos +=8;

        return pontos;
    }
}
