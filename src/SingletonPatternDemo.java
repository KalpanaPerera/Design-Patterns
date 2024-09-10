class Logger {
    private static Logger instance; // Private static variable for the single instance

    private Logger() {

    } // Private constructor to prevent object creation using 'new'

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger(); // Create the instance if it doesn't exist
        }
        return instance;
    }

    public void log(String message) {

        System.out.println("Log: " + message); // Log the message
    }
}

class SingletonPatternDemo {

    public static void main(String[] args) {
        Logger logger = Logger.getInstance(); // Get the instance of the Logger

        logger.log("This is the first log message.");
        logger.log("This is another log message.");

    }
}
