package service;

import com.nttdata.data.Candidate;
import com.nttdata.entity.CandidateEntity;
import com.nttdata.service.CandidateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.nttdata.repository.CandidateRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class CandidateServiceTest {

    @Mock
    private CandidateRepository candidateRepository;
    private CandidateService candidateService;

    @BeforeEach
    public void beforeAll() {
        candidateService = new CandidateService(candidateRepository);
    }

    @Test
    public void testFindAll_OK() {
        List<CandidateEntity> candidateEntities = new ArrayList<>();
        CandidateEntity c = new CandidateEntity();
        c.setId(1);
        c.setCandidateName("Nikola");
        c.setCandidateEmail("test@test");
        candidateEntities.add(c);

        Mockito.when(candidateRepository.findAll()).thenReturn(candidateEntities);
        List<Candidate> finalList = candidateService.findAllCandidates();

        if (!finalList.isEmpty()) {
            assertNotNull(c);
            assertEquals(c.getCandidateName(), finalList.get(0).getCandidateName());
            assertEquals(c.getCandidateEmail(), finalList.get(0).getEmail());

        }
        System.out.println(candidateEntities);
    }
}