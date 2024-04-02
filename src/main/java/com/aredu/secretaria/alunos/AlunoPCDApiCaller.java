package com.aredu.secretaria.alunos;

import com.aredu.secretaria.exceptions.ApiExternalException;
import com.aredu.secretaria.libs.ApiCaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;


@Component
public class AlunoPCDApiCaller extends ApiCaller<AlunoPCD> {

    @Autowired
    public AlunoPCDApiCaller(WebClient.Builder webClientBuilder, @Value("${baseUrl}") String baseUrl, @Value("${alunoServer.port}") int port) {
        super(webClientBuilder, baseUrl + ":" + port + "/api/aluno-pcd", "AlunoPCD", "AlunosPCD");
    }

    public List<NecessidadeEspecifica> addNecessidadeEspecificaAAluno(Long alunoPCDId, Long necessidadeId) {
        return webClient.post()
                .uri(baseUrl + "/" + alunoPCDId  + "/necessidades/" + necessidadeId)
                .retrieve()
                .bodyToMono(AlunoPCD.class)
                .flatMapIterable(AlunoPCD::getNecessidadesEspecificas)
                .collectList()
                .blockOptional()
                .orElseThrow(() -> new ApiExternalException(message.getSaveErrorMessage()));
    }


    public String deleteNecessidadeEspecifica(Long alunoPCDId, Long necessidadeId) {
        webClient.delete()
                .uri(baseUrl + "/" + alunoPCDId  + "/necessidades/" + necessidadeId)
                .retrieve()
                .toBodilessEntity()
                .block();
        return message.getDeleteSuccessMessage();
    }








    @Override
    protected Class<AlunoPCD> getResponseType() {
        return AlunoPCD.class;
    }
}
