package app;

import config.AppConfig;
import model.StatsMode;
import service.FilterService;

import java.nio.file.Paths;

public class Runner {

    public AppConfig parseArgs(String[] args) {
        AppConfig config = new AppConfig();
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-o":
                    if (i + 1 < args.length) {
                        config.setOutputDirection(Paths.get(args[i + 1]));
                        i++;
                    } else {
                        throw new IllegalArgumentException("Missing output directory");
                    }
                    break;

                case "-p":
                    if (i + 1 < args.length) {
                        config.setPrefix(args[i+1]);
                        i++;
                    } else {
                        throw new IllegalArgumentException("Missing prefix after -p");
                    }
                    break;

                case "-a":
                    config.setAppendMode(true);
                    break;

                case "-f":
                    config.setStatsMode(StatsMode.FULL);
                    break;

                case "-s":
                    config.setStatsMode(StatsMode.SHORT);
                    break;

                default:
                    if(!args[i].startsWith("-")) {
                        config.addInputFile(Paths.get(args[i]));
                    } else {
                        throw new IllegalArgumentException("Unknown option: " + args[i]);
                    }
            }
        }

        if(config.getInputFiles().isEmpty()) {
            throw new IllegalArgumentException("No input files specified");
        }
        return config;
    }

    public void run(String[] args) {
        FilterService service = new FilterService();
        service.run(parseArgs(args));
    }
}
