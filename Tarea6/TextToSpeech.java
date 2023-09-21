package Tarea6;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class TextToSpeech {

    public static void Reproucir(String string) {
        com.sun.javafx.application.PlatformImpl.startup(() -> {
        }); 
        String ruta= "C:\\Users\\New\\OneDrive - Universidad Autonoma de Coahuila\\Workspace 818\\Java\\Escuela\\AlgoritmosDeOrdenacion\\sonidos\\"+string+".mp3";
        final String NOMBRE_ARCHIVO = ruta;
        File archivo = new File(NOMBRE_ARCHIVO);
        Media audio = new Media(archivo.toURI().toString());
        MediaPlayer reproductor = new MediaPlayer(audio);
        
        try {
            reproductor.play();
            Thread.sleep(1500);
        } catch (InterruptedException e) {
           
        }
    }

    public static void main(String[] args) {
        TextToSpeech.Reproucir("cien");
    }
}