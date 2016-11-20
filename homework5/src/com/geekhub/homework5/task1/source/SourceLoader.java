package com.geekhub.homework5.task1.source;

import java.util.ArrayList;
import java.util.List;

/**
 * SourceLoader should contain all implementations of SourceProviders to be able to load different sources.
 */
public class SourceLoader {
    private List<SourceProvider> sourceProviders = new ArrayList<>();

    public SourceLoader() {
        this.sourceProviders.add(new FileSourceProvider());
        this.sourceProviders.add(new URLSourceProvider());
    }

    public String loadSource(String pathToSource) throws SourceLoadingException {
        for (SourceProvider sourceProvider : sourceProviders) {
            if (sourceProvider.isAllowed(pathToSource)) {
                return sourceProvider.load(pathToSource);
            }
        }
        throw new SourceLoadingException("Path to source is invalid!");
    }
}
