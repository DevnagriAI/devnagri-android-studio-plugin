package com.devnagri.androidstudio.actions;

import com.devnagri.androidstudio.helper.API;
import com.devnagri.androidstudio.ui.ProjectConfigDialog;
import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.devnagri.androidstudio.PropertiesRepository;

import javax.swing.*;


public class ConfigAction extends AnAction {
    public ConfigAction() {
    super();
}

    public ConfigAction(String text, String description, Icon icon) {
        super(text, description, icon);
    }

    public void actionPerformed(AnActionEvent e)
    {
        String clientPath = PropertiesRepository.getInstance().getClientPath();

        if (clientPath == null || clientPath.isEmpty() || !API.validateClient(clientPath)) {
            Notifications.Bus.notify(new Notification("Devnagri", "Error", "Please configure the path to the Devnagri client in the Devnagri plugin settings.", NotificationType.ERROR));
            return;
        }

        ProjectConfigDialog dialog = new ProjectConfigDialog(e.getProject(), clientPath);

        dialog.show();
        if (dialog.getExitCode() == 0) {
            dialog.writeConfigFile();
        }
    }
}
