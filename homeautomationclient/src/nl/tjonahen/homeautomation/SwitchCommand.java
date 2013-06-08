/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.tjonahen.homeautomation;

import com.codename1.components.InfiniteProgress;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.processing.Result;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 *
 * @author Philippe Tjon-A-Hen philippe@tjonahen.nl
 */
public class SwitchCommand extends Command {

    private String name;
    public SwitchCommand(String name, String command) {
        super(command);
        this.name = name;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("isQueIdle" + NetworkManager.getInstance().isQueueIdle());
        System.out.println("Sending toggle request." + Config.getInstance().getBaseUrl().trim()+"/"+name);
        // override, by default this method writes NVPs.
        ConnectionRequest req = new ConnectionRequest() {
            protected void buildRequestBody(OutputStream os) throws IOException {
                System.out.println("Writing out request");
                final Hashtable<String,String> h = new Hashtable<String, String>();
                h.put("action", "toggle");
                os.write(Result.fromContent(h).toString().getBytes("UTF-8"));
            }
        };

        req.setPost(true);
        req.setUrl(Config.getInstance().getBaseUrl().trim()+"/"+name);
        req.setContentType("application/json");
        final InfiniteProgress ip = new InfiniteProgress();
        final Dialog d = ip.showInifiniteBlocking();
        req.setDisposeOnCompletion(d);
        NetworkManager.getInstance().addToQueue(req);
        
    }
    
}
