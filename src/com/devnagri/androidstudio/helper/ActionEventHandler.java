package com.devnagri.androidstudio.helper;

import com.devnagri.androidstudio.PhraseAppConfiguration;
import com.devnagri.androidstudio.PropertiesRepository;
import com.devnagri.androidstudio.actions.ConfigAction;
import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;


public class ActionEventHandler {
    public void handleEvent(final AnActionEvent e, final String clientAction) {
        final String clientPath = PropertiesRepository.getInstance().getClientPath();

        if (clientPath == null || clientPath.isEmpty() || !API.validateClient(clientPath)) {
            Notifications.Bus.notify(new Notification("Devnagri", "Error", "Please choose a valid Devnagri client in the Devnagri plugin settings.", NotificationType.ERROR));
            return;
        }

        Project project = e.getProject();
        PhraseAppConfiguration configuration = new PhraseAppConfiguration(e.getProject());
        if (!configuration.configExists()) {
            ConfigAction ca = new ConfigAction();
            ca.actionPerformed(e);
            // Validate configuration was properly written.
            configuration.loadPhraseAppConfig();
            if (!configuration.configExists()) {
                Notifications.Bus.notify(new Notification("Devnagri", "Error", "No Devnagri configuration found for current project..", NotificationType.ERROR));
                return;
            }
        }

        PushPullAdapter phraseAppClient = new PushPullAdapter(clientPath, project);
        phraseAppClient.run(clientAction);
    }
}
