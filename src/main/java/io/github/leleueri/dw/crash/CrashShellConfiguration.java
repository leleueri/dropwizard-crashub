package io.github.leleueri.dw.crash;

import io.dropwizard.Configuration;

/**
 * Created by eric on 05/02/15.
 */
public interface CrashShellConfiguration<T extends Configuration>  {
    CrashShellFactory getCrashShellFactory(T configuration);
}
