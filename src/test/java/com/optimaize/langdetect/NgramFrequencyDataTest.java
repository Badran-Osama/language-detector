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

import com.google.common.collect.ImmutableSet;
import com.optimaize.langdetect.i18n.LdLocale;
import com.optimaize.langdetect.profiles.LanguageProfile;
import com.optimaize.langdetect.profiles.LanguageProfileReader;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Some rudimentary tests for NgramFrequencyData.
 *
 * @author Fabian Kessler
 */
public class NgramFrequencyDataTest {

//	private static NgramFrequencyData allThreeGrams;
//
//	@BeforeClass
//	public static void init() throws IOException {
//		allThreeGrams = forAll(3);
//	}
//
//	private static NgramFrequencyData forAll(int gramSize) throws IOException {
//		List<LanguageProfile> languageProfiles = new LanguageProfileReader().readAllBuiltIn();
//		return NgramFrequencyData.create(languageProfiles, ImmutableSet.of(gramSize));
//	}
//
//
//	@Test
//	public void size() throws Exception {
//		//update the number when adding built-in languages
//		assertEquals(allThreeGrams.getLanguageList().size(), 71);
//	}
//
//	@Test
//	public void constantOrder() throws Exception {
//		//expect constant order:
//		int pos=0;
//		for (LdLocale locale : allThreeGrams.getLanguageList()) {
//			assertEquals(allThreeGrams.getLanguage(pos), locale);
//			pos++;
//		}
//	}
//
//	@Test
//	public void expectGram() throws Exception {
//		//this must exist in many languages
//		double[] probabilities = allThreeGrams.getProbabilities("dam");
//		assert probabilities != null;
//		assertTrue(probabilities.length >= 5 && probabilities.length <= allThreeGrams.getLanguageList().size());
//	}
//
//	@Test
//	public void forbidGramOfWrongSize() throws Exception {
//		//we said 3-grams, not 2 grams
//		assertEquals(allThreeGrams.getProbabilities("da"), null);
//	}

    
	/**
	 * Added LLM-Generated Test Code using ChatGPT and DeepSeek
	 *
	 * @author Osama Badran
	 */
	
	
//    private static NgramFrequencyData allThreeGrams;
//
//    @BeforeClass
//    public static void init() throws IOException {
//        allThreeGrams = forAll(3);
//    }
//
//    private static NgramFrequencyData forAll(int gramSize) throws IOException {
//        List<LanguageProfile> languageProfiles = new LanguageProfileReader().readAllBuiltIn();
//        return NgramFrequencyData.create(languageProfiles, ImmutableSet.of(gramSize));
//    }
//
//    @Test
//    public void size() throws Exception {
//        // Update the number when adding built-in languages
//        assertEquals(71, allThreeGrams.getLanguageList().size());
//    }
//
//    @Test
//    public void constantOrder() throws Exception {
//        int pos = 0;
//        for (LdLocale locale : allThreeGrams.getLanguageList()) {
//            assertEquals(locale, allThreeGrams.getLanguage(pos));
//            pos++;
//        }
//    }
//
//    
//    
//    @Test
//    public void expectGram() throws Exception {
//        double[] probabilities = allThreeGrams.getProbabilities("dam");
//
//        // Check if the method handles unexpected null return
//        assertNotNull("Probabilities should not be null for 'dam'", probabilities);
//
//        // Check for valid probability length
//        assertTrue("Probabilities should have valid length",
//                probabilities.length >= 5 && probabilities.length <= allThreeGrams.getLanguageList().size());
//
//        // Check if returned probabilities contain at least one non-zero value
//        boolean hasNonZero = false;
//        for (double prob : probabilities) {
//            if (prob > 0) {
//                hasNonZero = true;
//                break;
//            }
//        }
//        assertTrue("Probabilities should contain at least one non-zero value", hasNonZero);
//    }
//
//    @Test
//    public void forbidGramOfWrongSize() throws Exception {
//        double[] probabilities = allThreeGrams.getProbabilities("da");
//
//        // Ensure method returns null for wrong-sized grams
//        assertNull("Expected null for non-3-gram input", probabilities);
//    }
//	
//	
//
//    //LLM manual Fix
//    @Test
//    public void testEmptyString() {
//        double[] probabilities = allThreeGrams.getProbabilities("");
//        assertNull("Expected null for empty string input", probabilities);
//    }
//
//    @Test
//    public void testWhitespaceOnly() {
//        double[] probabilities = allThreeGrams.getProbabilities("   ");
//        assertNull("Expected null for whitespace-only input", probabilities);
//    }
//
//    @Test
//    public void testSpecialCharacters() {
//        double[] probabilities = allThreeGrams.getProbabilities("!@#$%");
//        assertNull("Expected null for special characters", probabilities);
//    }
//
//    @Test
//    public void testNonLatinScripts() {
//        double[] probabilities = allThreeGrams.getProbabilities("你好"); // Chinese characters
//        assertNull("Expected null for non-Latin script input", probabilities);
//    }
    
	/**
	 * Added Manually Test Improvement
	 *
	 * @author Osama Badran
	 */
    
	private static NgramFrequencyData allThreeGrams;

	@BeforeClass
	public static void init() throws IOException {
		allThreeGrams = forAll(3);
	}

	private static NgramFrequencyData forAll(int gramSize) throws IOException {
		List<LanguageProfile> languageProfiles = new LanguageProfileReader().readAllBuiltIn();
		return NgramFrequencyData.create(languageProfiles, ImmutableSet.of(gramSize));
	}


	@Test
	public void size() throws Exception {
		//update the number when adding built-in languages
		assertEquals(allThreeGrams.getLanguageList().size(), 71);
	}

	@Test
	public void constantOrder() throws Exception {
		//expect constant order:
		int pos=0;
		for (LdLocale locale : allThreeGrams.getLanguageList()) {
			assertEquals(allThreeGrams.getLanguage(pos), locale);
			pos++;
		}
	}

	@Test
	public void expectGram() throws Exception {
		//this must exist in many languages
		double[] probabilities = allThreeGrams.getProbabilities("dam");
		assert probabilities != null;
		assertTrue(probabilities.length >= 5 && probabilities.length <= allThreeGrams.getLanguageList().size());
		
		
	}

	@Test
	public void forbidGramOfWrongSize() throws Exception {
		//we said 3-grams, not 2 grams
		assertEquals(allThreeGrams.getProbabilities("da"), null);
	}


}
