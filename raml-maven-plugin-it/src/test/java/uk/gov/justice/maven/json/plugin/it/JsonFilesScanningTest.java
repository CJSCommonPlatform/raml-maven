package uk.gov.justice.maven.json.plugin.it;


import static org.apache.commons.lang.StringUtils.substringBefore;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;

public class JsonFilesScanningTest {

    @Test
    public void shouldProcessInternalAndExternalJsonFiles() throws Exception {

        List<String> recordedJsonTitles = Files.readAllLines(recordedJsonTitlesFile());

        System.out.println("JsonFilesScanningTest: Printing out json-titles.txt");

        recordedJsonTitles.stream()
                .forEach(s -> System.out.println("JsonFilesScanningTest: Json Value Found" + s));

        assertThat(recordedJsonTitles, containsInAnyOrder("one", "two"));
    }

    private Path recordedJsonTitlesFile() throws URISyntaxException {
        URL classUrl = this.getClass().getResource(this.getClass().getSimpleName() + ".class");
        String generatedSourcesFolder = substringBefore(classUrl.toString(), "test-classes") + "generated-sources/";
        return Paths.get(new URI(generatedSourcesFolder + "json-titles.txt"));
    }
}
