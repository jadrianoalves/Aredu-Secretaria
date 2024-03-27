package com.aredu.secretaria.files;

import com.aredu.secretaria.dtos.AlunoDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

@Component
public class FileApiCaller {

    private final WebClient webClient;

    public FileApiCaller(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8089/api/files").build();;
    }

    public ResponseEntity<String> uploadFile(byte[] fileBytes, String pastaId, String alunoId, String type, String descricao) {
        try {
            String fileName = getFileNameFromBytes(fileBytes);
            ByteArrayResource resource = new ByteArrayResource(fileBytes) {
                @Override
                public String getFilename() {
                    return fileName; // Retorna o nome do arquivo com sua extensão original
                }
            };

            MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
            body.add("file", resource);
            body.add("pastaId", pastaId);
            body.add("alunoId", alunoId);
            body.add("type", type);
            if (descricao != null) {
                body.add("descricao", descricao);
            }

            return webClient.post()
                    .uri("/upload")
                    .contentType(MediaType.MULTIPART_FORM_DATA)
                    .body(BodyInserters.fromMultipartData(body))
                    .retrieve()
                    .toEntity(String.class)
                    .block();
        } catch (Exception e) {
            e.printStackTrace();
            // Trate a exceção conforme necessário
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao fazer upload do arquivo");
        }




    }


    public String getToken() {

        String token = webClient.get()
                .uri("/gettoken")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<String>() {})
                .blockOptional()
                .orElse(null);

        return token;
    }

    public boolean tokenIsValid(String token) {
        try {
            ResponseEntity<Boolean> responseEntity = webClient.get()
                    .uri(uriBuilder -> uriBuilder.path("/tokenisvalid")
                            .queryParam("token", token)
                            .build())
                    .retrieve()
                    .toEntity(Boolean.class)
                    .block();

            if (responseEntity != null && responseEntity.getStatusCode().is2xxSuccessful()) {
                return responseEntity.getBody();
            } else {
                // Tratar outros códigos de status aqui, se necessário
                return false;
            }
        } catch (WebClientResponseException e) {
            // Tratar exceções aqui, se necessário
            return false;
        }
    }


    private String getFileExtension(String fileName) {
        int lastIndex = fileName.lastIndexOf('.');
        if (lastIndex == -1) {
            return "";
        }
        return fileName.substring(lastIndex);
    }

    public static String getFileNameFromBytes(byte[] fileBytes) throws IOException {
        String fileName = "arquivo"; // Nome padrão caso não seja possível extrair o nome do arquivo

        if (isPDF(fileBytes)) {
            fileName = "documento.pdf";
        }

        return fileName;
    }

    // Verifica se os primeiros bytes indicam que o arquivo é um documento PDF
    private static boolean isPDF(byte[] fileBytes) {
        if (fileBytes.length >= 4) {
            byte[] header = new byte[4];
            System.arraycopy(fileBytes, 0, header, 0, 4);
            String headerString = new String(header, StandardCharsets.US_ASCII);
            return "%PDF".equals(headerString);
        }
        return false;
    }







}
