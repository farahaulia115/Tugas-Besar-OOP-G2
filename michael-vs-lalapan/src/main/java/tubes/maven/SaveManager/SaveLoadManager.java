package tubes.maven.SaveManager;

import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tubes.maven.State.GameState;

public class SaveLoadManager {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void saveGameState(GameState gameState, String fileName) throws IOException {
        File file = new File(fileName);
        File parentDir = file.getParentFile();

        // Membuat direktori jika belum ada
        if (parentDir != null && !parentDir.exists()) {
            if (!parentDir.mkdirs()) {
                throw new IOException("Failed to create directory: " + parentDir);
            }
        }
        // Menulis nilai ke file JSON
        try {
            
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, gameState);
            System.out.println("Data has been saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Data failed to save to " + fileName);
        }
    }

    public static GameState loadGameState(String fileName) throws IOException {
        return objectMapper.readValue(new File(fileName), GameState.class);
    }
}
