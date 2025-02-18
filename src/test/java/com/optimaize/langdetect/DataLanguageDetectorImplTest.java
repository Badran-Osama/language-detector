/*
 * Copyright 2011 Fabian Kessler
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.optimaize.langdetect;

import com.optimaize.langdetect.ngram.NgramExtractors;
import com.optimaize.langdetect.profiles.LanguageProfile;
import com.optimaize.langdetect.profiles.LanguageProfileReader;
import com.optimaize.langdetect.text.CommonTextObjectFactories;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * Uses all built-in language profiles and tests some simple clean phrases as well as longer texts  against them
 * with expected outcome.
 *
 * @author Fabian Kessler
 */
public class DataLanguageDetectorImplTest {

//    private final LanguageDetector shortDetector;
//    private final LanguageDetector longDetector;
//
//    public DataLanguageDetectorImplTest() throws IOException {
//        List<LanguageProfile> languageProfiles = new LanguageProfileReader().readAllBuiltIn();
//
//        shortDetector = LanguageDetectorBuilder.create(NgramExtractors.standard())
//                .shortTextAlgorithm(100)
//                .withProfiles(languageProfiles)
//                .build();
//
//        longDetector = LanguageDetectorBuilder.create(NgramExtractors.standard())
//                .shortTextAlgorithm(0)
//                .withProfiles(new LanguageProfileReader().readAllBuiltIn())
//                .build();
//    }
//
//    @Test(dataProvider = "shortCleanTexts")
//    public void shortTextAlgo(String expectedLanguage, CharSequence text) throws IOException {
//        assertEquals(shortDetector.getProbabilities(text).get(0).getLocale().getLanguage(), expectedLanguage);
//        //the detect() method doesn't have enough confidence for all these short texts.
//    }
//
//    @Test(dataProvider = "shortCleanTexts")
//    public void longTextAlgoWorkingOnShortText(String expectedLanguage, CharSequence text) throws IOException {
//        assertEquals(longDetector.getProbabilities(text).get(0).getLocale().getLanguage(), expectedLanguage);
//        //the detect() method doesn't have enough confidence for all these short texts.
//    }
//
//    @Test(dataProvider = "longerWikipediaTexts")
//    public void longTextAlgoWorkingOnLongText(String expectedLanguage, CharSequence text) throws IOException {
//        assertEquals(longDetector.getProbabilities(text).get(0).getLocale().getLanguage(), expectedLanguage);
//        assertEquals(longDetector.detect(text).get().getLanguage(), expectedLanguage);
//    }
//
//    @DataProvider
//    protected Object[][] shortCleanTexts() {
//        return new Object[][] {
//                {"en", shortCleanText("This is some English text.")},
//                {"fr", shortCleanText("Ceci est un texte français.")},
//                {"nl", shortCleanText("Dit is een Nederlandse tekst.")},
//                {"de", shortCleanText("Dies ist eine deutsche Text")},
//                {"km", shortCleanText("សព្វវចនាធិប្បាយសេរីសម្រាប់អ្នកទាំងអស់គ្នា។" + "នៅក្នុងវិគីភីឌាភាសាខ្មែរឥឡូវនេះមាន ១១៩៨រូបភាព សមាជិក១៥៣៣៣នាក់ និងមាន៤៥៨៣អត្ថបទ។")},
//                {"bg", shortCleanText("Европа не трябва да стартира нов конкурентен маратон и изход с приватизация")},
//                {"wa", shortCleanText("Çouchal c' est on tecse pår e walon.")},
//        };
//    }
//    private CharSequence shortCleanText(CharSequence text) {
//        return CommonTextObjectFactories.forDetectingShortCleanText().forText( text );
//    }
//
//    @DataProvider
//    protected Object[][] longerWikipediaTexts() {
//        return new Object[][] {
//                {"de", largeText(readText("/texts/de-wikipedia-Deutschland.txt"))},
//                {"fr", largeText(readText("/texts/fr-wikipedia-France.txt"))},
//                {"it", largeText(readText("/texts/it-wikipedia-Italia.txt"))},
//        };
//    }
//
//    private CharSequence readText(String path) {
//        try (InputStream inputStream = DataLanguageDetectorImplTest.class.getResourceAsStream(path)) {
//            try (BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
//                StringBuilder sb = new StringBuilder();
//                String str;
//                while ((str = in.readLine()) != null) {
//                    sb.append(str);
//                }
//                return sb.toString();
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private CharSequence largeText(CharSequence text) {
//        return CommonTextObjectFactories.forDetectingOnLargeText().forText( text );
//    }


	/**
	 * Added LLM-Generated Test Code using ChatGPT and DeepSeek
	 *
	 * @author Osama Badran
	 */
	
	//Refactored code to have it run Junit 5 from TestNG (this would be Initial Coverage Analysis before adding LLM-Generated Test)
    private static LanguageDetector shortDetector;
    private static LanguageDetector longDetector;

    @BeforeAll
    public static void setup() throws IOException {
        List<LanguageProfile> languageProfiles = new LanguageProfileReader().readAllBuiltIn();

        shortDetector = LanguageDetectorBuilder.create(NgramExtractors.standard())
                .shortTextAlgorithm(100)
                .withProfiles(languageProfiles)
                .build();

        longDetector = LanguageDetectorBuilder.create(NgramExtractors.standard())
                .shortTextAlgorithm(0)
                .withProfiles(languageProfiles)
                .build();
    }

    @ParameterizedTest
    @MethodSource("shortCleanTexts")
    public void shortTextAlgo(String expectedLanguage, CharSequence text) {
        assertEquals(expectedLanguage, shortDetector.getProbabilities(text).get(0).getLocale().getLanguage());
    }

    @ParameterizedTest
    @MethodSource("shortCleanTexts")
    public void longTextAlgoWorkingOnShortText(String expectedLanguage, CharSequence text) {
        assertEquals(expectedLanguage, longDetector.getProbabilities(text).get(0).getLocale().getLanguage());
    }

    @ParameterizedTest
    @MethodSource("longerWikipediaTexts")
    public void longTextAlgoWorkingOnLongText(String expectedLanguage, CharSequence text) {
        assertEquals(expectedLanguage, longDetector.getProbabilities(text).get(0).getLocale().getLanguage());
        assertEquals(expectedLanguage, longDetector.detect(text).get().getLanguage());
    }

    private static Stream<Arguments> shortCleanTexts() {
        return Stream.of(
                Arguments.of("en", shortCleanText("This is some English text.")),
                Arguments.of("fr", shortCleanText("Ceci est un texte français.")),
                Arguments.of("nl", shortCleanText("Dit is een Nederlandse tekst.")),
                Arguments.of("de", shortCleanText("Dies ist eine deutsche Text")),
                Arguments.of("km", shortCleanText("សព្វវចនាធិប្បាយសេរីសម្រាប់អ្នកទាំងអស់គ្នា។" +
                        "នៅក្នុងវិគីភីឌាភាសាខ្មែរឥឡូវនេះមាន ១១៩៨រូបភាព សមាជិក១៥៣៣៣នាក់ និងមាន៤៥៨៣អត្ថបទ។")),
                Arguments.of("bg", shortCleanText("Европа не трябва да стартира нов конкурентен маратон и изход с приватизация")),
                Arguments.of("wa", shortCleanText("Çouchal c' est on tecse pår e walon."))
        );
    }

    private static CharSequence shortCleanText(CharSequence text) {
        return CommonTextObjectFactories.forDetectingShortCleanText().forText(text);
    }

    private static Stream<Arguments> longerWikipediaTexts() {
        return Stream.of(
                Arguments.of("de", largeText(readText("/texts/de-wikipedia-Deutschland.txt"))),
                Arguments.of("fr", largeText(readText("/texts/fr-wikipedia-France.txt"))),
                Arguments.of("it", largeText(readText("/texts/it-wikipedia-Italia.txt")))
        );
    }

    private static CharSequence readText(String path) {
        try (InputStream inputStream = DataLanguageDetectorImplTest.class.getResourceAsStream(path);
             BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            StringBuilder sb = new StringBuilder();
            String str;
            while ((str = in.readLine()) != null) {
                sb.append(str);
            }
            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static CharSequence largeText(CharSequence text) {
        return CommonTextObjectFactories.forDetectingOnLargeText().forText(text);
    }
    
    //New added test cases for LLM-Generated Test Improvement
    
    @ParameterizedTest
    @MethodSource("additionalShortCleanTexts")
    @DisplayName("Test additional short clean texts for multiple languages")
    public void testAdditionalShortCleanTexts(String expectedLanguage, CharSequence text) {
        assertEquals(expectedLanguage, shortDetector.getProbabilities(text).get(0).getLocale().getLanguage());
    }

    @ParameterizedTest
    @MethodSource("additionalShortCleanTexts")
    @DisplayName("Test long text algorithm on additional short clean texts")
    public void testLongTextAlgoOnAdditionalShortTexts(String expectedLanguage, CharSequence text) {
        assertEquals(expectedLanguage, longDetector.getProbabilities(text).get(0).getLocale().getLanguage());
    }

    @ParameterizedTest
    @MethodSource("additionalLongerWikipediaTexts")
    @DisplayName("Test long text algorithm on additional longer texts")
    public void testLongTextAlgoOnAdditionalLongTexts(String expectedLanguage, CharSequence text) {
        assertEquals(expectedLanguage, longDetector.getProbabilities(text).get(0).getLocale().getLanguage());
        assertEquals(expectedLanguage, longDetector.detect(text).get().getLanguage());
    }

    // Additional test data for multiple languages
    private static Stream<Arguments> additionalShortCleanTexts() {
        return Stream.of(
                Arguments.of("es", shortCleanText("Este es un texto en español.")),
                Arguments.of("it", shortCleanText("Questo è un testo in italiano.")),
                Arguments.of("ja", shortCleanText("これは日本語のテキストです。")),
                Arguments.of("ru", shortCleanText("Это русский текст.")),
                Arguments.of("zh", shortCleanText("这是一段中文文本。")),
                Arguments.of("ar", shortCleanText("هذا نص باللغة العربية.")),
                Arguments.of("tr", shortCleanText("Bu bir Türkçe metindir.")),
                Arguments.of("pt", shortCleanText("Este é um texto em português."))
        );
    }

    private static Stream<Arguments> additionalLongerWikipediaTexts() {
        return Stream.of(
                Arguments.of("es", largeText(readText("/texts/es-wikipedia-Spain.txt"))),
                Arguments.of("it", largeText(readText("/texts/it-wikipedia-Italy.txt"))),
                Arguments.of("ja", largeText(readText("/texts/ja-wikipedia-Japan.txt"))),
                Arguments.of("ru", largeText(readText("/texts/ru-wikipedia-Russia.txt"))),
                Arguments.of("zh", largeText(readText("/texts/zh-wikipedia-China.txt"))),
                Arguments.of("ar", largeText(readText("/texts/ar-wikipedia-Arabic.txt"))),
                Arguments.of("tr", largeText(readText("/texts/tr-wikipedia-Turkey.txt"))),
                Arguments.of("pt", largeText(readText("/texts/pt-wikipedia-Portugal.txt")))
        );
    }

    
    

}
