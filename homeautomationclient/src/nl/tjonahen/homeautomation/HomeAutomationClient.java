package nl.tjonahen.homeautomation;


import com.codename1.io.Storage;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import java.io.IOException;

public class HomeAutomationClient {
   
    private Form current;
    private Resources res;

    public void init(Object context) {
        try {
            res = Resources.openLayered("/theme");
            UIManager.getInstance().setThemeProps(res.getTheme(res.getThemeResourceNames()[0]));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        setupConfig();
        if(current != null){
            current.show();
            return;
        }
        MainForm mainForm = new MainForm();
        
        Forms.getInstance().setMainForm(mainForm);
        Forms.getInstance().setConfigForm(new ConfigForm());
        
        mainForm.show();
    }

    private void setupConfig() {
        final Storage storage = Storage.getInstance();

        Config config = Config.getInstance();
        config.setBaseUrl("");
        
        Object object = storage.readObject(Config.BASE_URL);
        if (object == null) {
            storage.writeObject(Config.BASE_URL, config.getBaseUrl());
        } else {
            config.setBaseUrl((String) object);
            
        }
        storage.flushStorageCache();
    }    
    
    public void stop() {
        current = Display.getInstance().getCurrent();
    }
    
    public void destroy() {
    }
}
