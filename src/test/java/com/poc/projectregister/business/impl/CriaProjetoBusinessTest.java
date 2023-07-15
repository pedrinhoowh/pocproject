package com.poc.projectregister.business.impl;

import com.poc.projectregister.business.projeto.BuscaPessoa;
import com.poc.projectregister.business.projeto.impl.CriaProjetoBusiness;
import com.poc.projectregister.domain.ProjetoDomain;
import com.poc.projectregister.exception.BusinessException;
import com.poc.projectregister.exception.ErrorObject;
import com.poc.projectregister.repository.entity.ProjetoEntity;
import com.poc.projectregister.repository.repository.ProjetoRepository;
import com.poc.projectregister.validators.CriaAlteraProjetoValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CriaProjetoBusinessTest {

    @InjectMocks
    private CriaProjetoBusiness criaProjetoBusiness;

    @Mock
    private ProjetoRepository projetoRepository;

    @Mock
    private BuscaPessoa buscaPessoa;

    @Test
    public void success_whenCria() {
        ProjetoDomain projetoDomain = ProjetoDomain.builder()
                .idGerente(1l)
                .risco("AAA")
                .orcamento(1223d)
                .status("AAA")
                .descricao("AAA")
                .dataFim(LocalDate.now())
                .dataPrevisaoFim(LocalDate.now())
                .dataInicio(LocalDate.now())
                .nome("AAA")
                .build();

        CriaAlteraProjetoValidator criaAlteraProjetoValidator = mock(CriaAlteraProjetoValidator.class);

        List<CriaAlteraProjetoValidator> validators = Arrays.asList(criaAlteraProjetoValidator);

        ReflectionTestUtils.setField(criaProjetoBusiness, "validators", validators);

        when(criaAlteraProjetoValidator.valida(projetoDomain)).thenReturn(new ArrayList<>());

        when(projetoRepository.save(any(ProjetoEntity.class))).thenReturn(projetoDomain.toEntity());

        ProjetoDomain projetoRetorno = criaProjetoBusiness.cria(projetoDomain);

        assertSame(projetoDomain.getIdGerente(), projetoRetorno.getIdGerente());
        assertSame(projetoDomain.getRisco(), projetoRetorno.getRisco());
        assertSame(projetoDomain.getOrcamento(), projetoRetorno.getOrcamento());
        assertSame(projetoDomain.getStatus(), projetoRetorno.getStatus());
        assertSame(projetoDomain.getDescricao(), projetoRetorno.getDescricao());
        assertSame(projetoDomain.getDataFim(), projetoRetorno.getDataFim());
        assertSame(projetoDomain.getDataPrevisaoFim(), projetoRetorno.getDataPrevisaoFim());
        assertSame(projetoDomain.getDataInicio(), projetoRetorno.getDataInicio());
        assertSame(projetoDomain.getNome(), projetoRetorno.getNome());

        verify(buscaPessoa, times(1)).busca(1l);

        verify(projetoRepository, times(1)).save(any(ProjetoEntity.class));
    }

    @Test
    public void error_validation_whenCria() {
        ProjetoDomain projetoDomain = ProjetoDomain.builder()
                .idGerente(1l)
                .risco("AAA")
                .orcamento(1223d)
                .status("AAA")
                .descricao("AAA")
                .dataFim(LocalDate.now())
                .dataPrevisaoFim(LocalDate.now())
                .dataInicio(LocalDate.now())
                .nome("AAA")
                .build();

        CriaAlteraProjetoValidator criaAlteraProjetoValidator = mock(CriaAlteraProjetoValidator.class);

        List<CriaAlteraProjetoValidator> validators = Arrays.asList(criaAlteraProjetoValidator);

        ReflectionTestUtils.setField(criaProjetoBusiness, "validators", validators);

        ErrorObject errorObject = mock(ErrorObject.class);
        when(errorObject.getMensagemError()).thenReturn("AAA");

        when(criaAlteraProjetoValidator.valida(projetoDomain)).thenReturn(Arrays.asList(errorObject));

        Throwable raisedException = catchThrowable(() -> criaProjetoBusiness.cria(projetoDomain));

        assertThat(raisedException).isInstanceOf(BusinessException.class);

        assertThat(raisedException).hasMessage("AAA");

        verify(buscaPessoa, times(0)).busca(1l);

        verify(projetoRepository, times(0)).save(any(ProjetoEntity.class));
    }

    @Test
    public void error_buscaPessoa_cria() {
        ProjetoDomain projetoDomain = ProjetoDomain.builder()
                .idGerente(1l)
                .risco("AAA")
                .orcamento(1223d)
                .status("AAA")
                .descricao("AAA")
                .dataFim(LocalDate.now())
                .dataPrevisaoFim(LocalDate.now())
                .dataInicio(LocalDate.now())
                .nome("AAA")
                .build();

        CriaAlteraProjetoValidator criaAlteraProjetoValidator = mock(CriaAlteraProjetoValidator.class);

        List<CriaAlteraProjetoValidator> validators = Arrays.asList(criaAlteraProjetoValidator);

        ReflectionTestUtils.setField(criaProjetoBusiness, "validators", validators);

        when(criaAlteraProjetoValidator.valida(projetoDomain)).thenReturn(new ArrayList<>());

        when(buscaPessoa.busca(1l)).thenThrow(BusinessException.class);

        Throwable raisedException = catchThrowable(() -> criaProjetoBusiness.cria(projetoDomain));

        assertThat(raisedException).isInstanceOf(BusinessException.class);

        verify(buscaPessoa, times(1)).busca(1l);

        verify(projetoRepository, times(0)).save(any(ProjetoEntity.class));
    }
}
