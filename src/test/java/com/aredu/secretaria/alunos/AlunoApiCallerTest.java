import com.aredu.secretaria.alunos.Aluno;
import com.aredu.secretaria.alunos.AlunoApiCaller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

public class AlunoApiCallerTest {

    @Mock
    private RestTemplate restTemplate;

    private AlunoApiCaller alunoApiCaller;

    private static final String BASE_URL = "http://example.com";

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        alunoApiCaller = new AlunoApiCaller(new RestTemplateBuilder(), BASE_URL, 8091);
    }

    @Test
    public void testSave() {
        // Mocking the response entity
        Aluno aluno = new Aluno();
        when(restTemplate.exchange(
                eq(BASE_URL),
                eq(HttpMethod.POST),
                any(),
                eq(Aluno.class)))
                .thenReturn(new ResponseEntity<>(aluno, HttpStatus.CREATED));

        // Calling the method under test
        Aluno savedAluno = alunoApiCaller.save("{}");

        // Verifying the result
        assertEquals(aluno, savedAluno);
    }

    // Similar tests for other methods like getAll, getById, update, delete, search
}