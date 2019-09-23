package com.reciclatown.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class OrdemManutencao {

    @Id
    private String id;
    private Integer numeroEquipamento;
    private String problemaReportado;
    private String localDeRetirada;
    private String responsavelEquipamento;
    private LocalDateTime datahoraRetirada;
    private LocalDateTime dataHoraEntrega;
    private String telefoneResponsavel;
    private String statusOrdem;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getNumeroEquipamento() {
        return numeroEquipamento;
    }

    public void setNumeroEquipamento(Integer numeroEquipamento) {
        this.numeroEquipamento = numeroEquipamento;
    }

    public String getProblemaReportado() {
        return problemaReportado;
    }

    public void setProblemaReportado(String problemaReportado) {
        this.problemaReportado = problemaReportado;
    }

    public String getLocalDeRetirada() {
        return localDeRetirada;
    }

    public void setLocalDeRetirada(String localDeRetirada) {
        this.localDeRetirada = localDeRetirada;
    }

    public String getResponsavelEquipamento() {
        return responsavelEquipamento;
    }

    public void setResponsavelEquipamento(String responsavelEquipamento) {
        this.responsavelEquipamento = responsavelEquipamento;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime getDatahoraRetirada() {
        return datahoraRetirada;
    }

    public void setDatahoraRetirada(LocalDateTime datahoraRetirada) {
        this.datahoraRetirada = datahoraRetirada;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime getDataHoraEntrega() {
        return dataHoraEntrega;
    }

    public void setDataHoraEntrega(LocalDateTime dataHoraEntrega) {
        this.dataHoraEntrega = dataHoraEntrega;
    }

    public String getTelefoneResponsavel() {
        return telefoneResponsavel;
    }

    public void setTelefoneResponsavel(String telefoneResponsavel) {
        this.telefoneResponsavel = telefoneResponsavel;
    }

    public String getStatusOrdem() {
        return statusOrdem;
    }

    public void setStatusOrdem(String statusOrdem) {
        this.statusOrdem = statusOrdem;
    }
}
