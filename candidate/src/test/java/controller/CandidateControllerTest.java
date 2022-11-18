package controller;

import com.nttdata.recruitmentsystem.candidate.controller.CandidateController;
import com.nttdata.recruitmentsystem.candidate.data.Candidate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@ExtendWith(MockitoExtension.class)
public class CandidateControllerTest {

    @Mock
    private CandidateController candidateController;

    @Test
    public void testGetAllCandidates() {
        List<Candidate> candidate = new ArrayList<>();
        Candidate c = new Candidate(123456, "Nikola", "n@gmail.com");
        candidate.add(c);

        Mockito.when(candidateController.getAll()).thenReturn(candidate);
        List<Candidate> finalList = candidateController.getAll();

        if(!finalList.isEmpty()) {
            assertNotNull(c);
            assertEquals(c.getCandidateName(), finalList.get(0).getCandidateName());
            assertEquals(c.getEmail(), finalList.get(0).getEmail());
        }
        System.out.println(candidate);
    }

    @Test
    public void testCreateCandidate_OK(){

    }
}