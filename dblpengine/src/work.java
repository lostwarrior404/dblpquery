/**
 * Created by Tushar Kataria on 27-Nov-16.
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class work {
        public static Map<String, Integer> getTermFrequencyMap(String[] terms) {
            Map<String, Integer> termFrequencyMap = new HashMap<String, Integer>();
            for (String term : terms) {
                Integer n = termFrequencyMap.get(term);
                n = (n == null) ? 1 : ++n;
                termFrequencyMap.put(term, n);
            }
            return termFrequencyMap;
        }

        public static double cosineSimilarity(String text1, String text2) {
            //Get vectors
            Map<String, Integer> a = getTermFrequencyMap(text1.split("\\W+"));
            Map<String, Integer> b = getTermFrequencyMap(text2.split("\\W+"));

            //Get unique words from both sequences
            HashSet<String> intersection = new HashSet<String>(a.keySet());
            intersection.retainAll(b.keySet());

            double dotProduct = 0, magnitudeA = 0, magnitudeB = 0;

            //Calculate dot product
            for (String item : intersection) {
                dotProduct += a.get(item) * b.get(item);
            }

            //Calculate magnitude a
            for (String k : a.keySet()) {
                magnitudeA += Math.pow(a.get(k), 2);
            }

            //Calculate magnitude b
            for (String k : b.keySet()) {
                magnitudeB += Math.pow(b.get(k), 2);
            }

            //return cosine similarity
            return dotProduct / Math.sqrt(magnitudeA * magnitudeB);
        }
    }

