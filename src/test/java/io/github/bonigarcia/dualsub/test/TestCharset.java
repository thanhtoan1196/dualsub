/*
 * (C) Copyright 2014 Boni Garcia (http://bonigarcia.github.io/)
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package io.github.bonigarcia.dualsub.test;

import io.github.bonigarcia.dualsub.util.Charset;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

/**
 * TestCharset.
 * 
 * @author Boni Garcia (boni.gg@gmail.com)
 * @since 1.0.0
 */
public class TestCharset {

	private static final Logger log = LoggerFactory
			.getLogger(TestCharset.class);

	@Ignore
	@Test
	public void testCharsetGoT() throws IOException, SAXException {
		String gotEnFile = "Game of Thrones 1x01 - Winter Is Coming (English).srt";
		String gotEsFile = "Game of Thrones 1x01 - Winter Is Coming (Spanish).srt";

		InputStream isEsFile = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(gotEsFile);
		InputStream isEnFile = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(gotEnFile);

		log.info(Charset.detect(isEnFile));
		Assert.assertEquals(Charset.UTF8, Charset.detect(isEnFile));
		log.info(Charset.detect(isEsFile));
		Assert.assertEquals(Charset.ISO88591, Charset.detect(isEsFile));
	}

	@Ignore
	@Test
	public void testCharsetBB() throws IOException, SAXException {
		String bbEn = "Breaking Bad 5x09 - Blood Money (English).srt";
		String bbEs = "Breaking Bad 5x09 - Blood Money (Spanish).srt";

		InputStream isEsFile = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(bbEs);
		InputStream isEnFile = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(bbEn);

		log.info(Charset.detect(isEnFile));
		Assert.assertEquals(Charset.UTF8, Charset.detect(isEnFile));
		log.info(Charset.detect(isEsFile));
		Assert.assertEquals(Charset.ISO88591, Charset.detect(isEsFile));
	}

	@Ignore
	@Test
	public void testCharsetSH() throws IOException {
		String fileStr1 = "Sherlock 3x01 - The Empty Hearse (English).srt";
		String fileStr2 = "Sherlock 3x01 - The Empty Hearse (Español (España)).srt";

		log.info(Charset.detect(fileStr1));
		log.info(Charset.detect(fileStr2));
	}
}
