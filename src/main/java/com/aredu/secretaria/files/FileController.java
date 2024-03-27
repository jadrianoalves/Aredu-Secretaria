package com.aredu.secretaria.files;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/files")
public class FileController {

    private final FileApiCaller fileApiCaller;

    public FileController(FileApiCaller fileApiCaller) {
        this.fileApiCaller = fileApiCaller;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("pastaId") String pastaId,
            @RequestParam("alunoId") String alunoId,
            @RequestParam("type") String type,
            @RequestParam(value = "descricao", required = false) String descricao) {

        try {
            byte[] fileBytes = file.getBytes();
            return fileApiCaller.uploadFile(fileBytes, pastaId, alunoId, type, descricao);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao ler o conteúdo do arquivo");
        }
    }

    @GetMapping("/gettoken")
    public ResponseEntity<String> getToken(){
        return ResponseEntity.ok().body(fileApiCaller.getToken());
    }

    @GetMapping("/tokenisvalid")
    public ResponseEntity<Boolean> tokenIsValid(@RequestParam("token") String token) {
        return ResponseEntity.ok().body(fileApiCaller.tokenIsValid(token));
    }
}
