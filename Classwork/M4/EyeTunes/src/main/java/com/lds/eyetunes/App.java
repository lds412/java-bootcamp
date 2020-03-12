/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.eyetunes;

import com.lds.eyetunes.controller.EyeTunesController;
import com.lds.eyetunes.dao.EyeTunesDao;
import com.lds.eyetunes.dao.EyeTunesDaoException;
import com.lds.eyetunes.dao.EyeTunesDaoFileImpl;
import com.lds.eyetunes.ui.EyeTunesView;
import com.lds.eyetunes.ui.UserIO;
import com.lds.eyetunes.ui.UserIOConsoleImpl;

/**
 *
 * @author lydia
 */
public class App {

    public static void main(String[] args) throws EyeTunesDaoException {
        
        UserIO io = new UserIOConsoleImpl();
        EyeTunesView view = new EyeTunesView(io);
        EyeTunesDao dao = new EyeTunesDaoFileImpl();
        EyeTunesController controller = new EyeTunesController(view, dao);
        
        controller.run();
    }
}
