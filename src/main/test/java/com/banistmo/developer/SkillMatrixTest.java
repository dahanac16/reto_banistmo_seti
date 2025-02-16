package main.test.java.com.banistmo.developer;

import com.banistmo.developer.domain.SkillMatrix;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SkillMatrixTest {

    @Test
    void testNotADeveloper() {
        char[][] matrix = {
                {'B', 'T', 'M', 'N', 'M', 'B'},
                {'N', 'B', 'M', 'T', 'M', 'N'},
                {'T', 'T', 'B', 'T', 'T', 'T'},
                {'B', 'M', 'B', 'N', 'M', 'M'},
                {'M', 'N', 'M', 'T', 'N', 'B'},
                {'T', 'N', 'B', 'N', 'T', 'M'}
        };

        SkillMatrix skillMatrix = new SkillMatrix(matrix);
        assertFalse(skillMatrix.isDeveloper(), "El candidato NO debería ser Developer.");
    }

    @Test
    void testDeveloperDetectedWithTwoSequences() {
        char[][] matrix = {
                {'B', 'B', 'B', 'B', 'M', 'B'}, 
                {'N', 'B', 'M', 'T', 'M', 'N'},
                {'T', 'T', 'B', 'T', 'T', 'T'},
                {'B', 'M', 'B', 'N', 'M', 'M'},
                {'N', 'N', 'N', 'N', 'N', 'B'}, 
                {'T', 'N', 'B', 'N', 'T', 'M'}
        };

        SkillMatrix skillMatrix = new SkillMatrix(matrix);
        assertTrue(skillMatrix.isDeveloper(), "El candidato SÍ debería ser Developer.");
    }

    @Test
    void testDeveloperDetectedWithDiagonalSequence() {
        char[][] matrix = {
                {'B', 'T', 'M', 'N', 'M', 'B'},
                {'N', 'B', 'T', 'T', 'M', 'N'},
                {'T', 'B', 'N', 'T', 'T', 'T'},
                {'B', 'M', 'B', 'N', 'M', 'M'},
                {'N', 'N', 'B', 'B', 'N', 'B'},
                {'T', 'N', 'B', 'N', 'B', 'N'}
        };

        SkillMatrix skillMatrix = new SkillMatrix(matrix);
        assertTrue(skillMatrix.isDeveloper(), "El candidato SÍ debería ser Developer.");
    }

    @Test
    void testDeveloperDetectedWithVerticalSequence() {
        char[][] matrix = {
                {'B', 'T', 'M', 'N', 'M', 'B'},
                {'B', 'B', 'M', 'T', 'M', 'N'},
                {'B', 'T', 'B', 'T', 'M', 'T'},
                {'B', 'M', 'B', 'N', 'M', 'M'},
                {'N', 'N', 'M', 'T', 'N', 'B'},
                {'T', 'N', 'B', 'N', 'T', 'M'}
        };

        SkillMatrix skillMatrix = new SkillMatrix(matrix);
        assertTrue(skillMatrix.isDeveloper(), "El candidato SÍ debería ser Developer.");
    }
}
