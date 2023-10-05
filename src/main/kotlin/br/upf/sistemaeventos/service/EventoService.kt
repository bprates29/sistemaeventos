package br.upf.sistemaeventos.service

import br.upf.sistemaeventos.converters.EventoConverter
import br.upf.sistemaeventos.dtos.EventoDTO
import br.upf.sistemaeventos.dtos.EventoResponseDTO
import br.upf.sistemaeventos.exceptions.NotFoundException
import br.upf.sistemaeventos.repository.EventoRepository
import org.springframework.stereotype.Service

private const val EVENTO_NOT_FOUND_MESSAGE = "Evento não encontrado!"

@Service
class EventoService(private val repository: EventoRepository,
    private val converter: EventoConverter) {

    fun listar(): List<EventoResponseDTO> {
        return repository.findAll()
            .map(converter::toEventoResponseDTO)
    }

    fun buscarPorId(id: Long): EventoResponseDTO {
        val evento = repository.findById(id)
            .orElseThrow{ NotFoundException(EVENTO_NOT_FOUND_MESSAGE) }
        return converter.toEventoResponseDTO(evento)
    }

    fun cadastrar(dto: EventoDTO): EventoResponseDTO {
        val evento = repository.save(converter.toEvento(dto))
        return converter.toEventoResponseDTO(evento)
    }

    fun atualizar(id: Long, dto: EventoDTO): EventoResponseDTO {
        val evento = repository.findById(id)
            .orElseThrow{ NotFoundException(EVENTO_NOT_FOUND_MESSAGE) }
        val eventoAtualizado = repository.save(
            evento.copy(nome = dto.nome,
                data = dto.data,
                dataFimInsc = dto.dataFimInsc,
                dataInicioInsc = dto.dataInicioInsc,
                descricao = dto.descricao,
                status = dto.status)
        )
        return converter.toEventoResponseDTO(eventoAtualizado)
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }
}