package uea.pagamentos_api.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uea.pagamentos_api.models.Pessoa;
import uea.pagamentos_api.repositories.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Pessoa criar(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	public List<Pessoa> listarTodos(){
		return pessoaRepository.findAll();
	}
	
	public Pessoa buscarPorCodigo(Long codigo) { // null or not null
		Pessoa pessoa = pessoaRepository.findById(codigo).orElseThrow();
		return pessoa;
	}
	
	public void excluir(Long codigo) {
		pessoaRepository.deleteById(codigo);
	}
	public Pessoa atualizar(Long codigo, Pessoa pessoa){
		Pessoa pessoaSalva = pessoaRepository.findById(codigo).orElseThrow();
		BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo");
		return pessoaRepository.save(pessoaSalva);
	}
}
