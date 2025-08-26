//package app;
//
//import config.AppConfig;
//import model.StatsMode;
//import org.junit.jupiter.api.Test;
//
//
//import java.nio.file.Paths;
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//public class RunnerTest {
//
//    /**
//     * Тест для проверки наличия пути записи
//     */
//    @Test
//    public void testPathOutput(){
//        String[] args = {"-o", "C:\\Users\\artem\\IdeaProjects", "src/test/resources/test"};
//
//        AppConfig appConfig = new Runner().run(args);
//
//        assertEquals(Paths.get("C:\\Users\\artem\\IdeaProjects"), appConfig.getOutputDirection());
//    }
//
//    /**
//     * Тест опции -р с позитивным исходом
//     */
//    @Test
//    public void testPrefix(){
//        String[] args = {"-p", "test-prefix-", "test.txt", "test2.txt"};
//
//        AppConfig appConfig = new Runner().run(args);
//        assertEquals("test-prefix-", appConfig.getPrefix());
//
//    }
//
//    /**
//     * Тест опции -p с выбрасыванием исключения
//     */
//    @Test
//    public void testMissingPrefixThrowsException(){
//        String[] args = {"-p"};
//
//        assertThrows(IllegalArgumentException.class, () -> {new Runner().run(args);});
//    }
//
//
//    /**
//     * Тест опции -s с выбором коротокой статистики
//     */
//    @Test
//    public void testShortStatisticsOption(){
//        String[] args = {"-s", "test.txt", "test2.txt"};
//        AppConfig appConfig = new Runner().run(args);
//
//        assertEquals(StatsMode.SHORT, appConfig.getStatsMode());
//
//    }
//
//    /**
//     * Тест опции -f с выбором полной статистики
//     */
//    @Test
//    public void testFullStatisticsOption(){
//        String[] args = {"-f", "test.txt", "test2.txt"};
//        AppConfig appConfig = new Runner().run(args);
//        assertEquals(StatsMode.FULL, appConfig.getStatsMode());
//    }
//
//
//    @Test
//    public void testInputFilesPath(){
//        String[] args = {"test.txt"};
//
//        AppConfig appConfig = new Runner().run(args);
//        ArrayList<String> inputFiles = new ArrayList<>();
//        inputFiles.add("test.txt");
//        assertEquals(inputFiles.toString(), appConfig.getInputFiles().toString());
//    }
//}
