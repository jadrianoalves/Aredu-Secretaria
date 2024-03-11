package com.aredu.secretaria.alunos;

import com.aredu.secretaria.dtos.AlunoDTO;
import com.aredu.secretaria.libs.ApiResponse;
import com.aredu.secretaria.libs.BaseController;
import com.aredu.secretaria.libs.BaseServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController extends BaseController<Aluno> {

    @Autowired
    private final AlunoService alunoService;

    @Autowired
    public AlunoController(AlunoService alunoService) {
        super(alunoService,"Aluno", "Alunos");
        this.alunoService = alunoService;
    }


    @GetMapping
    public ResponseEntity<ApiResponse<List<AlunoDTO>>> getAll() {

        try {

            List<AlunoDTO> result = alunoService.getAllAlunos(); // Altere para o método correto se necessário

            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<List<AlunoDTO>>(HttpStatus.OK, message.getListSuccessMessage(), result));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<List<AlunoDTO>>(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null));
        }
    }


}

