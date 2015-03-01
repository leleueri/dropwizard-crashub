import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.github.leleueri.dw.crash.CrashShellBundle;

/**
 * Created by eric on 01/03/15.
 */
public class HelloApplication extends Application<CrashConfiguration>  {

    @Override
    public void run(CrashConfiguration configuration, Environment environment) throws Exception {
        environment.jersey().register(new HelloResource());
    }

    @Override
    public void initialize(Bootstrap<CrashConfiguration> bootstrap) {
        bootstrap.addBundle(new CrashShellBundle<CrashConfiguration>());
    }

    public static void main(String[] args) throws Exception {
        new HelloApplication().run(args);
    }
}
