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

import com.optimaize.langdetect.frma.LangProfileReader;
import com.optimaize.langdetect.cybozu.util.LangProfile;
import com.google.common.collect.ImmutableList;
import com.optimaize.langdetect.ngram.NgramExtractors;
import com.optimaize.langdetect.profiles.LanguageProfile;
import com.optimaize.langdetect.profiles.LanguageProfileReader;
import com.optimaize.langdetect.profiles.OldLangProfileConverter;
import com.optimaize.langdetect.text.*;

import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


//added with for LLM test case
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.*;


/**
 * Basic tests for the LanguageDetectorImpl.
 *
 * @author Fabian Kessler
 */
public class LanguageDetectorImplTest {

	//    @Test(dataProvider = "confident")
	//    public void confident(String expectedLanguage, CharSequence text) throws Exception {
	//        LanguageDetector languageDetector = makeNewDetector();
	//        List<DetectedLanguage> result = languageDetector.getProbabilities(text);
	//        DetectedLanguage best = result.get(0);
	//        assertEquals(best.getLocale().getLanguage(), expectedLanguage);
	//        assertTrue(best.getProbability() >= 0.9999d);
	//    }
	//    @DataProvider
	//    protected Object[][] confident() {
	//        return new Object[][] {
	//                {"de", "Dies ist eine deutsche Text"},
	//                {"de", "deutsche Text"},
	//                {"de", CommonTextObjectFactories.forDetectingOnLargeText().create().append("deutsche Text").append(" ").append("http://www.github.com/")},
	//        };
	//    }
	//
	//
	//    private LanguageDetector makeNewDetector() throws IOException {
	//        LanguageDetectorBuilder builder = LanguageDetectorBuilder.create(NgramExtractors.standard())
	//            .shortTextAlgorithm(50)
	//            .prefixFactor(1.5)
	//            .suffixFactor(2.0);
	//
	//        LangProfileReader langProfileReader = new LangProfileReader();
	//        for (String language : ImmutableList.of("en", "fr", "nl", "de")) {
	//            LangProfile langProfile = langProfileReader.read(LanguageDetectorImplTest.class.getResourceAsStream("/languages/" + language));
	//            LanguageProfile languageProfile = OldLangProfileConverter.convert(langProfile);
	//            builder.withProfile(languageProfile);
	//        }
	//
	//        return builder.build();
	//    }
	//    

	/**
	 * Added LLM-Generated Test Code using ChatGPT and DeepSeek
	 *
	 * @author Osama Badran
	 */



	//	//Refactored code to have it run Junit 5 from TestNG (this would be Initial Coverage Analysis before adding LLM-Generated Test)
	//
	//
	//
	//    private static LanguageDetector languageDetector;
	//
	//
	//    @BeforeAll
	//    public static void setup() throws IOException {
	//        languageDetector = makeNewDetector();
	//    }
	//    
	//
	//    @ParameterizedTest
	//    @MethodSource("confident")
	//    public void confident(String expectedLanguage, CharSequence text) {
	//        List<DetectedLanguage> result = languageDetector.getProbabilities(text);
	//        assertFalse(result.isEmpty(), "No language detected.");
	//        DetectedLanguage best = result.get(0);
	//        assertEquals(expectedLanguage, best.getLocale().getLanguage());
	//        assertTrue(best.getProbability() >= 0.9999d, "`should be high.");
	//    }
	//
	//    public static Stream<Object[]> confident() {
	//        return Stream.of(
	//                new Object[]{"de", "Dies ist eine deutsche Text"},
	//                new Object[]{"de", "deutsche Text"},
	//                new Object[]{"de", CommonTextObjectFactories.forDetectingOnLargeText().create().append("deutsche Text").append(" ").append("http://www.github.com/")}
	//        );
	//    }
	//
	//    private static LanguageDetector makeNewDetector() throws IOException {
	//        LanguageDetectorBuilder builder = LanguageDetectorBuilder.create(NgramExtractors.standard())
	//            .shortTextAlgorithm(50)
	//            .prefixFactor(1.5)
	//            .suffixFactor(2.0);
	//
	//        LangProfileReader langProfileReader = new LangProfileReader();
	//        for (String language : ImmutableList.of("en", "fr", "nl", "de")) {
	//            LangProfile langProfile = langProfileReader.read(LanguageDetectorImplTest.class.getResourceAsStream("/languages/" + language));
	//            LanguageProfile languageProfile = OldLangProfileConverter.convert(langProfile);
	//            builder.withProfile(languageProfile);
	//        }
	//
	//        return builder.build();
	//    }
	//    
	//    
	//New added test cases for LLM-Generated Test Improvement

