import company.InfoReader;
import company.RaceException;
import company.Solution;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class SolutionTest {

    @Test
    public void solutionHumanTest() throws RaceException, IOException {
        InfoReader.setInfo("C:\\Users\\Maria\\IdeaProjects\\deepplay\\src\\main\\resources\\TestFile");
        int result = Solution.getResult("STWSWTPPTPTTPWPP", "Human");
        assertEquals(10, result);
    }

    @Test
    public void solutionWoodmanTest() throws RaceException, IOException {
        InfoReader.setInfo("C:\\Users\\Maria\\IdeaProjects\\deepplay\\src\\main\\resources\\TestFile");
        int result = Solution.getResult("PPPPPPPPPPPPPPPP", "Woodman");
        assertEquals(10, result);
    }

    @Test
    public void solutionSwamperTest() throws RaceException, IOException {
        InfoReader.setInfo("C:\\Users\\Maria\\IdeaProjects\\deepplay\\src\\main\\resources\\TestFile");
        int result = Solution.getResult("STWSWTPPTPTTPWPP", "Swamper");
        assertEquals(15, result);
    }

    @Test
    public void solutionErrorTest() throws IOException {
        InfoReader.setInfo("C:\\Users\\Maria\\IdeaProjects\\deepplay\\src\\main\\resources\\TestFile");
        assertThrows(RaceException.class, ()->Solution.getResult("PPPPPPPPPPPPPPPP", "Troll"));
    }
    @Test
    public void solutionInputTest() throws IOException {
        InfoReader.setInfo("C:\\Users\\Maria\\IdeaProjects\\deepplay\\src\\main\\resources\\TestFile");
        assertThrows(IOException.class, ()->Solution.getResult("PPPPPPPPPPP", "Troll"));
    }
    @Test
    public void solutionInputTest2() throws IOException {
        InfoReader.setInfo("C:\\Users\\Maria\\IdeaProjects\\deepplay\\src\\main\\resources\\TestFile");
        assertThrows(IOException.class, ()->Solution.getResult("STWSWTPPTPTTPWPц", "Troll"));
    }
}
