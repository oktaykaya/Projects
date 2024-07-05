package oktay.kaya;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException, CmdLineException {

        Myoptions options = new Myoptions();
        CmdLineParser parser = new CmdLineParser(options);
        parser.parseArgument(args);
        List<String> words = getWords(options.unique, options.fileNames);
        Map<String, Integer> wordCount = countWords(words);

        switch (options.task.toLowerCase()) {
            case "numoftokens":
                System.out.println(words.size());
                break;
            case "frequentterms":

                printFrequentTerms(wordCount, options.topN);
                break;
            case "termsstartwith":
                ArrayList<String> tsw = termsStartWith(wordCount, options.start, options.reverse);
                try {
                    for (int i = 0; i < options.topN; i++) {
                        System.out.println(tsw.get(i));
                    }
                } catch (IndexOutOfBoundsException exception) {
                    System.out.println("There are no words starting with " + options.start);
                }
                break;
            case "termlengthstats":
                printsStats(words, words.size());
                break;
        }

    }

    public static List<String> getWords(boolean unique, String... fileNames) throws IOException {
        List<Path> paths = new ArrayList<>();
        for (String fileName : fileNames)
            paths.add(Paths.get(fileName));
        List<String> words = new ArrayList<>();
        for (Path path : paths) {
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                StringTokenizer tokenizer = new StringTokenizer(line, " ");
                while (tokenizer.hasMoreTokens()) {
                    String token = tokenizer.nextToken();
                    StringBuilder builder = new StringBuilder();
                    for (char c : token.toCharArray())
                        if (Character.isLetterOrDigit(c))
                            builder.append(Character.toLowerCase(c));
                    String result = builder.toString();
                    if (!result.trim().isEmpty()) words.add(result);
                }
            }
        }
        return unique ? new ArrayList<>(new HashSet<>(words)) : words;
    }

    public static Map<String, Integer> countWords(List<String> words) {
        Map<String, Integer> res = new HashMap<>();
        for (String word : words) {
            if (res.containsKey(word))
                res.replace(word, res.get(word) + 1);
            else res.put(word, 1);
        }
        return res;
    }

    public static void printFrequentTerms(Map<String, Integer> map, int topN) {
        for (int i = 0; i < topN; i++) {
            Map.Entry<String, Integer> maxValue = null;
            for (Map.Entry<String, Integer> entry : map.entrySet())
                if (maxValue == null || entry.getValue() > maxValue.getValue())
                    maxValue = entry;
            if (maxValue != null)
                map.remove(maxValue.getKey());
            else return;
            System.out.println(maxValue.getKey() + "   " + maxValue.getValue());
        }
    }

    public static ArrayList<String> termsStartWith(Map<String, Integer> map, String term, boolean reverse) {
        ArrayList<String> result = new ArrayList<>();
        for (String key : map.keySet()) {
            if (key.startsWith(term)) {
                result.add(key);
            }
        }
        Collections.sort(result);
        if (reverse) {
            Collections.sort(result, Collections.reverseOrder());
        }

        return result;

    }

    public static void printsStats(List<String> list, Integer length) {
        int max = 0;
        int min = 100;
        int total = 0;
        for (String key : list) {
            if (max < key.length()) {
                max = key.length();
            }
            if (min > key.length()) {
                min = key.length();
            }
            total += key.length();
        }
        double avg = (double) total / (double) length;
        DecimalFormat formatter = new DecimalFormat("#0.0000");
        System.out.println("Max Token Length in Character: " + max + ", Min Token Length: "
                + min + ", Average Token Length:" + formatter.format(avg));

    }
}
