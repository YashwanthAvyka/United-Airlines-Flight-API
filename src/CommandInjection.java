import java.io.IOException;

public class CommandInjection {
    public void executeCommand(String command) throws IOException {
        // Vulnerable line: user input is used as part of a system command
        Runtime.getRuntime().exec("ping " + command);
        System.out.println("Executed ping command: ping " + command);
    }
}
