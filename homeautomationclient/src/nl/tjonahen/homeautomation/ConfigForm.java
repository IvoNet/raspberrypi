/*
 * Copyright (C) 2012 Philippe Tjon-A-Hen philippe@tjonahen.nl
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package nl.tjonahen.homeautomation;

import com.codename1.io.Storage;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author Philippe Tjon-A-Hen
 */
public class ConfigForm extends Form {
   private TextField input;
           
    public ConfigForm() {
        setLayout(new BorderLayout());
        final Container cn = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        
        input = new TextField();
        cn.addComponent(input);
       
        addComponent(BorderLayout.NORTH, cn);
        
        /**
         * Add OK Button and command handler
         */
        addComponent(BorderLayout.SOUTH, new Button(new Command("Ok") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                evt.consume();
                Config.getInstance().setBaseUrl(input.getText());
                Storage.getInstance().writeObject(Config.BASE_URL, Config.getInstance().getBaseUrl());
                Forms.getInstance().getMainForm().showBack();
            }

            
        }));
        
        /**
         * Allow for back button functionality
         */
        setBackCommand(new Command("Exit") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                evt.consume();
                Forms.getInstance().getMainForm().showBack();
            }
        });
        
    }

    @Override
    protected void onShow() {
        input.setText("" + Config.getInstance().getBaseUrl());
        super.onShow();
    }
}
