package challenge;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {

    private final static int MAX_VAGAS = 10;
    private final static int MIN_IDADE = 18;
    private final static int SENIOR = 55;
    private final static int MAX_PONTOS = 20;
    private final List<Carro> vagas;

    Estacionamento() {
        this.vagas = new ArrayList<>();
    }

    public void estacionar(Carro carro) {
        this.validarCarro(carro);
        if(vagas.size() == MAX_VAGAS) {
            for (Carro vaga: vagas) {
                if(vaga.getMotorista().getIdade() < SENIOR) {
                    vagas.remove(vaga);
                    break;
                }
            }
            if(vagas.size() >= MAX_VAGAS)
                throw new EstacionamentoException("Estacionamento lotado");
        }
        vagas.add(carro);
    }

    public int carrosEstacionados() {
        return vagas.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return vagas.contains(carro);
    }

    public void validarCarro(Carro carro) {
        if(carro.getMotorista() == null)
            throw new EstacionamentoException("Carro autônomo não permitido");
        if(carro.getMotorista().getIdade() < MIN_IDADE)
            throw new EstacionamentoException("Menor de idade não permitido.");
        if(carro.getMotorista().getPontos() > MAX_PONTOS)
            throw new EstacionamentoException("Habilitação suspensa");
    }
}
