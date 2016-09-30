package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.FileName;
import com.infoedge.jrandomizer.providers.FileNameProvider;
import com.infoedge.jrandomizer.providers.ProviderFactory;

/**
 * Created by gagandeep on 31/7/16.
 */

public class FileNameGenerator extends GenerationRule<FileName,String> {

    private FileNameProvider mProvider;
    private FileName.Types types;
    private FileName.Format format;

    public FileNameGenerator(FileName annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        types = annotation.types();
        format = annotation.format();
        mProvider = providerFactory().provider(FileNameProvider.class, FileNameProvider.FileNameData.class);
    }

    @Override
    public String generate() {
        FileNameProvider.FileNameData fileNameData = mProvider.provide();
        String randomFileName = randomFileName(fileNameData, format);
        String randomFileExtension = fileTypesExtension(types, fileNameData.extensions);
        return String.format("%s%s", randomFileName, randomFileExtension);
    }

    private String fileTypesExtension(FileName.Types types, FileNameProvider.Extensions extensionsData) {
        String[] extensions = null;
        switch (types) {
            case ALL:
                extensions = extensionsData.all;
                break;
            case COMMON:
                extensions = extensionsData.common;
                break;
            case CODE:
                extensions = extensionsData.code;
                break;
            case DOCUMENT:
                extensions = extensionsData.document;
                break;
            case IMAGE:
                extensions = extensionsData.image;
                break;
            case MEDIA:
                extensions = extensionsData.media;
                break;
            case TEXT:
                extensions = extensionsData.text;
                break;
        }
        int randomIndex = getRandom().nextInt(extensions.length);
        return extensions[randomIndex];
    }

    private String randomFileName(FileNameProvider.FileNameData fileNameData, FileName.Format format) {
        int randomIndex = getRandom().nextInt(fileNameData.fileNames.length);
        String fileName = fileNameData.fileNames[randomIndex];
        return formatFileName(fileName, format);
    }

    private String formatFileName(String fileName, FileName.Format format) {
        if (format == FileName.Format.RANDOM) {
            format = FileName.Format.values()[getRandom().nextInt(FileName.Format.values().length)];
        }
        switch (format) {
            case file_name:
                return fileName.toLowerCase().replaceAll(" ", "_");
            case fileName:
                return firstLetterLower(fileName).replaceAll(" ", "");
            case FileName:
                return fileName.replaceAll(" ", "");
        }
        return fileName;
    }

    private String firstLetterLower(String name) {
        if (name.length() == 1) {
            return name.toLowerCase();
        } else {
            return name.substring(0, 1).toLowerCase() + name.substring(1);
        }
    }
}
