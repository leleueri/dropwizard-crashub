package io.github.leleueri.dw.crash;

import io.dropwizard.Configuration;
import io.dropwizard.ConfiguredBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**>
 * Created by eric on 05/02/15.
 */
public class CrashShellBundle<T extends Configuration> implements ConfiguredBundle<T> {

    @Override
    public void run(T configuration, Environment environment) throws Exception {
        CrashShellFactory factory = new CrashShellFactory();
        if (configuration instanceof CrashShellConfiguration) {
            CrashShellFactory tmp = ((CrashShellConfiguration)configuration).getCrashShellFactory(configuration);
            if (tmp != null) factory = tmp;
        }
        factory.build(environment);
    }

    @Override
    public void initialize(Bootstrap<?> bootstrap) {
        // nothing doing ?
    }

}
