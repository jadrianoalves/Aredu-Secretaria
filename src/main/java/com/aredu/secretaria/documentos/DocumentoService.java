package com.aredu.secretaria.documentos;


import com.aredu.secretaria.libs.BaseServiceApi;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DocumentoService extends BaseServiceApi<Documento> {


    private final DocumentoApiCaller documentoApiCaller;
    public DocumentoService(DocumentoApiCaller apiCaller) {
        super(apiCaller);
        this.documentoApiCaller = apiCaller;
    }


    public List<Documento> getAllByAlunoId(Long alunoId) {
        return documentoApiCaller.getAllByAlunoId(alunoId);
    }

}
