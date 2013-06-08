/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.tjonahen.homeautomation;

import com.codename1.components.InfiniteProgress;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Hashtable;

/**
 *
 * @author Philippe Tjon-A-Hen philippe@tjonahen.nl
 */
public class MainForm extends Form {

    public MainForm() {
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));

        addCommand(new ConfigCommand());
        Command exitCommand = new Command("Exit") {
            @Override
            public void actionPerformed(ActionEvent ev) {
                Display.getInstance().exitApplication();
            }
        };
        setBackCommand(exitCommand);

    }

    @Override
    protected void onShow() {
        get(this);
    }

    private void get(final Form form) {
        if (Config.getInstance().getBaseUrl() == null || "".equals(Config.getInstance().getBaseUrl())) {
            return;
        }
        System.out.println("Getting devices....");
        ConnectionRequest cr = new ConnectionRequest() {
            private Hashtable<String, Object> h;

            @Override
            protected void readResponse(InputStream input) throws IOException {
                System.out.println("Reading response...");
                final JSONParser jp = new JSONParser();
                h = jp.parse(new InputStreamReader(input));
            }

            @Override
            protected void postResponse() {
                System.out.println("Post response handling...");
                form.removeAll();
                for (final Hashtable<String, String> device : (Collection<Hashtable<String, String>>) h.get("devices")) {

                    if ("switch".equals(device.get("type"))) {
                        Container cnt = new Container(new GridLayout(1, 2));
                        cnt.addComponent(new Label(device.get("name")));
                        Button on = new Button("switch");
                        on.addActionListener(new SwitchCommand(device.get("name"), "on"));
                        cnt.addComponent(on);
                        form.addComponent(cnt);
                    }
                }
                for (final Hashtable<String, String> device : (Collection<Hashtable<String, String>>) h.get("devices")) {

                    if ("sensor".equals(device.get("type"))) {
                        Container cnt = new Container(new GridLayout(1, 2));
                        cnt.addComponent(new Label(device.get("name")));
                        cnt.addComponent(new Label(device.get("value")));
                        form.addComponent(cnt);
                    }

                }
            }
        };
        cr.setUrl(Config.getInstance().getBaseUrl().trim() + "/");
        cr.setPost(false);
        cr.setContentType("application/json");
        final InfiniteProgress ip = new InfiniteProgress();
        final Dialog d = ip.showInifiniteBlocking();
        cr.setDisposeOnCompletion(d);
        NetworkManager.getInstance().addErrorListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.out.println("Error event occurred...");
                evt.consume();
                final Dialog d = new Dialog("Fout");
                d.setLayout(new BorderLayout());
                d.addComponent(BorderLayout.NORTH, new Label("Server geeft geen antwoord.."));
                d.addComponent(BorderLayout.SOUTH, new Button(new Command("Ok")));
                d.setDialogType(Dialog.TYPE_ERROR);
                d.show();
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(cr);
    }
}
