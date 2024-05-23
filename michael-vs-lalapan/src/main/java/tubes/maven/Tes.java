package tubes.maven;

import tubes.maven.Input.InputHandler;

public class Tes {
    public static void main(String[] args) {
        String userInput = InputHandler.getStringInput("Masukkan nama pengguna: ");
        System.out.println("Nama pengguna yang dimasukkan: " + userInput);
    }
}
