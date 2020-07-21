package br.com.codenation;

import br.com.codenation.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.exceptions.TimeNaoEncontradoException;
import br.com.codenation.modelo.Jogador;
import br.com.codenation.modelo.Time;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;


public class DesafioMeuTimeApplication implements MeuTimeInterface {

	private Map<Long, Time> times =  new HashMap<>();
	private Map<Long, Jogador> jogadores = new HashMap<>();

	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		if(times.containsKey(id))
			throw new IdentificadorUtilizadoException();
		times.put(id, new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario));
	}

	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		if(jogadores.containsKey(id))
			throw new IdentificadorUtilizadoException();
		buscarTime(idTime).getIdJogadores().add(id);
		jogadores.put(id, new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario));
	}

	public void definirCapitao(Long idJogador) {
		Long idTime = buscarJogador(idJogador).getIdTime();
		buscarTime(idTime).setIdCapitao(idJogador);
	}

	public Long buscarCapitaoDoTime(Long idTime) {
		if(buscarTime(idTime).getIdCapitao() == null)
			throw new CapitaoNaoInformadoException();
		return buscarTime(idTime).getIdCapitao();
	}

	public String buscarNomeJogador(Long idJogador) {
		return buscarJogador(idJogador).getNome();
	}

	public String buscarNomeTime(Long idTime) {
		return buscarTime(idTime).getNome();
	}

	public List<Long> buscarJogadoresDoTime(Long idTime) {
		return buscarTime(idTime).getIdJogadores();
	}

	public Long buscarMelhorJogadorDoTime(Long idTime) {
		Jogador jogador = null;
		for(Long idJogador: buscarJogadoresDoTime(idTime)) {
			Jogador outroJogador = buscarJogador(idJogador);
			if(jogador == null || (jogador.getNivelHabilidade() < outroJogador.getNivelHabilidade()))
				jogador = outroJogador;
		}
		return jogador.getId();
	}

	public Long buscarJogadorMaisVelho(Long idTime) {
		Jogador jogador = null;
		for(Long idJogador: buscarJogadoresDoTime(idTime)) {
			Jogador outroJogador = buscarJogador(idJogador);
			if(jogador == null || (jogador.getDataNascimento().isAfter(outroJogador.getDataNascimento())))
				jogador = outroJogador;
		}
		return jogador.getId();
	}

	public List<Long> buscarTimes() {
		List<Long> idTimes = new ArrayList<>(times.keySet());
		return idTimes;
	}

	public Long buscarJogadorMaiorSalario(Long idTime) {
		Jogador jogador = null;
		for(Long idJogador: buscarJogadoresDoTime(idTime)) {
			Jogador outroJogador = buscarJogador(idJogador);
			if(jogador == null || (jogador.getSalario().compareTo(outroJogador.getSalario()) == -1))
				jogador = outroJogador;
		}
		return jogador.getId();
	}

	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		return buscarJogador(idJogador).getSalario();
	}

	public List<Long> buscarTopJogadores(Integer top) {
		if(jogadores.size() == 0)
			return new ArrayList<Long>();
		List<Jogador> melhoresJogadores = new ArrayList<>(jogadores.values());
		melhoresJogadores.sort(Comparator.comparing(Jogador::getNivelHabilidade).reversed().thenComparing(Jogador::getId));
		List<Long> idJogadores = new ArrayList<>();
		for(int i=0; i< top; i++) {
			idJogadores.add(melhoresJogadores.get(i).getId());
		}
		return idJogadores;
	}

	public Time buscarTime(Long idTime) {
		if(!times.containsKey(idTime))
			throw new TimeNaoEncontradoException();
		return times.get(idTime);
	}

	public Jogador buscarJogador(Long idJogador) {
		if(!jogadores.containsKey(idJogador))
			throw new JogadorNaoEncontradoException();
		return jogadores.get(idJogador);
	}
}