	//    private static LanguageDetector languageDetector;
	//
	//    @BeforeAll
	//    public static void setup() throws IOException {
	//        languageDetector = makeNewDetector();
	//    }
	//    
	//    @ParameterizedTest
	//    @MethodSource("confident")
	//    public void confident(String expectedLanguage, CharSequence text) {
	//        List<DetectedLanguage> result = languageDetector.getProbabilities(text);
	//        assertFalse(result.isEmpty(), "No language detected.");
	//        DetectedLanguage best = result.get(0);
	//        assertEquals(expectedLanguage, best.getLocale().getLanguage());
	//        assertTrue(best.getProbability() >= 0.9999d, "Probability should be high.");
	//    }
	//
	//    public static Stream<Object[]> confident() {
	//        return Stream.of(
	//                new Object[]{"de", "Dies ist eine deutsche Text"},
	//                new Object[]{"de", "deutsche Text"},
	//                new Object[]{"de", CommonTextObjectFactories.forDetectingOnLargeText().create().append("deutsche Text").append(" ").append("http://www.github.com/")}
	//        );
	//    }
	//
	//    @ParameterizedTest(name = "Test confident detection for \"{1}\"")
	//    @MethodSource("confidentTextProvider")
	//    @DisplayName("Test confident language detection")
	//    void testConfidentDetection(String expectedLanguage, CharSequence text) {
	//        List<DetectedLanguage> result = languageDetector.getProbabilities(text);
	//
	//        if (text == null || text.length() == 0) {
	//            // Branch 1: Null or empty text
	//            assertTrue(result.isEmpty(), "Expected no detection for empty/null text");
	//        } else if (expectedLanguage == null || expectedLanguage.isEmpty()) {
	//            // Branch 2: Unrecognized or ambiguous text
	//            if (!result.isEmpty()) {
	//                DetectedLanguage best = result.get(0);
	//                assertTrue(best.getProbability() < 0.5, 
	//                           "Probability should be low for ambiguous text: " + text);
	//            }
	//        } else {
	//            // Branch 3: Confident language detection
	//            assertFalse(result.isEmpty(), "No languages detected for text: " + text);
	//            DetectedLanguage best = result.get(0);
	//            assertEquals(expectedLanguage, best.getLocale().getLanguage(),
	//                         "Detected language mismatch for text: " + text);
	//            assertTrue(best.getProbability() >= 0.9999d,
	//                       "Probability too low for text: " + text);
	//        }
	//    }
	//
	//    //LLM manual fix 
	//    private static Stream<Arguments> confidentTextProvider() {
	//        return Stream.of(
	//            // Edge Cases for Full Branch Coverage
	//            Arguments.of("", ""),  // Edge case: Empty input
	//            Arguments.of(null, null),  // Edge case: Null input
	//            Arguments.of("", "     "),  // Whitespace only
	//            Arguments.of("", "????"),  // Ambiguous text
	//            Arguments.of("", "1234567890"),  // Numbers-only input
	//            Arguments.of("", "@#$%^&*()"),  // Symbols-only input
	//            
	//
	//            Arguments.of("en", "HELLO"),  // Case sensitivity test
	//            Arguments.of("en", "Hello there!"),  // Normal English text
	//            Arguments.of("en", "What are you doing?"),  // Question text
	//            Arguments.of("en", "The quick brown fox jumps over the lazy dog"),  // Sentence with all English letters
	//            Arguments.of("en", "Hi"),  // Very short English word
	//
	//            Arguments.of("fr", "Bonjour, comment allez-vous?"),  // French detection
	//            Arguments.of("fr", "C'est un bon jour!"),  // French with apostrophe
	//
	//            Arguments.of("zh", "你好，世界"),  // Chinese detection
	//            Arguments.of("ar", "مرحبا بالعالم"),  // Arabic detection
	//            Arguments.of("ru", "Привет, мир"),  // Russian (Cyrillic)
	//
	//            Arguments.of("fr", "Bonjour, this is a mix of French and English."),  // Mixed-language text
	//            Arguments.of("en", "Hello! 1234 @#$%^"),  // Symbols & numbers
	//            Arguments.of("en", "Hello 你好!"),  // English + Chinese mix
	//
	//            Arguments.of("es", "Hola"),  // Spanish
	//            Arguments.of("es", "¿Cómo estás?"),  // Spanish with inverted question mark
	//            Arguments.of("it", "Ciao, come va?"),  // Italian
	//            Arguments.of("nl", "Dit is een Nederlandse zin."),  // Dutch detection
	//
	//
	//
	//            // Edge case: Random letters that don’t match a known language
	//            Arguments.of("", "zxqjvbn"),  // Unrecognized language
	//            Arguments.of("", "asdfghjkl"),  // Keyboard mash
	//            Arguments.of("", "lorem ipsum dolor sit amet"),  // Latin placeholder text
	//
	//            // Edge case: Multiple equal probabilities
	//            Arguments.of("en", "The sun rises in the east. Le soleil se lève à l'est."),  // English-French mix
	//            Arguments.of("es", "Hola! Bonjour! Hello!"),  // Equal probability case
	//            Arguments.of("fr", "Bonjour, Guten Tag, Hello"),  // Similar probabilities, should return French
	//            Arguments.of("de", "Hallo! Bonjour! Hola!"),  // Similar probabilities, should return German
	//            Arguments.of("en", "Hello world! Guten Tag Welt! Bonjour le monde!"),  // Multi-language mix
	//
	//            // Edge case: Sentence with emojis (should ignore emojis)
	//            Arguments.of("en", "Hello 😊! How are you?"),
	//            Arguments.of("fr", "Bonjour 😊! Comment ça va?"),
	//            Arguments.of("es", "¡Hola 😊! ¿Qué tal?")
	//        );
	//    }
	//    
	//    
	//    private static TextObject createComplexTextObject() {
	//        return CommonTextObjectFactories.forDetectingOnLargeText()
	//                .create()
	//                .append("deutscher Text")
	//                .append(" ")
	//                .append("http://www.github.com/");
	//    }
	//
	//    
	//    //LLM manual Fix
	//    private static LanguageDetector makeNewDetector() throws IOException {
	//        // Create mock LangProfiles with valid n-grams (1-3 characters)
	//        LangProfile englishLangProfile = new LangProfile("en");
	//        addNgrams(englishLangProfile, "t", "th", "the", "an", "and");
	//
	//        LangProfile frenchLangProfile = new LangProfile("fr");
	//        addNgrams(frenchLangProfile, "l", "le", "la", "et", "bon");
	//
	//        LangProfile germanLangProfile = new LangProfile("de");
	//        addNgrams(germanLangProfile, "u", "un", "und", "is", "ist");
	//
	//        // Convert to new profile format
	//        List<LanguageProfile> profiles = Arrays.asList(
	//            OldLangProfileConverter.convert(englishLangProfile),
	//            OldLangProfileConverter.convert(frenchLangProfile),
	//            OldLangProfileConverter.convert(germanLangProfile)
	//        );
	//
	//        return LanguageDetectorBuilder.create(NgramExtractors.standard())
	//                .withProfiles(profiles)
	//                .build();
	//    }
	//
	//    // Helper method adds only valid n-grams (1-3 chars)
	//    private static void addNgrams(LangProfile profile, String... ngrams) {
	//        for (String ngram : ngrams) {
	//            if (ngram.length() < 1 || ngram.length() > 3) {
	//                throw new IllegalArgumentException("Invalid ngram length: " + ngram);
	//            }
	//            profile.add(ngram);
	//        }
	//    }
	//    
	//    






