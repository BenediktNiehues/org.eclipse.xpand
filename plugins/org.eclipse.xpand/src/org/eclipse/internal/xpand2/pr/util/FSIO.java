/*
 * <copyright>
 *
 * Copyright (c) 2005-2006 Sven Efftinge (http://www.efftinge.de) and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sven Efftinge (http://www.efftinge.de) - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.internal.xpand2.pr.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class FSIO {
    private static final char[] FILE_DELIMITER = { '\\', '/' };

    private static int cvNumerOfFilesRead = 1;

    private static int cvSize = 2000;

    private static void getAllFilesInternal(final File aPath, final FilenameFilter aFilter, final List<File> aList) {
        final File[] allFiles = aPath.listFiles(aFilter);
        for (int i = 0; i < allFiles.length; i++) {
            if (allFiles[i].isDirectory())
                getAllFilesInternal(allFiles[i], aFilter, aList);
            else
                aList.add(allFiles[i]);
        }
    }

    public static String readSingleFile(final String aFilePath) throws IOException {
        if (aFilePath == null)
            throw new IllegalArgumentException("Fileparameter should not be null!");
        return readSingleFile(new File(aFilePath), null);
    }

    public static String readSingleFile(final File aFile, final String fileEncoding) throws IOException {
        if (aFile == null)
            throw new IllegalArgumentException("Fileparameter should not be null!");

        if (!aFile.isFile())
            throw new IOException(aFile.getPath() + " is not a file!");
        if (!aFile.canRead())
            throw new IOException(aFile.getPath() + " is not a readable!");

        final StringBuffer aString = new StringBuffer();
        Reader aFileReader = null;
        {
            if (fileEncoding == null) {
                aFileReader = new FileReader(aFile);
            } else {
                aFileReader = new InputStreamReader(new FileInputStream(aFile), fileEncoding);
            }
        }
        final int size = (int) Math.floor((double) cvSize / (double) cvNumerOfFilesRead);
        cvNumerOfFilesRead++;
        final char[] chars = new char[size];
        int len;
        while ((len = aFileReader.read(chars)) != -1) {
            cvSize += len;
            aString.append(chars, 0, len);
        }
        aFileReader.close();

        return aString.toString();
    }

    /**
     * 
     * @param aReader
     * @return
     * @throws IOException
     * @since 4.2
     */
    public static String readSingleFile(final Reader aReader) throws IOException {
        if (aReader == null)
            throw new IllegalArgumentException("Reader must not be null!");

        final StringBuffer aString = new StringBuffer();

        final int size = (int) Math.floor((double) cvSize / (double) cvNumerOfFilesRead);
        cvNumerOfFilesRead++;
        final char[] chars = new char[size];
        int len;
        while ((len = aReader.read(chars)) != -1) {
            cvSize += len;
            aString.append(chars, 0, len);
        }
        aReader.close();

        return aString.toString();
    }
    
    /**
     * 
     * @param aWriter
     * @param text
     * @throws IOException
     * @since 4.2
     */
    public static void writeSingleFile (final Writer aWriter, CharSequence text) throws IOException {
        if (aWriter == null)
            throw new IllegalArgumentException("Reader must not be null!");

        StringReader reader = new StringReader(text.toString());
        writeSingleFile(aWriter, reader);
    }
    
    /**
     * 
     * @param aWriter
     * @param text
     * @throws IOException
     * @since 4.2
     */
    public static void writeSingleFile (final Writer aWriter, Reader aReader) throws IOException {
        if (aWriter == null)
            throw new IllegalArgumentException("Reader must not be null!");

        final char[] chars = new char[4096];
        int len;
        while ((len = aReader.read(chars)) != -1) {
            cvSize += len;
            aWriter.write(chars, 0, len);
        }
        aReader.close();
        aWriter.close();
    }

    public static File[] getAllFiles(final File aPath, final FilenameFilter aFilter) throws IOException {
        if (!aPath.isDirectory())
            throw new IOException(aPath.getPath() + " is not a directory!");
        final List<File> returnList = new ArrayList<File>();
        getAllFilesInternal(aPath, aFilter, returnList);
        return returnList.toArray(new File[returnList.size()]);
    }

    public static File[] getAllFiles(final String aBasePath, final FilenameFilter aFilter) throws IOException {
        return getAllFiles(new File(aBasePath), aFilter);
    }

    public static String normalizePath(String aFileName) {
        for (int i = 0; i < FILE_DELIMITER.length; i++) {
            aFileName = aFileName.replace(FILE_DELIMITER[i], File.separatorChar);
        }
        return aFileName;
    }
}
