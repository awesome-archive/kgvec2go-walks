package walkGenerators.classic.alod.services.testTools;

import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Set;

/**
 * A class which provides supporting functionalities mainly for writing unit tests.
 */
public class TestOperations {

    private static Logger LOG = LoggerFactory.getLogger(TestOperations.class);

    /**
     * Checks whether two sets contain the same contents.
     * @param s1 Set 1
     * @param s2 Set 2
     * @return True if the content of the sets is equal, else false.
     */
    public static boolean setContainsSameContent(Set s1, Set s2){
        if(s1.size() != s2.size()){
            LOG.error("Sets have different size.");
            return false;
        }

        for(Object o : s1){
            if(!s2.contains(o)){
                LOG.error(o.toString() + " not contained in both sets.");

                LOG.error("Contents of set 1:");
                s1.stream().forEach(x -> LOG.error(x.toString()));

                LOG.error("Contents of set 2:");
                s2.stream().forEach(x -> LOG.error(x.toString()));

                return false;
            }
        }
        return true;
    }


    /**
     * Checks whether two string arrays contain the same contents.
     * @param array_1 Array 1.
     * @param array_2 Array 2.
     * @return True if the content of the arrays is equal, else false.
     */
    public static boolean isSameStringArray(String[] array_1, String[] array_2) {
        if (array_1.length != array_2.length) {
            LOG.info("Arrays have different length.");
            return false;
        } else if(array_1 == null && array_2 == null) {
            return true;
        } else {
            for (int i = 0; i < array_1.length; i++) {
                if (!array_1[i].equals(array_2[i])) {
                    LOG.info(array_1[i] + " != " + array_2[i]);
                    return false;
                }
            }
            return true;
        }
    }


    /**
     * Checks whether two double arrays contain the same contents.
     * @param array_1 Array 1.
     * @param array_2 Array 2.
     * @return True if the content of the arrays is equal, else false.
     */
    public static boolean isSameDoubleArray(double[] array_1, double[] array_2) {
        if (array_1.length != array_2.length) {
            LOG.info("Arrays have different length.");
            return false;
        } else if(array_1 == null && array_2 == null) {
            return true;
        } else {
            for (int i = 0; i < array_1.length; i++) {
                if (array_1[i] != (array_2[i])) {
                    LOG.info(array_1[i] + " != " + array_2[i]);
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * Checks whether two double arrays contain the same contents.
     * @param array_1 Array 1.
     * @param array_2 Array 2.
     * @return True if the content of the arrays is equal, else false.
     */
    public static boolean isSameDoubleArray(Double[] array_1, Double[] array_2) {
        return isSameDoubleArray(ArrayUtils.toPrimitive(array_1), ArrayUtils.toPrimitive(array_2));
    }

    /**
     * Checks whether the String components within the two given arrays are equal. The position of the elements does not matter.
     * @param array_1 Array 1.
     * @param array_2 Array 2.
     * @return True if the content of the arrays is equal, else false.
     */
    public static boolean isSameArrayContent(String[] array_1, String[] array_2){
        if (array_1.length != array_2.length) {
            LOG.info("Arrays have different length.");
            return false;
        } else if(array_1 == null && array_2 == null) {
            return true;
        }
        if(Arrays.asList(array_2).containsAll(Arrays.asList(array_1))){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Prints the contents of a String Array.
     * @param stringArray The String Array to be printed.
     */
    private void printStringArray(String[] stringArray){
        Arrays.stream(stringArray).forEach(System.out::println);
    }
}
