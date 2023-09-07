package Tarea6;
import com.sun.speech.freetts.*;


import java.io.File;


public class TextToSpeech {

    public static void main(String[] args) {
        System.out.println("Ingrese el texto que desea convertir en sonido:");
        String texto = System.console().readLine();
        
        generarSonidoDesdeTexto(texto);
    }

    public static void generarSonidoDesdeTexto(String texto) {
        // Crea una voz
        Voice voz = getVoice();

        // Inicializa la voz
        voz.allocate();

        // Genera el audio a partir del texto
        voz.speak(texto);

        // Libera la voz
        voz.deallocate();
    }

    private static Voice getVoice() {
        // Define la ruta a las voces de FreeTTS
        String rutaVoces = "C:\\Users\\New\\OneDrive - Universidad Autonoma de Coahuila\\Workspace 818\\Java\\Bibliotecas\\freetts-1.2.2-bin\\freetts-1.2\\lib\\freetts\\voices";
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        System.setProperty("mbrola.base", rutaVoces + File.separator + "mbrola");

        VoiceManager voiceManager = VoiceManager.getInstance();
        return voiceManager.getVoice("kevin16");
    }
}

