import config.AppConfig;
import stats.StatsMode;

import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        AppConfig config = new AppConfig();

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-0":
                    if (i + 1 < args.length) {
                        config.setOutputDirection(Paths.get(args[i++]));
                    } else {
                        System.err.println("Error: missing output direction");
                    }
                    break;

                case "-p":
                    if (i + 1 < args.length) {
                        config.setPrefix(args[i++]);
                    } else {
                        System.err.println("Error: missing prefix");
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
                        System.err.println("Error: unknown option: " + args[i]);
                    }
            }
        }

        if(config.getInputFiles().isEmpty()) {
            System.err.println("Error: no input files specified");
        }


    }


}