	/**
	 * Added Manually Test Improvement
	 *
	 * @author Osama Badran
	 */



	private static LanguageDetector languageDetector;


	@BeforeAll
	public static void setup() throws IOException {
		languageDetector = makeNewDetector();
	}


	@ParameterizedTest
	@MethodSource("confident")
	public void confident(String expectedLanguage, CharSequence text) {

		// Handle null inputs explicitly
		if (text == null) {
			assertThrows(NullPointerException.class, () -> languageDetector.getProbabilities(text), "Null input should throw an exception.");
			return;  // Stop further execution
		}

		
		
		List<DetectedLanguage> result = languageDetector.getProbabilities(text);
		assertFalse(result.isEmpty(), "No language detected.");
		DetectedLanguage best = result.get(0);
		
		//Manually added
		System.out.println(best.toString()  + " text " + text );


		assertTrue(best.getProbability() >= 0.9999d, "Probability should be high.");
		
	    
		assertEquals(expectedLanguage, best.getLocale().getLanguage());
	}

	public static Stream<Object[]> confident() {
		return Stream.of(
				new Object[]{"de", "Dies ist eine deutsche Text"},
				new Object[]{"de", "deutsche Text"},
				new Object[]{"de", CommonTextObjectFactories.forDetectingOnLargeText().create().append("deutsche Text").append(" ").append("http://www.github.com/")},


				//Manually added
				new Object[] {"ar", "هذا نص باللغة العربية."},
				new Object[] {"", "                                                                       "},
				new Object[] {"pr", " In the heart of Italy, tra colline verdi e città storiche, تجد أرضاً غنية بالثقافة والتقاليد. Every corner racconta una storia antica, من الأطلال الرومانية إلى الساحات العصور الوسطى. La cucina italiana, famous worldwide, offre sapori inimitabili con ingredienti freschi وحقيقية. Il suono melodico للغة italiana si mescola مع ضوضاء المرور والضحكات delle persone che يعيشون la loro vita اليومية con passione e gioia. A journey in Italy è un viaggio nel tempo, بين الفن، storia e bellezza senza fine."},
				new Object[] {null, null},
				new Object[] {"", "  2 tessings"},			
				new Object[] {"", "  2 128y3 2772s2z4"},	
				new Object[] {"", "A18"},
				new Object[] {"", "Hello"},

				new Object[] {"en", "Hello world! Guten Tag Welt! Bonjour le monde!"},
				new Object[] {"fr", "Salut, this text is mixed with English."},
				new Object[] {"nl", "Dit is een Nederlandse zin."},
				
				new Object[] {"en", "H3llo wrld ??? #$% 你好 Salut 123"},
				new Object[] {"da", "Kan u me de weg wijzen naar het station, alstublieft?"}
				

				);
	}
	
	private static LanguageDetector makeNewDetector() throws IOException {
		LanguageDetectorBuilder builder = LanguageDetectorBuilder.create(NgramExtractors.standard())
				.shortTextAlgorithm(50)
				.prefixFactor(1.5)
				.suffixFactor(2.0);

		LangProfileReader langProfileReader = new LangProfileReader();
		for (String language : ImmutableList.of("en", "fr", "nl", "de", "ar","da")) {
			LangProfile langProfile = langProfileReader.read(LanguageDetectorImplTest.class.getResourceAsStream("/languages/" + language));
			LanguageProfile languageProfile = OldLangProfileConverter.convert(langProfile);
			builder.withProfile(languageProfile);
		}

		return builder.build();
	}





}
