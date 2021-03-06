package walkGenerators.classic.alod.applications.alodRandomWalks.generationSPARQL;

import walkGenerators.classic.alod.applications.alodRandomWalks.generationSPARQL.controller.AlodRandomWalkGenerator;
import walkGenerators.classic.alod.services.tools.IOoperations;

/**
 * This class is able to obtain walks for the ALOD data set from a file which contains given entities for which a
 * path shall be generated. The paths are generated in a random fashion but higher-confidence relations have a higher
 * probability of being drawn.
 */
public class AlodRandomWalkFromFile {

    /**
     * Main Method.
     * @param args No arguments required.
     */
    public static void main(String[] args) {

        //------------------------------------------------------------------------------------------
        // Set your parameters below.
        //------------------------------------------------------------------------------------------

        final boolean useTDB = true;

        final int numberOfThreads = 40;
        final int numberOfWalks = 150;
        final int depth = 3;
        final String outputFileName = "myWalks.gz";



        //------------------------------------------------------------------------------------------
        // Do not change the code below.
        //------------------------------------------------------------------------------------------

        System.out.println("STARTING PROCESS");
        AlodRandomWalkGenerator walkGenerator = new AlodRandomWalkGenerator(numberOfWalks, depth, outputFileName);
        walkGenerator.setUseTDB(useTDB);

        IOoperations.writeSetToFileInOutputDirectory(walkGenerator.getEntities(), "");

        /*
        HashSet<String> entities = new HashSet<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(pathToConceptFile)));
            String readConcept;
            while((readConcept = reader.readLine()) != null){
                entities.add(readConcept);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        walkGenerator.setEntities(entities);
        long startTime = System.currentTimeMillis();
        walkGenerator.generateWalks(pathToRepo, 1, -1);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        */
        System.out.println("PROCESS COMPLETED");

    }
}
