import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Rebrand {

    static final Map<String,String> replacements = new LinkedHashMap<>();

    static {
        replacements.put(">Telegram<", ">C-SYNC<");
        replacements.put(">Telegram Beta<", ">C-SYNC<");
        replacements.put("**Telegram**", "**C-SYNC**");
        replacements.put(" Telegram ", " C-SYNC ");
        replacements.put("Telegram ", "C-SYNC ");
        replacements.put(" Telegram", " C-SYNC");
        replacements.put("Welcome to Telegram", "Welcome to C-SYNC");
        replacements.put("Update Telegram", "Update C-SYNC");
        replacements.put("Telegram for Android", "C-SYNC");
        replacements.put("Optimizing Telegram", "Optimizing C-SYNC");
    }

    static final String[] SKIP = {
            "telegram.org",
            "t.me",
            "TelegramPremium",
            "Telegram Passport",
            "TelegramPassport",
            "TelegramFAQ",
            "TelegramFaq",
            "TelegramFeatures",
            "TelegramFeaturesUrl",
            "TelegramVersion",
            "TelegramContacts",
            "MapPreviewProviderTelegram",
            "TelegramCache",
            "MTProto",
            "getdesktop.telegram.org",
            "web.telegram.org",
            "ads.telegram.org",
            "translations.telegram.org"
    };

    public static void main(String[] args) throws Exception {

        Path root = Paths.get("..","TMessagesProj","src","main","res");

        Files.walk(root)
                .filter(f -> f.toString().endsWith(".xml"))
                .forEach(Rebrand::process);

        System.out.println("Rebranding completed.");
    }

    static void process(Path file) {

        try {

            String text = Files.readString(file);

            for(String skip:SKIP){

                text=text.replace(skip,"@@"+skip+"@@");
            }

            for(var e:replacements.entrySet()){

                text=text.replace(e.getKey(),e.getValue());
            }

            for(String skip:SKIP){

                text=text.replace("@@"+skip+"@@",skip);
            }

            Files.writeString(file,text,StandardCharsets.UTF_8);

            System.out.println(file);

        } catch(Exception ex){

            ex.printStackTrace();
        }
    }
}