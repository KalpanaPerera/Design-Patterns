interface MediaPlayer {
    void play(String audioType, String fileName);
}

// New AdvancedMediaPlayer interface
interface AdvancedMediaPlayer {
    void playMkv(String fileName);
    void playMp4(String fileName);
}

// Implementation of AdvancedMediaPlayer for MKV
class MkvPlayer implements AdvancedMediaPlayer {
    @Override
    public void playMkv(String fileName) {
        System.out.println("Playing mkv file. Name: " + fileName);
    }

    @Override
    public void playMp4(String fileName) {
    }
}

// Implementation of AdvancedMediaPlayer for MP4
class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playMkv(String fileName) {
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: " + fileName);
    }
}

// Adapter class implementing MediaPlayer and using AdvancedMediaPlayer
class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer advancedMusicPlayer;

    public MediaAdapter(String audioType) {
        if(audioType.equalsIgnoreCase("mkv")) {
            advancedMusicPlayer = new MkvPlayer();
        } else if(audioType.equalsIgnoreCase("mp4")) {
            advancedMusicPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("mkv")) {
            advancedMusicPlayer.playMkv(fileName);
        } else if(audioType.equalsIgnoreCase("mp4")) {
            advancedMusicPlayer.playMp4(fileName);
        }
    }
}

// Implementation of MediaPlayer using the adapter
class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {
        // Playing mp3 files directly
        if(audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3 file. Name: " + fileName);
        }
        // Using adapter for other file formats
        else if(audioType.equalsIgnoreCase("mkv") || audioType.equalsIgnoreCase("mp4")) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }
}

public class AdapterPatternDemo {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "beyond_the_horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("mkv", "far_far_away.mkv");
        audioPlayer.play("avi", "mind_me.avi");
    }
}
