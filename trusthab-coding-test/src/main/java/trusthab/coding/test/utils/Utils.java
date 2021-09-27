package trusthab.coding.test.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

public class Utils {

    private static final Logger LOGGER = LoggerFactory.getLogger(Utils.class);

    private Utils() {

    }

    public static String readResourcesFile(String fileName) throws IOException {

	StringBuilder sb = new StringBuilder();
	File file = ResourceUtils.getFile("classpath:".concat(fileName));

	try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr);) {

	    String line;
	    while ((line = br.readLine()) != null) {
		sb.append(line);
	    }
	} catch (IOException e) {
	    LOGGER.error(e.getMessage());
	}
	return sb.toString();
    }

}
